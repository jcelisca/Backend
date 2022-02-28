package com.sofka.back.CrudBackend.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity

/**
 * Clase principal que contiene los atributos de los objetos que se guardan en la base de datos
 */
@Table(name = "todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    private boolean isCompleted;

    @ManyToOne(optional = false)
    @JoinColumn(name="todolist_id", updatable = true)
    private TodoList relation;

    public Todo() {
    }

    public Todo(String name, boolean isCompleted, TodoList relation) {
        this.name = name;
        this.isCompleted = isCompleted;
        this.relation = relation;
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

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }


    public TodoList getRelation() {
        return relation;
    }

    public void setRelation(TodoList relation) {
        this.relation = relation;
    }

}
