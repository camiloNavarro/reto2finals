package model.data_structures;

import model.logic.Director;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico <T extends Comparable<T>> implements IArregloDinamico <T>  {
		/**
		 * Capacidad maxima del arreglo
		 */
        private int tamanoMax;
		/**
		 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
		 */
        private int tamanoAct;
        /**
         * Arreglo de elementos de tamaNo maximo
         */
        private T[] elementos;

        /**
         * Tamaño de arreglo por defecto
         */
        
        private static final int DEFAULT_SIZE = 7;
        
        /**
         * Construir un arreglo con la capacidad maxima por defecto.
         */
        
		public ArregloDinamico()
        {

	        elementos = (T[]) new Comparable [DEFAULT_SIZE];
	        tamanoMax = DEFAULT_SIZE;
	        tamanoAct = 0;
        }
        
        /**
         * Construir un arreglo con la capacidad maxima inicial.
         * @param max Capacidad maxima inicial
         */
        
		public ArregloDinamico( int max )
        {
               elementos = (T[]) new Comparable [max];
               tamanoMax = max;
               tamanoAct = 0;
        }
        
		public void agregar( Comparable generos )
        {	
               if ( tamanoAct == tamanoMax) 
               {  // caso de arreglo lleno (aumentar tamaNo)
                    tamanoMax = (tamanoMax * 3) / 2 + 1; // Asegura capacidad (Formula ideal)
                    T [ ] copia = elementos;
                    elementos = (T[]) new Comparable[tamanoMax];
                    
                    // Copia el arreglo de los elementos 
                    for ( int i = 0; i < copia.length; i++)
                    {
                     	 elementos[i] = copia[i];
                    } 
            	    
               }	
            // Adiciona el elemento al arreglo
               elementos[tamanoAct] = (T) generos;
            // Incrementa el tamaño de la lista 
               tamanoAct++;

       }

		public int darCapacidad() {
			return tamanoMax;
		}

		public int darTamano() {
			return tamanoAct;
		}

		public T darElemento(int i) {
			 if ( tamanoAct <= tamanoMax) {
			return elementos[i];
			 }
			return null;
		}

		public T buscar(T dato) {
		
			for (int i =0; i< tamanoAct; i++) {
				T datoact = elementos [i];
			if (datoact.compareTo(dato) == 0) {
				return datoact; 
				}
			
			}
			return null;
			 
		}
		
		public void eliminartodo() {
			if (isempty())
				return;
			for ( int i = 0; i < tamanoAct; i++)
                 {
                  	 elementos[i] = null;
                 } 
            tamanoAct =0;
			}

		public T eliminar(T dato) {
			for (int i =0; i< tamanoAct; i++) {
				T datoact = elementos [i];
			if (datoact.compareTo(dato) == 0) {
				if(i == tamanoAct-1) {
					elementos [i] =null;
				}
				else { while (i<tamanoAct-1 ) {
					elementos [i] = elementos [i+1];
					}
				}
				tamanoAct--; 
					
				return datoact; 
				}
			}
			return null;
			 
		}


		private boolean isempty() {
			return tamanoAct == 0;
		}
		
		
		
}
