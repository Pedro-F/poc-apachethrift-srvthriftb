package apacheThriftSrvB;

import java.util.List;

import javax.servlet.Servlet;

import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServlet;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
public class ServicioB {

	List<PrendaThrift> prendas;
	
	public static ServicioBThrift servicioB;

	public static ThriftService.Processor<ServicioBThrift> processor;
	
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
	 * MAIN                                    *
	 *                                         *
	 * @param args                             *
	 *                                         *
	 * @throws Exception                       *
	 *                                         *
	 ******************************************/
	public static void main(String[] args) throws Exception {
		
		
		try {
			servicioB = new ServicioBThrift();
			processor = new ThriftService.Processor<ServicioBThrift>(servicioB);
			Runnable simple = new Runnable() {
				public void run() {
					simple(processor);
				}
			};
			new Thread(simple).start();
		} catch (Exception x) {
			x.printStackTrace();
		}
		
		SpringApplication.run(ServicioB.class, args);
		
	}
	
	public static void simple(ThriftService.Processor<ServicioBThrift> processor) {
		try {

			TServerTransport serverTransport = new TServerSocket(9094);
			TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport)
			            .processor(processor).protocolFactory(new TJSONProtocol.Factory())
			            .inputTransportFactory(new TFramedTransport.Factory())
			            .outputTransportFactory(new TFramedTransport.Factory()));
			System.out.println("Arrancando servidor...");
			server.serve();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
