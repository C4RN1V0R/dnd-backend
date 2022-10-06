package ch.datamanager.carnivor.dndbackend.entities;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
public class PlayerCharacter{

    @Id
    @GeneratedValue
    @Type(type="uuid-char")
    private UUID id;

    @ManyToOne
    private User user;

    @OneToOne
    private Personality personality;
}
