import java.util.Random;

public class edificio {
    private static final int DAYS = 7;
    private static final int HOURS_PER_DAY = 24;
    private static final double PROB_BLIND_OPEN = 0.7;
    private static final double PROB_LIGHT_ON = 0.6;
    private static Random random = new Random();
    private static int[] dailyConsumption = new int[DAYS];

    public static void main(String[] args) {
        int weeklyConsumption = 0;

        for (int day = 0; day < DAYS; day++) {
            for (int hour = 0; hour < HOURS_PER_DAY; hour++) {
                int hourlyConsumption = simulateHour(day, hour);
                dailyConsumption[day] += hourlyConsumption;
                System.out.println(" ");
                System.out.println("Dia " + (day + 1) + " - " + (hour + 1) + ":00h Consumo hora: " + hourlyConsumption);
                System.out.println(" ");
            }
            weeklyConsumption += dailyConsumption[day];
            System.out.println("CONSUMOS: ");
            for (int d = 0; d <= day; d++) {
                System.out.print("D" + (d + 1) + ": " + dailyConsumption[d] + " | ");
            }
            System.out.println("\n");
        }

        System.out.println("CONSUMOS TOTALES: ");
        for (int d = 0; d < DAYS; d++) {
            System.out.print("D" + (d + 1) + ": " + dailyConsumption[d] + " | ");
        }
        System.out.println(" ");
        System.out.println("\nMedia de consumo semanal: " + (weeklyConsumption / DAYS));
    }

    private static int simulateHour(int day, int hour) {
        String[][] building = new String[7][7];
        int lightCount = 0;

        for (int floor = 0; floor < building.length; floor++) {
            for (int room = 0; room < 3; room++) {
                building[floor][room] = simulateRoom();
                if (building[floor][room].equals(":[*]:")) lightCount++;
            }
            building[floor][3] = "[    ]";
            for (int room = 4; room < 7; room++) {
                building[floor][room] = simulateRoom();
                if (building[floor][room].equals(":[*]:")) lightCount++;
            }
        }
        printBuilding(building);
        return lightCount;
    }

    private static String simulateRoom() {
        boolean blindOpen = random.nextDouble() < PROB_BLIND_OPEN;
        boolean lightOn = random.nextDouble() < PROB_LIGHT_ON;
        if (blindOpen) {
            return ":[ ]:";
        } else {
            return lightOn ? ":[*]:" : ":[º]:";
        }
    }

    private static void printBuilding(String[][] building) {
        System.out.println("               __/\\__");
        System.out.println("  |    |    |  |####|  |    |    |");
        System.out.println("====================================");
        for (int i = building.length - 1; i >= 0; i--) {
            for (int j = 0; j < building[i].length; j++) {
                System.out.print(building[i][j]);
            }
            System.out.println(" - P" + (i + 1));
        }
        System.out.println("------------------------------------");
        System.out.println("     ==========================");
        System.out.println("   ==============================");
        System.out.println(" ==================================");
    }
}