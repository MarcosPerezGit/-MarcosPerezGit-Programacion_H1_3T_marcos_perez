package paquete;

import java.util.HashMap;
import java.util.Scanner;

public class MenuApp {

    public HashMap<String, Animal> animales;  // Almacena los animales con su número de chip como clave
    public HashMap<String, Adopcion> adopciones;  // Almacena las adopciones por chip del animal
    public Scanner entrada;  // Objeto para leer la entrada del usuario desde la consola

    public MenuApp() {
        animales = new HashMap<>();  // Inicializa el HashMap de animales
        adopciones = new HashMap<>();  // Inicializa el HashMap de adopciones
        entrada = new Scanner(System.in);  // Inicializa el scanner para la entrada del usuario
    }

    // Método para mostrar el menú y gestionar las opciones elegidas por el usuario
    public void mostrarMenu() {
        int opcion;

        do {
            System.out.println("----- MENU PROTECTORA -----");
            System.out.println("1- DAR DE ALTA A UN ANIMAL");
            System.out.println("2- LISTAR ANIMALES");
            System.out.println("3- BUSCAR ANIMAL");
            System.out.println("4- REALIZAR ADOPCION");
            System.out.println("5- DAR DE BAJA");
            System.out.println("6- MOSTRAR ESTADISTICAS DE GATOS");
            System.out.println("7- SALIR");
            System.out.print("ELIGE UNA OPCION: ");

            opcion = entrada.nextInt();  // Lee la opción del usuario
            entrada.nextLine();  // Limpia el buffer de entrada

            // Se maneja cada opción del menú
            switch (opcion) {
                case 1:
                    darAltaAnimal();  // Dar de alta un nuevo animal
                    break;
                case 2:
                    mostrarTodos();  // Listar todos los animales
                    break;
                case 3:
                    buscarAnimalPorChip();  // Buscar un animal por su chip
                    break;
                case 4:
                    realizarAdopcion();  // Realizar la adopción de un animal
                    break;
                case 5:
                    darDeBaja();  // Eliminar un animal del sistema
                    break;
                case 6:
                    mostrarEstadisticasGatos();  // Mostrar estadísticas de gatos
                    break;
                case 7:
                    System.out.println("APAGANDO SISTEMA...");
                    break;
                default:
                    System.out.println("ERROR, INTRODUCE UNA OPCION VALIDA");  // Si la opción no es válida
            }
        } while (opcion != 7);  // El bucle sigue hasta que el usuario seleccione la opción de salir
    }

    // Método para dar de alta un nuevo animal
    public void darAltaAnimal() {
        System.out.print("INTRODUCE EL NUMERO DE CHIP ");
        String chip = entrada.nextLine();

        if (animales.containsKey(chip)) {  // Verifica si el chip ya está registrado
            System.out.println("ERROR, ESTE NUMERO DE CHIP YA EXISTE.");
        } else {
            // Solicita los datos del animal
            System.out.print("NOMBRE: ");
            String nombre = entrada.nextLine().toLowerCase();

            System.out.print("EDAD: ");
            int edad = entrada.nextInt();
            entrada.nextLine();  // Limpiar buffer

            System.out.print("RAZA: ");
            String raza = entrada.nextLine();

            System.out.print("ESTA ADOPTADO? TRUE o FALSE: ");
            boolean adoptado = entrada.nextBoolean();
            entrada.nextLine();  // Limpiar buffer

            // Pregunta si el animal es un perro o un gato
            System.out.print("ES UN PERRO O UN GATO (PERRO/GATO): ");
            String tipo = entrada.nextLine().toUpperCase();

            Animal animal = null;

            // Si es perro, se recoge el tamaño
            if (tipo.equals("PERRO")) {
                System.out.print("TAMAÑO (PEQUEÑO/MEDIANO/GRANDE): ");
                String tamaño = entrada.nextLine();
                animal = new Perro(chip, nombre, edad, raza, adoptado, tamaño);
            } 
            // Si es gato, se pregunta si ha pasado el test de leucemia
            else if (tipo.equals("GATO")) {
                System.out.print("HA HECHO EL TEST DE LEUCEMIA? TRUE o FALSE: ");
                boolean testLeucemia = entrada.nextBoolean();
                entrada.nextLine();  // Limpiar buffer
                animal = new Gato(chip, nombre, edad, raza, adoptado, testLeucemia);
            } else {
                System.out.println("PORFAVOR INTRODUZCA PERRO O GATO");
            }

            if (animal != null) {
                animales.put(chip, animal);  // Registra el animal en el sistema
                System.out.println("SE HA REGISTRADO EL ANIMAL");
            }
        }
    }

    // Método para mostrar todos los animales registrados
    public void mostrarTodos() {
        if (animales.isEmpty()) {
            System.out.println("NO HAY ANIMALES REGISTRADOS.");
        } else {
            for (Animal animal : animales.values()) {  // Itera sobre todos los animales
                animal.mostrar();  // Muestra los datos del animal
                System.out.println("----------------------");
            }
        }
    }

    // Método para buscar un animal por su chip
    public void buscarAnimalPorChip() {
        System.out.print("INTRODUCE EL NUMERO DE CHIP ");
        String chip = entrada.nextLine();

        Animal animal = animales.get(chip);  // Busca el animal por chip
        if (animal != null) {
            animal.mostrar();  // Si existe, muestra los datos
        } else {
            System.out.println("NO HAY NINGUN ANIMAL CON ESTE CHIP");
        }
    }

    // Método para realizar la adopción de un animal
    public void realizarAdopcion() {
        System.out.print("INTRODUCE EL NUMERO DE CHIP DEL ANIMAL A ADOPTAR: ");
        String chip = entrada.nextLine();

        Animal animal = animales.get(chip);  // Busca el animal por chip

        if (animal == null) {
            System.out.println("NO EXISTE UN ANIMAL CON ESE CHIP");
            return;
        }

        if (adopciones.containsKey(chip)) {  // Verifica si el animal ya ha sido adoptado
            System.out.println("ESTE ANIMAL YA ESTA ADOPTADO.");
            return;
        }

        // Solicita los datos del adoptante
        System.out.print("NOMBRE DEL ADOPTANTE: ");
        String nombreAdoptante = entrada.nextLine();

        System.out.print("DNI DEL ADOPTANTE: ");
        String dniAdoptante = entrada.nextLine();

        Adopcion adopcion = new Adopcion(nombreAdoptante, dniAdoptante);  // Crea la adopción
        adopciones.put(chip, adopcion);  // Registra la adopción
        animal.adoptado = true;  // Marca el animal como adoptado

        System.out.println("ADOPCION REALIZADA CON EXITO.");
    }

    // Método para dar de baja un animal
    public void darDeBaja() {
        System.out.print("INTRODUCE EL NUMERO DE CHIP DEL ANIMAL A DAR DE BAJA: ");
        String chip = entrada.nextLine();

        Animal animal = animales.get(chip);  // Busca el animal por chip

        if (animal == null) {
            System.out.println("NO EXISTE UN ANIMAL CON ESE CHIP");
            return;
        }

        if (adopciones.containsKey(chip)) {  // Si el animal está adoptado, se elimina la adopción
            adopciones.remove(chip); 
            System.out.println("ADOPCION ELIMINADA.");
        }

        animales.remove(chip);  // Elimina el animal del sistema
        System.out.println("ANIMAL DADO DE BAJA.");
    }

    // Método para mostrar estadísticas de gatos
    public void mostrarEstadisticasGatos() {
        int totalGatos = 0;
        int gatosConLeucemia = 0;

        for (Animal animal : animales.values()) {  // Recorre todos los animales
            if (animal instanceof Gato) {  // Filtra solo los gatos
                totalGatos++;  // Cuenta el total de gatos
                Gato gato = (Gato) animal;
                if (gato.testLeucemia) {  // Si el gato tiene test de leucemia positivo
                    gatosConLeucemia++;
                }
            }
        }

        // Muestra las estadísticas de los gatos
        System.out.println("TOTAL DE GATOS: " + totalGatos);
        System.out.println("GATOS CON TEST DE LEUCEMIA: " + gatosConLeucemia);
    }
}
