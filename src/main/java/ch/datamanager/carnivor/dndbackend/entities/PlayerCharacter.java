package ch.datamanager.carnivor.dndbackend.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
public class PlayerCharacter{

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    private User user;

    @OneToOne
    private Personality personality;
}
