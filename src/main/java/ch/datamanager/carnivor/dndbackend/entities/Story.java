package ch.datamanager.carnivor.dndbackend.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Story extends BaseEntity{

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    private User creator;

    @ManyToOne
    private World world;

    @OneToMany
    private List<Membership> membershipList;

    private String name;
}
