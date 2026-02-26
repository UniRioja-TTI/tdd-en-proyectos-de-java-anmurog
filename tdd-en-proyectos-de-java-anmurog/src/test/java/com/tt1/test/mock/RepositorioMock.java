package com.tt1.test.mock;

import com.tt1.test.IRepositorio;
import com.tt1.test.ToDo;
import java.util.ArrayList;
import java.util.List;

public class RepositorioMock implements IRepositorio {
    public boolean guardarLlamado = false;

    @Override
    public ToDo encontrarToDo(Integer id) { return new ToDo(); }
    @Override
    public void marcarComoCompletado(Integer id) {}
    @Override
    public void guardarToDo(ToDo todo) { guardarLlamado = true; }
    @Override
    public void guardarEmail(String email) {}
    @Override
    public List<ToDo> obtenerTodosLosToDos() { return new ArrayList<>(); }
    @Override
    public List<String> obtenerTodosLosEmails() { return new ArrayList<>(); }
}
