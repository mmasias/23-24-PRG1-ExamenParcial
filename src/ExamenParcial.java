public class ExamenParcial {
    
    static int consumoDia1;
    static int consumoDia2;
    static int consumoDia3;
    static int consumoDia4;
    static int consumoDia5;
    static int consumoDia6;
    static int consumoDia7;

    public static void main(String[] args) {
        
        int consumoHora = 0;
        int hora = 0;
        int dia = 1;
        final int HORAS_MAXIMAS = 24;
        final int DIAS_MAXIMOS = 7;
        final int PROBABILIDAD_MANTENIMIENTO = 5;
        final int PROBABILIDAD_RAYO = 20;
        
        for(dia = 1; dia <= DIAS_MAXIMOS; dia++) {
            
            int plantaMantenimiento = 0;
            int columnaRayo = 0;
            
            boolean hayMantenimiento = numeroAleatorio(0, 100) <= PROBABILIDAD_MANTENIMIENTO;
            
            if (hayMantenimiento) {
                plantaMantenimiento = numeroAleatorio(1, 7);
            }
            
            for(hora = 0; hora < HORAS_MAXIMAS; hora++) {
                
                int segundos = 3;

                boolean caeRayo = numeroAleatorio(0, 100) <= PROBABILIDAD_RAYO;
                boolean rayoCaido = columnaRayo > 0;

                if (caeRayo && !rayoCaido){
                    columnaRayo = numeroAleatorio(1, 7);
                }

                imprimeEdificio(consumoHora, dia, hora, plantaMantenimiento, columnaRayo, hayMantenimiento);
                
                pause(segundos);
            }
        }
        cleanScreen();
    }

    private static void imprimeEdificio(int consumoHora, int dia, int hora, int plantaMantenimiento, int columnaRayo, boolean hayMantenimiento) {
        
        final String ANTENA = " ".repeat(15) + "__/\\__" + " ".repeat(15);
        final String PARARRAYOS = "  |    |    |  |####|  |    |    |  ";
        final String TEJADO = "=".repeat(36);
        final String PORTAL = ":[       ]::::|      |::::[       ]:";
        final String SUELO = "-".repeat(36);
        final String ESCALERA_1 = " ".repeat(5) + "=".repeat(26) + " ".repeat(5);
        final String ESCALERA_2 = "  " + "=".repeat(32) + "  ";
        final String ESCALERA_3 = " " + "=".repeat(34) + " ";
        
        final String VENTANA_CERRADA = ":[ ]:";
        final String LUZ_ENCENDIDA = ":[*]:";
        final String LUZ_APAGADA = ":[º]:";
        final String RAYO = ":[X]:";
        final String MANTENIMIENTO = ":[#]:";

        final int NUMERO_FILAS = 7;
        final int NUMERO_COLUMNAS = 7;

        System.out.println();
        System.out.println(ANTENA);
        System.out.println(PARARRAYOS);
        System.out.println(TEJADO);

        for (int fila=1;fila<=NUMERO_FILAS;fila++){        
            for(int columna=1;columna<=NUMERO_COLUMNAS;columna++){
                
                if(columna == 4) {
                    System.out.print("[    ]");
                } else if (fila == plantaMantenimiento) {
                    System.out.print(MANTENIMIENTO);
                } else if (columna == columnaRayo) {
                    System.out.print(RAYO);
                } else {
                    if(Math.random()<=0.3) {
                        System.out.print(VENTANA_CERRADA);
                        if(Math.random()<=0.6) {
                            consumoHora = consumoHora + 1;
                        }} else {
                            if(Math.random()<=0.6){
                                consumoHora = consumoHora + 1;
                                System.out.print(LUZ_ENCENDIDA);
                            } else {
                                System.out.print(LUZ_APAGADA);
                            }
                        }
                }
            }
            System.out.println();
        }
        
        System.out.println(PORTAL);
        System.out.println(SUELO);
        System.out.println(ESCALERA_1);
        System.out.println(ESCALERA_2);
        System.out.println(ESCALERA_3);
        System.out.println();
        System.out.println("Dia " + dia + " - Hora " + hora + ":00h - " + "Consumo hora: " + consumoHora);

        if (columnaRayo > 0){
            System.out.println("Ha caido un rayo en la columna ["+columnaRayo+"]!");
        }
        if (hayMantenimiento) {
            System.out.println("Hay mantenimiento en la planta ["+plantaMantenimiento+"]!");
        }
        
        consumos(consumoHora, dia);
    }

    private static void consumos(int consumoHora, int dia) {
        
        if(dia == 1) {
            consumoDia1 = consumoDia1 + consumoHora;
        } else if(dia == 2) {
            consumoDia2 = consumoDia2 + consumoHora;
        } else if(dia == 3) {
            consumoDia3 = consumoDia3 + consumoHora;
        } else if(dia == 4) {
            consumoDia4 = consumoDia4 + consumoHora;
        } else if(dia == 5) {
            consumoDia5 = consumoDia5 + consumoHora;
        } else if(dia == 6) {
            consumoDia6 = consumoDia6 + consumoHora;
        } else if(dia == 7) {
            consumoDia7 = consumoDia7 + consumoHora;
        } else {
        }
        System.out.println("CONSUMOS: D1: ["+consumoDia1+"] | D2: ["+consumoDia2+"] | D3: ["+consumoDia3+"] | D4: ["+consumoDia4+"] | D5: ["+consumoDia5+"] | D6: ["+consumoDia6+"] | D7: ["+consumoDia7+"]");
        System.out.println("CONSUMO MEDIO SEMANAL: " + (consumoDia1 + consumoDia2 + consumoDia3 + consumoDia4 + consumoDia5 + consumoDia6 + consumoDia7)/7);
    }

    private static void pause(int segundos) {
        try {
            Thread.sleep(1000 * segundos);
        } catch (InterruptedException e) {
        }
    }

    private static void cleanScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static int numeroAleatorio(int minimo, int maximo) {
        return (int) (Math.random() * (maximo - minimo) + minimo);
    }
}