import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BankManager extends Remote {

  // Add method to return an Account service
  public Account getAccount(String accountNumber)
       throws RemoteException;

  // Add method to return a Client service
  public Client getClient(String clientName)
       throws RemoteException;
}
