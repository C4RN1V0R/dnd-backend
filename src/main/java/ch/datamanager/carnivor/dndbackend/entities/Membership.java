package ch.datamanager.carnivor.dndbackend.entities;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Data
@Entity
public class Membership{

    @Id
    @GeneratedValue
    @Type(type="uuid-char")
    private UUID id;

    @ManyToOne
    private Story story;

    @ManyToOne
    private User user;

}
