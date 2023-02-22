import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Bank {

  static Scanner scanner = new Scanner(System.in);
  static ArrayList<User> users = new ArrayList<User>();
  static ArrayList<Integer> balances = new ArrayList<Integer>();
  static int userCount = 0;

  public static void MainMenu() {
    
    System.out.print("login or signup: ");
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

    // need to check if login is valid

    int userIndex = -1;
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i) != null && users.get(i).getUsername().equals(username) && users.get(i).getPassword().equals(password)) {
        userIndex = i;
        break;
      }
    }

    if (userIndex == -1) {
      System.out.println("invalid username or password, try again");
      MainMenu();
    } else {
      System.out.println();

      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      
      System.out.println("==================");
      System.out.println("LOGIN SUCCESSFUL..");
      System.out.println("==================");

      if (userIndex < balances.size()) {
        Options(userIndex);
      } else {
        System.out.println("Error: balance not found");
        MainMenu();
      }
    }
    
  }

  public static void Signup() {
    
    System.out.println();
    System.out.print("enter a username: ");
    String username = scanner.nextLine();

    System.out.print("enter a password: ");
    String password = scanner.nextLine();
    System.out.println();
    System.out.println("thanks for signing up with us!");

    users.add(new User(username, password, 0));
    balances.add(0);

    System.out.println("taking u to login page...");
    try {
        Thread.sleep(600);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    Login();
    MainMenu();
}


  public static void Options(int userIndex) {

    try {
      Thread.sleep(800);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println();
    System.out.println("OPTIONS");
    System.out.println("-------");
    System.out.println("1. Deposit \n2. Withdraw\n3. Check Balance\n4. Deposit History\n5. Withdrawal History\n6. Transfer\n7. Sign Out");
    System.out.println();
    System.out.print("choose an option: ");

    int option;

    try {

      option = scanner.nextInt();
      
    } catch (InputMismatchException e) {
      System.out.println("invalid input, plz try again");
      scanner.nextLine();
      Options(userIndex);
      return;
    }

    switch (option) {
      case 1:
        Deposit(userIndex);
        break;
      case 2:
        Withdraw(userIndex);
        break;
      case 3:
        System.out.println();
        System.out.println("===========================");
        System.out.println("ur current balance is $" + CheckBalance(userIndex));
        System.out.println("===========================");
        Options(userIndex);
        break;
      case 4:
        DepositHistory(userIndex);
        break;
      case 5:
        WithdrawalHistory(userIndex);
        break;
      case 6:
        Transfer(userIndex);
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
        System.out.println("invalid option, pls try again.");
        Options(userIndex);
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
  
  public static void Deposit(int userIndex) {

    try {

      while (true) {
        System.out.println();
        System.out.print("enter amount to deposit: $");
        int deposit = scanner.nextInt();
        if (deposit == 0) {
          System.out.println("thx for depositing with us today");
          break;
        } else {
          balances.set(userIndex, balances.get(userIndex) + deposit);
          System.out.println("u now have $" + balances.get(userIndex) + " in ur account.");
        }
      }
      
    } catch (InputMismatchException e) {
      System.out.println("plz enter a whole integer value");
      scanner.next();
      System.out.println();
      Deposit(userIndex);
    }

    Options(userIndex);
    
  }

  public static void Withdraw(int userIndex) {

    try {

      System.out.println();
      System.out.print("How much would you like to withdraw? $");
      int withdraw = scanner.nextInt();
      if (withdraw > balances.get(userIndex)) {
        System.out.println("insufficient funds.");
        Withdraw(userIndex);
      } else {
        int newBalance = balances.get(userIndex) - withdraw;
        balances.set(userIndex, newBalance);
        System.out.println("u now have $" + balances.get(userIndex) + " in ur account.");
      }
      
    } catch (InputMismatchException e) {
      System.out.println("plz enter a whole integer value");
      scanner.next();
      System.out.println();
      Withdraw(userIndex);
    }

    Options(userIndex);
    
  }

  public static int CheckBalance(int userIndex) {
    
    return balances.get(userIndex);
    
  }

  public static void DepositHistory(int userIndex) {
    System.out.println();
    System.out.println("sorry, under maintenance");

    Options(userIndex);
    
  }

  public static void WithdrawalHistory(int userIndex) {
    System.out.println();
    System.out.println("sorry, under maintenance");

    Options(userIndex);
    
  }

  public static void Transfer(int userIndex) {
    System.out.println();
    System.out.println("sorry, under maintenance");

    Options(userIndex);
    
  }
  
}
