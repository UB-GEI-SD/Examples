import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.net.MalformedURLException;

public class BankSystemServer {

  // public No-argument constructor
  public BankSystemServer() {
  }

  public static void main(String args[]) {
    new BankSystemServer();

    BankManager bm = null;

    try {
      // Create a BankManager object
      bm = new BankManagerImpl();
      // Export it to RMI
      //UnicastRemoteObject.exportObject( bm );
    } catch (RemoteException remoteException) {
      System.err.println( 
        "Failure during object export to RMI: " + 
         remoteException);
    }

    // Register an external name for the service
    try {
      Naming.rebind("//localhost/BankSystem", bm);
    } catch (RemoteException remoteException) {
      System.err.println(
        "Failure during Name registration: " + 
        remoteException);
    } catch (MalformedURLException malformedException) {
      System.err.println(
        "Failure during Name registration: " + 
        malformedException);
    }

    System.out.println("Server started.");
    System.out.println("Enter <CR> to end.");
    try {
       int i = System.in.read();
    } catch (IOException ioException) {
    }
    System.exit(0);
  }
}

