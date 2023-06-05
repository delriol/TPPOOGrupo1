package Hoteles;

public class Habitacion {
    private int numeroHabitacion;
    private int capacidad;
    private boolean disponibilidad;

    // Constructor
    public Habitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
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
}