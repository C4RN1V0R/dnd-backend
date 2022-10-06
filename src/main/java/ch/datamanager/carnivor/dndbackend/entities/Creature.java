package ch.datamanager.carnivor.dndbackend.entities;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Creature{

    @Id
    @GeneratedValue
    @Type(type="uuid-char")
    private UUID id;

    private String name;
}
