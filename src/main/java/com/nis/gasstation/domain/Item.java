package com.nis.gasstation.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Item.
 */
@Entity
@Table(name = "item")
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "naziv_robe")
    private String nazivRobe;

    @Column(name = "vrsta_robe")
    private String vrstaRobe;

    @Column(name = "grupa_robe")
    private String grupaRobe;

    @Column(name = "hijerarhija_robe")
    private String hijerarhijaRobe;

    @Column(name = "osnovna_cena")
    private Double osnovnaCena;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazivRobe() {
        return nazivRobe;
    }

    public Item nazivRobe(String nazivRobe) {
        this.nazivRobe = nazivRobe;
        return this;
    }

    public void setNazivRobe(String nazivRobe) {
        this.nazivRobe = nazivRobe;
    }

    public String getVrstaRobe() {
        return vrstaRobe;
    }

    public Item vrstaRobe(String vrstaRobe) {
        this.vrstaRobe = vrstaRobe;
        return this;
    }

    public void setVrstaRobe(String vrstaRobe) {
        this.vrstaRobe = vrstaRobe;
    }

    public String getGrupaRobe() {
        return grupaRobe;
    }

    public Item grupaRobe(String grupaRobe) {
        this.grupaRobe = grupaRobe;
        return this;
    }

    public void setGrupaRobe(String grupaRobe) {
        this.grupaRobe = grupaRobe;
    }

    public String getHijerarhijaRobe() {
        return hijerarhijaRobe;
    }

    public Item hijerarhijaRobe(String hijerarhijaRobe) {
        this.hijerarhijaRobe = hijerarhijaRobe;
        return this;
    }

    public void setHijerarhijaRobe(String hijerarhijaRobe) {
        this.hijerarhijaRobe = hijerarhijaRobe;
    }

    public Double getOsnovnaCena() {
        return osnovnaCena;
    }

    public Item osnovnaCena(Double osnovnaCena) {
        this.osnovnaCena = osnovnaCena;
        return this;
    }

    public void setOsnovnaCena(Double osnovnaCena) {
        this.osnovnaCena = osnovnaCena;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        if (item.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), item.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Item{" +
            "id=" + getId() +
            ", nazivRobe='" + getNazivRobe() + "'" +
            ", vrstaRobe='" + getVrstaRobe() + "'" +
            ", grupaRobe='" + getGrupaRobe() + "'" +
            ", hijerarhijaRobe='" + getHijerarhijaRobe() + "'" +
            ", osnovnaCena=" + getOsnovnaCena() +
            "}";
    }
}
