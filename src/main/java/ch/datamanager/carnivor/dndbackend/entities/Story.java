package ch.datamanager.carnivor.dndbackend.entities;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Story{

    @Id
    @GeneratedValue
    @Type(type="uuid-char")
    private UUID id;

    @ManyToOne
    private User creator;

    @ManyToOne
    private World world;

    private String name;
}
