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
import servicios.Respuesta;
import servicios.Transaccion;

@Stateless
public class MovimientoON {

	@Inject
	private MovimientoDao dao;

	@Inject
	private CuentaDao daoc;

	public Respuesta nuevaTransferencia(Transaccion t) {
		Movimiento ori = new Movimiento();
		Movimiento det = new Movimiento();

		Respuesta res = new Respuesta();
		Cuenta destino = null;
		Cuenta origen = null;
		try {
			destino = daoc.buscarCuenta(t.getDestino());
			origen = daoc.buscarCuenta(t.getOrigen());
		} catch (Exception e) {
			if (destino == null) {
				res.setCodigo(0);
				res.setMensaje("Cuenta destino no existe");
			}
			if (origen == null) {
				res.setCodigo(0);
				res.setMensaje("Cuenta origen no existe");
			}
		}

		if (destino != null && origen != null) {
			Double saldo = destino.getSaldo();

			Double saldoo = origen.getSaldo();
			if (saldoo >= t.getMonto()) {
				saldoo = saldoo - t.getMonto();
				origen.setSaldo(saldoo);
				saldo = saldo + t.getMonto();
				destino.setSaldo(saldo);
				daoc.actualizarSaldo(origen);
				daoc.actualizarSaldo(destino);
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
				res.setCodigo(1);
				res.setMensaje("Transaccion finalizada correctamente");
			} else {
				res.setCodigo(0);
				res.setMensaje("Saldo insuficiente");
			}
		}
		return res;
	}
}
