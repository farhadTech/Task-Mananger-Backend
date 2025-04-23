package com.farhad.tms.controller;

import com.farhad.tms.dto.request.TaskRequestDTO;
import com.farhad.tms.model.Task;
import com.farhad.tms.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Task task) {
        return ResponseEntity.ok(taskService.getTaskById(task.getId()));
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody TaskRequestDTO taskRequestDTO) {
        Task createdTask = taskService.createTask(taskRequestDTO);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTaskById(@PathVariable Long id, @RequestBody TaskRequestDTO taskRequestDTO) {
        Task updatedTask = taskService.updateTask(id, taskRequestDTO);
        return new ResponseEntity<> (updatedTask, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteTaskById(@PathVariable Task task) {
        taskService.deleteTaskById(task.getId());
    }
}





























