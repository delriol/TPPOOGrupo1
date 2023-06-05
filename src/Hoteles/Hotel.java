package Hoteles;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String nombre;
    private String ubicacion;
    private int categoria;
    private int capacidadTotal;
    private List<Habitacion> habitaciones;

    // Constructor
    public Hotel(String nombre, String ubicacion, int categoria, int capacidadTotal) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.categoria = categoria;
        this.capacidadTotal = capacidadTotal;
        this.habitaciones = new ArrayList<>();
    }
    

    public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getUbicacion() {
		return ubicacion;
	}



	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}



	public int getCategoria() {
		return categoria;
	}



	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}



	public int getCapacidadTotal() {
		return capacidadTotal;
	}



	public void setCapacidadTotal(int capacidadTotal) {
		this.capacidadTotal = capacidadTotal;
	}



	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}



	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}



	// Métodos adicionales
    public void agregarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
    }


    public Habitacion buscarHabitacionPorNumero(int numeroHabitacion) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumeroHabitacion() == numeroHabitacion) {
                return habitacion;
            }
        }
        return null; // Si no se encuentra la habitación, se devuelve null
    }



}