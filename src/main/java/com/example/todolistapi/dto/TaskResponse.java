package com.example.todolistapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.example.todolistapi.model.Task;

@JsonPropertyOrder({ "id", "task_name", "completed" })
public class TaskResponse {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("task_name")
    private String taskName;
    @JsonProperty("completed")
    private Boolean completed;

    public static TaskResponse fromEntity(Task task) {
        TaskResponse response = new TaskResponse();
        response.setId(task.getId());
        response.setTaskName(task.getTaskName());
        response.setCompleted(task.isCompleted());
        return response;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Boolean isCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
