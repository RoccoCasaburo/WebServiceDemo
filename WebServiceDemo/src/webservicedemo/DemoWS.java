/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webservicedemo;

import com.sun.net.httpserver.HttpExchange;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;


/**
 *
 * @author Rocco
 */

@WebService
public class DemoWS {
    private static ExecutorService executor;
 @Resource
  WebServiceContext wsContext;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       
        
            Endpoint endpoint = Endpoint.publish("http://localhost:8080/WS/Demo",
					new DemoWS());
           
            
            //inutile,non si usa così:...	
            endpoint.setExecutor(Executors.newFixedThreadPool(4));
    }
@WebMethod 
public int add(int addendo1, int addendo2) {
    System.out.println(getLog());
		return (addendo1+addendo2);
	}
@WebMethod 
public int sub(int minuendo, int sottraendo) {
		return (minuendo - sottraendo);
	}

public void metodo1(){}
    

String getLog(){

MessageContext mc = wsContext.getMessageContext();
HttpExchange exchange = (HttpExchange)mc.get("com.sun.xml.internal.ws.http.exchange");
InetSocketAddress remoteAddress = exchange.getRemoteAddress();
String IP = remoteAddress.getHostName();
    System.out.println(IP);
     return IP;

}}
