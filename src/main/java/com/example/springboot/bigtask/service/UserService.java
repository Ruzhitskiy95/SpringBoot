package com.example.springboot.bigtask.service;

import com.example.springboot.bigtask.dao.UsersSSDao;
import com.example.springboot.bigtask.model.UsersSS;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final UsersSSDao usersSSDao;

    public UserService(UsersSSDao usersSSDao) {
        this.usersSSDao = usersSSDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersSS user = usersSSDao.findUsersSSByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException(username);
        }
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRolesSSES().get(0).getRole())
                .build();

    }
}
