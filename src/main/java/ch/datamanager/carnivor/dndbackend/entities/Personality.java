package ch.datamanager.carnivor.dndbackend.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Data
@Entity
public class Personality{

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    private Creature race;

    @ManyToOne
    private Story story;
}
