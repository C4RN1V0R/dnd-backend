package ch.datamanager.carnivor.dndbackend.entities;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDTO {

    private final String username;

    private UserDTO(String username){
        this.username = username;
    }

    public static UserDTO build(User user){
        return new UserDTO(user.getUsername());
    }

    public static List<UserDTO> build(Iterable<User> users){
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User user: users) {
            userDTOS.add(UserDTO.build(user));
        }
        return userDTOS;
    }

}
