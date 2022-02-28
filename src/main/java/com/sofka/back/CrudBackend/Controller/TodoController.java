package com.sofka.back.CrudBackend.Controller;

import java.util.ArrayList;
import java.util.List;
//import java.util.List;
import java.util.Optional;

import com.sofka.back.CrudBackend.Models.Todo;
import com.sofka.back.CrudBackend.Models.TodoList;
import com.sofka.back.CrudBackend.Services.TodoListService;
import com.sofka.back.CrudBackend.Services.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class TodoController {

    @Autowired
    private TodoService service;

    @Autowired
    private TodoListService services;

    @GetMapping(path = "/todolist")
    public ArrayList<TodoList> list(){
        return services.list();
    }

    @PostMapping(path = "/todolist")
    public TodoList save(@RequestBody TodoList todo){
        return services.save(todo);
    }

    @PutMapping(path = "/todolist")
    public TodoList update(@RequestBody TodoList todo){
        if(todo.getId() != null){
            return services.save(todo);
        }
        throw new RuntimeException("No existe el id para actualziar");
    }

    @DeleteMapping(path = "/todolist/delete/{id}")
    public void deleteList(@PathVariable("id") Long id){
        services.deleteList(id);
    }

    @GetMapping(path = "/todolist/todo")
    public List<Todo> listTodo(){
        return service.listTodo();
    }

    @GetMapping(path = "/todolist/todo/{relation}")
    public List<Todo> getByRelation(@PathVariable("relation") TodoList relation){
        return (List<Todo>) service.getByRelation(relation);
    }

    @PostMapping(path = "/todolist/todo")
    public Todo save(@RequestBody Todo todo){
        return service.save(todo);
    }

    @PutMapping(value = "/todolist/todo")
    public Todo update(@RequestBody Todo todo){
        if(todo.getId() != null){
            return service.save(todo);
        }
        throw new RuntimeException("No existe el id para actualziar");
    }

    @DeleteMapping(path = "/todolist/{id}/todo")
    public void delete(@PathVariable("id") Long id){
        service.delete(id);
    }

    @GetMapping(path = "/todolist/{id}")
    public Optional<Todo> get(@PathVariable("id") Long id){
        return service.get(id);
    }

}