package negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.CuentaDao;
import dao.MovimientoDao;
import modelo.Cuenta;
import modelo.Movimiento;
import servicios.Transaccion;

@Stateless
public class MovimientoON {

	@Inject
	private MovimientoDao dao;

	@Inject
	private CuentaDao daoc;

	public List<Cuenta> nuevaTransferencia(Transaccion t) {
		Movimiento ori = null;
		Movimiento det = null;
		List<Cuenta> cuentas = new ArrayList<Cuenta>();
		
		if (t.getTipo().equals("t")) {
			if (t.getOrigen() > 0 && t.getDestino() > 0) {
				ori = new Movimiento();
				det = new Movimiento();
				Cuenta destino = daoc.buscarCuenta(t.getDestino());
				Double saldo = destino.getSaldo();
				saldo = saldo + t.getMonto();
				Cuenta origen = daoc.buscarCuenta(t.getOrigen());
				Double saldoo = origen.getSaldo();
				saldoo = saldoo - t.getMonto();
				origen.setSaldo(saldoo);
				destino.setSaldo(saldo);
				daoc.actualizarSaldo(origen);
				daoc.actualizarSaldo(destino);
				cuentas.add(origen);
				cuentas.add(destino);
				
				ori.setFecha(new Date());
				ori.setMonto(t.getMonto());
				ori.setNumero(t.getOrigen());
				ori.setTipo("Debito");
				
				det.setFecha(new Date());
				det.setMonto(t.getMonto());
				det.setNumero(t.getDestino());
				det.setTipo("Credito");
				dao.nuevaTransaccion(ori);
				dao.nuevaTransaccion(det);
				origen.agregarMovimiento(ori);
				destino.agregarMovimiento(det);	
			}
		} else if (t.getTipo().equals("r")) {
			if (t.getOrigen() > 0) {
				ori = new Movimiento();
				Cuenta origen = daoc.buscarCuenta(t.getOrigen());
				Double saldoo = origen.getSaldo();
				saldoo = saldoo - t.getMonto();
				origen.setSaldo(saldoo);
				daoc.actualizarSaldo(origen);
				cuentas.add(origen);
				ori.setFecha(new Date());
				ori.setMonto(t.getMonto());
				ori.setNumero(t.getOrigen());
				ori.setTipo("Retiro");
				dao.nuevaTransaccion(ori);
				origen.agregarMovimiento(ori);
			}
		}
		return cuentas;
	}
}
