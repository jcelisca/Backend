package com.sofka.back.CrudBackend.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.sofka.back.CrudBackend.Models.Todo;
import com.sofka.back.CrudBackend.Models.TodoList;
import com.sofka.back.CrudBackend.Repositories.TodoListRepository;
import com.sofka.back.CrudBackend.Repositories.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoListService {

    @Autowired
    private TodoListRepository repository;

    @Autowired
    private TodoRepository repository2;

    public ArrayList<TodoList> list(){
        return (ArrayList<TodoList>) repository.findAll();
    }

    public TodoList save(TodoList todo){
        return repository.save(todo);
    }

    public void deleteList(Long id){
        Optional<TodoList> list = repository.findById(id);
        TodoList elem = list.get();
        List<Todo> todo = repository2.findByRelation(elem);
        repository2.deleteAll(todo);
        repository.deleteById(id);
    }
}
