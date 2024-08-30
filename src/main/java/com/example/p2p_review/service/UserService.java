package com.example.p2p_review.service;



import com.example.p2p_review.client.SpecialistProfileClient;
import com.example.p2p_review.dto.response.UserDTO;
import com.example.p2p_review.model.User;
import com.example.p2p_review.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

//    private final SpecialistProfileClient client;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


//    public List<UserDTO> getAllIntegratedUsers() {
//        return client.findAllUsers();
//    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("User with this email already exists");
        }
        return userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}

