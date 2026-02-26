package com.tt1.test;
import java.util.List;

public interface IDBStub {
    void insertToDo(ToDo todo);
    ToDo findToDo(Integer id);
    void updateToDo(ToDo todo);
    void deleteToDo(Integer id);
    List<ToDo> findAllToDos();
    void insertEmail(String email);
    List<String> findAllEmails();
}
