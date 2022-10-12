package ch.datamanager.carnivor.dndbackend.entities;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
public class World{

    @Id
    @GeneratedValue
    @Type(type="uuid-char")
    private UUID id;

    private String name;

    @ManyToOne
    private User creator;
}
