package apacheThriftSrvB;

import java.util.List;

import javax.servlet.Servlet;

import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@EnableAutoConfiguration
@ComponentScan
@RequestMapping(method=RequestMethod.POST)
public class ServicioB {

	List<PrendaThrift> prendas;
	
	public ServicioB() {
		prendas = PrendaDao.instance.getPrendas();
	}

	
    @Bean
    public TProtocolFactory tProtocolFactory() {
        //We will use binary protocol, but it's possible to use JSON and few others as well
        return new TCompactProtocol.Factory();
//        return new TJSONProtocol.Factory();
    }
    
    @Bean
    public Servlet servicioB(TProtocolFactory protocolFactory, ServicioBThrift handler) {
        return new TServlet(new ThriftService.Processor<ServicioBThrift>(handler), protocolFactory);
    }

 
	/*******************************************
	 * MAIN *
	 * 
	 * @param args
	 *            *
	 * @throws Exception
	 *             *
	 ******************************************/
	public static void main(String[] args) throws Exception {
		SpringApplication.run(ServicioB.class, args);
	}
}
