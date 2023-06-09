
package Hoteles;

import java.util.ArrayList;
import java.util.List;

public class SistemaReservas {
    private static List<Hotel> hoteles;
    private static List<Cliente> clientes;
    private static List<Reserva> reservas;
    private static List<Paquete> paquetes;
    private static SistemaReservas sistemaReservas;

    public SistemaReservas() {
        hoteles = new ArrayList<>();
        clientes = new ArrayList<>();
        reservas = new ArrayList<>();
        paquetes = new ArrayList<>();
        

        // Inicializar la lista de hoteles con datos de prueba
        Hotel hotelA = new Hotel("Hotel A", "Ubicacion A", 4, 100);
        Hotel hotelB = new Hotel("Hotel B", "Ubicacion B", 3, 80);
        Hotel hotelC = new Hotel("Hotel C", "Ubicacion C", 5, 120);
        //hoteles.add(new Hotel("Hotel A", "Ubicaci�n A", 4, 100));
        //hoteles.add(new Hotel("Hotel B", "Ubicaci�n B", 3, 80));
        //hoteles.add(new Hotel("Hotel C", "Ubicaci�n C", 5, 120));
        hoteles.add(hotelA);
        hoteles.add(hotelB);
        hoteles.add(hotelC);

        hotelA.agregarHabitacion(new Habitacion(1,2));
        hotelA.agregarHabitacion(new Habitacion(2, 2));
        hotelA.agregarHabitacion(new Habitacion(3,4));
        hotelA.agregarHabitacion(new Habitacion(4, 1));
        hotelA.agregarHabitacion(new Habitacion(5,2));
        hotelB.agregarHabitacion(new Habitacion(2, 2));
        hotelB.agregarHabitacion(new Habitacion(1,2));
        hotelB.agregarHabitacion(new Habitacion(2, 2));
        hotelC.agregarHabitacion(new Habitacion(3,4));
        hotelC.agregarHabitacion(new Habitacion(4, 1));
        hotelC.agregarHabitacion(new Habitacion(5,2));

        Paquete paquete1 = new Paquete("dayTour", "visita guiada por la ciudad", 2.500);
        Paquete paquete2 = new Paquete("museo", "visita a un museo importante de la ciudad", 4.500);

        paquetes.add(paquete1);
        paquetes.add( paquete2);
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

    public static Paquete buscarPaquete(String nombrePaquete) {
        for(Paquete paquete : paquetes) {
            if(paquete.getNombre().equalsIgnoreCase(nombrePaquete)){
                return paquete;
            }
        }
        return null;
    }
    
    // Resto de los m�todos de la clase SistemaReservas
    // ...
}

