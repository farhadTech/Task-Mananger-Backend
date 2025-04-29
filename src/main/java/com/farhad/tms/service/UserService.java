package com.farhad.tms.service;

import com.farhad.tms.dto.request.UserRequestDTO;
import com.farhad.tms.dto.response.CustomUserResponse;
import com.farhad.tms.dto.response.UserResponseDTO;
import com.farhad.tms.model.Task;
import com.farhad.tms.model.User;
import com.farhad.tms.repository.TaskRepository;
import com.farhad.tms.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserService {
    UserRepository userRepository;
    TaskRepository taskRepository;

    public UserService(UserRepository userRepository, TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<CustomUserResponse> findAllUsers() {
        return userRepository.findAllUsers();
    }

    public List<UserResponseDTO> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public User findUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return user;
    }

    public List<UserResponseDTO> getUserById() {
        return userRepository.getAllUsers();
    }

    public User createUser(UserRequestDTO userRequestDTO) {
        User email = userRepository.findByEmail(userRequestDTO.email());
        if (email != null) {
            throw new RuntimeException("Email already exists");
        }
        User user = new User();
        user.setFirstName(userRequestDTO.firstName());
        user.setLastName(userRequestDTO.lastName());
        user.setUsername(userRequestDTO.username());
        user.setEmail(userRequestDTO.email());
        user.setPassword(userRequestDTO.password());

        Set<Task> tasks = taskRepository.getTaskByIdIsIn(userRequestDTO.taskIds());
        for (Task task : tasks) {
            task.setUser(user);
        }
        user.setTask(tasks);

        return userRepository.save(user);
    }

    public User updateUser(Long id, UserRequestDTO userRequestDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setFirstName(userRequestDTO.firstName());
        user.setLastName(userRequestDTO.lastName());
        user.setUsername(userRequestDTO.username());
        user.setEmail(userRequestDTO.email());
        user.setPassword(userRequestDTO.password());

        Set<Task> tasks = taskRepository.getTaskByIdIsIn(userRequestDTO.taskIds());
        for (Task task : tasks) {
            task.setUser(user);
        }
        user.setTask(tasks);

        return userRepository.save(user);
    }

    public String deleteUser(Long id) {
        userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.deleteById(id);
        return "User deleted";
    }
}









