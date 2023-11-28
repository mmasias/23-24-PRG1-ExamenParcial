public class Building {
    public static void main(String[] args) {
        final String WINDOW_CLOSED = ":[ ]:";
        final String WINDOW_DAMAGED = ":[X]:";
        final String WINDOW_UNDER_MAINTENANCE = ":[#]:";
        final String WINDOW_OPEN_ON = ":[*]:";
        final String WINDOW_OPEN_OFF = ":[º]:";
        final String CENTRAL_GAP = "[    ]";

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
}
