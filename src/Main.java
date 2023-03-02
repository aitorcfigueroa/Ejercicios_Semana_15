import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido al simulador de ligas.");
        ArrayList<Liga_futbol> ligas = new ArrayList<>();

        int menu = -1;
        while (menu != 0) {
            System.out.println("\nSeleccione una opción: " +
                    "\n1 - Crear una liga nueva. " +
                    "\n2 - Jugar una liga. " +
                    "\n0 - Salir.");
            menu = Input.num();
            Options(menu, ligas);
        }
    }
    
    public static void Options(int menu, ArrayList<Liga_futbol> ligas) {
        if (menu == 1) {
            System.out.println("\n¿Qué nombre desea darle a la liga?");
            String nombre = Input.str();
            Liga_futbol ligaFutbol = new Liga_futbol(nombre);
            ligas.add(ligaFutbol);
            System.out.println("Ligas actuales:");
            for (int i = 0; i < ligas.size(); i++) {
                System.out.println("- " + ligas.get(i).nombre);
            }
        } else if (menu == 2) {
            System.out.println("jugar una liga");
        } else if (menu != 0) {
            System.out.println("Por favor, seleccione una opción válida.");
        }
    }
}
