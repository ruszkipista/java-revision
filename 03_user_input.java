import java.util.Scanner;

class get_user_name{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name");
        String name = scanner.nextLine();
        scanner.close();
        System.out.println("Your name: " + name);
    }
}