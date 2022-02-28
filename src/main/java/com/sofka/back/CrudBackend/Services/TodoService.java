package com.sofka.back.CrudBackend.Services;

import java.util.List;
import java.util.Optional;

import com.sofka.back.CrudBackend.Models.Todo;
import com.sofka.back.CrudBackend.Models.TodoList;
import com.sofka.back.CrudBackend.Repositories.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
/**
 * Clase que accede a los métodos que posee la interface repository
*/
public class TodoService {

    @Autowired
    private TodoRepository repository;

    /**
     * Devuelve todos los objetos Todo que contiene la base de datos
     * @return Lista de oobjetos Todo
     */
    public List<Todo> listTodo(){
        return (List<Todo>) repository.findAll();
    }

    public List<Todo> getByRelation(TodoList relation){
        return (List<Todo>) repository.findByRelation(relation);
    }


    /**
     * Guarda un nuevo objeto todo en la base de datos
     * @param todo Objeto con sus valores de atributos
     * @return Objeto guardado
     */
    public Todo save(Todo todo){
        return repository.save(todo);
    }

    /**
     * Elimina un objeto Todo
     * @param id Identificador único del objeto a eliminar
     */
    public void delete(Long id){
        repository.deleteById(id);
    }

    /**
     * Devuelve un objeto Todo buscandolo por su Id
     * @param id Identificador único del objeto a buscar
     * @return Objet Todo
     */
    public Optional<Todo> get(Long id){
        return (Optional<Todo>) repository.findById(id);
    }
}
