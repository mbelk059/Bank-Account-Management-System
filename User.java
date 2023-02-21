public class User {
  private String username;
  private String password;
  private int balance;

  public User(String username, String password, int balance) {
    this.username = username;
    this.password = password;
    this.balance = balance;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }

  public double getBalance() {
    return balance;
  }

}
