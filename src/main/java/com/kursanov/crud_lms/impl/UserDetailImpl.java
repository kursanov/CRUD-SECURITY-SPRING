package com.kursanov.crud_lms.impl;

import com.kursanov.crud_lms.entity.Role;
import com.kursanov.crud_lms.entity.User;
import com.kursanov.crud_lms.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserDetailImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByName(username);

        if (user == null){
            throw new NotFoundException(String.format("User with %s user name not found!", username));
        }
        return new org.springframework.security.core.userdetails.User(
                user.getName(),
                user.getPassword(),
                mapRoleToAuthority(user.getRoles())
        );
    }

    private Collection<? extends GrantedAuthority> mapRoleToAuthority(Collection<Role> roles){
        return roles.stream().map(role ->
                new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
