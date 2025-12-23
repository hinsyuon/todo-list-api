package com.example.todolistapi.repository;

import com.example.todolistapi.model.Task;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    public List<Task> findByCompletedTrue(Sort sort);
    public List<Task> findByCompletedFalse(Sort sort);
    public Task getById(Long id);

}
