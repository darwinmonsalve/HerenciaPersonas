import java.time.LocalDate;

public class Profesor extends Persona {
    private String materia;
    private int numSalon;
    private double salario;

    public Profesor(){
        super();
    }

    public Profesor(String nombre, String apellido, LocalDate fechaNacimiento, String genero, double estatura, double peso, String materia, int numSalon, double salario) {
        super(nombre, apellido, fechaNacimiento, genero, estatura, peso);
        this.materia = materia;
        this.numSalon = numSalon;
        this.salario = salario;
    }

    // Getters

    public String getMateria() {
        return materia;
    }

    public int getNumSalon() {
        return numSalon;
    }

    public double getSalario() {
        return salario;
    }

    // Setters

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public void setNumSalon(int numSalon) {
        this.numSalon = numSalon;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}