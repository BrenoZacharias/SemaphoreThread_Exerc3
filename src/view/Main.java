package view;

import java.util.concurrent.Semaphore;

import controller.ThreadSistemaCompra;

public class Main {

	public static void main (String args []) {
		
		Semaphore semaforo = new Semaphore(1);
		
		for(int pessoa = 1; pessoa<=300; pessoa++){
			ThreadSistemaCompra t = new ThreadSistemaCompra(semaforo);
			t.start();
		}
	}
}
