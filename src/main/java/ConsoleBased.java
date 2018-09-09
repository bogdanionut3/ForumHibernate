import java.sql.SQLException;
import java.util.Scanner;

public class ConsoleBased extends Forum {
    private Scanner sc;
    private String prompt;

    public ConsoleBased(){
        sc = new Scanner(System.in);
        prompt = ">";
        mainMenu();
    }

    private Integer drawTopicMenu() {
        System.out.println("1. Create Topic");
        System.out.println("2. Show all topics");
        System.out.println("3. Enter topic");
        System.out.println("4. Return");
        System.out.println(prompt);
        Integer option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    public void categoryMenu() {
        while (true) {
            prompt = whoIsLoggedIn() + "," + whoIsLoggedIn() + ">";
            switch (drawTopicMenu()) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid Option");
                    break;
            }
        }
    }

    private Integer drawCategoryMenu() {
        System.out.println("1. Create category");
        System.out.println("2. Show all categories");
        System.out.println("3. Enter category");
        System.out.println("4. Return");
        System.out.println(prompt);
        Integer option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    public void loginMenu() {
        while (true) {
            prompt = whoIsLoggedIn() + ">";
            switch (drawCategoryMenu()) {
                case 1:
                    System.out.println("Category subject");
                    String subject = sc.nextLine();
                    insertCategory(subject);
                    break;
                case 2:
                    System.out.println("Aici ar trebui sa fie metoda getAllCategories");
                    break;
                case 3:
                    System.out.println("Enter category= ");
                    Integer categ_id = sc.nextInt();
                    sc.nextLine();
                    if (enterCategory(categ_id)) {
                        categoryMenu();
                    }
                    break;
                case 4:
                    System.out.println("Have a nice day.");
                    return;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    private Integer drawMainMenu() {
        System.out.println("\n******************");
        System.out.println("Operations");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.println(prompt);
        Integer option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    public void mainMenu() {
        while (true) {
            prompt = ">";
            switch (drawMainMenu()) {
                case 1:
                    System.out.println("Username ");
                    String username = sc.nextLine();
                    System.out.println("Password ");
                    String password = sc.nextLine();
                    if (login(username, password)) {
                        loginMenu();
                    }
                    break;
                case 2:
                    String readUsername = null;
                    String readPassword = null;
                    String readMail = null;
                    System.out.println("Insert username ");
                    readUsername = sc.nextLine();
                    System.out.println("Insert password ");
                    readPassword = sc.nextLine();
                    System.out.println("Insert email");
                    readMail = sc.nextLine();
                    register(readUsername, readPassword, readMail);
                    break;
                case 3:
                    System.out.println("Have a nice day");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
