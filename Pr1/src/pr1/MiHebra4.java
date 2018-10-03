package pr1;

public class MiHebra4 extends Thread{
	
	long nr;
 	
	public MiHebra4(long nr) {
		this.nr = nr;		 
	}
	
	@Override
	public void run(){		
		 if (GUIPrimoSencillo1a.esPrimo(nr)) {
			System.out.println("El numero ---> "+ nr + " ES primo!");
		}else {
			System.out.println("El numero ---> "+ nr + " NO ES primo!");
		}
	}

}
