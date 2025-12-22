package com.example.taskmanager.service;

import com.example.taskmanager.exceptions.TaskNotFoundException;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAll(){
        return taskRepository.findAll();
    }

    public Task findById(Long id){
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException());

        return task;
    }

    public Task save(Task task){
        return taskRepository.save(task);
    }

    public Task update(Long id, Task task){
        Task taskToUpdate = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException());

        BeanUtils.copyProperties(task, taskToUpdate, "idTask", "creationDate");
        return taskRepository.save(taskToUpdate);
    }

    public void delete(Long id){
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException());

        taskRepository.delete(task);
    }
}
