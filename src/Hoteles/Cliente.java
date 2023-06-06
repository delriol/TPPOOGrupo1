package Hoteles;

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

    // Constructor
	public Cliente() {}

    public Cliente(String nombre, String apellido, String domicilio, String DNI, String fechaNacimiento,
                   String datosTarjetaCredito, String email, String contrasena) {
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


	public void setDNI(String dNI) {
		DNI = dNI;
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


	// M�todos adicionales
    public void registrarCuentaBancaria(String cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public void registrarCuentaMercadoPago(String cuentaMercadoPago) {
        this.cuentaMercadoPago = cuentaMercadoPago;
    }

	public void registrar(String nombre, String apellido, String domicilio, String DNI, String fechaNacimiento,
                      String datosTarjetaCredito, String email, String contrasena, String cuentaBancaria,
                      String cuentaMercadoPago) {
    	this.nombre = nombre;
    	this.apellido = apellido;
    	this.domicilio = domicilio;
    	this.DNI = DNI;
    	this.fechaNacimiento = fechaNacimiento;
    	this.datosTarjetaCredito = datosTarjetaCredito;
    	this.email = email;
    	this.contrasena = contrasena;
    	this.cuentaBancaria = cuentaBancaria;
    	this.cuentaMercadoPago = cuentaMercadoPago;
	}
	public void iniciarSesion(String main, String contrasena){
		if (this.email.equals(email) && this.contrasena.equals(contrasena)) {
			System.out.println("Inicio de sesión exitoso.");
		} else {
			System.out.println("Error: Email o contraseña incorrectos.");
		}
	}

	public void reservar() {}
}