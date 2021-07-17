package com.sukuawali.sukuawalibackend.services;

import com.sukuawali.sukuawalibackend.models.Role;
import com.sukuawali.sukuawalibackend.models.User;
import com.sukuawali.sukuawalibackend.repositories.RoleRepository;
import com.sukuawali.sukuawalibackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       PasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    public User findUserByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }

    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(true);
        HashSet<Role> roles = new HashSet<>();
        user.getRoles().forEach(role ->
                {
                    Role userRole = roleRepository.findByRole(role.getRole());
                    roles.add(userRole);
                }
        );
        user.setRoles(roles);
        return userRepository.save(user);
    }

    public Optional<User> deleteUser(Long userId) {
            Optional<User> user = userRepository.findById(userId);
            if (!user.isEmpty()) {
                userRepository.deleteById(user.get().getId());
                return user;
            } else
                return Optional.empty();

    }

}