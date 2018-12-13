import java.util.Scanner;

public class Main {
    private static CarParkService carParkService = new CarParkServiceImpl();
    private static final String INPUT_REGEX = "((([p])[^\\s,]+)(,?)|(([u])[\\d]+)(,?)|([c](,?)))*";

    public static void main(String[] args){
        System.out.println("Welcome to the Car Park. Please insert your command.");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(processInput(sc.nextLine()));
        }
}
    private static String processInput(String input){
        if (!input.matches(INPUT_REGEX)) {
            return "Input is not valid. Please try again.";
        } else if (input.endsWith(",")) {
            return "Input is incomplete. Please remove ',' from the end.";
        } else if (input.isEmpty()) {
            return "Empty input.";
        } else {
            String[] inputArray = input.split(",");
            for (String s : inputArray) {
                switch (s.charAt(0)) {
                    case 'p':
                        carParkService.park(s.split("p")[1]);
                        break;
                    case 'u':
                        carParkService.unpark(Integer.valueOf(s.split("u")[1]));
                        break;
                    case 'c':
                        carParkService.compact();
                        break;
                }
            }
            return carParkService.getCurrentParkingOrder();
        }
    }
}
