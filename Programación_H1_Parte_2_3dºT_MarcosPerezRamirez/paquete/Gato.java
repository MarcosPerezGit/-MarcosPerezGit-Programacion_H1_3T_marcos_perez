package paquete; // Esta clase también pertenece al paquete "paquete"

public class Gato extends Animal { // La clase "Gato" hereda de la clase abstracta "Animal"
 public boolean testLeucemia; // Atributo específico de los gatos para saber si tienen leucemia

 // Constructor que recibe todos los datos necesarios, incluidos los del animal y el test de leucemia
 public Gato(String chip, String nombre, int edad, String raza, boolean adoptado, boolean testLeucemia) {
     super(chip, nombre, edad, raza, adoptado); // Llama al constructor de la clase Animal (superclase)
     this.testLeucemia = testLeucemia; // Asigna el valor del test de leucemia
 }

 @Override
 public void mostrar() {
     // Se está implementando el método abstracto "mostrar" de la clase Animal
     System.out.println("-------- LISTA GATOS --------");
     System.out.println("CHIP: " + chip);
     System.out.println("NOMBRE: " + nombre);
     System.out.println("EDAD: " + edad);
     System.out.println("RAZA: " + raza);
     System.out.println("ADOPTADO: " + adoptado);
     System.out.println("TEST LEUCEMIA: " + testLeucemia); // Muestra si ha dado positivo o no en el test
 }
}


