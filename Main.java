import java.util.Scanner;

public class Main {
  
  static int total = 0;
  
  public static void main(String[] args) {
    //BankAccount();
    Opening();
  }

  public static void BankAccount() {
    Welcome();
    
  }

  public static void Opening() {
    System.out.print("Login or Signup: ");
    Scanner sc = new Scanner(System.in);
    String choice = sc.nextLine();

    if (choice.equals("signup")) {
      Signup();
    } else if (choice.equals("login")) {
      Login();
    } else {
      Opening();
    }
    
  }

  public static void Login() {
    System.out.println();
    System.out.print("enter ur username: ");
    Scanner sc = new Scanner(System.in);
    String username = sc.nextLine();

    System.out.print("enter ur password: ");
    Scanner scc = new Scanner(System.in);
    String password = scc.nextLine();
  }

  public static void Signup() {
    System.out.println();
    System.out.print("enter a username: ");
    Scanner sc = new Scanner(System.in);
    String username = sc.nextLine();

    System.out.print("enter a password: ");
    Scanner scc = new Scanner(System.in);
    String password = scc.nextLine();
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
    
    System.out.println("1. Deposit \n2. Withdraw\n3. Check Balance\n4. Deposit History\n5. Withdrawal History\n6. Transfer");
    System.out.println();
    System.out.print("Choose an option: ");

    Scanner sc = new Scanner(System.in);
    int option = sc.nextInt();

    switch (option) {
      case 1:
        Deposit();
        break;
      case 2:
        Withdraw();
        break;
      case 3:
        System.out.println("ur current balance is $" + CheckBalance() + " .");
        break;
    }
    
  }
  
  public static void Deposit() {
    Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.println();
      System.out.print("Enter amount to deposit: $");
      int deposit = sc.nextInt();
      if (deposit == 0) {
        System.out.println("Thanks for depositing with us today. Goodbye!");
        break;
      } else {
        total += deposit; 
        System.out.println("You now have $" + total + " in your account.");
      }
    }
  }

  public static void Withdraw() {
    Scanner sc = new Scanner(System.in);
    System.out.println();
    System.out.print("How much would you like to withdraw? $");
    int withdraw = sc.nextInt();
    total -= withdraw;
    System.out.println("You now have $" + total + " in your account.");
  }

  public static int CheckBalance() {
    return total;
  }

  public static void DepositHistory() {
    
  }
  
}
