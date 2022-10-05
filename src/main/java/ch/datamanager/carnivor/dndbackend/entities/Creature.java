package ch.datamanager.carnivor.dndbackend.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Creature extends BaseEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    @OneToMany
    private List<Character> characters;
}
