package pr2;

class HebraBloques3 extends Thread{
	private int miId, numHebras, n;
	double [] vectorX, vectorY;

	public HebraBloques3(int miId, int numHebras, int n, double[] vectorX, double[] vectorY) {
		super();
		this.miId = miId;
		this.numHebras = numHebras;
		this.n = n;
		this.vectorX = vectorX;
		this.vectorY = vectorY;
	}

	public void run() {
		int tam = (n + numHebras - 1) / numHebras;
		int ini = miId * tam;
		int fin = Math.min(ini + tam, n);
		for (int i=ini; i<fin; i++) {
			vectorY[ i ] = EjemploFuncionSencilla1a.evaluaFuncion( vectorX[ i ] );
		}
	}
}