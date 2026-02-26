package com.tt1.test;

public class MailerStub implements IMailer{

	public boolean enviarCorreo(String direccion, String mensaje) {
        System.out.println("-> [EMAIL ENVIADO A: " + direccion + "] Mensaje: " + mensaje);
        return true;
    }
}
