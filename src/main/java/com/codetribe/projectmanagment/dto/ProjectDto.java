package com.codetribe.projectmanagment.dto;

import com.codetribe.projectmanagment.model.ProjectStatus;

import java.time.LocalDateTime;
import java.util.List;

public class ProjectDto {
    private String name;

    private LocalDateTime startDate;

    private LocalDateTime deadline;

    private String clientName;

    private String description;

    private ProjectStatus status;

    private List<TaskDto> tasks;

    public ProjectDto(String name, LocalDateTime startDate, LocalDateTime deadline, String clientName, String description, ProjectStatus status) {
        this.name = name;
        this.startDate = startDate;
        this.deadline = deadline;
        this.clientName = clientName;
        this.description = description;
        this.status = status;
    }

    public ProjectDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }
}
