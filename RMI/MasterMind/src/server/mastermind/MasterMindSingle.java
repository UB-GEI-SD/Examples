package mastermind;
import java.io.Console;

public class MasterMindSingle {
	public static void main(String[] args ) {
		MasterMindSingle mms = new MasterMindSingle();
		mms.jugar();
	}
	
	public void jugar() {
		Console cons = System.console();
		System.out.println("Mastermind. Introduzca la jugada o 'exit' para salir");
		Combinacion combinacionSecreta = new Combinacion();
		String cmd = cons.readLine();
		while (!cmd.equals("exit")) {
			Combinacion c = new Combinacion(cmd);
			Resultado r = combinacionSecreta.comparaCombinacion(c);
			if (r.estado == EstadoJugada.GANADOR) {
				System.out.println("Ganaste");
				combinacionSecreta = new Combinacion();
			} else {
				System.out.println(r.muertos+ " muertos y "+r.heridos+" heridos");
			}	
			cmd = cons.readLine();
		}
	}
}
