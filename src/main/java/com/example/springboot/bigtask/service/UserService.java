package com.example.springboot.bigtask.service;

import com.example.springboot.bigtask.dao.UsersDao;
import com.example.springboot.bigtask.model.Users;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final UsersDao usersDao;

    public UserService(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersDao.findUsersSSByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException(username);
        }
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRoles().get(0).getRole())
                .build();

    }
}
