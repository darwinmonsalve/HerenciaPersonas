import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class AlmacenarProfesores {
    public static void main(String[] args) {
        HashMap<Integer, Profesor> profesores = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (int i = 1; i <= 51; i++) {
            Profesor prof = crearProfesor(scanner, formatter, i);
            profesores.put(i, prof);
        }

        mostrarProfesores(profesores, scanner);
        scanner.close();
    }

    private static Profesor crearProfesor(Scanner scanner, DateTimeFormatter formatter, int i) {
        Profesor prof = new Profesor();

        System.out.println("Ingrese el nombre del profesor " + i + ":");
        prof.setNombre(scanner.nextLine());

        System.out.println("Ingrese el apellido del profesor " + i + ":");
        prof.setApellido(scanner.nextLine());

        prof.setGenero(validarGenero(scanner, i));
        prof.setEstatura(validarDouble(scanner, "Ingrese la estatura del profesor " + i + ":"));
        prof.setPeso(validarDouble(scanner, "Ingrese el peso del profesor " + i + ":"));
        prof.setFechaNacimiento(validarFecha(scanner, formatter, i));

        System.out.println("Ingrese el salón del profesor " + i + ":");
        prof.setNumSalon(Integer.parseInt(scanner.nextLine()));

        System.out.println("Ingrese la materia del profesor " + i + ":");
        prof.setMateria(scanner.nextLine());

        prof.setSalario(validarDouble(scanner, "Ingrese el salario del profesor " + i + " (sin puntos ni comas):"));

        System.out.println("Profesor " + i + " creado exitosamente.");

        return prof;
    }

    private static String validarGenero(Scanner scanner, int i) {
        while (true) {
            System.out.println("Ingrese el género del profesor " + i + "(M/F):");
            String genero = scanner.nextLine().trim().toUpperCase();
            if (genero.equals("M") || genero.equals("F")) {
                return genero;
            } else{
                System.out.println("Entrada no válida. Debe ser 'M' o 'F'.");
            }
        }
    }

    private static double validarDouble(Scanner scanner, String mensaje) {
        while (true) {
            System.out.println(mensaje);
            String input = scanner.nextLine();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Formato incorrecto. Use '.' en lugar de ','.");
            }
        }
    }

    private static LocalDate validarFecha(Scanner scanner, DateTimeFormatter formatter, int i) {
        while (true) {
            System.out.println("Ingrese la fecha de nacimiento del profesor " + i + " (yyyy-MM-dd):");
            String fechaIngresada = scanner.nextLine().trim();

            try {
                LocalDate fecha = LocalDate.parse(fechaIngresada, formatter);

                return fecha;
            } catch (Exception e) {
                System.out.println("Formato de fecha incorrecto. Use yyyy-MM-dd.");
            }
        }
    }
    private static void mostrarProfesores(HashMap<Integer, Profesor> profesores, Scanner scanner) {
        while (true) {
            System.out.println("¿Desea ver la lista de profesores registrados? (Y/N):");
            String respuesta = scanner.nextLine().trim().toUpperCase();

            if (respuesta.equals("Y")) {
                System.out.println("--- LISTA DE PROFESORES ---");
                for (int clave : profesores.keySet()) {
                    Profesor prof = profesores.get(clave);
                    System.out.println("Profesor " + clave + ":");
                    System.out.println("Nombre: " + prof.getNombre());
                    System.out.println("Apellido: " + prof.getApellido());
                    System.out.println("Género: " + prof.getGenero());
                    System.out.println("Estatura: " + prof.getEstatura());
                    System.out.println("Peso: " + prof.getPeso());
                    System.out.println("Fecha de Nacimiento: " + prof.getFechaNacimiento());
                    System.out.println("Salón: " + prof.getNumSalon());
                    System.out.println("Materia: " + prof.getMateria());
                    System.out.println("Salario: " + prof.getSalario());
                    System.out.println("----------------------------------------");
                }
                break;
            } else if (respuesta.equalsIgnoreCase("N")) {
                System.out.println("Finalizando programa...");
                break;
            } else {
                System.out.println("Entrada no válida. Use 'Y' o 'N'.");
            }
        }
    }
}