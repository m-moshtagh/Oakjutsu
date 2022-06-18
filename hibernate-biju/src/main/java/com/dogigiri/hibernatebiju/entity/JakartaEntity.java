package com.dogigiri.hibernatebiju.entity;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import jakarta.persistence.*;

import java.time.OffsetDateTime;
// TODO Complete Inheritance and Builder for lombok.md
@Entity
@Table(name = "jakartaEntity")
public class JakartaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long entityId;
    private String entityName;
    private OffsetDateTime creationDate;

    public JakartaEntity() {
    }


    public JakartaEntity(long entityId, String entityName, OffsetDateTime creationDate) {
        this.entityId = entityId;
        this.entityName = entityName;
        this.creationDate = creationDate;
    }

    public long getEntityId() {
        return entityId;
    }

    public JakartaEntity setEntityId(long entityId) {
        this.entityId = entityId;
        return this;
    }

    public String getEntityName() {
        return entityName;
    }

    public JakartaEntity setEntityName(String entityName) {
        this.entityName = entityName;
        return this;
    }

    public OffsetDateTime getCreationDate() {
        return creationDate;
    }

    public JakartaEntity setCreationDate(OffsetDateTime creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JakartaEntity that = (JakartaEntity) o;
        return getEntityId() == that.getEntityId();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getEntityId());
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("entityId", entityId)
                .add("entityName", entityName)
                .add("creationDate", creationDate)
                .toString();
    }
}
