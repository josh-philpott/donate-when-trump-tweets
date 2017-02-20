package com.joshphilpott.service;

import com.google.common.collect.Lists;
import com.joshphilpott.models.User;
import com.joshphilpott.repository.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * Created by pterodactyl on 2/18/17.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements UserDetailsService{
    @NonNull
    UserRepository userRpsy;

    public boolean emailExists(String email){
        User user = userRpsy.findFirstByEmailIgnoreCase(email);
        return user!=null;
    }

    public boolean usernameExists(String username){
        User user = userRpsy.findFirstByUsernameIgnoreCase(username);
        return user!=null;
    }

    public User save(User user){
        return userRpsy.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username){
        User user =  userRpsy.findByUsername(username);
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), Lists.newArrayList(new SimpleGrantedAuthority("USER_ROLE")));
        return userDetails;
    }

}
