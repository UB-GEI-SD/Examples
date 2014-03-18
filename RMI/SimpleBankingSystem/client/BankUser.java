import java.rmi.*;
import java.net.MalformedURLException;
import java.util.Locale;
import java.text.NumberFormat;

public class BankUser {

  // Interface reference to BankManager
  private BankManager bm;

  // No-argument constructor
  public BankUser() {

    try {
      bm = (BankManager)Naming.lookup(
        "rmi://localhost:1099/BankSystem");
    } catch (MalformedURLException malformedException) {
      System.err.println("Bad URL: " + malformedException);
    } catch (NotBoundException notBoundException) {
      System.err.println("Not Bound: " + notBoundException);
    } catch (RemoteException remoteException) {
      System.err.println("Remote Exception: " + remoteException);
    }

    try {
      // Lookup account 4461
      Account account = bm.getAccount("4461");

      // Get client for account
      Client client = account.getClient();

      // Get name for client
      String name = client.getName();

      // Get balance for account
      long cash = account.getBalance();

      // Format and display output
      NumberFormat currencyFormat = 
        NumberFormat.getCurrencyInstance(Locale.US);
      String balanceString = currencyFormat.format(cash);
      System.out.println(name + "'s account has " + balanceString);
    } catch (RemoteException remoteException) {
      System.err.println(remoteException);
    }
  }

  public static void main(String[] args) {
    new BankUser();
  }
}
