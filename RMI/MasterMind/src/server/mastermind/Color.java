package mastermind;
import java.util.Random;

public enum Color {
	Rojo, Verde, Amarillo, Blanco, Azul, Rosa;
	static Random r = new Random();
	
	public static Color colorAleatorio() {
		int n = r.nextInt(6);
		switch (n) {
		case 0: return Amarillo;
		case 1: return Azul;
		case 2: return Blanco;
		case 3: return Rojo;
		case 4: return Rosa;
		default: return Verde;
		}
	}
	
	public static Color convierteCaracterAColor (char c) {
		switch (c) {
		case 'A': return Amarillo;
		case 'Z': return Azul;
		case 'B': return Blanco;
		case 'R': return Rojo;
		case 'S': return Rosa;
		case 'V': return Verde;
		default: return null;
		}
	}
};
