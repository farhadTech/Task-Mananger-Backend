package com.farhad.tms.repository;

import com.farhad.tms.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("""
            SELECT t 
            FROM Task t
            """)
    List<Task> findAllTasks();

    @Query("""
            SELECT t 
            FROM Task t 
            WHERE t.id = :id 
            """)
    List<Task> findTaskById(Set<Long> id);


    Set<Task> getTaskByIdIsIn(Set<Long> ids);
}
