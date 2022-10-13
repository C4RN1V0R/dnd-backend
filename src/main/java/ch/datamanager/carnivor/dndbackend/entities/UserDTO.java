package ch.datamanager.carnivor.dndbackend.entities;


import lombok.Data;

@Data
public class UserDTO {

    private final String username;

    private UserDTO(String username){
        this.username = username;
    }

    public static UserDTO build(User user){
        return new UserDTO(user.getUsername());
    }

}
