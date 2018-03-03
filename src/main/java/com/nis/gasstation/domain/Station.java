package com.nis.gasstation.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Station.
 */
@Entity
@Table(name = "station")
public class Station implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sifra_bs")
    private String sifraBs;

    @Column(name = "naziv")
    private String naziv;

    @Column(name = "brend")
    private String brend;

    @Column(name = "adresa")
    private String adresa;

    @Column(name = "mesto")
    private String mesto;

    @Column(name = "gps_lat")
    private String gpsLat;

    @Column(name = "gps_lon")
    private String gpsLon;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSifraBs() {
        return sifraBs;
    }

    public Station sifraBs(String sifraBs) {
        this.sifraBs = sifraBs;
        return this;
    }

    public void setSifraBs(String sifraBs) {
        this.sifraBs = sifraBs;
    }

    public String getNaziv() {
        return naziv;
    }

    public Station naziv(String naziv) {
        this.naziv = naziv;
        return this;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getBrend() {
        return brend;
    }

    public Station brend(String brend) {
        this.brend = brend;
        return this;
    }

    public void setBrend(String brend) {
        this.brend = brend;
    }

    public String getAdresa() {
        return adresa;
    }

    public Station adresa(String adresa) {
        this.adresa = adresa;
        return this;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getMesto() {
        return mesto;
    }

    public Station mesto(String mesto) {
        this.mesto = mesto;
        return this;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public String getGpsLat() {
        return gpsLat;
    }

    public Station gpsLat(String gpsLat) {
        this.gpsLat = gpsLat;
        return this;
    }

    public void setGpsLat(String gpsLat) {
        this.gpsLat = gpsLat;
    }

    public String getGpsLon() {
        return gpsLon;
    }

    public Station gpsLon(String gpsLon) {
        this.gpsLon = gpsLon;
        return this;
    }

    public void setGpsLon(String gpsLon) {
        this.gpsLon = gpsLon;
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
        Station station = (Station) o;
        if (station.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), station.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Station{" +
            "id=" + getId() +
            ", sifraBs='" + getSifraBs() + "'" +
            ", naziv='" + getNaziv() + "'" +
            ", brend='" + getBrend() + "'" +
            ", adresa='" + getAdresa() + "'" +
            ", mesto='" + getMesto() + "'" +
            ", gpsLat='" + getGpsLat() + "'" +
            ", gpsLon='" + getGpsLon() + "'" +
            "}";
    }
}
