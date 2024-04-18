package com.littlesekii.finances.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Entity(name = "t_transaction")
@Table(name = "t_transaction")
public class TransactionEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -3427919971120419753L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Integer value;
    private String description;
    private Instant moment;
    private Boolean incoming;

    public TransactionEntity() {}

    public TransactionEntity(UUID id, Integer value, String description, Instant moment, Boolean incoming) {
        this.id = id;
        this.value = value;
        this.description = description;
        this.moment = moment;
        this.incoming = incoming;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIncoming() {
        return incoming;
    }

    public void setIncoming(Boolean incoming) {
        this.incoming = incoming;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionEntity that = (TransactionEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(value, that.value) && Objects.equals(description, that.description) && Objects.equals(incoming, that.incoming);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, description, incoming);
    }
}
