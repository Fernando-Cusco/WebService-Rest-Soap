package servicios;


import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import modelo.Cuenta;

import negocio.CuentaON;
import negocio.MovimientoON;

@Path("/movimiento")
public class WebServiceRest {

	
	@Inject
	private MovimientoON on;
	
	@Inject
	private CuentaON onc;
	
	
	
	@POST
	@Path("/nuevo")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Respuesta movimiento(Transaccion transaccion) {
		return on.nuevaTransferencia(transaccion);
		
	}
	
	@POST
	@Path("/cuenta")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Respuesta crear(List<Cuenta> c) {
		Respuesta r = new Respuesta();
		try {
			onc.crear(c);
			r.setMensaje("cuentas creadas");
		} catch (Exception e) {
			r.setMensaje("error");
			e.printStackTrace();
		}
		return r;
	}
	
	
	@POST
	@Path("/listar")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Cuenta> mostar() {
		
		return  onc.mostra();
	}
	
	
}
