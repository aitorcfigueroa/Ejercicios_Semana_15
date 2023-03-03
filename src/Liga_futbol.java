import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Liga_futbol implements Liga {
    String nombre;
    int jornada;
    String [] equipos = {"Athletic Club", "Atlético de Madrid", "CA Osasuna", "Cádiz CF", "Elche CF", "FC Barcelona",
            "Getafe CF", "Girona FC", "Levante UD","Rayo Vallecano", "RC Celta", "RCD Espanyol de Barcelona",
            "RCD Mallorca", "Real Betis", "Real Madrid", "Real Sociedad", "Real Valladolid CF", "Sevilla FC",
            "UD Almería", "UD Las Palmas", "Valencia CF", "Villarreal CF"};
    ArrayList<Equipo_futbol> listaEquipos = new ArrayList<>();

    Liga_futbol(String nombre) {
        this.nombre = nombre;
        this.jornada = 0;

        for (String equipo: equipos) {
            Equipo_futbol nuevoEquipo = new Equipo_futbol(equipo);
            listaEquipos.add(nuevoEquipo);
        }
    }

    public void calcular_jornada() {

    }

    public void clasificacion() {
        Collections.sort(listaEquipos, new Comparator<Equipo_futbol>() {
            @Override
            public int compare(Equipo_futbol o1, Equipo_futbol o2) {
                return Integer.valueOf(o1.puntos).compareTo(Integer.valueOf(o2.puntos));
            }
        });

        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("%50s","Clasificación de " + this.nombre);
        System.out.println();
        System.out.printf("%25s %10s %5s %5s %5s %5s %5s %5s", "EQUIPO", "PJ", "GF", "GC", "V", "E", "D", "PTS");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------");
        for(Equipo_futbol equipo: listaEquipos){
            System.out.format("%25s %10d %5d %5d %5d %5d %5d %5d",
                    equipo.nombre, equipo.partidosJugados, equipo.golesAFavor, equipo.golesEnContra, equipo.victorias, equipo.empates, equipo.derrotas, equipo.puntos);
            System.out.println();
        }
        System.out.println("-----------------------------------------------------------------------------");
    }
}
