package negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Query;

import dao.CuentaDao;
import modelo.Cuenta;


@Stateless
public class CuentaON {

	@Inject
	private CuentaDao dao;
	
	public void crear(List<Cuenta> cuentas) {
		for (Cuenta cuenta : cuentas) {
			dao.crearCuenta(cuenta);
		}
	}
	
	public List<Cuenta> mostra() {
		return dao.mostar();
	}
	
	
}
