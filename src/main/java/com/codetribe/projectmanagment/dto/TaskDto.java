package com.codetribe.projectmanagment.dto;

import com.codetribe.projectmanagment.model.TaskStatus;

public class TaskDto {
    private Long id;

    private String name;

    private String specification;

    private TaskStatus status;

    private Long projectId;

    public TaskDto(String name, String specification, TaskStatus status, Long projectId) {
        this.name = name;
        this.specification = specification;
        this.status = status;
        this.projectId = projectId;
    }

    public TaskDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
