public abstract class Equipo {
    String nombre;
    int partidosJugados;
    int golesAFavor;
    int golesEnContra;
    int victorias;
    int derrotas;
    int empates;
    int puntos;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPartidosJugados() {
        this.partidosJugados++;
    }

    public void setGolesAFavor(int golesAFavor) {
        this.golesAFavor += golesAFavor;
    }

    public void setGolesEnContra(int golesEnContra) {
        this.golesEnContra += golesEnContra;
    }

    public void setVictorias() {
        this.victorias++;
    }

    public void setDerrotas() {
        this.derrotas++;
    }

    public void setEmpates() {
        this.empates++;
    }

    public void setPuntos() {
        this.puntos = this.victorias*3 + this.empates;
    }
}
