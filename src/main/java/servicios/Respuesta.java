package servicios;

public class Respuesta {

	private int id;
	
	private String mensaje;
	
	private int cuentaOrigen;
	private int cuentaDestino;
	
	private Double saldoOrigen;
	private Double saldoDestino;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public int getCuentaOrigen() {
		return cuentaOrigen;
	}

	public void setCuentaOrigen(int cuentaOrigen) {
		this.cuentaOrigen = cuentaOrigen;
	}

	public int getCuentaDestino() {
		return cuentaDestino;
	}

	public void setCuentaDestino(int cuentaDestino) {
		this.cuentaDestino = cuentaDestino;
	}

	public Double getSaldoOrigen() {
		return saldoOrigen;
	}

	public void setSaldoOrigen(Double saldoOrigen) {
		this.saldoOrigen = saldoOrigen;
	}

	public Double getSaldoDestino() {
		return saldoDestino;
	}

	public void setSaldoDestino(Double saldoDestino) {
		this.saldoDestino = saldoDestino;
	}
	
	
}
