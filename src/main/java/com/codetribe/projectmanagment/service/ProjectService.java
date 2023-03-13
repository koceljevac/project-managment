package com.codetribe.projectmanagment.service;

import com.codetribe.projectmanagment.ResourceNotFoundException;
import com.codetribe.projectmanagment.dto.ProjectDto;
import com.codetribe.projectmanagment.model.Project;
import com.codetribe.projectmanagment.model.ProjectStatus;
import com.codetribe.projectmanagment.model.Task;
import com.codetribe.projectmanagment.model.TaskStatus;
import com.codetribe.projectmanagment.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    public Iterable<Project> findAll() {
        return projectRepository.findAll();
    }

    public Project findById(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project", id));

        return project;
    }

    public Project save(ProjectDto projectDto) {
        Project project = new Project();
        project.setName(projectDto.getName());
        project.setStartDate(projectDto.getStartDate());
        project.setDeadline(projectDto.getDeadline());
        project.setClientName(projectDto.getClientName());
        project.setDescription(projectDto.getDescription());
        project.setStatus(ProjectStatus.PLANNING);

        return projectRepository.save(project);
    }

    public Project updateStatus(Project project) {
        boolean hasToDo = false;
        boolean hasInProgress = false;
        boolean hasDone = false;
        for (Task task: project.getTasks()) {
            if (task.getStatus() == TaskStatus.TO_DO) {
                hasToDo = true;
            }
            if (task.getStatus() == TaskStatus.IN_PROGRESS) {
                hasInProgress = true;
            }
            if (task.getStatus() == TaskStatus.DONE) {
                hasDone = true;
            }
        }

        if (hasDone && !hasInProgress && !hasToDo) {
            project.setStatus(ProjectStatus.FINISHED);
        } else if (hasDone || hasInProgress) {
            project.setStatus(ProjectStatus.DEVELOPMENT);
        } else {
            project.setStatus(ProjectStatus.PLANNING);
        }

        return projectRepository.save(project);

    }
}
