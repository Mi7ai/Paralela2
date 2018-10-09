package pr2;

public class HebraCiclica extends Thread{
	private int miId, numHebras, n;

	public HebraCiclica(int miId, int numHebras, int n) {
		this.miId = miId;
		this.numHebras = numHebras;
		this.n = n;
	}
	
	@Override
	public void run() {
		for (int i=miId; i<n; i+=numHebras) {
			System.out.println("Hebra: "+miId+"  "+i);
		}
	}
}