package com.randy.taskmanager.dto;

import com.randy.taskmanager.entity.TaskPriority;
import com.randy.taskmanager.entity.TaskStatus;

import java.time.LocalDateTime;
import lombok.*;

@Getter
@Setter

public class TaskRequest {

    private String title;
    private String description;
    private TaskStatus status;
    private TaskPriority priority;
    private LocalDateTime dueDate;

}

