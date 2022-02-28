package com.sofka.back.CrudBackend.Repositories;

import com.sofka.back.CrudBackend.Models.TodoList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoListRepository extends CrudRepository<TodoList, Long>{

}
