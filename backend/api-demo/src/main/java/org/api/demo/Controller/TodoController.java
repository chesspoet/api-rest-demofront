package org.api.demo.Controller;

import org.api.demo.Model.Task;
import org.api.demo.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")

public class TodoController {
    @Autowired
    private TodoRepository todoRepository;
    @GetMapping(value = "/")
    public String holaMundo(){
        return "Servidor por defecto";
    }
    @GetMapping(value = "/tasks")
    public List<Task> getTask(){
        return todoRepository.findAll();
    }
    @PostMapping(value = "/savetask")
    public String saveTask(@RequestBody Task task){
        todoRepository.save(task);
        return "Tarea guardada";
    }
    @PutMapping(value = "/update/{id}")
    public String updateTask(@PathVariable long id, @RequestBody Task task){
        Task updateTask = todoRepository.findById(id).get();
        updateTask.setTitulo(task.getTitulo());
        updateTask.setDescripcion(task.getDescripcion());
        todoRepository.save(updateTask);
        return "La tarea a sido actualizada";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteTask(@PathVariable long id){
        Task deleteTask = todoRepository.findById(id).get();
        todoRepository.delete(deleteTask);
        return "La tarea ha sido borrada";
    }
}
