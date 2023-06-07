package Hoteles;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class HotelReservationCLI {
    private Scanner scanner;

    public HotelReservationCLI() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean exit = false;
        Cliente sesion_actual = null;
        int opcion;
        ArrayList<Cliente> baseclientes = new ArrayList<>();
        System.out.print("\033c");
        while (!exit) {
            if (sesion_actual == null){
                System.out.println("Bienvenido a Hotelaltoque");
                System.out.println("Selecciona una opci�n:");
                System.out.println("1. Iniciar Sesion");
                System.out.println("2. Registrarse");
                System.out.println("0. Salir");
                System.out.print("Opci�n: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer
                switch (opcion) {
                    case 1:
                        sesion_actual = Cliente.iniciarSesion2(scanner,baseclientes);
                        break;
                    case 2:
                    baseclientes.add(Cliente.registrar2(scanner));
                        break;
                    case 0:
                        exit = true;
                        break;
                    default:
                        System.out.println("Opci�n inv�lida. Por favor, elige una opci�n v�lida.");
                        break;
                    }
            }else{
                System.out.println("Bienvenido a Hotelaltoque");
                System.out.println("Selecciona una opci�n:");
                System.out.println("1. Buscar hoteles");
                System.out.println("2. Realizar reserva");
                System.out.println("3. Consultas y reclamos");
                System.out.println("0. Salir");
                System.out.print("Opci�n: ");
                
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
                        gestionarConsultas();
                        break;
                    case 0:
                        exit = true;
                        break;
                    default:
                        System.out.println("Opci�n inv�lida. Por favor, elige una opci�n v�lida.");
                        break;
                    }
                }
        }
        
        scanner.close();
        System.out.println("Gracias por utilizar Hotelaltoque. �Hasta luego!");
    }
    
    public void buscarHoteles(Scanner scanner) {
        System.out.println("B�squeda de hoteles");
        System.out.print("Ingrese la categor�a m�nima: ");
        int categoriaMinima = scanner.nextInt();
        System.out.print("Ingrese la capacidad m�nima: ");
        int capacidadMinima = scanner.nextInt();

        List<Hotel> hotelesEncontrados = SistemaReservas.buscarHoteles(categoriaMinima, capacidadMinima);

        if (hotelesEncontrados.isEmpty()) {
            System.out.println("No se encontraron hoteles que cumplan los criterios de b�squeda.");
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
            System.out.println("Cliente no encontrado. Reg�strese antes de realizar una reserva.");
            return;
        }

        System.out.print("Ingrese el nombre del hotel: ");
        String nombreHotel = scanner.nextLine();
        Hotel hotel = SistemaReservas.buscarHotel(nombreHotel);

        if (hotel == null) {
            System.out.println("Hotel no encontrado. Intente nuevamente.");
            return;
        } 
        
     // L�gica para seleccionar una habitaci�n
        
        System.out.print("Ingrese el n�mero de habitaci�n: ");
        int numeroHabitacion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner

        // Buscar la habitaci�n por su n�mero en el hotel correspondiente
        Habitacion habitacion = hotel.buscarHabitacionPorNumero(numeroHabitacion);

        // Verificar si la habitaci�n existe y est� disponible
        if (habitacion == null) {
            System.out.println("La habitaci�n no existe en este hotel. Intente nuevamente.");
            return;
        }

        if (!habitacion.isDisponibilidad()) {
            System.out.println("La habitaci�n seleccionada no est� disponible. Intente nuevamente.");
            return;
        }

        // Verificar si la capacidad de la habitaci�n es suficiente
        System.out.print("Ingrese la cantidad de personas: ");
        int cantidadPersonas = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner
        if (habitacion.getCapacidad() < cantidadPersonas) {
            System.out.println("La habitaci�n seleccionada no tiene suficiente capacidad. Intente nuevamente.");
            return;
        }

        // L�gica para seleccionar las fechas de reserva, check-in y check-out
        System.out.print("Ingrese la fecha de reserva: ");
        String fechaReserva = scanner.nextLine();

        System.out.print("Ingrese la fecha de check-in(formato AAMMDD): ");
        String fechaCheckIn = scanner.nextLine();

        System.out.print("Ingrese la fecha de check-out(formato AAMMDD): ");
        String fechaCheckOut = scanner.nextLine();


        // L�gica para seleccionar habitaci�n, fecha de reserva, etc.

        Reserva reserva = new Reserva(cliente, hotel, habitacion, fechaReserva, fechaCheckIn, fechaCheckOut); // Crear objeto Reserva con los datos necesarios
        SistemaReservas.realizarReserva(reserva);

        System.out.println("Reserva realizada con �xito.");
    }

    
    private void gestionarConsultas() {
        // Implementa la l�gica para gestionar consultas y reclamos
        // Puedes permitir al usuario enviar una consulta y mostrar la respuesta correspondiente
    }

    public static void main(String[] args) {
        HotelReservationCLI cli = new HotelReservationCLI();
        cli.start();
    }
}
