package Hoteles;

import java.util.ArrayList;
import java.util.List;

public class SistemaReservas {
    private List<Hotel> hoteles;
    private List<Cliente> clientes;
    private List<Reserva> reservas;

    public SistemaReservas() {
        hoteles = new ArrayList<>();
        clientes = new ArrayList<>();
        reservas = new ArrayList<>();
    }

    public void agregarHotel(Hotel hotel) {
        hoteles.add(hotel);
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void realizarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    // Otros métodos para gestionar las reservas, buscar hoteles y paquetes, procesar pagos, etc.
}