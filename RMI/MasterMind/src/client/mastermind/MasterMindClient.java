package mastermind;
import java.io.Console;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class MasterMindClient {
	public static void main(String[] args ) {
		MasterMindClient mmc = new MasterMindClient();
		mmc.conectarYJugar();
	}
	
	public void conectarYJugar() {
		try {
			MasterMindServer server = (MasterMindServer) Naming.lookup("MasterMind");
			jugar(server);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.out.println("URL errónea al realizar el lookup");
		} catch (RemoteException e) {
			e.printStackTrace();
			System.out.println("Problemas de comunicación al realizar el lookup");
		} catch (NotBoundException e) {
			e.printStackTrace();
			System.out.println("No existe ningún objeto en el registro con el nombre indicado");
		}
	}
	
	public void jugar(MasterMindServer server) {
		Console cons = System.console();
		System.out.println("Cliente Mastermind. Introduzca la jugada o 'exit' para salir");
		int numPartida = 0;
		try {
			numPartida = server.obtenerPartida();
		} catch (RemoteException e) {
			System.out.println("Problemas de comunicación al solicitar la partida");
			e.printStackTrace();
		}
		String cmd = cons.readLine();
		while (!cmd.equals("exit")) {
			Combinacion c = new Combinacion(cmd);
			Resultado r;
			try {
				r = server.evaluaJugada(numPartida, c);
				if (r.estado == EstadoJugada.GANADOR) {
					System.out.println("Ganaste");
					numPartida = server.obtenerPartida();
				} else if (r.estado == EstadoJugada.PARTIDA_CAMBIADA) {
					System.out.println("Lo siento, la partida ha cambiado");
					numPartida = server.obtenerPartida();
				} else {
					System.out.println(r.muertos+ " muertos y "+r.heridos+" heridos");
				}
			} catch (RemoteException e) {
				System.out.println("Problemas de comunicación");
				e.printStackTrace();
			}		
			cmd = cons.readLine();
		}
	}
}
