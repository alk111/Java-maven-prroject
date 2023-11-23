package com.apache.camel.repository;

import com.apache.camel.enitities.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, Long> {

    public Mono<User> findByUserId(String userId);

    public Mono<Long> deleteByUserId(String userId);

}