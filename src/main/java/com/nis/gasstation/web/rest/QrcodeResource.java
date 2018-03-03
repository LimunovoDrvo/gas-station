package com.nis.gasstation.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.nis.gasstation.domain.Qrcode;

import com.nis.gasstation.repository.QrcodeRepository;
import com.nis.gasstation.web.rest.errors.BadRequestAlertException;
import com.nis.gasstation.web.rest.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Qrcode.
 */
@RestController
@RequestMapping("/api")
public class QrcodeResource {

    private final Logger log = LoggerFactory.getLogger(QrcodeResource.class);

    private static final String ENTITY_NAME = "qrcode";

    private final QrcodeRepository qrcodeRepository;

    public QrcodeResource(QrcodeRepository qrcodeRepository) {
        this.qrcodeRepository = qrcodeRepository;
    }

    /**
     * POST  /qrcodes : Create a new qrcode.
     *
     * @param qrcode the qrcode to create
     * @return the ResponseEntity with status 201 (Created) and with body the new qrcode, or with status 400 (Bad Request) if the qrcode has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/qrcodes")
    @Timed
    public ResponseEntity<Qrcode> createQrcode(@RequestBody Qrcode qrcode) throws URISyntaxException {
        log.debug("REST request to save Qrcode : {}", qrcode);
        if (qrcode.getId() != null) {
            throw new BadRequestAlertException("A new qrcode cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Qrcode result = qrcodeRepository.save(qrcode);
        return ResponseEntity.created(new URI("/api/qrcodes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /qrcodes : Updates an existing qrcode.
     *
     * @param qrcode the qrcode to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated qrcode,
     * or with status 400 (Bad Request) if the qrcode is not valid,
     * or with status 500 (Internal Server Error) if the qrcode couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/qrcodes")
    @Timed
    public ResponseEntity<Qrcode> updateQrcode(@RequestBody Qrcode qrcode) throws URISyntaxException {
        log.debug("REST request to update Qrcode : {}", qrcode);
        if (qrcode.getId() == null) {
            return createQrcode(qrcode);
        }
        Qrcode result = qrcodeRepository.save(qrcode);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, qrcode.getId().toString()))
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
