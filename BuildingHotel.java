
class BuildingHotels {
    static int totalElectricityConsumption = 0;
    static boolean lightningStruck = false;
    static boolean maintenanceRequired = false;

    public static void main(String[] args) {
        printRoof(7, 6);

        int hourPerDay = 24;
        int daysOfTheWeek = 7;

        for (int day = 1; day <= daysOfTheWeek; day++) {
            int dailyElectricityConsumption = 0;
            lightningStruck = false;
            maintenanceRequired = false;

            for (int hour = 0; hour < hourPerDay; hour++) {
                System.out.println("Day: " + day + " Hour: " + hour + "h");
                printRoof(7, 6);
                dailyElectricityConsumption = dailyElectricityConsumption + printRoof();
            }

            System.out.println("CONSUMOS: D" + day + ": " + dailyElectricityConsumption + " | ");
            totalElectricityConsumption = totalElectricityConsumption + dailyElectricityConsumption;
        }

        System.out.println("Overall total electricity consumption: " + totalElectricityConsumption);
    }

    public static int calculateProbabiltyOfEachWindow() {
        int MAXROWS = 7;
        int MAXCOLUMNS = 6;
        int electricityConsumption = 0;

        final String CLOSEROOM = "[ ]::";
        final String LIGHTON = "[*]::";
        final String LIGHTOFF = "[º]::";
        final String HITTHUNDER = "[X]::";
        final String FIXING = "[#]::";

        int columnAffectedByLightning = -1;
        int rowUnderRepair = -1;

        if (Math.random < 0.2) {
            columnAffectedByLightning = (int) ((Math.random() * MAXCOLUMNS) - 1);
        }

        if (Math.random < 0.05) {
            rowUnderRepair = (int) ((Math.random() * MAXROWS) - 1);
        }

        for (int rows = 0; rows < MAXROWS; rows++) {
            for (int columns = 0; columns < MAXCOLUMNS; columns++) {
                boolean blindOpen = Math.random() < 0.6;
                boolean lightOn = Math.random() < 0.7;

                if (blindOpen) {
                    if (lightOn) {
                        System.out.print(LIGHTON);
                        electricityConsumption++;
                    } else {
                        System.out.print(LIGHTOFF);
                    }
                } else {
                    System.out.print(CLOSEROOM);
                }

                if (columnAffectedByLightning != -1) {
                    System.out.print(HITTHUNDER);
                }
                if (rowUnderRepair != -1) {
                    System.out.print(FIXING);
                }
            }

            System.out.println("- P" + (rows + 1));
        }
        System.out.println("------------------------------------");
        System.out.println("Electricity consumption for the hour: " + electricityConsumption);
        return electricityConsumption;
    }

    static void printRoof(int maxRows, int maxColumns) {
        System.out.println("               __/\\__");
        System.out.println("  |    |    |  |####|  |    |    |  ");
        System.out.println("====================================");
        System.out.println("====================================");
    }

    static void cleanScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}