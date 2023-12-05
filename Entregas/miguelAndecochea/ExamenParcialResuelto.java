import java.util.Scanner;


class ExamenParcialResuelto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        final String ventanaCerrada = ":[ ]:";
        final String ventanaAbiertaEncendida = ":[*]:";
        final String ventanaAbiertaApagada = ":[º]:";
        final String ventanaCerradaEncendida = ":[ ]:";
        final String ventaEnMantenimiento = ":[0]:";
        final String ventanaDañada = ":[X]:";
        final String espacioCentral = "[    ]";
        int rayoCae;
        int plantaMantenimiento;

        for (int dia = 1; dia <= 7; dia++) {
            int horasLuzDia=0;

            for (int hora = 0; hora <= 23; hora++) {
                System.out.println("Presiona Enter para avanzar de hora " + hora);
                scanner.nextLine();
                int horasLuz=0;
                System.out.println("Dia" + dia + "son las " + hora);
                
                boolean lluvia = Math.random() < 0.4;
                boolean rayo = Math.random() < 0.2;
                boolean mantenimiento = Math.random() < 0.05;

               rayoCae = (int) (Math.random() * 6) + 1;
               plantaMantenimiento = (int) (Math.random() * 7) + 1;
    
               for (int planta = 7; planta>=1;planta--){
                for (int habitacion = 1; habitacion < 8; habitacion++) {
                    if (habitacion == rayoCae && lluvia && rayo && habitacion != 8 / 2) {
                      System.out.print(ventanaDañada);
                    } else if (habitacion == 8 / 2) {
                      System.out.print(espacioCentral);
                    } else if (planta == plantaMantenimiento && mantenimiento && habitacion!= 8 / 2) {
                      System.out.print(ventaEnMantenimiento);
                    } else {
                      boolean luzEncendida = Math.random() < 0.70;
                      boolean ventanaAbierta = Math.random() < 0.60;
                      String estadoVentana =
                        (luzEncendida ? (ventanaAbierta? ventanaAbiertaEncendida : ventanaCerradaEncendida) : (ventanaAbierta ? ventanaAbiertaApagada : ventanaCerrada));
        
                      System.out.print(estadoVentana);

                      if (
                        estadoVentana.equals(ventanaAbiertaEncendida) || estadoVentana.equals(ventanaCerradaEncendida)) {
                        horasLuz++;
        
                    }
                    }
                }
                System.out.println();
            }
            
            System.out.println("El consumo por hora es de: " + horasLuz);

            horasLuzDia = horasLuzDia + horasLuz;
            System.out.println("El consumo total del día es de: " + horasLuzDia);

            }
            
        }
    }
}


    
