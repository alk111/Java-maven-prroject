package com.apache.camel.controller;

import com.apache.camel.enitities.User;
import com.apache.camel.serviceimpl.UserService;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProducerTemplate producerTemplate;

    @PostMapping(value = "/")
    public Mono<String> addUser(@RequestBody User user) {
        producerTemplate.requestBody("direct:insert",user);
        return Mono.just("Data Inserted...");
//        return this.userService.addUser(user);
    }

    @GetMapping(value = "id/{id}")
    public Mono<User> getUser(@PathVariable String id) {
        return this.userService.getUserById(id);
    }

    @GetMapping(value = "/")
    public Flux<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @DeleteMapping(value = "/")
    public String deleteUser(String id) {
        return this.userService.deleteUser(id);
    }

}
