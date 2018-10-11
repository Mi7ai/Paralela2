package pr2;

// ============================================================================
class EjemploFuncionSencilla1a {
// ============================================================================

  // --------------------------------------------------------------------------
  public static void main( String args[] ) {
    int     n, numHebras;
    long    t1, t2;
    double  tt, sumaX, sumaY;

    // Comprobacion y extraccion de los argumentos de entrada.
    if( args.length != 2 ) {
      System.err.println( "Uso: java programa <numHebras> <tamanyo>" );
      System.exit( -1 );
    }
    try {
      numHebras = Integer.parseInt( args[ 0 ] );
      n         = Integer.parseInt( args[ 1 ] );
    } catch( NumberFormatException ex ) {
      numHebras = -1;
      n         = -1;
      System.out.println( "ERROR: Argumentos numericos incorrectos." );
      System.exit( -1 );
    }

    // Crea los vectores.
    double vectorX[] = new double[ n ];
    double vectorY[] = new double[ n ];

    //
    // Implementacion secuencial.
    //
    inicializaVectorX( vectorX );
    inicializaVectorY( vectorY );
    t1 = System.nanoTime();
    for( int i = 0; i < n; i++ ) {
      vectorY[ i ] = evaluaFuncion( vectorX[ i ] );
    }
    t2 = System.nanoTime();
    tt = ( ( double ) ( t2 - t1 ) ) / 1.0e9;
    System.out.println( "Tiempo secuencial (seg.):                    " + tt );
    //// imprimeResultado( vectorX, vectorY );
    // Comprueba el resultado. 
    sumaX = sumaVector( vectorX );
    sumaY = sumaVector( vectorY );
    System.out.println( "Suma del vector X:          " + sumaX );
    System.out.println( "Suma del vector Y:          " + sumaY );


    System.out.println( "Fin del programa." );
    
    // Ejercicio 2.1 Distribucion ciclica

    inicializaVectorX( vectorX );
    inicializaVectorY( vectorY );
    long t1c = System.nanoTime();
    Thread[] vtc2 = new HebraCiclica3[numHebras];
    for (int i=0; i<numHebras; i++) {
    	vtc2[i] = new HebraCiclica3(i, numHebras, n, vectorX, vectorY);
    	vtc2[i].start();
    }

    for (int i=0; i<numHebras; i++) {
    	try {
    		vtc2[i].join();
    	}catch(InterruptedException e) {
    		e.printStackTrace();
    	}
    }
    
    long t2c = System.nanoTime();
    double ttc = ( ( double ) ( t2c - t1c ) ) / 1.0e9;
    System.out.println( "Tiempo paralelo ciclico (seg.):                    " + ttc );
    //// imprimeResultado( vectorX, vectorY );
    // Comprueba el resultado. 
    sumaX = sumaVector( vectorX );
    sumaY = sumaVector( vectorY );
    System.out.println( "Suma del vector X:          " + sumaX );
    System.out.println( "Suma del vector Y:          " + sumaY );
    
    System.out.println("Incremento ciclico: "+tt/ttc);
    System.out.println( "Fin del programa con ---Distribucion ciclica---." );
    // --------------------------------------------------------------------------

    
 // --------------------------------------------------------------------------

    // Ejercicio 2.2 Distribucion bloques

    inicializaVectorX( vectorX );
    inicializaVectorY( vectorY );
    long t1b = System.nanoTime();


    Thread[] vtb2 = new HebraBloques3[numHebras];

    for (int i=0; i<numHebras; i++) {
    	vtb2[i] = new HebraBloques3(i, numHebras, n, vectorX, vectorY);
    	vtb2[i].start();
    }

    for (int i=0; i<numHebras; i++) {
    	try {
    		vtb2[i].join();
    	}catch(InterruptedException e) {
    		e.printStackTrace();
    	}
    }

    
    long t2b = System.nanoTime();
    double ttb = ( ( double ) ( t2b - t1b ) ) / 1.0e9;
    System.out.println( "Tiempo paralelo bloques (seg.):                    " + ttb );
    //// imprimeResultado( vectorX, vectorY );
    // Comprueba el resultado. 
    sumaX = sumaVector( vectorX );
    sumaY = sumaVector( vectorY );
    System.out.println( "Suma del vector X:          " + sumaX );
    System.out.println( "Suma del vector Y:          " + sumaY );

    System.out.println("Incremento ciclico: "+tt/ttb);
    System.out.println( "Fin del programa con ---Distribucion bloques---." );
    // --------------------------------------------------------------------------
  
  }//fin main

  
  
  // --------------------------------------------------------------------------
  static void inicializaVectorX( double vectorX[] ) {
    if( vectorX.length == 1 ) {
      vectorX[ 0 ] = 0.0;
    } else {
      for( int i = 0; i < vectorX.length; i++ ) {
        vectorX[ i ] = 10.0 * ( double ) i / ( ( double ) vectorX.length - 1 );
      }
    }
  }

  // --------------------------------------------------------------------------
  static void inicializaVectorY( double vectorY[] ) {
    for( int i = 0; i < vectorY.length; i++ ) {
      vectorY[ i ] = 0.0;
    }
  }

  // --------------------------------------------------------------------------
  static double sumaVector( double vector[] ) {
    double  suma = 0.0;
    for( int i = 0; i < vector.length; i++ ) {
      suma += vector[ i ];
    }
    return suma;
  }

  // --------------------------------------------------------------------------
  static double evaluaFuncion( double x ) {
	  return (2.5)*x;
  }

  // --------------------------------------------------------------------------
  static void imprimeVector( double vector[] ) {
    for( int i = 0; i < vector.length; i++ ) {
      System.out.println( " vector[ " + i + " ] = " + vector[ i ] );
    }
  }

  // --------------------------------------------------------------------------
  static void imprimeResultado( double vectorX[], double vectorY[] ) {
    for( int i = 0; i < Math.min( vectorX.length, vectorY.length ); i++ ) {
      System.out.println( "  i: " + i + 
                          "  x: " + vectorX[ i ] +
                          "  y: " + vectorY[ i ] );
    }
  }

}