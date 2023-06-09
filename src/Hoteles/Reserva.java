<<<<<<< HEAD
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
=======
package Hoteles;

public class Reserva {
    private Cliente cliente;
    private Hotel hotel;
    private Habitacion habitacion;
    private Paquete paquete;
    private String fechaReserva;
    private String fechaCheckIn;
    private String fechaCheckOut;
    private String metodoPago;

    public Reserva(Cliente cliente, Hotel hotel, Habitacion habitacion, String fechaReserva, String fechaCheckIn, String fechaCheckOut, String metodoPago) {
        this.cliente = cliente;
        this.hotel = hotel;
        this.habitacion = habitacion;
        this.fechaReserva = fechaReserva;
        this.fechaCheckIn = fechaCheckIn;
        this.fechaCheckOut = fechaCheckOut;
        this.metodoPago = metodoPago;
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

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public void setFechaCheckIn(String fechaCheckIn) {
        this.fechaCheckIn = fechaCheckIn;
    }

    public void setFechaCheckOut(String fechaCheckOut) {
        this.fechaCheckOut = fechaCheckOut;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }
}
>>>>>>> aa4c975 (se agrego la eleccion de metodo de pago)
