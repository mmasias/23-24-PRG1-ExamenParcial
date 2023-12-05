package deCosSaul;
import java.util.Scanner;
class ParcialMejorado {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String salida = "CONSUMOS: ";
        int consumoSemana = 0;

        for (int dia = 1; dia <= 7; dia ++){
            
            final int PROBABILIDAD_MANTENIMIENTO = 5;
            final int PROBABILIDAD_RAYO = 20;

            int plantaMantenimiento = 0;
            int columnaRayo = 0;
          
            boolean hayMantenimiento = calculoProbabilidad(PROBABILIDAD_MANTENIMIENTO);

            if (hayMantenimiento){
                plantaMantenimiento = numeroAleatorio(1, 7);
            }

            int consumoDia = 0;

            for (int hora = 0; hora <=23; hora++){
            
                int consumoHora = 0;
                
                boolean caeRayo = calculoProbabilidad(PROBABILIDAD_RAYO);
                boolean yaCaido = columnaRayo > 0;
                
                
                if (caeRayo && !yaCaido){
                    columnaRayo = numeroAleatorio(1, 7);
                }
                
                impresionTecho();

                for (int planta = 7; planta >= 1; planta--){
                    for (int ventana = 1; ventana <= 7; ventana++){

                        if (ventana == 4){
                            System.out.print("[    ]");
                        } else if (planta == plantaMantenimiento){
                            System.out.print(":[#]:");
                        } else if (ventana == columnaRayo){
                            System.out.print(":[X]:");
                        } else {
                        consumoHora += ventanaSinProblemas();
                        }

                    }

                    System.out.println(" - P" + planta);
                
                }
            
                impresionBajos();

                System.out.println("Dia " + dia + " - " + hora + ":00h Consumo hora: " + consumoHora);
                
                consumoDia += consumoHora;
                System.out.println(salida);
                pausa(1);
                limpiarPantalla();
        }
        consumoSemana += consumoDia;
        salida += "D" + dia + ": " + consumoDia + " | ";
    }
    System.out.println(salida);
    System.out.println("Media consumo semanal: " + (consumoSemana/7));
}

    static int ventanaSinProblemas() {
        
        final int PROBABILIDAD_VENTANA_ABIERTA = 70;
        final int PROBABILIDAD_LUZ_ENCENDIDA = 60;
        boolean ventanaAbierta = calculoProbabilidad(PROBABILIDAD_VENTANA_ABIERTA);
        boolean luzEncendida = calculoProbabilidad(PROBABILIDAD_LUZ_ENCENDIDA);

        int consumo = 0;
        if (!ventanaAbierta){
            System.out.print(":[ ]:");
            if (luzEncendida){
                consumo = 1;
            }
            } else if (luzEncendida){
                System.out.print(":[*]:");
                consumo = 1;
            } else {
                System.out.print(":[º]:");
                consumo = 0;
        }
        return consumo;
    }

    static boolean calculoProbabilidad(int probabilidad) {
        if (numeroAleatorio(0, 100) < probabilidad){
            return true;
        } else {
            return false;
        }
    }

    static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    static int numeroAleatorio(int minimo, int maximo) {
        return (int) (Math.random() * (maximo - minimo + 1) + minimo);
    }

    static void pausa(int segundos) {
        try {
            Thread.sleep(1000 * segundos);
        } catch (InterruptedException e) {
        }
    }


    static void impresionTecho() {
        final String TIP = "     ".repeat(3) + "__/\\__";
        final String HEADER = "|####|";
        final String ANTENNA = "  |  ";
        final String ROOF = "=".repeat(36);

        System.out.println(TIP);
        System.out.println(ANTENNA.repeat(3) + HEADER + ANTENNA.repeat(3));
        System.out.println(ROOF);
    }

    static void impresionBajos() {
        System.out.println("""
                :[       ]::::|      |::::[       ]:
                ------------------------------------
                     ==========================
                   ==============================
                 ==================================
                """);
    }
}
