public class ParcialEntrega2 {
    public static void main(String[] args) {
        String InformacionLuz = "Gastos: ";

        for (int dia = 1; dia <= 7; dia++) {
            System.out.println("Dia " + dia);
            int horasLuz = 0;
            int horasLuzDia = 0;

            for (int horas = 0; horas <= 23; horas++) {
                horasLuz=0;
                System.out.println("               __/\\__              ");
                System.out.println("  |    |    |  |####|  |    |    |  ");
                System.out.println("====================================");

                for(int planta=7;planta>=1;planta--){
                    for(int ventana=1;ventana<=6;ventana++){
                        boolean estaAbierta=Math.random()>0.7;
                        boolean luzEncendida=Math.random()>0.6;
                        horasLuz=horasLuz + (luzEncendida?1:0);
                        String laVentana=verVentana(estaAbierta,luzEncendida);

                        System.out.print(laVentana);

                        if(ventana==3){
                            System.out.print("[    ]");
                        }
                        if(ventana==6){
                            System.out.print(" - P" + planta);
                        }

                    }
                    System.out.println();
                }
                System.out.println("------------------------------------");
                System.out.println("     ==========================     ");
                System.out.println("   ==============================   ");
                System.out.println(" ================================== ");
                horasLuzDia=horasLuzDia+ horasLuz;
                System.out.println("Son las " + horas + ":00h del dia " + dia);
                System.out.println("Horas luz: " + horasLuz);
                System.out.println(InformacionLuz);
            }
           InformacionLuz=InformacionLuz + "Dia [" + dia + "] consumo [" + horasLuzDia + "] - ";
        }

    }
    private static String verVentana(boolean estaAbierta, boolean luzEncendida){
        if(estaAbierta){
            return ":[ ]:";
        }else if(luzEncendida){
            return ":[*]:";
        }
        return ":[º]:";
    }
}
