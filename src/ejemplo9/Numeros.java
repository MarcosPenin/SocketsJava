package ejemplo9;

import java.io.Serializable;

public class Numeros implements Serializable  {

	int numero;
	long cuadrado;
	long cubo;

	public Numeros() {}
	
	public Numeros(int numero, long cuadrado, long cubo) {

		this.numero = numero;
		this.cuadrado = cuadrado;
		this.cubo = cubo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public long getCuadrado() {
		return cuadrado;
	}

	public void setCuadrado() {
		this.cuadrado=this.numero*this.numero;
	}

	public long getCubo() {
		return cubo;
	}

	public void setCubo() {
		this.cubo=this.numero*this.numero*this.numero;
	}

}
