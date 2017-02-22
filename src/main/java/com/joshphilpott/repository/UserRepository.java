package com.joshphilpott.repository;

import com.joshphilpott.models.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by pterodactyl on 2/18/17.
 */
public interface UserRepository extends CrudRepository<User, Long>{
    User findFirstByEmailIgnoreCase(String email);
    User findFirstByUsernameIgnoreCase(String username);
    User findByUsername(String username);
}
