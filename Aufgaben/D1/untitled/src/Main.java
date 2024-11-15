import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean continueLoop = true;
        Time time;

        try {
            System.out.println("Hour: ");
            int hour = scanner.nextInt();

            System.out.println("Minute: ");
            int minute = scanner.nextInt();

            System.out.println("Second: ");
            int second = scanner.nextInt();

            time = new Time(second, minute, hour);

            System.out.println(time);
        } catch (Exception e) {
            System.out.println("There was an error: \n" + e);
            time = new Time();
        }

        while (continueLoop) {
            try {

                System.out.println("Exit: 'e' \n" +
                        "Add Second: 'a' \n" +
                        "New Time: 't' \n" +
                        "New Hour: 'h' \n" +
                        "New Minute: 'm' \n" +
                        "New Second: 's' \n" +
                        "Get Data: 'g' \n");

                String input = scanner.next();

                switch (input) {
                    case "e": continueLoop = false;
                    case "a": time = time.nextSecond(); break;
                    case "t": newTime(time); break;
                    case "h": newHour(time); break;
                    case "m": newMinute(time); break;
                    case "s": newSecond(time); break;
                    case "g": getInfo(time); break;
                    default: break;
                }

            } catch (Exception e) {
                System.out.println("There was an error: \n" + e);
            }
        }

    }

    private static void newTime(Time time) throws Exception {
        System.out.println("Hour: ");
        int hour = scanner.nextInt();
        System.out.println("Mionute: ");
        int minute = scanner.nextInt();
        System.out.println("Second: ");
        int second = scanner.nextInt();
        time.setTime(second, minute, hour);
    }
    private static void newHour(Time time) throws Exception {
        System.out.println("Hour: ");
        int hour = scanner.nextInt();
        time.setHour(hour);
    }
    private static void newMinute(Time time) throws Exception {
        System.out.println("Minute: ");
        int minute = scanner.nextInt();
        time.setMinute(minute);
    }
    private static void newSecond(Time time) throws Exception {
        System.out.println("Second: ");
        int second = scanner.nextInt();
        time.setSecond(second);
    }

    private static void getInfo(Time time) throws Exception {
        System.out.println("Get Hour: 'h' \n" +
                "Get Minute: 'm' \n" +
                "Get Second: 's' \n" +
                "Print Time: 't'");

        String input = scanner.next();

        switch(input) {
            case "h": System.out.println(time.getHour());
            case "m": System.out.println(time.getMinute());
            case "s": System.out.println(time.getSecond());
            case "t": System.out.println(time.toString());
        }
    }
}