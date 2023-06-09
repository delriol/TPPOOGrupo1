<<<<<<< HEAD
package Hoteles;

public class Habitacion {
    private int numeroHabitacion;
    private int capacidad;
    private boolean disponibilidad;

    // Constructor
    public Habitacion(int numeroHabitacion, int capacidad) {
        this.numeroHabitacion = numeroHabitacion;
        this.capacidad = capacidad;
        this.disponibilidad = true;
    }

    public int getNumeroHabitacion() {
		return numeroHabitacion;
	}

	public void setNumeroHabitacion(int numeroHabitacion) {
		this.numeroHabitacion = numeroHabitacion;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public boolean isDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	// Métodos adicionales
    public void marcarComoNoDisponible() {
        disponibilidad = false;
    }

    public void marcarComoDisponible() {
        disponibilidad = true;
    }
=======
package Hoteles;

public class Habitacion {
    private int numeroHabitacion;
    private int capacidad;
    private boolean disponibilidad;

    // Constructor
    public Habitacion(int numeroHabitacion, int capacidad) {
        this.numeroHabitacion = numeroHabitacion;
		this.capacidad = capacidad;
        this.disponibilidad = true;
    }

    public int getNumeroHabitacion() {
		return numeroHabitacion;
	}

	public void setNumeroHabitacion(int numeroHabitacion) {
		this.numeroHabitacion = numeroHabitacion;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public boolean isDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	// Mï¿½todos adicionales
    public void marcarComoNoDisponible() {
        disponibilidad = false;
    }

    public void marcarComoDisponible() {
        disponibilidad = true;
    }
>>>>>>> aa4c975 (se agrego la eleccion de metodo de pago)
}