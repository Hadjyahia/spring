package com.example.test.services;


import com.example.test.models.AppUser;
import com.example.test.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority ;
import org.springframework.security.core.userdetails.UserDetails ;
import org.springframework.security.core.userdetails.UserDetailsService ;
import org.springframework.security.core.userdetails.UsernameNotFoundException ;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDateTime;
import java.util.Collections ;
import java.util.Optional;

@Component
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<AppUser> userRes = userRepo.findAppUserByEmail(email);
        if(userRes.isEmpty())
            throw new UsernameNotFoundException("Could not find User with email = " + email);
        AppUser user = userRes.get();
        return new org.springframework.security.core.userdetails.User(
                email,
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("USER")));
    }
    public int enableAppUser(String email) {
        return userRepo.enableAppUser(email);
    }
}

