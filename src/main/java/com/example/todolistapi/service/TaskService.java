package com.example.todolistapi.service;

import com.example.todolistapi.dto.TaskRequest;
import com.example.todolistapi.dto.TaskResponse;
import com.example.todolistapi.exception.TaskNotFoundException;
import com.example.todolistapi.model.Task;
import com.example.todolistapi.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    public TaskResponse creatNewTask(TaskRequest taskRequest) {
        Task task = new Task(
            taskRequest.getTaskName(), 
            taskRequest.isCompleted()
        );
      
        Task savedTask = taskRepository.save(task);
        return TaskResponse.fromEntity(savedTask);
    }
    public List<TaskResponse> getAllTasks() {
        return taskRepository.findAll(Sort.by("id").descending()).stream()
            .map(TaskResponse::fromEntity)
            .toList();
    }
    public TaskResponse findTaskById(Long id) {
        return TaskResponse.fromEntity(taskRepository.findById(id)
          .orElseThrow(() -> new TaskNotFoundException("Task not found id: " + id)));
    }
    public List<TaskResponse> findAllCompletedTask() {
        return taskRepository.findByCompletedTrue(Sort.by("id").descending())
            .stream()
            .map(TaskResponse::fromEntity)
            .toList();
    }
    public List<TaskResponse> findAllInCompleteTask() {
        return taskRepository.findByCompletedFalse(Sort.by("id").descending())
            .stream()
            .map(TaskResponse::fromEntity)
            .toList();
    }
    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found id: " + id));
        taskRepository.delete(task);
    }
    public TaskResponse updateTask(Long id, TaskRequest taskRequest) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found id: " + id));

        task.setTaskName(taskRequest.getTaskName());
        task.setCompleted(taskRequest.isCompleted());

        return TaskResponse.fromEntity(taskRepository.save(task));
    }
}
