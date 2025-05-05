package com.farhad.tms.service;

import com.farhad.tms.dto.request.UserRequestDTO;
import com.farhad.tms.model.User;
import com.farhad.tms.repository.TaskRepository;
import com.farhad.tms.dto.request.TaskRequestDTO;
import com.farhad.tms.model.Task;
import com.farhad.tms.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    TaskRepository taskRepository;
    UserRepository userRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        return task;
    }

    public Task createTask(TaskRequestDTO taskRequestDTO) {
        Task task = new Task();
        task.setTitle(taskRequestDTO.title());
        task.setTaskStatus(taskRequestDTO.taskStatus());
        task.setStartTime(taskRequestDTO.startTime());
        task.setEndTime(taskRequestDTO.endTime());

        User user = userRepository.getUserById(taskRequestDTO.userId());
        task.setUser(user);

        return taskRepository.save(task);
    }

    public Task updateTask(Long id, TaskRequestDTO taskRequestDTO) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setTitle(taskRequestDTO.title());
        task.setTaskStatus(taskRequestDTO.taskStatus());
        task.setStartTime(taskRequestDTO.startTime());
        task.setEndTime(taskRequestDTO.endTime());

        User user = userRepository.getUserById(taskRequestDTO.userId());
        task.setUser(user);

        return taskRepository.save(task);
    }

    public String deleteTaskById(Long id) {
        taskRepository.deleteById(id);
        return "Task deleted";
    }

    public List<Task> SortById() {
        List<Task> tasks = taskRepository.findAll();
        return tasks;
    }
}
