class Edificio {
    public static void main(String[] args) {

        int dias = 7;
        int dia;
        int horas = 24;
        int consumoTotal = 0;
        int consumoDiario = 0;
        int consumo = 0;
        boolean caeRayo;
        int columna = 0;
        boolean hayMantenimiento;
        int mantenimiento = 0;
        // int[] gastoDiario = new int[dia];

        for (dia = 0; dia < 7; dia++) {
            caeRayo = false;
            hayMantenimiento = false;
            // gastoDiario[dia] = consumoDiario;
            consumoTotal += consumoDiario;
            consumoDiario = 0;

            for (int hora = 0; hora <= horas; hora++) {
                System.out.println("El consumo de la hora fue: " + consumo);
                System.out.println();
                System.out.println("Dia: " + dias);
                System.out.println("Hora " + hora);
                consumoDiario = consumoDiario + consumo;
                consumo = 0;

                if (!caeRayo && Math.random() < 0.2) {
                    columna = (int) (Math.random() * 6) + 1;
                }
                if (!hayMantenimiento && Math.random() < 0.05) {
                    mantenimiento = (int) (Math.random() * 6) + 1;
                }
                System.out.println("""
                                       __/\\__
                          |    |    |  |####|  |    |    |
                        ====================================
                              """);
                for (int planta = 1; planta <= 7; planta++) {
                    for (int ventana = 1; ventana <= 6; ventana++) {

                        boolean ventanaAbierta = Math.random() < 0.6;
                        boolean luzEncendida = Math.random() < 0.7;
                        if (ventana == 4) {
                            System.out.print("      ");
                        }
                        if (mantenimiento == planta) {
                            System.out.print(" [#] ");
                        } else {
                            if (columna == ventana) {
                                System.out.print(" [X] ");
                            } else {
                                if (!ventanaAbierta) {
                                    System.out.print(" [ ] ");
                                } else {
                                    if (luzEncendida = true) {
                                        consumo++;
                                        System.out.print(" [*] ");
                                    } else {
                                        System.out.print(" [º] ");
                                    }

                                }
                            }
                        }
                    }
                    System.out.println();

                }
                System.out.print("""
                        ------------------------------------
                            ==========================
                          ==============================
                        ==================================

                        """);

            }

            System.out.println("El consumo por planta es de " + consumo);
        }
        // for(int i=0; gastoDiario.length; i++) {
        // System.out.print ("Gastos: " + "D" + i + ": " + gastoDiario[i]);
        // }
        System.out.println("El consumo diario es de: " + consumoDiario);
        System.out.println("El consumo medio de la semana es: " + (consumoTotal / 7));
    }

}
// me da todo el rato el siguiente error cuando intento usar un array
// The type of the expression must be an array type but it resolved to String
// nose como arreglarlo