package ch.datamanager.carnivor.dndbackend.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class User extends BaseEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private String passwd;

    @OneToMany
    private List<Membership> membershipList;

    @OneToMany
    private List<Story> createdStories;

    @OneToMany
    private List<World> createdWorlds;
}
