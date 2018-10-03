package pr1;

public class MiHebra3 extends Thread{
	
	int miId;
	CuentaIncrementos1a incremento;
	
	public MiHebra3(int id, CuentaIncrementos1a i) {
		miId = id;
		incremento = i;
	}
	
	@Override
	public void run(){
		
		System.out.println("Hebra "+miId+" empezando tarea incremento...");
		
		for (int i = 0; i<1000000; i++){
			incremento.incrementaContador();
		}
		
		System.out.println("Hebra "+miId+" ha acabado tarea incremento!");
	}

}
