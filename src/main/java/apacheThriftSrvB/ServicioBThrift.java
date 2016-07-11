package apacheThriftSrvB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.POST;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;


public class ServicioBThrift implements ThriftService.Iface {

	List<PrendaThrift> prendas;
	
	public ServicioBThrift() {
		prendas = PrendaDao.instance.getPrendas();
	}
	
	public MensajeOutServicio recuperaPrendas(MensajeInServicio mensajeIn) throws TException {
		MensajeOutServicio respuesta = new MensajeOutServicio();
		List<PrendaThrift> listadoPrendas = new ArrayList<PrendaThrift>();

		long iniTime = System.currentTimeMillis();
		
		for (PrendaThrift prenda : prendas) {
			if (prenda.getTipo().equals(TipoThrift.findByValue(Integer.parseInt(mensajeIn.getCuerpo().get("TipoPrenda"))))
					&& prenda.getColor().toUpperCase().equals(mensajeIn.getCuerpo().get("Color").toUpperCase())) {
				try {
					TTransport transport = new TFramedTransport(new TSocket("thrift-srvc", 8080)); 
			        TProtocol protocol = new TJSONProtocol(transport); 
			        ThriftServiceStock.Client clientC = new ThriftServiceStock.Client(protocol); 
			        transport.open();
					String stock = clientC.recuperaStock(prenda.getNombre(), prenda.getColor(), prenda.getTalla());
					prenda.setStock(stock);
					
				} catch (TException e) {
					e.printStackTrace();
				}
				listadoPrendas.add(prenda);
			}
		}
		Map<String,String> cabeceraSalida = mensajeIn.getCabecera();
        cabeceraSalida.put("UID", "Respuesta_" + cabeceraSalida.get("UID"));
        Map<String,List<PrendaThrift>> cuerpoSalida = new HashMap<String,List<PrendaThrift>>();
        cuerpoSalida.put("Prendas", listadoPrendas);
        respuesta.setCabecera(cabeceraSalida);
        respuesta.setCuerpo(cuerpoSalida);
		if(listadoPrendas.size()==0) respuesta.setAviso("No se han encontrado prendas con las especificaciones");
		System.out.println("FIN ServicioBThrift.  ts = {" + (System.currentTimeMillis() - iniTime) + "}");
		return respuesta;
	}
}
