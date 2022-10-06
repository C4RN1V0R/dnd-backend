package ch.datamanager.carnivor.dndbackend.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
public class World{

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    @ManyToOne
    private User creator;
}
