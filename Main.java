import java.util.Scanner;

public class Main {
  
  static int total = 0;
  
  public static void main(String[] args) {
    BankAccount();
  }

  public static void BankAccount() {
    Welcome();
    //DepositHistory();
    //Deposit();
    
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
    
    System.out.println("Choose an option: ");
    System.out.println("1. Deposit \n2. Withdraw\n3. Check Balance\n4. Deposit History\n5. Withdrawal History\n6. Create Account\n7. Transfer");
  }
  
  public static void Deposit() {
    Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.print("Enter amount to deposit: $");
      int deposit = sc.nextInt();
      if (deposit == -1) {
        System.out.println("Thanks for using this bank today. Goodbye!");
        System.out.println();
        System.out.print("Would you like to make a withdrawal? ");
        String withdrawal_option = sc.next();
        if (withdrawal_option.equalsIgnoreCase("yes") || withdrawal_option.equalsIgnoreCase("y")) {
          Withdraw();
        }
        break;
      } else {
        total += deposit; 
        System.out.println("You now have $" + total + " in your account.");
      }
    }
  }

  public static void Withdraw() {
    Scanner sc = new Scanner(System.in);
    System.out.print("How much would you like to withdraw? $");
    int withdraw = sc.nextInt();
    total -= withdraw;
    System.out.println("You now have $" + total + " in your account.");
  }

  public static void DepositHistory() {
    System.out.print("would u like to view ur deposit history?: ");
    Scanner sc = new Scanner(System.in);
    String view = sc.nextLine();
    
  }
  
}
