<<<<<<< HEAD
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
=======
package Hoteles;

import java.util.ArrayList;
import java.util.List;

public class SistemaReservas {
    private static List<Hotel> hoteles;
    private static List<Cliente> clientes;
    private static List<Reserva> reservas;
    private static SistemaReservas sistemaReservas;

    public SistemaReservas() {
        hoteles = new ArrayList<>();
        clientes = new ArrayList<>();
        reservas = new ArrayList<>();
        

        // Inicializar la lista de hoteles con datos de prueba
        Hotel hotelA = new Hotel("Hotel A", "Ubicacion A", 4, 100);
        Hotel hotelB = new Hotel("Hotel B", "Ubicacion B", 3, 80);
        Hotel hotelC = new Hotel("Hotel C", "Ubicacion C", 5, 120);
        //hoteles.add(new Hotel("Hotel A", "Ubicaciï¿½n A", 4, 100));
        //hoteles.add(new Hotel("Hotel B", "Ubicaciï¿½n B", 3, 80));
        //hoteles.add(new Hotel("Hotel C", "Ubicaciï¿½n C", 5, 120));
        hoteles.add(hotelA);
        hoteles.add(hotelB);
        hoteles.add(hotelC);

        hotelA.agregarHabitacion(new Habitacion(1,2));
        hotelA.agregarHabitacion(new Habitacion(2, 2));
    }
    
    public static SistemaReservas getSistemaReservas() {
        if (sistemaReservas == null) {
            sistemaReservas = new SistemaReservas();
        }
        return sistemaReservas;
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

    
    // Resto de los mï¿½todos de la clase SistemaReservas
    // ...
}
>>>>>>> aa4c975 (se agrego la eleccion de metodo de pago)
