package servicios;

import java.util.List;

import modelo.Movimiento;



public class CuentaTMP {

	private int id;
	
	private String nombres;
	
	private int numero;
	
	
	private List<Movimiento> movimientos;
	
	private Double saldo;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public List<Movimiento> getMovimientos() {
		return movimientos;
	}


	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}


	public Double getSaldo() {
		return saldo;
	}


	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	
}
