
import java.util.Scanner;

public class ConsoleBased extends Forum {
    private Scanner sc;
    private String prompt;

    public ConsoleBased(User userLogedIn, Category currentCategory, Post post, Scanner sc, String prompt) {
        super(userLogedIn, currentCategory, post);
        this.sc = sc;
        this.prompt = ">";
    }

    public ConsoleBased() {
    }


    private Integer drawTopicMenu() {
        System.out.println("1. Create topic");
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
            prompt = whoIsLoggedIn() + " , " + wichCategory() + " > ";
            switch (drawTopicMenu()) {
                case 1:
                    System.out.println("Enter new topic: ");
                    String subject = sc.nextLine();
                    insertTopic(subject);
                    break;
                case 2:
                    System.out.println(getAllTopics());
                    break;
                case 3:
                    System.out.println("Enter topic");
                    Integer id_topic = sc.nextInt();
                    sc.nextLine();
                    enterTopic(id_topic);
                    break;
                case 4:
                    System.out.println("Have a nice day");
                    return;
                default:
                    System.out.println("Optiunea nu exista");
                    break;
            }
        }
    }

    private Integer drawCategoryMenu() {
        System.out.println("1. Create category");
        System.out.println("2. Show all Categoryes");
        System.out.println("3. Enter category");
        System.out.println("4. return");
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
                    System.out.println("Enter category subject");
                    String subject = sc.nextLine();
                    insertCategory(subject);
                    break;
                case 2:
                    System.out.println(getAllCategories());
                    break;
                case 3:
                    System.out.println("Enter category");
                    Integer id_category = sc.nextInt();
                    sc.nextLine();
                    if (enterCategory(id_category)) {
                        categoryMenu();
                    }
                    break;
                case 4:
                    System.out.println("Have a nice day");
                    return;
                default:
                    System.out.println("Option not exist");
                    break;
            }
        }
    }

    private Integer drawMainMenu() {
        System.out.println("\n***************************");
        System.out.println("Operations:");
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
                    System.out.println("Enter username");
                    String username = sc.nextLine();
                    System.out.println("Enter password");
                    String password = sc.nextLine();
                    if (login(username, password)) {
                        loginMenu();
                    }
                    break;
                case 2:
                    String readUsername = null;
                    String readPassword = null;
                    String readMail = null;
                    System.out.println("Insert username= ");
                    readUsername = sc.nextLine();
                    System.out.println("Insert password= ");
                    readPassword = sc.nextLine();
                    System.out.println("Insert email= ");
                    readMail = sc.nextLine();
                    register(readUsername, readPassword, readMail);
                    break;
                case 3:
                    System.out.println("Have a nice day ");
                    break;
                default:
                    System.out.println("Option not exist. ");
            }
        }
    }
}