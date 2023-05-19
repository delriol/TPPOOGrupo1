package Hoteles;

public class Reserva {
    private Cliente cliente;
    private Hotel hotel;
    private Habitacion habitacion;
    private Paquete paquete;
    private String fechaReserva;
    private String fechaCheckIn;
    private String fechaCheckOut;

    public Reserva(Cliente cliente, Hotel hotel, Habitacion habitacion, Paquete paquete,
                   String fechaReserva, String fechaCheckIn, String fechaCheckOut) {
        this.cliente = cliente;
        this.hotel = hotel;
        this.habitacion = habitacion;
        this.paquete = paquete;
        this.fechaReserva = fechaReserva;
        this.fechaCheckIn = fechaCheckIn;
        this.fechaCheckOut = fechaCheckOut;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public String getFechaCheckIn() {
        return fechaCheckIn;
    }

    public String getFechaCheckOut() {
        return fechaCheckOut;
    }

}
