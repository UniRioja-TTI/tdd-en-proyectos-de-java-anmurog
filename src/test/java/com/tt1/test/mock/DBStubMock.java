package com.tt1.test.mock;

import com.tt1.test.IDBStub;
import com.tt1.test.ToDo;
import java.util.ArrayList;
import java.util.List;

public class DBStubMock implements IDBStub {
    public boolean insertLlamado = false;

    @Override
    public void insertToDo(ToDo todo) { insertLlamado = true; }
    @Override
    public ToDo findToDo(Integer id) { return new ToDo(); }
    @Override
    public void updateToDo(ToDo todo) {}
    @Override
    public void deleteToDo(Integer id) {}
    @Override
    public List<ToDo> findAllToDos() { return new ArrayList<>(); }
    @Override
    public void insertEmail(String email) {}
    @Override
    public List<String> findAllEmails() { return new ArrayList<>(); }
}
