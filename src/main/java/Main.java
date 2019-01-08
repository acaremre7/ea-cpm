import java.util.Scanner;

public class Main {
    private static CarParkService carParkService = new CarParkServiceImpl();
    public static void main(String[] args){
        System.out.println("Welcome to the Car Park. Please insert your command.");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(carParkService.processInput(sc.nextLine()));
        }
    }
}
