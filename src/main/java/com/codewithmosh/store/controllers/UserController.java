package com.codewithmosh.store.controllers;

import com.codewithmosh.store.dtos.UserDto;
import com.codewithmosh.store.entities.User;
import com.codewithmosh.store.mappers.UserMapper;
import com.codewithmosh.store.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @GetMapping
    public Iterable<UserDto> getAllUsers(@RequestParam(required = false, defaultValue = "", name = "sort") String sortBy){      // good practice to set the name to be the same as the query key: sort, just so in case we decide in the future to rename our parameter, the code doesnt break

        if(!Set.of("name","email").contains(sortBy)){     // set of valid values; does this contain the sortBy argument?
            sortBy = "name";
        }

        return userRepository.findAll(Sort.by(sortBy))
                .stream()
                .map(userMapper::toDto)         //  map() returns a Stream object that we convert into a list
                .toList();

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id){
        var user = userRepository.findById(id).orElse(null);
        if(user == null){
            return ResponseEntity.notFound().build();       // returns a Response entity with the status of NOT FOUND and; notFound() - sets the http status to 404; build() - finalizes the response with no body content in this case
        }

        //var userDto = new UserDto(user.getId(), user.getName(), user.getEmail());

        return ResponseEntity.ok(userMapper.toDto(user));     // returns a Response entity with the status of OK 200 and the user DTO as well
    }



}
