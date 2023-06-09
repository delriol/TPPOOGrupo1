package Hoteles;
import java.util.Scanner;
public class Encuesta {
    String nombre;
    Scanner scanner;
     
    
    public void hacerEncuesta(Scanner scanner) {
        String respuesta;
        System.out.println("Ingrese su nombre por favor : ");
        nombre = scanner.nextLine();
        scanner.nextLine();

        System.out.println(nombre + " ,bienvenido a la encuesta de satisfacion de HotelAlToque ");
        System.out.println(" Pudo registrarse facilmente? SI / NO ");
        respuesta = scanner.nextLine();
        scanner.nextLine();

        if(respuesta.equals("SI")){
            System.out.println("Pudo elegir habitacion en el hotel deseado ? SI / NO ");
            respuesta = scanner.nextLine();
            scanner.nextLine();

            if(respuesta.equals("SI")) {
                System.out.println("Encontro habitacion para la fecha deseada? SI / NO ");
                respuesta = scanner.nextLine();
                scanner.nextLine();

                if(respuesta.equals("SI")) {
                    System.out.println("Espacio para dejar un comentario sobre su experiencia al usar la app ");
                    respuesta = scanner.nextLine();
                    scanner.nextLine();

                }else{
                    System.out.println("Puede dejar un comentario al respecto de porque no consiguio habitacion: ");
                    respuesta = scanner.nextLine();
                    scanner.nextLine();
                }
            }else{
                System.out.println("Eligio en otro hotel ? SI / NO ");
                respuesta = scanner.nextLine();
                scanner.nextLine();

                if(respuesta.equals("SI")) {
                    System.out.println("Encontro habitacion para la fecha deseada? SI / NO");
                    respuesta = scanner.nextLine();
                    scanner.nextLine();

                    if(respuesta.equals("SI")) {
                        System.out.println("Espacio para dejar un comentario sobre su experiencia al usar la app ");
                        respuesta = scanner.nextLine();
                        scanner.nextLine();

                    }else{
                        System.out.println("Puede dejar un comentario al respecto de porque no consiguio habitacion: ");
                        respuesta = scanner.nextLine();
                        scanner.nextLine();
                    }
                }
            }
        }else{
            System.out.println("Cual fue el motivo por el cual no pudo registrarse facilmente ? ");
            respuesta = scanner.nextLine();
            scanner.nextLine();
        }
        System.out.println("Muchas gracias por contestar esta pequeña encuesta!");
    }
}
