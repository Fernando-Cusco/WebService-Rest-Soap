package dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import modelo.Movimiento;

public class MovimientoDao {
	
	@Inject
	private EntityManager em;
	
	
	public void nuevaTransaccion(Movimiento m) {
		em.persist(m);
	}
	
}
