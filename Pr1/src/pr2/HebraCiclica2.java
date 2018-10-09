package pr2;

public class HebraCiclica2 extends Thread{
	private int miId, numHebras, n;
	double [] vectorX, vectorY;

	public HebraCiclica2(int miId, int numHebras, int n, double[] vectorX, double[] vectorY) {
		super();
		this.miId = miId;
		this.numHebras = numHebras;
		this.n = n;
		this.vectorX = vectorX;
		this.vectorY = vectorY;
	}
	
	@Override
	public void run() {
		for (int i=miId; i<n; i+=numHebras) {
		      vectorY[ i ] = EjemploFuncionCostosa1a.evaluaFuncion( vectorX[ i ] );
		}
	}
}
