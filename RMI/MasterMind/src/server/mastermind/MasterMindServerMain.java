package mastermind;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;


public class MasterMindServerMain   {
	public static void main(String[] args) throws RemoteException {
		MasterMindServer mm = new MasterMindServerImp();
		try {
			Naming.rebind("MasterMind",mm);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.out.println("URL errónea al realizar el bind");
		} catch (RemoteException e) {
			e.printStackTrace();
			System.out.println("Problemas de comunicación al realizar el bind");
		}
	}
}
