package mastermind;
import java.rmi.RemoteException;
import java.rmi.server.*;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//import java.io.Serializable;


public class MasterMindServerImp extends UnicastRemoteObject implements MasterMindServer {
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	int numPartida = 0;
	Combinacion combinacionSecreta;
	Lock l;
	Random r;
	
	public MasterMindServerImp() throws RemoteException {
		l = new ReentrantLock();
		r = new Random();
		combinacionSecreta = new Combinacion();
	}
	
	
	
	public Resultado evaluaJugada(int numPartidaCliente,Combinacion combinacionCliente) throws RemoteException {
		Resultado r = new Resultado();
		System.out.println("Combinacion recibida:"+combinacionCliente);
		l.lock();
		try {
			if (numPartidaCliente == numPartida) {
				r = combinacionSecreta.comparaCombinacion(combinacionCliente);
				if (r.estado == EstadoJugada.GANADOR) {
					numPartida++;
					combinacionSecreta = new Combinacion();
				}
			} else {
				r.estado = EstadoJugada.PARTIDA_CAMBIADA;
			}
			return r;
		} finally {
			l.unlock();
		}
	}
	
	
	@Override
	public int obtenerPartida() throws RemoteException {
		l.lock();
		try {
			return numPartida;
		} finally {
			l.unlock();
		}
	}

}
