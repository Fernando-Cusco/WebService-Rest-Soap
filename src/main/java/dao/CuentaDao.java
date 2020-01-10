package dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Cuenta;
import modelo.Movimiento;


public class CuentaDao {

	@Inject
	private EntityManager em;
	
	public void crearCuenta(Cuenta c) {
		em.persist(c);
	}
	
	public Cuenta actualizarSaldo(Cuenta c) {
		return em.merge(c);
	}
	
	public Cuenta buscarCuenta(int numero) {
		String jpql = "SELECT c FROM Cuenta c where c.numero = :numero";
		Query query = em.createQuery(jpql, Cuenta.class);
		query.setParameter("numero", numero);
		Cuenta cuenta = (Cuenta) query.getSingleResult();
		return cuenta;
	}
	

	public List<Cuenta> mostar() {
		String jpql = "SELECT c FROM Cuenta c";
		Query query = em.createQuery(jpql, Cuenta.class);
		List<Cuenta> cuentas = query.getResultList();
		for (Cuenta cuenta : cuentas) {
			cuenta.getMovimientos().size();
		}
		return cuentas;
	}
	
	
}
