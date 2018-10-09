package pr2;

public class HebraBloques extends Thread{
	private int miId, numHebras, n;

	public HebraBloques (int miId, int numHebras, int n) {
		this.miId = miId;
		this.numHebras = numHebras;
		this.n = n;
	}
	
	@Override
	public void run() {
      int tam = (n + numHebras - 1) / numHebras;
	  int ini = miId * tam;
	  int fin = Math.min(ini + tam, n);
		for (int i=ini; i<fin; i++) {
			System.out.println("Hebra: "+miId+"  "+i);
		}
	}
}