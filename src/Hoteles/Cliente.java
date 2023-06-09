package Hoteles;

import java.util.Scanner;
import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private String apellido;
    private String domicilio;
    private String DNI;
    private String fechaNacimiento;
    private String datosTarjetaCredito;
    private String email;
    private String contrasena;
    private String cuentaBancaria;
    private String cuentaMercadoPago;

    public Cliente(String nombre, String apellido, String domicilio, String DNI, String fechaNacimiento,
                   String datosTarjetaCredito, String email, String contrasena, String cuentaBancaria, String cuentaMercadoPago) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.DNI = DNI;
        this.fechaNacimiento = fechaNacimiento;
        this.datosTarjetaCredito = datosTarjetaCredito;
        this.email = email;
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDatosTarjetaCredito() {
        return datosTarjetaCredito;
    }

    public void setDatosTarjetaCredito(String datosTarjetaCredito) {
        this.datosTarjetaCredito = datosTarjetaCredito;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(String cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public String getCuentaMercadoPago() {
        return cuentaMercadoPago;
    }

    public void setCuentaMercadoPago(String cuentaMercadoPago) {
        this.cuentaMercadoPago = cuentaMercadoPago;
    }

    // Métodos adicionales
    public void registrarCuentaBancaria(String cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public void registrarCuentaMercadoPago(String cuentaMercadoPago) {
        this.cuentaMercadoPago = cuentaMercadoPago;
    }

    public static Cliente registrar(Scanner scanner) {
        String nombre, apellido, domicilio, DNI, fechaNacimiento, datosTarjetaCredito,
                email, contrasena, cuentaBancaria, cuentaMercadoPago;
        Cliente nuevo_cliente;

        System.out.println("Ingrese su Nombre:");
        nombre = scanner.nextLine();
        System.out.println("Ingrese su Apellido:");
        apellido = scanner.nextLine();
        System.out.println("Ingrese su domicilio:");
        domicilio = scanner.nextLine();
        System.out.println("Ingrese su DNI:");
        DNI = scanner.nextLine();
        System.out.println("Ingrese su fecha de nacimiento:");
        fechaNacimiento = scanner.nextLine();
        System.out.println("Ingrese sus datos de Tarjeta de Credito:");
        datosTarjetaCredito = scanner.nextLine();
        System.out.println("Ingrese su email:");
        email = scanner.nextLine();
        System.out.println("Ingrese su contraseña:");
        contrasena = scanner.nextLine();
        System.out.println("Ingrese su cuentaBancaria:");
        cuentaBancaria = scanner.nextLine();
        System.out.println("Ingrese su cuentaMercadoPago:");
        cuentaMercadoPago = scanner.nextLine();

        nuevo_cliente = new Cliente(nombre, apellido, domicilio,
                DNI, fechaNacimiento, datosTarjetaCredito, email, contrasena, cuentaBancaria, cuentaMercadoPago);

        SistemaReservas sistema = SistemaReservas.getSistemaReservas();
        sistema.agregarCliente(nuevo_cliente);

        System.out.print("\033c");
        System.out.println("Usuario registrado exitosamente.\n");

        return nuevo_cliente;
    }

    public static Cliente iniciarSesion(Scanner scanner, ArrayList<Cliente> baseclientes) {
        Cliente cliente = null;
        String _email, _contrasena;

        System.out.println("Ingrese su email:");
        _email = scanner.nextLine();
        System.out.println("Ingrese su contraseña:");
        _contrasena = scanner.nextLine();

        for (Cliente i : baseclientes) {
            if (i.getEmail().equals(_email) && i.getContrasena().equals(_contrasena)) {
                cliente = i;
                break;
            }
        }
        System.out.print("\033c");
        if (cliente != null) {
            System.out.println("Inicio de sesión exitoso.\n");
        } else {
            System.out.println("Email o contraseña incorrectos.\n");
        }
        return cliente;
    }
}