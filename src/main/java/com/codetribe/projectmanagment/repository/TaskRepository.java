package com.codetribe.projectmanagment.repository;


import com.codetribe.projectmanagment.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

}

