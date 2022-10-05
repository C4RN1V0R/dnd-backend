package ch.datamanager.carnivor.dndbackend.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Data
@Entity
public class Character extends BaseEntity{

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    private Creature race;
}
