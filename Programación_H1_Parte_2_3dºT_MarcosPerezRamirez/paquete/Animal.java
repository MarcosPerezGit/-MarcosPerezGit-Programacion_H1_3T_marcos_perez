package paquete; // Aquí se está indicando que esta clase forma parte del paquete llamado "paquete"

public abstract class Animal { // Clase abstracta llamada "Animal", no se puede instanciar directamente
    public String chip;       // Atributo que guarda el número de chip del animal
    public String nombre;     // Atributo para el nombre del animal
    public int edad;          // Atributo que indica la edad del animal
    public String raza;       // Atributo para la raza del animal
    public boolean adoptado;  // Atributo booleano que indica si el animal ha sido adoptado o no

    // Constructor que recibe todos los atributos como parámetros y los asigna
    public Animal(String chip, String nombre, int edad, String raza, boolean adoptado) {
        this.chip = chip;
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
        this.adoptado = adoptado;
    }

    // Método abstracto que deben implementar las clases hijas
    public abstract void mostrar(); // No tiene cuerpo aquí porque depende del tipo específico de animal
}