class ProgramacionMejora{
    public static void main(String[] args) {

        final int PLANTAS_EDIFICIO = 7;
        final int HABITACIONES_CADA_PLANTA = 7;

        final String VENTANA_CERRADA = "[ ]";
        final String VENTANA_ABIERTA_LUZ = "[*]";
        final String VENTANA_ABIERTA_NO_LUZ = "[º]";
        final String HUECO = "[    ]";
        final String AVERIA= "[X]";
        final String MANTENIMIENTO= "[#]";

        int hora = 0;
        int dia = 1;
        final int DIA_MAXIMO = 7;
        int consumoHora = 0;
        int consumoDia = 0;
        int consumoSemanaTotal = 0;

        boolean rayoDiario = false;
        boolean mantenimientoDiario = false;

        String mensajeRayo = "";
        String mensajeMantenimiento = "";

        String [][] valoresEdificio = new String[PLANTAS_EDIFICIO][HABITACIONES_CADA_PLANTA];

        while(dia<=DIA_MAXIMO){

            if (!rayoDiario){
                if (Math.random()<0.2){

                    rayoDiario = true;
                    int columnaAfectada;

                    do {
                        columnaAfectada = (int) (Math.random() * 7);

                    } while (columnaAfectada == 3);

                    mensajeRayo = "Un rayo ha apagado la columna " + columnaAfectada;

                    valoresEdificio = cambiarColumna(valoresEdificio, columnaAfectada, AVERIA);

                }

            }

            if (!mantenimientoDiario){
                if (Math.random()<0.05){

                    mantenimientoDiario = true;
                    int filaAfectada;

                    do {
                        filaAfectada = (int) (Math.random() * 7);

                    } while (filaAfectada == 3);

                    mensajeMantenimiento = (7-filaAfectada) + "º planta está en mantenimiento";

                    valoresEdificio = cambiarFila(valoresEdificio, filaAfectada, MANTENIMIENTO);

                }

            }

            for(int i = 0;i<valoresEdificio.length;i++){
                for(int j = 0; j<valoresEdificio[i].length;j++){

                    valoresEdificio[i][3]="[    ]";

                    boolean ABIERTO_O_CERRADO = Math.random() <= 0.7;
                    boolean ENCENDIDO_O_APAGADO = Math.random() <= 0.6;

                    if (ABIERTO_O_CERRADO) {
                        if (ENCENDIDO_O_APAGADO) {

                            if (valoresEdificio[i][j]!=AVERIA && valoresEdificio[i][j]!= MANTENIMIENTO){
                                valoresEdificio[i][j] = VENTANA_ABIERTA_LUZ;
                                consumoHora++;

                            }

                        }else{

                            if (valoresEdificio[i][j]!=AVERIA && valoresEdificio[i][j]!= MANTENIMIENTO){
                                valoresEdificio[i][j] = VENTANA_ABIERTA_NO_LUZ;

                            }

                        }

                    }else{

                        if (valoresEdificio[i][j]!=AVERIA && valoresEdificio[i][j]!= MANTENIMIENTO){
                            valoresEdificio[i][j] = VENTANA_CERRADA;
                            if (ENCENDIDO_O_APAGADO) {
                                consumoHora++;

                            }

                        }

                    }

                }

            }

            printCeiling();

            int piso = 7;

            for(int i = 0;i<valoresEdificio.length;i++){
                for(int j = 0; j<valoresEdificio[i].length;j++){

                    if (valoresEdificio[i][j] == HUECO){
                        System.out.print(valoresEdificio[i][j]);

                    }else{
                        System.out.print(":" + valoresEdificio[i][j] + ":");

                    }

                }
                System.out.print(" - P" + piso);
                System.out.println();
                piso--;

            }

            printBasement();

            System.out.println("Dia " + dia + " - " + hora + ":00h Consumo hora: " + consumoHora);

            if (rayoDiario){
                System.out.println(mensajeRayo);
            }
            if (mantenimientoDiario){
                System.out.println(mensajeMantenimiento);
            }

            consumoDia = consumoDia + consumoHora;
            consumoHora=0;

            if (hora==23) {
                hora = 0;
                System.out.println("Consumos: D" + dia + ": " + consumoDia + "|");
                dia++;
                consumoSemanaTotal = consumoSemanaTotal + consumoDia;
                consumoDia = 0;
                rayoDiario = false;
                mantenimientoDiario = false;
                for (int i=0;i< valoresEdificio.length;i++){
                    for (int j=0;j<valoresEdificio[i].length;j++){
                        valoresEdificio[i][j]= "[ ]";
                    }

                }

            }

            pause(1);
            clearScreen();

            hora++;

        }
        int mediaConsumoSemanal = consumoSemanaTotal/DIA_MAXIMO;
        System.out.println("La media de consumo en la semana ha sido: " + mediaConsumoSemanal);

    }

    static void printCeiling() {
        final String TIP = "     ".repeat(3) + "__/\\__";
        final String HEADER = "|####|";
        final String ANTENNA = "  |  ";
        final String ROOF = "=".repeat(36);

        System.out.println(TIP);
        System.out.println(ANTENNA.repeat(3) + HEADER + ANTENNA.repeat(3));
        System.out.println(ROOF);
    }

    static void printBasement() {
        System.out.println("""
                :[       ]::::|      |::::[       ]:
                ------------------------------------
                     ==========================
                   ==============================
                 ==================================
                """);
    }

    static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void pause(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
        }
    }

    static String[][] cambiarColumna(String[][] matriz, int columna, String nuevoValor) {
            for (int i = 0; i < matriz.length; i++) {
                for (int j= 0;j<matriz[i].length;j++){
                    matriz[i][columna] = nuevoValor;
                }

            }
            return matriz;

    }

    static String[][] cambiarFila(String[][] matriz, int fila, String nuevoValor) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j= 0;j<matriz[i].length;j++){
                matriz[fila][j] = nuevoValor;
            }

        }
        return matriz;

    }

}
