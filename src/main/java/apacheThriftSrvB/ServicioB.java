package apacheThriftSrvB;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.Servlet;
import javax.ws.rs.POST;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;

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
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@EnableAutoConfiguration
@ComponentScan
public class ServicioB {

	List<PrendaThrift> prendas;
	
	public static ServicioBThrift servicioB;

	public static ThriftService.Processor processor;
	
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
		
		
		try {
			servicioB = new ServicioBThrift();
			processor = new ThriftService.Processor(servicioB);
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
		
//		ApplicationContext ctx = SpringApplication.run(ServicioB.class, args);
//		System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//        String[] beanNames = ctx.getBeanDefinitionNames();
//        Arrays.sort(beanNames);
//        for (String beanName : beanNames) {
//            System.out.println(beanName);
//        }
	}
	
	public static void simple(ThriftService.Processor processor) {
		try {

			/*TServerTransport serverTransport = new TServerSocket(9092);
			//TServer server = new TSimpleServer(new Args(serverTransport).processor(processor));
			
			TThreadPoolServer.Args serverArgs = new TThreadPoolServer.Args(serverTransport);
			serverArgs.processor(processor);
			TServer server =  new TThreadPoolServer(serverArgs);*/
			TServerTransport serverTransport = new TServerSocket(9094);
			TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport)
			            .processor(processor).protocolFactory(new TJSONProtocol.Factory())
			            .inputTransportFactory(new TFramedTransport.Factory())
			            .outputTransportFactory(new TFramedTransport.Factory()));
			System.out.println("Arrancando servidor...");
			server.serve();
			
			
			/**TNonblockingServerTransport serverTransport = new TNonblockingServerSocket(9092);
			TServer server = new TNonblockingServer(new TNonblockingServer.Args(serverTransport)
					.processor(processor).transportFactory(new TFramedTransport.Factory(256 * 1024 * 1024))
                    .protocolFactory(new TBinaryProtocol.Factory()));
			
			server.serve();*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
