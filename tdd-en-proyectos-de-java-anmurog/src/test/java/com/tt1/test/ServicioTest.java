package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.tt1.test.mock.MailerMock;
import com.tt1.test.mock.RepositorioMock;
import java.time.LocalDate;

public class ServicioTest {

    private Servicio servicio;
    private RepositorioMock repoMock;
    private MailerMock mailerMock;

    @BeforeEach
    void setUp() {
        
        repoMock = new RepositorioMock();
        mailerMock = new MailerMock();
        servicio = new Servicio(repoMock, mailerMock);
    }

    @Test
    void testCrearToDo() {
        
        String nombre = "Estudiar Java";
        String descripcion = "Hacer la práctica";
        LocalDate fecha = LocalDate.now();

        servicio.crearToDo(nombre, descripcion, fecha);

       assertTrue(repoMock.guardarLlamado, "El repositorio debería haber sido llamado para guardar");
    }
}
