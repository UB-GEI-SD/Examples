package mastermind;
import java.io.Serializable;

//@SuppressWarnings("serial")
public class Combinacion implements Serializable {
	public static int TAM_JUGADA = 4;
	private Color[] combinacion;
	
	public Combinacion() {
		combinacion = new Color[TAM_JUGADA];
		System.out.println("Nueva combinación secreta");
		for (int i = 0 ; i < TAM_JUGADA ; i++) {
			combinacion[i] = Color.colorAleatorio();
		}
		System.out.println(this);
	}
	
	public Combinacion(String s) {
		combinacion = new Color[TAM_JUGADA];
		for (int i = 0 ; i < TAM_JUGADA; i++) {
			combinacion[i] = Color.convierteCaracterAColor(s.charAt(i));
		}
	}
	
	public String toString() {
		return toString(combinacion);
	}
	
	public String toString(Color []combinacion) {
		String str = "" + combinacion[0];
		for (int i = 1 ; i < TAM_JUGADA; i++) {
			str = str + "," + combinacion[i];
		}
		return str;
	}
	
	public Resultado comparaCombinacion(Combinacion jugada) {
		Resultado r  = new Resultado(); 
		Color[] copiaClave = combinacion.clone();
		System.out.println(toString(copiaClave));
		Color[] copiaJugada = jugada.combinacion.clone();
		System.out.println(toString(copiaJugada));
		int n = copiaClave.length;
		for (int i = 0; i < n; i++) {
			if (copiaClave[i] == copiaJugada[i]) {
				r.muertos++;
				copiaClave[i] = null;
				copiaJugada[i] = null;
			}
		}
		for ( int i  = 0 ; i < n; i++) {
			int j = 0;
			boolean encontrado = false;
			while ( (j < n) && !encontrado) {
				encontrado = ((copiaClave[i] == copiaJugada[j]) && (copiaClave[i]!=null));
				j++;
			}
			if (encontrado) {
				copiaClave[i] = null;
				copiaJugada[j-1] = null;
				r.heridos++;
			}
		}
		if (r.muertos == 4) {
			r.estado = EstadoJugada.GANADOR;
		} else {
			r.estado = EstadoJugada.RESULTADO_PARCIAL;
		}
		return r;
	}
	
}
