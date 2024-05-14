package com.samsung.srok.service.impl;

import com.samsung.srok.dao.UserRepository;
import com.samsung.srok.domain.User;
import com.samsung.srok.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> byUsername = userRepository.findByUsername(username);

        if (!byUsername.isPresent()) throw new UserNotFoundException("User with username " + username + " not found");

        return byUsername.get();
    }
}