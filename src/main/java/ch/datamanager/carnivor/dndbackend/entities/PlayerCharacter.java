package ch.datamanager.carnivor.dndbackend.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
public class PlayerCharacter extends BaseEntity{

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    private Membership membership;

    @OneToOne
    private Character character;
}
