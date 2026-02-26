package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class ServicioIntegracionTest {

    private Servicio servicio;
    private DBStub dbReal;

    @BeforeEach
    void setUp() {
        
        dbReal = new DBStub();
        Repositorio repoReal = new Repositorio(dbReal);
        MailerStub mailerReal = new MailerStub();
        servicio = new Servicio(repoReal, mailerReal);
    }

    @Test
    void testCrearToDoIntegracion() {
        
        String nombre = "Test Integridad";
        LocalDate fecha = LocalDate.now();

        servicio.crearToDo(nombre, "Desc", fecha);

        assertEquals(1, dbReal.findAllToDos().size(), "Debería haber 1 tarea en la base de datos");
    }
}
