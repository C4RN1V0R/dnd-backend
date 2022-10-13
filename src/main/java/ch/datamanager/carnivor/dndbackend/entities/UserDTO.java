package ch.datamanager.carnivor.dndbackend.entities;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDTO {

    private final String username;
    private final String id;
    private final String mail;

    private UserDTO(String id, String username, String mail){
        this.username = username;
        this.id = id;
        this.mail = mail;
    }

    public static UserDTO build(User user){
        String id = user.getId().toString();
        String username = user.getUsername();
        String mail = user.getMail();
        return new UserDTO(id, username, mail);
    }

    public static List<UserDTO> build(Iterable<User> users){
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User user: users) {
            userDTOS.add(UserDTO.build(user));
        }
        return userDTOS;
    }

}
