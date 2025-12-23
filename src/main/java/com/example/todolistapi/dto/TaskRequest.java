package com.example.todolistapi.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TaskRequest {
    
    @NotNull(message = "Task name cannot be null")
    @Size(min = 1, max = 250, message = "Task name must be between 1 and 250 characters")
    private String taskName;
    @NotNull(message = "Completed must be true or false")
    private Boolean completed;

    public Boolean isCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}
