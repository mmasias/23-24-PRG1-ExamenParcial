class ExamenParcial2 {
    public static void main(String[] args) {
        final String ventanaCerrada=":[ ]:";
        final String luzApagada=":[º]:";
        final String luzEncendida=":[*]:";
        final String rayoCaido=":[X]:";
        final String mantenimiento=":[#]:";
        final int numeroPlantas=7;
        final int numeroHabitaciones=6;
        final int horasMaximas=24;

        for (int dia = 1;dia <= 7;dia++) {
            int consumoDia=0;
            boolean rayoCayo=false;
            boolean mantenimientoPlanta=false;
            int plantaEnMantenimiento=-1;
            int columnaRayo=-1;

            if (Math.random()<0.05) {
                mantenimientoPlanta=true;
                plantaEnMantenimiento=(int)(Math.random()*numeroPlantas);
                System.out.println("¡Mantenimiento en la planta " + plantaEnMantenimiento + "!");
            }

            for (int hora = 1;hora<=horasMaximas;hora++) {
                pause(2);
                clearScreen();
                System.out.println("Dia " + dia + " - " + hora + ":00h ");

                int consumoHora = 0;

                if (!rayoCayo && Math.random()<0.2) {
                    columnaRayo = (int)(Math.random()*numeroHabitaciones);
                    System.out.println("¡Rayo caído en la columna " + columnaRayo + "! Electricidad desactivada para esta columna.");
                    rayoCayo = true;
                }

                for (int planta = 0;planta<numeroPlantas;planta++) {
                    for (int habitacion=0;habitacion<numeroHabitaciones;habitacion++) {
                        int columna=habitacion;

                        if (mantenimientoPlanta && planta == plantaEnMantenimiento) {
                            System.out.print(mantenimiento);
                        } else if (rayoCayo && columna == columnaRayo) {
                            System.out.print(rayoCaido);
                        } else {
                            boolean ventanaAbierta = Math.random() < 0.7;
                            boolean luzOn = Math.random() < 0.6;

                            if (ventanaAbierta && luzOn) {
                                System.out.print(luzEncendida);
                                consumoDia++;
                                consumoHora++;
                            } else if (ventanaAbierta) {
                                System.out.print(luzApagada);
                            } else {
                                System.out.print(ventanaCerrada);
                            }
                        }
                    }
                    System.out.println();
                }
                System.out.println("Costo de esta hora: " + consumoHora + " habitaciones");
                System.out.println("Costo acumulado hasta ahora en el dia " + dia + ": " + consumoDia + " habitaciones");
            }
            System.out.println("Costo total del dia " + dia + ": " + consumoDia + " habitaciones");
        }
    }

    static void pause(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
        }
    }

    static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}