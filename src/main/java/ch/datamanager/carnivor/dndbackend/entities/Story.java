package ch.datamanager.carnivor.dndbackend.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Story{

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    private User creator;

    @ManyToOne
    private World world;

    private String name;
}
