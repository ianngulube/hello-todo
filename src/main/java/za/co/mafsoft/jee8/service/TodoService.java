package za.co.mafsoft.jee8.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import za.co.mafsoft.jee8.entity.Todo;

import java.util.List;

@Transactional
public class TodoService {

    @PersistenceContext
    EntityManager entityManager;

    public Todo createTodo(final Todo todo) {
        entityManager.persist(todo);
        return todo;
    }

    public Todo updateTodo(final Todo todo) {
        entityManager.merge(todo);
        return todo;
    }

    public Todo findTodo(final Long id) {
        return entityManager.find(Todo.class, id);
    }

    public List<Todo> getTodos() {
        return entityManager.createQuery("SELECT td FROM Todo td", Todo.class).getResultList();
    }

}
