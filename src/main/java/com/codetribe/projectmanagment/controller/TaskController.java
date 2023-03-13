package com.codetribe.projectmanagment.controller;

import com.codetribe.projectmanagment.dto.ProjectDto;
import com.codetribe.projectmanagment.dto.TaskDto;
import com.codetribe.projectmanagment.model.Project;
import com.codetribe.projectmanagment.model.Task;
import com.codetribe.projectmanagment.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
public class TaskController {
    @Autowired
    TaskService taskService;


    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Iterable<Task> findAll() {
        return taskService.findAll();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Task save(@RequestBody TaskDto taskDto) {
        return taskService.save(taskDto);
    }

    @PatchMapping()
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Task update(@RequestBody TaskDto taskDto) {
        return taskService.update(taskDto);
    }

}
