package com.apache.camel.serviceimpl;

import com.apache.camel.enitities.User;
import com.apache.camel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Mono<User> addUser(User user) {
        return this.userRepository.save(user);
    }

    public Mono<User> getUserById(String id){
        return this.userRepository.findByUserId(id);
    }

    public Flux<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    public String deleteUser(String id){
        this.userRepository.deleteByUserId(id);
        return "Data Deleted...";
    }


}
