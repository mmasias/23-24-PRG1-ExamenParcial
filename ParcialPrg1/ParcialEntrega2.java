public class ParcialEntrega2 {
    public static void main(String[] args) {
        String InformacionLuz = "Gastos: ";

        for (int dia = 1; dia <= 7; dia++) {
            System.out.println("Dia " + dia);
            int horasLuz = 0;
            int horasLuzDia = 0;
            int plantaMant;
            boolean mant=false;
            for (int horas = 0; horas <= 23; horas++) {
                horasLuz=0;
                int probMant=(int)Math.round(Math.random()*100);
                System.out.println("               __/\\__              ");
                System.out.println("  |    |    |  |####|  |    |    |  ");
                System.out.println("====================================");

                for(int planta=7;planta>=1;planta--){
                    for(int ventana=1;ventana<=7;ventana++){
                        boolean estaAbierta=Math.random()>0.7;
                        boolean luzEncendida=Math.random()>0.6;
                        horasLuz=horasLuz + (luzEncendida?1:0);

                        if(probMant<=5){
                            mant=true;
                        }

                        if(mant){
                            plantaMant=(int)Math.round(Math.random()*6+1);
                            if(planta==plantaMant){
                                for(int ventana2=1;ventana<=6;ventana++){
                                    System.out.print("[X]");
                                    if(ventana2==4){
                                        System.out.print("[    ]");
                                    }
                                }
                            }

                        }else if(estaAbierta){
                            if(luzEncendida){
                                System.out.print("[*]");
                                horasLuz=horasLuz + (luzEncendida?1:0);
                            }else{
                                System.out.print("[´]");
                            }
                        }else if(estaAbierta==false){
                            if(luzEncendida){
                                horasLuz=horasLuz + (luzEncendida?1:0);
                                System.out.print("[ ]");
                            }else{
                                System.out.print("[ ]");
                            }
                        }

                        if(ventana==4){
                            System.out.print("[    ]");
                        }
                        if(ventana==7){
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
}
