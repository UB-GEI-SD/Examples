package mastermind;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;



public interface MasterMindServer extends Remote, Serializable {
	public int obtenerPartida() throws RemoteException;
	public Resultado evaluaJugada(int numPartida, Combinacion c) throws RemoteException;
}
