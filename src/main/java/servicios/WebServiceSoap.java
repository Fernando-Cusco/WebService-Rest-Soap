package servicios;


import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import modelo.Cuenta;
import negocio.CuentaON;

@WebService
public class WebServiceSoap {

	
	@Inject
	private CuentaON on;
	
	@WebMethod
	public List<Cuenta> mostar() {
		
		return  on.mostra();
	}
	
}

