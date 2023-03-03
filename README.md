## Ejercicio - La Liga
Se solicita crear un programa que simule una Liga de fútbol por jornadas.

El programa debe mostrar un menú con las siguientes opciones:
- Crear nueva Liga. Debe pedir un nombre para la Liga y rellenar con
  equipos la Liga (22 equipos)
- Jugar Liga. Solo debe permitirlo si una Liga está creada. Este abrirá un
  submenú:
  - Siguiente jornada. Simula 11 partidos
  - Consultar tabla. Muestra, en orden de puntuación descendente,
    los equipos.
  - Pausar Liga. Devuelve al menú anterior.
  - Eliminar Liga actual. Solicitará confirmación del usuario y elimina todos
    los datos de la Liga actual. Solo debe poder hacerse si hay una Liga
    creada.
- Salir. Termina el programa.

Varias especificaciones:
- Los equipos se enfrentan entre ellos 2 veces, ida y vuelta. No se
  enfrentará un Equipo contra sí mismo.
- De cada Equipo se solicita tener información de:
  - Partidos jugados
  - Goles a favor
  - Goles en contra
  - Victorias
  - Derrotas
  - Empates
  - Puntuación
- No se calculará una victoria o derrota, si no que se calcularán los goles
  que mete cada Equipo y se comparará entre ellos quien metió más
  goles o si hay empate.
- Se debe crear una interfaz para “Liga”, con una clase “Liga_futbol”
  para especificar la Liga de fútbol.
  - Métodos comunes podrían ser “calcular jornada”, por ejemplo.
- Se debe crear una interfaz “Equipo”, con una clase “Equipo_futbol”
  para especificar que se trata de un Equipo de fútbol.
  - Se puede incluso añadir una clase abstracta en vez de una
    interfaz si se cree conveniente.
- La Liga debe contener un array de equipos.