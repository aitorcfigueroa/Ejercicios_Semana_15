import java.util.ArrayList;

public class Liga_futbol implements Liga {
    String nombre;
    int jornada;

    ArrayList<Equipo_futbol> listaEquipos = new ArrayList<>();

    String [] equipos = {"Athletic Club", "Atlético de Madrid", "CA Osasuna", "Cádiz CF", "Elche CF", "FC Barcelona",
            "Getafe CF", "Girona FC", "Levante UD","Rayo Vallecano", "RC Celta", "RCD Espanyol de Barcelona",
            "RCD Mallorca", "Real Betis", "Real Madrid", "Real Sociedad", "Real Valladolid CF", "Sevilla FC",
            "UD Almería", "UD Las Palmas", "Valencia CF", "Villarreal CF"};
    int k = 0;
    int j = equipos.length - 2;
    Liga_futbol(String nombre) {
        this.nombre = nombre;
        this.jornada = 0;

        for (String equipo: equipos) {
            Equipo_futbol nuevoEquipo = new Equipo_futbol(equipo);
            listaEquipos.add(nuevoEquipo);
        }
    }

    public void calcular_jornada() {
        this.jornada++;
        int numPartidosJornada = listaEquipos.size()/2;
        int numJornadas = listaEquipos.size()*2-2;

        if (this.jornada > numJornadas) {
            System.out.println("La liga " + this.nombre + " ha acabado.");
            this.jornada = numJornadas;
        } else {
            Partido[] jornada = new Partido[numPartidosJornada];

            for (int i = 0; i < numPartidosJornada; i++) {
                jornada[i] = new Partido();
                Equipo_futbol local = listaEquipos.get(k);
                Equipo_futbol visitante;

                if (i == 0) {
                    visitante = listaEquipos.get(listaEquipos.size() - 1);
                } else {
                    visitante = listaEquipos.get(j);
                    j--;
                }

                if (this.jornada % 2 != 0) {
                    local = visitante;
                    visitante = listaEquipos.get(k);
                }

                //Almacenar datos de cada partido de la jornada
                guardarPartido(jornada[i], local, visitante);

                k++;
                if (k == numJornadas/2) {
                    k = 0;
                }

                if (j == -1) {
                    j = listaEquipos.size() - 2;
                }
            }

            printJornada(this.jornada, jornada);
        }

    }

    public static void guardarPartido(Partido jornada, Equipo_futbol local, Equipo_futbol visitante) {
        //Partido que se juega
        jornada.setEquipoLocal(local.nombre);
        jornada.setEquipoVisitante(visitante.nombre);
        jornada.setGolesLocal((int) (Math.random()*6));
        jornada.setGolesVisitante((int) (Math.random()*6));

        //Cambiando las estadísticas de los equipos
        local.setPartidosJugados();
        visitante.setPartidosJugados();
        local.setGolesAFavor(jornada.getGolesLocal());
        local.setGolesEnContra(jornada.getGolesVisitante());
        visitante.setGolesAFavor(jornada.getGolesVisitante());
        visitante.setGolesEnContra(jornada.getGolesLocal());

        //Comprobando quien ganó
        if (jornada.getGolesLocal() == jornada.getGolesVisitante()) {
            local.setEmpates();
            visitante.setEmpates();
        } else if (jornada.getGolesLocal() > jornada.getGolesVisitante()) {
            local.setVictorias();
            visitante.setDerrotas();
        } else if (jornada.getGolesLocal() < jornada.getGolesVisitante()) {
            local.setDerrotas();
            visitante.setVictorias();
        }
        local.setPuntos();
        visitante.setPuntos();
    }

    public void clasificacion() {
        listaEquipos.sort((o1, o2) -> {
            int puntos = Integer.compare(o2.puntos, o1.puntos);
            if (puntos != 0) {
               return puntos;
            }
            int victorias = Integer.compare(o2.victorias, o1.victorias);
            if (victorias != 0) {
               return victorias;
            }
            int empates = Integer.compare(o2.empates, o1.empates);
            if (empates != 0) {
               return empates;
            }
            int gFavor = Integer.compare(o2.golesAFavor, o1.golesAFavor);
            if (gFavor != 0) {
                return gFavor;
            }
           return Integer.compare(o1.golesEnContra, o2.golesEnContra);
        });

        printClas(this.nombre, listaEquipos);
    }

    public static void printJornada(int jornada, Partido[] partidos) {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Jornada " + jornada);
        System.out.println("-----------------------------------------------------------------------------");
        for(Partido partido: partidos){
            System.out.format("%25s %5d %5s %5d %5s",
                    partido.getEquipoLocal(), partido.getGolesLocal(), "-", partido.getGolesVisitante(), partido.getEquipoVisitante());
            System.out.println();
        }
        System.out.println("-----------------------------------------------------------------------------");
    }

    public static void printClas(String nombreLiga, ArrayList<Equipo_futbol> listaEquipos) {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("%50s","Clasificación de " + nombreLiga);
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
