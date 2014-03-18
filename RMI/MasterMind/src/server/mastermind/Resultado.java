package mastermind;
import java.io.Serializable;

public class Resultado implements Serializable{
	public int muertos = 0;
	public int heridos = 0;
	public EstadoJugada estado;
}
