package pr2;

class HebraCiclica3 extends Thread{
	private int miId, numHebras, n;
	double [] vectorX, vectorY;

	public HebraCiclica3(int miId, int numHebras, int n, double[] vectorX, double[] vectorY) {
		super();
		this.miId = miId;
		this.numHebras = numHebras;
		this.n = n;
		this.vectorX = vectorX;
		this.vectorY = vectorY;
	}
	
	public void run() {
		for (int i=miId; i<n; i+=numHebras) {
		      vectorY[ i ] = EjemploFuncionSencilla1a.evaluaFuncion( vectorX[ i ] );
		}
	}
}
