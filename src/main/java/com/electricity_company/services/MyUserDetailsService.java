package com.electricity_company.services;

import com.electricity_company.config.MyUserPrincipal;
import com.electricity_company.entities.User;
import com.electricity_company.repositories.UsersRepository;
import com.electricity_company.services.contracts.IMyUserDetailsService;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MyUserDetailsService implements IMyUserDetailsService {
    private final UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = this.usersRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("No user found with username: " + email);
        }

        return new MyUserPrincipal(user);
    }
}