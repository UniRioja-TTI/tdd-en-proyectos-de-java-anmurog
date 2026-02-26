package com.tt1.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Servicio {
    private IRepositorio repositorio;
    private IMailer mailer;

    public Servicio(IRepositorio repositorio, IMailer mailer) {
        this.repositorio = repositorio;
        this.mailer = mailer;
    }

    public void crearToDo(String nombre, String descripcion, LocalDate fechaLimite) {
        comprobarYEnviarAlertas();
        
        ToDo nuevo = new ToDo();
        nuevo.setNombre(nombre);
        nuevo.setDescripcion(descripcion);
        nuevo.setFechaLimite(fechaLimite);
        nuevo.setCompletado(false);
        
        repositorio.guardarToDo(nuevo);
    }

    public void agregarEmailAgenda(String email) {
        comprobarYEnviarAlertas();
        repositorio.guardarEmail(email);
    }

    public void marcarTareaFinalizada(Integer id) {
        comprobarYEnviarAlertas();
        repositorio.marcarComoCompletado(id);
    }

    public List<ToDo> consultarPendientes() {
        comprobarYEnviarAlertas();
        
        List<ToDo> todos = repositorio.obtenerTodosLosToDos();
        List<ToDo> pendientes = new ArrayList<>();
        
        for (ToDo t : todos) {
            if (!t.isCompletado()) {
                pendientes.add(t);
            }
        }
        return pendientes;
    }

    private void comprobarYEnviarAlertas() {
        List<ToDo> todos = repositorio.obtenerTodosLosToDos();
        boolean hayCaducadas = false;
        
        for (ToDo t : todos) {
            // Si no está completada y su fecha límite es ANTERIOR a hoy
            if (!t.isCompletado() && t.getFechaLimite() != null && t.getFechaLimite().isBefore(LocalDate.now())) {
                hayCaducadas = true;
                break;
            }
        }

        if (hayCaducadas) {
            List<String> emails = repositorio.obtenerTodosLosEmails();
            for (String email : emails) {
                mailer.enviarCorreo(email, "¡Alerta! Tienes tareas pendientes cuya fecha límite ha expirado.");
            }
        }
    }
}
