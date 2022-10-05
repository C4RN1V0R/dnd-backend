package ch.datamanager.carnivor.dndbackend.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Data
public abstract class BaseEntity {
    @Id
    @GeneratedValue
    private UUID id;

}
