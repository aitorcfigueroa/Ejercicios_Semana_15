public abstract class equipo {
    String club;
    int partidosJugados;
    int golesAFavor;
    int golesEnContra;
    int victorias;
    int derrotas;
    int empates;
    int puntos;

    public void setClub(String club) {
        this.club = club;
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
