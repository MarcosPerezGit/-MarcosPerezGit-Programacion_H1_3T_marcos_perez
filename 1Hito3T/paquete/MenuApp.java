package paquete; // La clase forma parte del paquete "paquete"

import java.util.HashMap;   // Importa la clase HashMap para guardar animales con su chip como clave
import java.util.Scanner;   // Importa Scanner para leer datos del usuario por consola

public class MenuApp {

    public HashMap<String, Animal> animales; // Estructura donde se guardan los animales con el chip como clave
    public Scanner entrada; // Scanner para pedir datos al usuario

    public MenuApp() {
        animales = new HashMap<>(); // Se crea el HashMap vacío
        entrada = new Scanner(System.in); // Se inicializa el Scanner
    }

    public void mostrarMenu() {
        int opcion;

        // Bucle que muestra el menú y espera una opción válida
        do {
            System.out.println("----- MENU PROTECTORA -----");
            System.out.println("1- DAR DE ALTA A UN ANIMAL");
            System.out.println("2- BUSCAR ANIMAL POR NUMERO DE CHIP");
            System.out.println("3- MOSTRAR TODOS LOS ANIMALES");
            System.out.println("0- SALIR");
            System.out.print("ELIGE UNA OPCION: ");

            opcion = entrada.nextInt();  // Lee la opción del usuario
            entrada.nextLine(); // Limpia el buffer

            switch (opcion) {
                case 1:
                    darAltaAnimal(); // Llama al método para registrar un nuevo animal
                    break;
                case 2:
                    buscarAnimalPorChip(); // Llama al método para buscar un animal por chip
                    break;
                case 3:
                    mostrarTodos(); // Muestra todos los animales registrados
                    break;
                case 0:
                    System.out.println("APAGANDO SISTEMA...");
                    System.out.println("SISTEMA APAGADO");
                    break;
                default:
                    System.out.println("ERROR, INTRODUCE UNA OPCION QUE SEA VALIDA");
            }
        } while (opcion != 0); // Se repite hasta que el usuario elija salir (0)
    }

    public void darAltaAnimal() {
        // Pide el chip y comprueba si ya existe
        System.out.print("INTRODUCE EL NUMERO DE CHIP ");
        String chip = entrada.nextLine();

        if (animales.containsKey(chip)) {
            System.out.println("ERROR, ESTE NUMERO DE CHIP YA EXISTE.");
        } else {
            // Si no existe, pide el resto de datos
            System.out.print("NOMBRE: ");
            String nombre = entrada.nextLine().toLowerCase();

            System.out.print("EDAD: ");
            int edad = entrada.nextInt();
            entrada.nextLine();

            System.out.print("RAZA: ");
            String raza = entrada.nextLine();

            System.out.print("ESTA ADOPTADO? TRUE o FALSE: ");
            boolean adoptado = entrada.nextBoolean();
            entrada.nextLine();

            System.out.print("ES UN PERRO O UN GATO (PERRO/GATO): ");
            String tipo = entrada.nextLine().toUpperCase();

            Animal animal = null;

            if (tipo.equals("PERRO")) {
                // Si es perro, pide el tamaño
                System.out.print("TAMAÑO (PEQUEÑO/MEDIANO/GRANDE): ");
                String tamaño = entrada.nextLine();
                animal = new Perro(chip, nombre, edad, raza, adoptado, tamaño);

            } else if (tipo.equals("GATO")) {
                // Si es gato, pregunta por el test de leucemia
                System.out.print("HA HECHO EL TEST DE LEUCEMIA? TRUE o FALSE: ");
                boolean testLeucemia = entrada.nextBoolean();
                entrada.nextLine();
                animal = new Gato(chip, nombre, edad, raza, adoptado, testLeucemia);

            } else {
                System.out.println("NO CONTEMPLAMOS ALGO QUE NO SEA PERRO O GATO");
            }

            if (animal != null) {
                animales.put(chip, animal); // Añade el animal al mapa
                System.out.println("SE HA REGISTRADO AL ANIMAL");
            }
        }
    }

    public void buscarAnimalPorChip() {
        // Pide un chip y muestra la info del animal si existe
        System.out.print("INTRODUCE EL NUMERO DE CHIP ");
        String chip = entrada.nextLine();

        Animal animal = animales.get(chip);
        if (animal != null) {
            animal.mostrar(); // Usa el método mostrar del animal (según su clase concreta)
        } else {
            System.out.println("NO HAY NINGUN ANIMAL CON ESTE CHIP");
        }
    }

    public void mostrarTodos() {
        // Muestra todos los animales guardados en el sistema
        if (animales.isEmpty()) {
            System.out.println("NO HAY ANIMALES REGISTRADOS.");
        } else {
            for (Animal animal : animales.values()) {
                animal.mostrar();
                System.out.println("----------------------");
            }
        }
    }
}
