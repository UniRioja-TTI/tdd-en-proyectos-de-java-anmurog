package com.tt1.test;

import java.util.*;

public class DBStub implements IDBStub{
    
	private Map<Integer, ToDo> tablaToDos = new HashMap<>();
    private Set<String> tablaEmails = new HashSet<>();
    private int idCounter = 1; // Para autogenerar IDs

    @Override
    public void insertToDo(ToDo todo) {
        if (todo.getId() == null) {
            todo.setId(idCounter++); // Le asignamos un ID único
        }
        tablaToDos.put(todo.getId(), todo);
    }

    @Override
    public ToDo findToDo(Integer id) {
        return tablaToDos.get(id);
    }

    @Override
    public void updateToDo(ToDo todo) {
        tablaToDos.put(todo.getId(), todo);
    }

    @Override
    public void deleteToDo(Integer id) {
        tablaToDos.remove(id);
    }

    @Override
    public List<ToDo> findAllToDos() {
        return new ArrayList<>(tablaToDos.values());
    }

    @Override
    public void insertEmail(String email) {
        tablaEmails.add(email);
    }

    @Override
    public List<String> findAllEmails() {
        return new ArrayList<>(tablaEmails);
    }
}
