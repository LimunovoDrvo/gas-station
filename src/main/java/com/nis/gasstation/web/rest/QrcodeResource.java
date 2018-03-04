package com.nis.gasstation.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.nis.gasstation.domain.Item;
import com.nis.gasstation.domain.Qrcode;
import com.nis.gasstation.repository.ItemRepository;
import com.nis.gasstation.repository.QrcodeRepository;
import com.nis.gasstation.web.rest.util.HeaderUtil;

import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing Qrcode.
 */
@RestController
@RequestMapping("/api")
public class QrcodeResource {

    private final Logger log = LoggerFactory.getLogger(QrcodeResource.class);

    private static final String ENTITY_NAME = "qrcode";

    private final QrcodeRepository qrcodeRepository;
    
    private final ItemRepository itemRepository;

    public QrcodeResource(QrcodeRepository qrcodeRepository, ItemRepository itemRepository) {
        this.qrcodeRepository = qrcodeRepository;
        this.itemRepository = itemRepository;
    }

    /**
     * POST  /qrcodes : Create a new qrcode.
     *
     * @param qrcode the qrcode to create
     * @return the ResponseEntity with status 201 (Created) and with body the new qrcode, or with status 400 (Bad Request) if the qrcode has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/qrcodes")
    @Transactional
    public ResponseEntity<Qrcode> createQrcode(@RequestBody String req) throws URISyntaxException {
    	
    	String[] split = req.split(",");
    	Qrcode code = new Qrcode();
    	Set<Item> items = new HashSet<>();
    	for(String s : split) {
    		Long valueOf = Long.valueOf(s);
    		Item item = itemRepository.getOne(valueOf);
    		
    		Item newItem = new Item();
    		newItem.setGrupaRobe(item.getGrupaRobe());
    		newItem.setKolicina(1d);
    		newItem.setNazivRobe(item.getNazivRobe());
    		newItem.setOsnovnaCena(item.getOsnovnaCena());
    		newItem.setVrstaRobe(item.getVrstaRobe());
    		
    		
    		newItem.setQrcode(code);
    		items.add(newItem);
    	}
    	
    	code.setItems(items);
    	
        Qrcode result = qrcodeRepository.save(code);
        return ResponseEntity.created(new URI("/api/qrcodes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }


    /**
     * GET  /qrcodes : get all the qrcodes.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of qrcodes in body
     */
    @GetMapping("/qrcodes")
    @Timed
    public List<Qrcode> getAllQrcodes() {
        log.debug("REST request to get all Qrcodes");
        return qrcodeRepository.findAll();
        }

    /**
     * GET  /qrcodes/:id : get the "id" qrcode.
     *
     * @param id the id of the qrcode to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the qrcode, or with status 404 (Not Found)
     */
    @GetMapping("/qrcodes/{id}")
    @Timed
    public ResponseEntity<Qrcode> getQrcode(@PathVariable Long id) {
        log.debug("REST request to get Qrcode : {}", id);
        Qrcode qrcode = qrcodeRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(qrcode));
    }

    /**
     * DELETE  /qrcodes/:id : delete the "id" qrcode.
     *
     * @param id the id of the qrcode to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/qrcodes/{id}")
    @Timed
    public ResponseEntity<Void> deleteQrcode(@PathVariable Long id) {
        log.debug("REST request to delete Qrcode : {}", id);
        qrcodeRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
