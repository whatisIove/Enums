package ua.ithillel.java;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        User admin = new User("ADMIN", "ADMIN2022", "ADMIN", Position.ADMINISTRATOR);
        User client = new User("John007", "JLn2wf5", "John Moore", Position.CLIENT);
        User director = new User("owner", "ITFSW52gst", "Case Johns", Position.DIRECTOR);
        User manager = new User("smnth", "YYYTwfw52", "Samantha Fox", Position.MANAGER);
        User anonim = new User("", "", "", Position.ANONIM);

        Store store = new Store("eldorado", "www.eldorado.ua",
                new User[]{admin, client, director, manager, anonim});

        while (true) {
            tryLogin(store);
        }
    }

    static boolean tryLogin(Store store) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("Enter login: ");
        String login = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        boolean isRegistration = store.login(login, password);
        if (isRegistration) {
            store.getCurrentUserRights();
            store.logout();

        }
        if (!isRegistration) {
            System.out.println("Invalid username or password.");
        }
        return isRegistration;
    }
}