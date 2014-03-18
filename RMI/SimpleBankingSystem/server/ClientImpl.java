import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientImpl extends UnicastRemoteObject implements Client  {

  private BankManager bankManager;
  private String      clientName;

  // public constructor
  public ClientImpl(BankManager bm, String name) 
	  throws RemoteException {
    super();
    this.bankManager = bm;
    this.clientName  = name;
  }

  public BankManager getBankManager() 
      throws RemoteException {
    return bankManager;
  }

  public String getName() 
      throws RemoteException {
    return clientName;
  }
}
    
