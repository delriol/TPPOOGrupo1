package Hoteles;
import java.util.List;
import java.util.Scanner;


public class HotelReservationCLI {
    private Scanner scanner;

    public HotelReservationCLI() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean exit = false;
        
        while (!exit) {
            System.out.println("Bienvenido a Hotelaltoque");
            System.out.println("Selecciona una opción:");
            System.out.println("1. Buscar hoteles");
            System.out.println("2. Realizar reserva");
            System.out.println("3. Consultas y reclamos");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            
            switch (opcion) {
                case 1:
                    buscarHoteles(scanner);
                    break;
                case 2:
                    realizarReserva(scanner);
                    break;
                case 3:
                    gestionarConsultas();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, elige una opción válida.");
                    break;
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
        
        System.out.print("Ingrese el número de habitación: ");
        int numeroHabitacion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner

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
        scanner.nextLine(); // Limpiar el buffer del scanner
        if (habitacion.getCapacidad() < cantidadPersonas) {
            System.out.println("La habitación seleccionada no tiene suficiente capacidad. Intente nuevamente.");
            return;
        }

        // Lógica para seleccionar las fechas de reserva, check-in y check-out
        System.out.print("Ingrese la fecha de reserva: ");
        String fechaReserva = scanner.nextLine();

        System.out.print("Ingrese la fecha de check-in(formato AAMMDD): ");
        String fechaCheckIn = scanner.nextLine();

        System.out.print("Ingrese la fecha de check-out(formato AAMMDD): ");
        String fechaCheckOut = scanner.nextLine();


        // Lógica para seleccionar habitación, fecha de reserva, etc.

        Reserva reserva = new Reserva(cliente, hotel, habitacion, fechaReserva, fechaCheckIn, fechaCheckOut); // Crear objeto Reserva con los datos necesarios
        SistemaReservas.realizarReserva(reserva);

        System.out.println("Reserva realizada con éxito.");
    }

    
    private void gestionarConsultas() {
        // Implementa la lógica para gestionar consultas y reclamos
        // Puedes permitir al usuario enviar una consulta y mostrar la respuesta correspondiente
    }

    public static void main(String[] args) {
        HotelReservationCLI cli = new HotelReservationCLI();
        cli.start();
    }
}
