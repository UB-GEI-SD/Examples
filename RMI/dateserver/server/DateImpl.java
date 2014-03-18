import java.rmi.RemoteException; import java.rmi.server.UnicastRemoteObject; import java.util.Date;
public class DateImpl extends UnicastRemoteObject implements DateInterface {
	public DateImpl() throws RemoteException {}
	public Date getDate() throws RemoteException { return new Date();
	}
}