package paquete; // La clase está dentro del paquete llamado "paquete"

public class Perro extends Animal { // "Perro" es una clase que hereda de la clase abstracta "Animal"
 public String tamaño; // Atributo específico de los perros para indicar el tamaño (pequeño, mediano o grande)

 // Constructor que recibe todos los datos del perro, incluidos los del animal base y el tamaño
 public Perro(String chip, String nombre, int edad, String raza, boolean adoptado, String tamaño) {
     super(chip, nombre, edad, raza, adoptado); // Llama al constructor de la clase padre "Animal"
     this.tamaño = tamaño; // Asigna el tamaño que se ha recibido por parámetro
 }

 @Override
 public void mostrar() {
     // Implementación del método abstracto "mostrar", que viene de la clase Animal
     System.out.println("-------- LISTA PERROS --------");
     System.out.println("CHIP: " + chip);
     System.out.println("NOMBRE: " + nombre);
     System.out.println("EDAD: " + edad);
     System.out.println("RAZA: " + raza);
     System.out.println("ADOPTADO: " + adoptado);
     System.out.println("TAMAÑO: " + tamaño); // Muestra el tamaño del perro
 }
}
