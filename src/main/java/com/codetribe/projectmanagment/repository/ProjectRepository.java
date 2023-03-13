package com.codetribe.projectmanagment.repository;


import com.codetribe.projectmanagment.model.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>  {

}

