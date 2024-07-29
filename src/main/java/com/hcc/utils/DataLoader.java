package com.hcc.utils;

import com.hcc.entities.Authority;
import com.hcc.entities.User;
import com.hcc.repositories.AuthorityRepository;
import com.hcc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    UserRepository userRepo;

    @Autowired
    AuthorityRepository authRepo;
    @Override
    public void run(String... args) throws Exception {
        loadUserData();
        loadAuthorityData();

    }

    private void loadUserData() {
        if (userRepo.count() == 0) {
            PasswordEncoder pwenc = new BCryptPasswordEncoder();
            String pw = pwenc.encode("1234");

            User isaac = new User(LocalDate.now(), "isaac", pw);
            userRepo.save(isaac);

            User isaac2 = new User(LocalDate.now(), "isaac2", pw);
            userRepo.save(isaac2);
        }
    }

    private void loadAuthorityData() {
        if (authRepo.count() == 0) {
            Authority learner = new Authority("ROLE_LEARNER", userRepo.findByUsername("isaac").get());
            authRepo.save(learner);
            Authority reviewer = new Authority("ROLE_REVIEWER", userRepo.findByUsername("isaac2").get());
            authRepo.save(reviewer);
        }
    }
}
