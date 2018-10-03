package pr1;
// ============================================================================
class CuentaIncrementos1a {
// ============================================================================
  long contador = 0;

  // --------------------------------------------------------------------------
  void incrementaContador() {
    contador++;
  }

  // --------------------------------------------------------------------------
  long dameContador() {
    return( contador );
  }
}


// ============================================================================
class EjemploIncrementos1a {
// ============================================================================

  // --------------------------------------------------------------------------
  public static void main( String args[] ) {
    int  numHebras;

    // Comprobacion y extraccion de los argumentos de entrada.
    if( args.length != 1 ) {
      System.err.println( "Uso: java programa <numHebras>" );
      System.exit( -1 );
    }
    try {
      numHebras = Integer.parseInt( args[ 0 ] );
    } catch( NumberFormatException ex ) {
      numHebras = -1;
      System.out.println( "ERROR: Argumentos numericos incorrectos." );
      System.exit( -1 );
    }

    //4.2.1  El programa principal debe averiguar el numero de hebras que debe crear.
    System.out.println( "Hay que crear: " + numHebras + " hebras.");
    
    //4.2.2  El programa principal debe crear e inicializar el objeto de la clase.
    CuentaIncrementos1a incrementos = new CuentaIncrementos1a();
    
    //4.2.3  El programa principal debe imprimir el valor inicial del contador.
    System.out.println("Contador actual = "+incrementos.dameContador());
    
    //4.2.4  El programa principal debe crear y arrancar las hebras.
    Thread vt [] = new MiHebra3[numHebras];
    
    for (int i=0; i<numHebras; i++){
    	vt[i] = new MiHebra3(i,incrementos);
    	vt[i].start();
    }
    
    //4.2.5  El programa principal debe esperar a que todas las hebras terminen.
    for (int i=0; i<numHebras; i++){
    	try{
    		vt[i].join();
    	}catch(InterruptedException e){
    		e.printStackTrace();
    	}
    }
    
    
    //4.2.6 El programa principal debe imprimir el valor nal del contador.
    System.out.println("Valor final contador: "+incrementos.dameContador());
  }
}

