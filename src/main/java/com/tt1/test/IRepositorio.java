package com.tt1.test;
import java.util.List;

public interface IRepositorio {
    ToDo encontrarToDo(Integer id);
    void marcarComoCompletado(Integer id);
    void guardarToDo(ToDo todo);
    void guardarEmail(String email);
    List<ToDo> obtenerTodosLosToDos();
    List<String> obtenerTodosLosEmails();
}
