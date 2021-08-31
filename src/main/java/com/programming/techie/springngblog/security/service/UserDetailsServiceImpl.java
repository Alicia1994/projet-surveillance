package com.programming.techie.springngblog.security.service;

import com.programming.techie.springngblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.programming.techie.springngblog.model.User user = userRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("No user found " + username));
        return new User(user.getUsername(),
                user.getPassword(),
                true, true, true, true,
                getAuthorities(user));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(com.programming.techie.springngblog.model.User user) {
        return Collections.singletonList(new SimpleGrantedAuthority(user.getRole()));
    }
}