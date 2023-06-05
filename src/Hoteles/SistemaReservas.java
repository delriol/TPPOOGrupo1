package Hoteles;

import java.util.ArrayList;
import java.util.List;

public class SistemaReservas {
    private static List<Hotel> hoteles;
    private static List<Cliente> clientes;
    private static List<Reserva> reservas;

    public SistemaReservas() {
        hoteles = new ArrayList<>();
        clientes = new ArrayList<>();
        reservas = new ArrayList<>();

        // Inicializar la lista de hoteles con datos de prueba
        hoteles.add(new Hotel("Hotel A", "Ubicación A", 4, 100));
        hoteles.add(new Hotel("Hotel B", "Ubicación B", 3, 80));
        hoteles.add(new Hotel("Hotel C", "Ubicación C", 5, 120));
    }

    public void agregarHotel(Hotel hotel) {
        hoteles.add(hotel);
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public static void realizarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public static List<Hotel> buscarHoteles(int categoria, int capacidadMinima) {
        List<Hotel> hotelesEncontrados = new ArrayList<>();

        for (Hotel hotel : hoteles) {
            if (hotel.getCategoria() >= categoria && hotel.getCapacidadTotal() >= capacidadMinima) {
                hotelesEncontrados.add(hotel);
            }
        }

        return hotelesEncontrados;
    }

    public static Cliente buscarCliente(String nombreCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombreCliente)) {
                return cliente;
            }
        }
        return null; // Si no se encuentra el cliente
    }

    public static Hotel buscarHotel(String nombreHotel) {
        for (Hotel hotel : hoteles) {
            if (hotel.getNombre().equalsIgnoreCase(nombreHotel)) {
                return hotel;
            }
        }
        return null; // Si no se encuentra el hotel
    }

    // Resto de los métodos de la clase SistemaReservas
    // ...
}
