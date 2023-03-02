public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido al simulador de ligas.");
        

        int menu = -1;
        while (menu != 0) {
            System.out.println("Seleccione una opción: " +
                    "\n1 - Crear una liga nueva. " +
                    "\n2 - Jugar una liga. " +
                    "\n0 - Salir.");
            menu = Input.num();
            Options(menu);
        }
    }
    
    public static void Options(int menu) {
        if (menu == 1) {
            System.out.println("crear una liga");
        } else if (menu == 2) {
            System.out.println("jugar una liga");
        } else if (menu != 0) {
            System.out.println("Por favor, seleccione una opción válida.");
        }
    }
}
