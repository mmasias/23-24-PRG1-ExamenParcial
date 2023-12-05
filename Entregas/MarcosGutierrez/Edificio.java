class Edificio {
    public static void main(String[] args) {
        String estadisticaLuz = "ESTADISTICAS: ";
        int plantaMantenimiento = 0;
        int columnaImpactada = 0;
        boolean mantenimiento = false;
        boolean rayo = false;
        for (int dia = 1; dia <= 7; dia++) {
            int mantenimientosDiarios = 0;
            int rayosDiarios = 0;
            int horasLuzDia = 0;
            for (int horas = 1; horas <= 24; horas++) {
                if (rayosDiarios == 0) {
                    rayo = Math.random() < 0.2;
                    columnaImpactada = (int) (Math.random() * 6) + 1;
                    if (rayo) {
                        rayosDiarios++;
                    }
                }

                if (mantenimientosDiarios == 0) {
                    mantenimiento = Math.random() < 0.05;
                    plantaMantenimiento = (int) (Math.random() * 7) + 1;
                    if (mantenimiento) {
                        mantenimientosDiarios++;
                    }
                }

                cleanScreen();
                int horasLuz = 0;
                System.out.println("Dia " + dia);
                System.out.println("> Son las " + horas);

                for (int planta = 7; planta >= 1; planta--) {
                    for (int ventana = 1; ventana <= 6; ventana++) {
                        if (rayo && ventana == columnaImpactada) {
                            System.out.print("[X]");
                        } else if (mantenimiento && planta == plantaMantenimiento) {
                            System.out.print("[#]");
                        } else {
                            boolean estaAbierta = Math.random() > 0.7;
                            boolean luzEncendida = Math.random() > 0.6;
                            horasLuz = horasLuz + (luzEncendida ? 1 : 0);
                            String laVentana = verVentana(estaAbierta, luzEncendida);
                            System.out.print(laVentana);
                        }
                    }
                    System.out.println();
                }
                horasLuzDia = horasLuzDia + horasLuz;
                System.out.println("Horas luz: " + horasLuz);
                System.out.println(estadisticaLuz);
                pause(1);
            }
            estadisticaLuz = estadisticaLuz + "Dia [" + dia + "] consumo [" + horasLuzDia + "] - ";
        }

    }

    static String verVentana(boolean estaAbierta, boolean luzEncendida) {
        if (!estaAbierta) {
            return "[ ]";
        } else if (luzEncendida) {
            return "[*]";
        }

        return "[']";
    }

    static void cleanScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void pause(int segundos) {
        try {
            Thread.sleep(1000 * segundos);
        } catch (InterruptedException e) {
        }
    }
}
