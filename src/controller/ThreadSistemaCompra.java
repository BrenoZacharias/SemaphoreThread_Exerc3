package controller;

import java.util.concurrent.Semaphore;

public class ThreadSistemaCompra extends Thread{

	private static int capacidade = 100;
	private Semaphore semaforo; 
	
	public ThreadSistemaCompra(Semaphore semaforo) {
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		if(login()==true){
			if(processoCompra()==true){
				try {
					semaforo.acquire();
					validacaoCompra();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally{
					semaforo.release();
				}
			}
		}
	}

	private boolean login() {
		int tempo = (int)(Math.random() * 1951) + 50;
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(tempo > 1000){
			System.out.println("timeout");
			return false;
		}
		else{
		return true;
		}
	}

	private boolean processoCompra() {
		int tempo = (int)(Math.random() * 2001) + 1000;
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(tempo > 2500){
			System.out.println("final de tempo de sessão");
			return false;
		}
		else{
		return true;
		}
	}
		
	private void validacaoCompra() {
		int ingressos = (int)(Math.random() * 3.1) + 1; 
		if(capacidade >= ingressos){
			capacidade-=ingressos;
			System.out.println("Venda de " + ingressos + " ingressos concluída!!! Restam: " + capacidade + " ingressos");
		}
		else{
			System.out.println("Indisponibildade de ingressos");
		}
	}
}
