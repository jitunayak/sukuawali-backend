package com.sukuawali.sukuawalibackend;

import com.sukuawali.sukuawalibackend.models.Role;
import com.sukuawali.sukuawalibackend.models.User;
import com.sukuawali.sukuawalibackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.HashSet;

@SpringBootApplication
public class SukuawaliBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SukuawaliBackendApplication.class, args);
    }

}
