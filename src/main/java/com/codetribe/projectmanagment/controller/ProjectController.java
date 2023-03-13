package com.codetribe.projectmanagment.controller;

import com.codetribe.projectmanagment.dto.ProjectDto;
import com.codetribe.projectmanagment.model.Project;
import com.codetribe.projectmanagment.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/projects", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProjectController {
    @Autowired
    ProjectService projectService;


    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Iterable<Project> findAll() {
        return projectService.findAll();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Project save(@RequestBody ProjectDto projectDto) {
        return projectService.save(projectDto);
    }

}
