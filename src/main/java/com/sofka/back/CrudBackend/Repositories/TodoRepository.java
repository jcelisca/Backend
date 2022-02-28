package com.sofka.back.CrudBackend.Repositories;


import java.util.List;

import com.sofka.back.CrudBackend.Models.Todo;
import com.sofka.back.CrudBackend.Models.TodoList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long>{
    List<Todo> findByRelation(TodoList relation);
}
