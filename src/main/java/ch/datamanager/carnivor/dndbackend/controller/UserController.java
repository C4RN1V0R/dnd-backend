package ch.datamanager.carnivor.dndbackend.controller;

import ch.datamanager.carnivor.dndbackend.entities.User;
import ch.datamanager.carnivor.dndbackend.entities.UserDTO;
import ch.datamanager.carnivor.dndbackend.entities.UserRepository;
import ch.datamanager.carnivor.dndbackend.security.MyUserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/api/user")
public class UserController {

    private Authentication authentication(){
        return SecurityContextHolder.getContext().getAuthentication();
    }

    private User getSessionUser(){
        MyUserPrincipal principal = (MyUserPrincipal) authentication().getPrincipal();
        return principal.getUser();
    }


    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/mydata")
    public UserDTO getSessionUserData(){
        return UserDTO.build(getSessionUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable(value = "id") UUID id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            return ResponseEntity.ok().body(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public User saveUser(@Validated @RequestBody User user) {
        return userRepository.save(user);
    }
}
