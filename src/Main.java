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
            LigaCreator(ligas);
        } else if (menu == 2) {
            LigaMenu(ligas);
        } else if (menu == 0) {
            System.out.println("Hasta pronto!");
        } else {
            System.out.println("Por favor, seleccione una opción válida.");
        }
    }

    public static void LigaCreator(ArrayList<Liga_futbol> ligas) {
        System.out.println("\n¿Qué nombre desea darle a la liga?");
        String nombre = Input.str();
        Liga_futbol ligaFutbol = new Liga_futbol(nombre);
        ligas.add(ligaFutbol);
        System.out.println("Ligas actuales:");
        for (int i = 0; i < ligas.size(); i++) {
            System.out.println("- " + ligas.get(i).nombre);
        }
    }

    public static void LigaMenu(ArrayList<Liga_futbol> ligas) {
        if (ligas.size() == 0) {
            System.out.println("No existe ninguna liga actualmente." +
                    "\nDebe crear una liga antes de poder jugar.");
        } else {
            int ligaSelect = -1;
            while (ligaSelect != 0) {
                System.out.println("Seleccione la liga que desea jugar:");
                for (int i = 0; i < ligas.size(); i++) {
                    System.out.println(i+1 + " - " + ligas.get(i).nombre);
                }
                System.out.println("0 - Volver al menú anterior.");
                ligaSelect = Input.num();
                if(ligaSelect != 0) {
                    JugarLiga(ligas, ligaSelect-1);
                }
            }

        }
    }

    public static void JugarLiga(ArrayList<Liga_futbol> ligas, int index) {
        int select = -1;
        while (select != 0) {
            System.out.println("\nSeleccione que desea hacer:" +
                    "\n0 - Pausar liga (salir al menú anterior)." +
                    "\n1 - Siguiente jornada." +
                    "\n2 - Consultar clasificación." +
                    "\n3 - Eliminar liga actual.");
            select = Input.num();
            if (select == 1) {
                //TODO: Siguiente jornada.
            } else if (select == 2) {
                ligas.get(index).clasificacion();
            } else if (select == 3) {
                EliminarLiga(ligas, index);
            } else if (select == 0) {
                System.out.println("Cerrando liga " + ligas.get(index).nombre);
            } else {
                System.out.println("Por favor, seleccione una opción válida.");
            }
        }
    }

    public static void EliminarLiga(ArrayList<Liga_futbol> ligas, int index) {
        int confirmation = -1;
        while (confirmation != 0) {
            String nombreLiga = ligas.get(index).nombre;
            System.out.println("¿Desea eliminar la liga " + nombreLiga + " ?" +
                    "\n1 - Sí, elimínala." +
                    "\n0 - No, no deseo eliminarla.");
            confirmation = Input.num();
            if (confirmation == 1) {
                ligas.remove(index);
                System.out.println("Liga " + nombreLiga + " eliminada.");
                confirmation = 0;
            } else if (confirmation != 0) {
                System.out.println("Por favor, seleccione una opción válida.");
            }
        }
    }
}
