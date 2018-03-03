package com.nis.gasstation.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Transaction.
 */
@Entity
@Table(name = "transaction")
public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sifra_bs")
    private String sifraBS;

    @Column(name = "broj_racuna")
    private String brojRacuna;

    @Column(name = "broj_stavke")
    private String brojStavke;

    @Column(name = "datum")
    private String datum;

    @Column(name = "vreme")
    private String vreme;

    @Column(name = "tip_kupca")
    private String tipKupca;

    @Column(name = "sifra_robe")
    private String sifraRobe;

    @Column(name = "naziv_robe")
    private String nazivRobe;

    @Column(name = "vrsta_robe")
    private String vrstaRobe;

    @Column(name = "grupa_robe")
    private String grupaRobe;

    @Column(name = "hijerarhija_robe")
    private String hijerarhijaRobe;

    @Column(name = "kolicina")
    private Double kolicina;

    @Column(name = "konacna_cena")
    private Double konacnaCena;

    @Column(name = "osnovna_cena")
    private Double osnovnaCena;

    @Column(name = "kompanijska_kartica")
    private String kompanijskaKartica;

    @Column(name = "loyalty_kartica")
    private String loyaltyKartica;

    @Column(name = "loyalty_kartica_status")
    private String loyaltyKarticaStatus;

    @Column(name = "loyalty_poeni")
    private Double loyaltyPoeni;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSifraBS() {
        return sifraBS;
    }

    public Transaction sifraBS(String sifraBS) {
        this.sifraBS = sifraBS;
        return this;
    }

    public void setSifraBS(String sifraBS) {
        this.sifraBS = sifraBS;
    }

    public String getBrojRacuna() {
        return brojRacuna;
    }

    public Transaction brojRacuna(String brojRacuna) {
        this.brojRacuna = brojRacuna;
        return this;
    }

    public void setBrojRacuna(String brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    public String getBrojStavke() {
        return brojStavke;
    }

    public Transaction brojStavke(String brojStavke) {
        this.brojStavke = brojStavke;
        return this;
    }

    public void setBrojStavke(String brojStavke) {
        this.brojStavke = brojStavke;
    }

    public String getDatum() {
        return datum;
    }

    public Transaction datum(String datum) {
        this.datum = datum;
        return this;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getVreme() {
        return vreme;
    }

    public Transaction vreme(String vreme) {
        this.vreme = vreme;
        return this;
    }

    public void setVreme(String vreme) {
        this.vreme = vreme;
    }

    public String getTipKupca() {
        return tipKupca;
    }

    public Transaction tipKupca(String tipKupca) {
        this.tipKupca = tipKupca;
        return this;
    }

    public void setTipKupca(String tipKupca) {
        this.tipKupca = tipKupca;
    }

    public String getSifraRobe() {
        return sifraRobe;
    }

    public Transaction sifraRobe(String sifraRobe) {
        this.sifraRobe = sifraRobe;
        return this;
    }

    public void setSifraRobe(String sifraRobe) {
        this.sifraRobe = sifraRobe;
    }

    public String getNazivRobe() {
        return nazivRobe;
    }

    public Transaction nazivRobe(String nazivRobe) {
        this.nazivRobe = nazivRobe;
        return this;
    }

    public void setNazivRobe(String nazivRobe) {
        this.nazivRobe = nazivRobe;
    }

    public String getVrstaRobe() {
        return vrstaRobe;
    }

    public Transaction vrstaRobe(String vrstaRobe) {
        this.vrstaRobe = vrstaRobe;
        return this;
    }

    public void setVrstaRobe(String vrstaRobe) {
        this.vrstaRobe = vrstaRobe;
    }

    public String getGrupaRobe() {
        return grupaRobe;
    }

    public Transaction grupaRobe(String grupaRobe) {
        this.grupaRobe = grupaRobe;
        return this;
    }

    public void setGrupaRobe(String grupaRobe) {
        this.grupaRobe = grupaRobe;
    }

    public String getHijerarhijaRobe() {
        return hijerarhijaRobe;
    }

    public Transaction hijerarhijaRobe(String hijerarhijaRobe) {
        this.hijerarhijaRobe = hijerarhijaRobe;
        return this;
    }

    public void setHijerarhijaRobe(String hijerarhijaRobe) {
        this.hijerarhijaRobe = hijerarhijaRobe;
    }

    public Double getKolicina() {
        return kolicina;
    }

    public Transaction kolicina(Double kolicina) {
        this.kolicina = kolicina;
        return this;
    }

    public void setKolicina(Double kolicina) {
        this.kolicina = kolicina;
    }

    public Double getKonacnaCena() {
        return konacnaCena;
    }

    public Transaction konacnaCena(Double konacnaCena) {
        this.konacnaCena = konacnaCena;
        return this;
    }

    public void setKonacnaCena(Double konacnaCena) {
        this.konacnaCena = konacnaCena;
    }

    public Double getOsnovnaCena() {
        return osnovnaCena;
    }

    public Transaction osnovnaCena(Double osnovnaCena) {
        this.osnovnaCena = osnovnaCena;
        return this;
    }

    public void setOsnovnaCena(Double osnovnaCena) {
        this.osnovnaCena = osnovnaCena;
    }

    public String getKompanijskaKartica() {
        return kompanijskaKartica;
    }

    public Transaction kompanijskaKartica(String kompanijskaKartica) {
        this.kompanijskaKartica = kompanijskaKartica;
        return this;
    }

    public void setKompanijskaKartica(String kompanijskaKartica) {
        this.kompanijskaKartica = kompanijskaKartica;
    }

    public String getLoyaltyKartica() {
        return loyaltyKartica;
    }

    public Transaction loyaltyKartica(String loyaltyKartica) {
        this.loyaltyKartica = loyaltyKartica;
        return this;
    }

    public void setLoyaltyKartica(String loyaltyKartica) {
        this.loyaltyKartica = loyaltyKartica;
    }

    public String getLoyaltyKarticaStatus() {
        return loyaltyKarticaStatus;
    }

    public Transaction loyaltyKarticaStatus(String loyaltyKarticaStatus) {
        this.loyaltyKarticaStatus = loyaltyKarticaStatus;
        return this;
    }

    public void setLoyaltyKarticaStatus(String loyaltyKarticaStatus) {
        this.loyaltyKarticaStatus = loyaltyKarticaStatus;
    }

    public Double getLoyaltyPoeni() {
        return loyaltyPoeni;
    }

    public Transaction loyaltyPoeni(Double loyaltyPoeni) {
        this.loyaltyPoeni = loyaltyPoeni;
        return this;
    }

    public void setLoyaltyPoeni(Double loyaltyPoeni) {
        this.loyaltyPoeni = loyaltyPoeni;
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
        Transaction transaction = (Transaction) o;
        if (transaction.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), transaction.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Transaction{" +
            "id=" + getId() +
            ", sifraBS='" + getSifraBS() + "'" +
            ", brojRacuna='" + getBrojRacuna() + "'" +
            ", brojStavke='" + getBrojStavke() + "'" +
            ", datum='" + getDatum() + "'" +
            ", vreme='" + getVreme() + "'" +
            ", tipKupca='" + getTipKupca() + "'" +
            ", sifraRobe='" + getSifraRobe() + "'" +
            ", nazivRobe='" + getNazivRobe() + "'" +
            ", vrstaRobe='" + getVrstaRobe() + "'" +
            ", grupaRobe='" + getGrupaRobe() + "'" +
            ", hijerarhijaRobe='" + getHijerarhijaRobe() + "'" +
            ", kolicina=" + getKolicina() +
            ", konacnaCena=" + getKonacnaCena() +
            ", osnovnaCena=" + getOsnovnaCena() +
            ", kompanijskaKartica='" + getKompanijskaKartica() + "'" +
            ", loyaltyKartica='" + getLoyaltyKartica() + "'" +
            ", loyaltyKarticaStatus='" + getLoyaltyKarticaStatus() + "'" +
            ", loyaltyPoeni=" + getLoyaltyPoeni() +
            "}";
    }
}
