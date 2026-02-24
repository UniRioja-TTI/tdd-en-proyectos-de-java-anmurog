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
        // Arrange: Preparamos los mocks y el servicio
        repoMock = new RepositorioMock();
        mailerMock = new MailerMock();
        servicio = new Servicio(repoMock, mailerMock);
    }

    @Test
    void testCrearToDo() {
        // Arrange
        String nombre = "Estudiar Java";
        String descripcion = "Hacer la práctica";
        LocalDate fecha = LocalDate.now();

        // Act
        servicio.crearToDo(nombre, descripcion, fecha);

        // Assert: Comprobamos que el servicio intentó guardar en el repositorio
        assertTrue(repoMock.guardarLlamado, "El repositorio debería haber sido llamado para guardar");
    }
}
