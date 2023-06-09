package Hoteles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelReservationCLI {
    private Scanner scanner;
    private List<String> consultasPendientes;

    public HotelReservationCLI() {
        scanner = new Scanner(System.in);
        consultasPendientes = new ArrayList<>();
    }

    public void start() {
        boolean exit = false;
        Cliente sesion_actual = null;
        ArrayList<Cliente> baseclientes = new ArrayList<>();
        int opcion;

        System.out.print("\033c");
        while (!exit) {
            if (sesion_actual == null) {
                System.out.println("Bienvenido a Hotelaltoque");
                System.out.println("Selecciona una opción:");
                System.out.println("1. Iniciar Sesión");
                System.out.println("2. Registrarse");
                System.out.println("0. Salir");
                System.out.print("Opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();
                switch (opcion) {
                    case 1:
                        sesion_actual = Cliente.iniciarSesion(scanner, baseclientes);
                        break;
                    case 2:
                        Cliente clienteRegistrado = Cliente.registrar(scanner);
                        if (clienteRegistrado != null) {
                            sesion_actual = clienteRegistrado;
                        }
                        break;
                    case 0:
                        exit = true;
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, elige una opción válida.");
                        break;
                }
            } else {
                System.out.println("Bienvenido a Hotelaltoque");
                System.out.println("Selecciona una opción:");
                System.out.println("1. Buscar hoteles");
                System.out.println("2. Realizar reserva");
                System.out.println("3. Consultas y reclamos");
                System.out.println("0. Salir");
                System.out.print("Opción: ");

                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        buscarHoteles(scanner);
                        break;
                    case 2:
                        realizarReserva(scanner);
                        break;
                    case 3:
                        gestionarConsultas(this.consultasPendientes);
                        break;
                    case 0:
                        exit = true;
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, elige una opción válida.");
                        break;
                }
            }
        }

        scanner.close();
        System.out.println("Gracias por utilizar Hotelaltoque. ¡Hasta luego!");
    }

    public void buscarHoteles(Scanner scanner) {
        System.out.println("Búsqueda de hoteles");
        System.out.print("Ingrese la categoría mínima: ");
        int categoriaMinima = scanner.nextInt();
        System.out.print("Ingrese la capacidad mínima: ");
        int capacidadMinima = scanner.nextInt();
        scanner.nextLine();

        List<Hotel> hotelesEncontrados = SistemaReservas.buscarHoteles(categoriaMinima, capacidadMinima);

        if (hotelesEncontrados.isEmpty()) {
            System.out.println("No se encontraron hoteles que cumplan los criterios de búsqueda.");
        } else {
            System.out.println("Hoteles encontrados:");
            for (Hotel hotel : hotelesEncontrados) {
                System.out.println(hotel.getNombre() + " - " + hotel.getUbicacion());
            }
        }
    }

    public void realizarReserva(Scanner scanner) {
        System.out.println("Realizar reserva");
        System.out.print("Ingrese su nombre de cliente: ");
        String nombreCliente = scanner.nextLine();
        Cliente cliente = SistemaReservas.buscarCliente(nombreCliente);

        if (cliente == null) {
            System.out.println("Cliente no encontrado. Regístrese antes de realizar una reserva.");
            return;
        }

        System.out.print("Ingrese el nombre del hotel: ");
        String nombreHotel = scanner.nextLine();
        Hotel hotel = SistemaReservas.buscarHotel(nombreHotel);

        if (hotel == null) {
            System.out.println("Hotel no encontrado. Intente nuevamente.");
            return;
        }

        // Lógica para seleccionar una habitación
        System.out.println("Habitaciones disponibles en " + hotel.getNombre() + ":");
        List<Habitacion> habitaciones = hotel.getHabitaciones();
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.isDisponibilidad()) {
                System.out.println("Número de habitación: " + habitacion.getNumeroHabitacion() + " - Capacidad: " + habitacion.getCapacidad());
            }
        }

        System.out.print("Ingrese el número de habitación: ");
        int numeroHabitacion = scanner.nextInt();
        scanner.nextLine();

        // Buscar la habitación por su número en el hotel correspondiente
        Habitacion habitacion = hotel.buscarHabitacionPorNumero(numeroHabitacion);

        // Verificar si la habitación existe y está disponible
        if (habitacion == null) {
            System.out.println("La habitación no existe en este hotel. Intente nuevamente.");
            return;
        }

        if (!habitacion.isDisponibilidad()) {
            System.out.println("La habitación seleccionada no está disponible. Intente nuevamente.");
            return;
        }

        // Verificar si la capacidad de la habitación es suficiente
        System.out.print("Ingrese la cantidad de personas: ");
        int cantidadPersonas = scanner.nextInt();
        scanner.nextLine();
        if (habitacion.getCapacidad() < cantidadPersonas) {
            System.out.println("La habitación seleccionada no tiene suficiente capacidad. Intente nuevamente.");
            return;
        }

        // Lógica para seleccionar las fechas de reserva, check-in y check-out
        System.out.print("Ingrese la fecha de reserva: ");
        String fechaReserva = scanner.nextLine();

        System.out.print("Ingrese la fecha de check-in (formato AAMMDD): ");
        String fechaCheckIn = scanner.nextLine();

        System.out.print("Ingrese la fecha de check-out (formato AAMMDD): ");
        String fechaCheckOut = scanner.nextLine();

        String metodoPago;
        while (true) {
            System.out.print("Ingrese el método de pago (Cuenta Bancaria / Mercado Pago): ");
            metodoPago = scanner.nextLine();

            if (metodoPago.equalsIgnoreCase("Cuenta Bancaria") || metodoPago.equalsIgnoreCase("Mercado Pago")) {
                break;
            } else {
                System.out.println("Opción de método de pago inválida. Por favor, ingrese 'Cuenta Bancaria' o 'Mercado Pago'.");
            }
        }

        Reserva reserva = new Reserva(cliente, hotel, habitacion, fechaReserva, fechaCheckIn, fechaCheckOut, metodoPago);
        SistemaReservas.realizarReserva(reserva);

        System.out.println("---------------------------------------------");
        System.out.println(cliente.getNombre() + " su reserva en el hotel " + hotel.getNombre() + " ,en la habitacion " + habitacion.getNumeroHabitacion() + " ,para la fecha " + fechaReserva + " ,con el metodo de pago: " + metodoPago + " . Recuerde que su fecha para checkin es : " + fechaCheckIn + " y su fecha para el checkout es: " + fechaCheckOut);
        System.out.println("---------------------------------------------");
        System.out.println("Reserva realizada con éxito.");
        Encuesta encuestaNueva = new Encuesta();
        encuestaNueva.hacerEncuesta(scanner);
    }

    public void gestionarConsultas(List<String> consultasPendientes) {
        System.out.println("Gestión de consultas y reclamos");

        if (consultasPendientes.isEmpty()) {
            System.out.println("No hay consultas o reclamos pendientes.");
        } else {
            System.out.println("Consultas y reclamos pendientes:");
            for (String consulta : consultasPendientes) {
                System.out.println("- " + consulta);
            }
        }
    }

    public static void main(String[] args) {
        HotelReservationCLI cli = new HotelReservationCLI();
        cli.start();
    }
}
