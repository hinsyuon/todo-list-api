package com.example.todolistapi.controller;

import com.example.todolistapi.dto.TaskRequest;
import com.example.todolistapi.dto.TaskResponse;
import com.example.todolistapi.response.ApiResponse;
import com.example.todolistapi.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class TaskController {
    private final TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping("/tasks")
    public ResponseEntity<ApiResponse<List<TaskResponse>>> getAllTasks() {
        return ResponseEntity.ok(
                new ApiResponse<>("Get all tasks successfully", taskService.getAllTasks())
        );
    }
    @GetMapping("/tasks/completed")
    public ResponseEntity<ApiResponse<List<TaskResponse>>> getAllCompletedTasks() {
        return ResponseEntity.ok(
                new ApiResponse<>("Get all completed tasks successfully", taskService.findAllCompletedTask())
        );
    }
    @GetMapping("/tasks/incomplete")
    public ResponseEntity<ApiResponse<List<TaskResponse>>> getAllInCompleteTasks() {
        return ResponseEntity.ok(
                new ApiResponse<>("Get incomplete tasks successfully", taskService.findAllInCompleteTask())
        );
    }
    @GetMapping("/tasks/{id}")
    public ResponseEntity<ApiResponse<TaskResponse>> show(@PathVariable Long id) {
        return ResponseEntity.ok(
                new ApiResponse<>("Get a task detail successfully", taskService.findTaskById(id))
        );
    }
    @PostMapping("/tasks")
    public ResponseEntity<ApiResponse<TaskResponse>> store(@Valid @RequestBody TaskRequest taskRequest) {
       taskService.creatNewTask(taskRequest);
        return ResponseEntity.ok(
                new ApiResponse<>( "Created new task successfully")
        );
    }
    @PutMapping("/tasks/{id}")
    public ResponseEntity<ApiResponse<TaskResponse>> update(@PathVariable Long id ,@Valid @RequestBody TaskRequest taskRequest) {
        taskService.updateTask(id, taskRequest);
        return ResponseEntity.ok(
                new ApiResponse<>("Task updated successfully")
        );
    }
    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<ApiResponse<Boolean>> destroy(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok(
                new ApiResponse<>("Task deleted successfully")
        );
    }

}
