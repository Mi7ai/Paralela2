package pr2;

public class HebraBloques2 extends Thread{
	private int miId, numHebras, n;
	double [] vectorX, vectorY;

	public HebraBloques2(int miId, int numHebras, int n, double[] vectorX, double[] vectorY) {
		super();
		this.miId = miId;
		this.numHebras = numHebras;
		this.n = n;
		this.vectorX = vectorX;
		this.vectorY = vectorY;
	}

	@Override
	public void run() {
		int tam = (n + numHebras - 1) / numHebras;
		int ini = miId * tam;
		int fin = Math.min(ini + tam, n);
		for (int i=ini; i<fin; i++) {
			vectorY[ i ] = EjemploFuncionCostosa1a.evaluaFuncion( vectorX[ i ] );
		}
	}
}
