import java.util.Scanner;

public class Main {
  
  static int total = 0;
  static Scanner scanner = new Scanner(System.in);
  
  public static void main(String[] args) {
    
    Welcome();
    
  }

  public static void MainMenu() {
    
    System.out.print("Login or Signup: ");
    String choice = scanner.nextLine();

    if (choice.equals("signup")) {
      Signup();
    } else if (choice.equals("login")) {
      Login();
    } else {
      MainMenu();
    }
    
  }

  public static void Login() {
    
    System.out.println();
    System.out.print("enter ur username: ");
    String username = scanner.nextLine();

    System.out.print("enter ur password: ");
    String password = scanner.nextLine();

    // need to check if login is successful

    Options();
    
  }

  public static void Signup() {
    
    System.out.println();
    System.out.print("enter a username: ");
    String username = scanner.nextLine();

    System.out.print("enter a password: ");
    String password = scanner.nextLine();
    System.out.println();
    System.out.println("thanks for signing up with us!");
    System.out.println("taking u to login page...");

    try {
      Thread.sleep(600);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    Login();
    
  }

  public static void Options() {

    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println();
    System.out.println("OPTIONS");
    System.out.println("-------");
    System.out.println("1. Deposit \n2. Withdraw\n3. Check Balance\n4. Deposit History\n5. Withdrawal History\n6. Transfer\n7. Sign Out");
    System.out.println();
    System.out.print("Choose an option: ");

    int option = scanner.nextInt();
    scanner.nextLine();

    switch (option) {
      case 1:
        Deposit();
        break;
      case 2:
        Withdraw();
        break;
      case 3:
        System.out.println("==========================");
        System.out.println("ur current balance is $" + CheckBalance());
        System.out.println("==========================");
        Options();
        break;
      case 4:
        DepositHistory();
        break;
      case 5:
        WithdrawalHistory();
        break;
      case 6:
        Transfer();
        break;
      case 7:
        System.out.println();
        System.out.println("signing u out..");
        System.out.println();

        try {
          Thread.sleep(600);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        
        System.out.println("===========================");
        System.out.println("          GOODBYE          ");
        System.out.println("===========================");
        System.exit(0);
        break;
      default:
        System.out.println("Invalid option. Please try again.");
        Options();
        break;
    }
    
  }

  public static void Welcome() {
    
    System.out.println("===========================");
    System.out.println("   WELCOME TO THE BANK");
    System.out.println("===========================");
    System.out.println("");
    
    // time delay before next code
    try {
      Thread.sleep(700);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    MainMenu();
    
  }
  
  public static void Deposit() {
    
    Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.println();
      System.out.print("enter amount to deposit: $");
      int deposit = sc.nextInt();
      if (deposit == 0) {
        System.out.println("thx for depositing with us today");
        break;
      } else {
        total += deposit; 
        System.out.println("u now have $" + total + " in ur account.");
      }
    }

    Options();
    
  }

  public static void Withdraw() {
    
    Scanner sc = new Scanner(System.in);
    System.out.println();
    System.out.print("How much would you like to withdraw? $");
    int withdraw = sc.nextInt();
    if (withdraw > total) {
      System.out.println("insufficient funds.");
      Withdraw();
    } else {
      total -= withdraw;
      System.out.println("u now have $" + total + " in ur account.");
    }

    Options();
    
  }

  public static int CheckBalance() {
    
    return total;
    
  }

  public static void DepositHistory() {
    
    System.out.println("sorry, under maintenance");

    Options();
    
  }

  public static void WithdrawalHistory() {

    System.out.println("sorry, under maintenance");

    Options();
    
  }

  public static void Transfer() {

    System.out.println("sorry, under maintenance");

    Options();
    
  }
  
}
