package com.codetribe.projectmanagment.service;

import com.codetribe.projectmanagment.ResourceNotFoundException;
import com.codetribe.projectmanagment.dto.TaskDto;
import com.codetribe.projectmanagment.model.Project;
import com.codetribe.projectmanagment.model.Task;
import com.codetribe.projectmanagment.model.TaskStatus;
import com.codetribe.projectmanagment.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    @Autowired
    ProjectService projectService;

    public Iterable<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task", id));

        return task;
    }
    public Task save(TaskDto taskDto) {
        Task task = new Task();
        task.setName(taskDto.getName());
        task.setSpecification(taskDto.getSpecification());
        task.setStatus(TaskStatus.TO_DO);

        Project project = projectService.findById(taskDto.getProjectId());
        task.setProject(project);

        return taskRepository.save(task);
    }

    public Task update(TaskDto taskDto) {
        Task task = findById(taskDto.getId());
        task.setStatus(taskDto.getStatus());
        taskRepository.save(task);

        projectService.updateStatus(task.getProject());
        return task;
    }
}
