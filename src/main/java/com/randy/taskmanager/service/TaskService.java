package com.randy.taskmanager.service;

import com.randy.taskmanager.dto.TaskRequest;
import com.randy.taskmanager.dto.TaskResponse;
import com.randy.taskmanager.entity.Task;
import com.randy.taskmanager.repository.TaskRepository;
import com.randy.taskmanager.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserService userService;

    public TaskService(TaskRepository taskRepository, UserService userService) {
        this.taskRepository = taskRepository;
        this.userService = userService;
    }

    public TaskResponse createTask(TaskRequest request) {
        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setStatus(request.getStatus());
        task.setPriority(request.getPriority());
        task.setDueDate(request.getDueDate());
        task.setUser(userService.getCurrentUser());

        Task saved = taskRepository.save(task);

        TaskResponse response = new TaskResponse();
        response.setId(saved.getId());
        response.setTitle(saved.getTitle());
        response.setDescription(saved.getDescription());
        response.setStatus(saved.getStatus());
        response.setPriority(saved.getPriority());
        response.setDueDate(saved.getDueDate());

        return response;
    }

    public List<TaskResponse> getMyTasks() {
        return taskRepository.findByUserId(userService.getCurrentUser().getId())
                .stream()
                .map(task -> {
                    TaskResponse response = new TaskResponse();
                    response.setId(task.getId());
                    response.setTitle(task.getTitle());
                    response.setDescription(task.getDescription());
                    response.setStatus(task.getStatus());
                    response.setPriority(task.getPriority());
                    response.setDueDate(task.getDueDate());
                    return response;
                })
                .toList();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
    }

    public Task updateTask(Long id, Task updatedTask) {
        Task task = taskRepository.findById(id).orElseThrow();

        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setStatus(updatedTask.getStatus());
        task.setPriority(updatedTask.getPriority());
        task.setDueDate(updatedTask.getDueDate());

        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}