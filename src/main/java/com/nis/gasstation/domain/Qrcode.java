package com.nis.gasstation.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Qrcode.
 */
@Entity
@Table(name = "qrcode")
public class Qrcode implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "transaction_id")
    private String transactionId;

    @OneToMany(mappedBy = "qrcode")
    @JsonIgnore
    private Set<Item> items = new HashSet<>();

    @ManyToOne
    private User user;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public Qrcode transactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Set<Item> getItems() {
        return items;
    }

    public Qrcode items(Set<Item> items) {
        this.items = items;
        return this;
    }

    public Qrcode addItems(Item item) {
        this.items.add(item);
        item.setQrcode(this);
        return this;
    }

    public Qrcode removeItems(Item item) {
        this.items.remove(item);
        item.setQrcode(null);
        return this;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public User getUser() {
        return user;
    }

    public Qrcode user(User user) {
        this.user = user;
        return this;
    }

    public void setUser(User user) {
        this.user = user;
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
        Qrcode qrcode = (Qrcode) o;
        if (qrcode.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), qrcode.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Qrcode{" +
            "id=" + getId() +
            ", transactionId='" + getTransactionId() + "'" +
            "}";
    }
}
