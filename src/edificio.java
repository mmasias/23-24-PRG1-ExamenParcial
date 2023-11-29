import java.util.Random;

public class edificio {
    private static final int DAYS = 7;
    private static final int HOURS_PER_DAY = 24;
    private static final double PROB_BLIND_OPEN = 0.7;
    private static final double PROB_LIGHT_ON = 0.6;
    private static Random random = new Random();

    public static void main(String[] args) {
        for (int day = 1; day <= DAYS; day++) {
            for (int hour = 1; hour <= HOURS_PER_DAY; hour++) {
                simulateHour(day, hour);
            }
        }
    }

    private static void simulateHour(int day, int hour) {
        String[][] building = new String[7][7];
        for (int floor = 0; floor < building.length; floor++) {
            for (int room = 0; room < building[floor].length; room++) {
                building[floor][room] = simulateRoom();
            }
        }               
        printBuilding(building);
        System.out.println(" ");
        System.out.println("Dia " + day + " - " + hour + ":00h");      
    }

    private static String simulateRoom() {
        boolean blindOpen = random.nextDouble() < PROB_BLIND_OPEN;
        boolean lightOn = random.nextDouble() < PROB_LIGHT_ON;
        if (blindOpen) {
            return "[ ]";
        } else {
            return lightOn ? "[*]" : "[º]";
        }
    }

    private static void printBuilding(String[][] building) {
        System.out.println("               __/\\__");
        System.out.println("  |    |    |  |####|  |    |    |");
        System.out.println("====================================");
        for (int i = building.length - 1; i >= 0; i--) {
            for (int j = 0; j < building[i].length; j++) {
                System.out.print(building[i][j] + "::");
            }
            System.out.println(" - P" + (i + 1));
        }
        System.out.println("------------------------------------");
        System.out.println("     ==========================");
        System.out.println("   ==============================");
        System.out.println(" ==================================");
    }
}
