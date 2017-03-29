package com.java.ws;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManagerFactory;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpsConfigurator;
import com.sun.net.httpserver.HttpsParameters;
import com.sun.net.httpserver.HttpsServer;

public class RabbitCounterPublisher {
	
	private Map<Integer,Integer> fibs;
	
	public RabbitCounterPublisher(){
		fibs = Collections.synchronizedMap(new HashMap<Integer,Integer>());
	}
	public static void main(String[] args){
		new RabbitCounterPublisher().publish();
	}
	public Map<Integer,Integer> getMap(){
		return fibs;
	}
	@SuppressWarnings("unused")
	private void publish(){
		int port = 9876;
		String ip = "https://localhost:";
		String path = "/fibs";
		String url = ip+port+path;
		
		HttpsServer server = get_https_server(ip,port,path);
		HttpContext http_ctx = server.createContext(path);
		System.out.println("publising rabbit counter @@  "+url);
		if(server != null){
			server.start();
		}else System.err.println("Failed to start server. Exiting");
	}
	
	private HttpsServer get_https_server(String ip,int port,String path){
		HttpsServer server = null;
		try{
			InetSocketAddress inet = new InetSocketAddress(port);
			server = HttpsServer.create(inet,5);
			javax.net.ssl.SSLContext ssl_ctx = SSLContext.getInstance("TLS");
			char[] password = "qubits".toCharArray();
			KeyStore ks = KeyStore.getInstance("JKS");
			System.setProperty("javax.net.ssl.keyStore","\\Users\\i324759\\Jarvis\\eclipse\\Jarvis\\src\\main\\resources\\");
			FileInputStream fis = new FileInputStream("/Users/i324759/Jarvis/eclipse/Jarvis/src/main/resources/rc.keystore");
			ks.load(fis,password);
			
			KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
			kmf.init(ks, password);
			TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
			tmf.init(ks);
			ssl_ctx.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
			final SSLEngine eng = ssl_ctx.createSSLEngine();
			server.setHttpsConfigurator(new HttpsConfigurator(ssl_ctx){
				public void configure(HttpsParameters parms){
					parms.setCipherSuites(eng.getEnabledCipherSuites());
					parms.setProtocols(eng.getEnabledProtocols());
				}
			});
			server.setExecutor(null);
			HttpContext tContext = server.createContext(path, new MyHttpHandler(this));
		}catch(Exception e){ System.err.println(e);}
		return server;
	}
}




class MyHttpHandler implements HttpHandler {
	private RabbitCounterPublisher pub;
	public MyHttpHandler(RabbitCounterPublisher pub){
		this.pub = pub;
	}

	public void handle(HttpExchange ex) throws IOException {
		String verb = ex.getRequestMethod().toUpperCase();
		if(verb.equals("GET")) doGet(ex);
		else if(verb.equals("POST")) doPost(ex);
		else if(verb.equals("DELETE")) doDelete(ex);
		System.out.println("Wrong Request");
		
	}
	
	private void respond_to_client(HttpExchange ex,String res){
		try{
			ex.sendResponseHeaders(100, 0);
			OutputStream out = ex.getResponseBody();
			out.write(res.getBytes());
			out.flush();
			ex.close();
		}catch(IOException e){
			System.err.println(e);
		}
	}
	private void doGet(HttpExchange ex){
		Map<Integer,Integer> fibs = pub.getMap();
		Collection<Integer> list = fibs.values();
		respond_to_client(ex, list.toString());
	}
	
	private void doPost(HttpExchange ex){
		Map<Integer,Integer> fibs = pub.getMap();
		fibs.clear();
		try{
			InputStream is = ex.getRequestBody();
			byte[] raw_bytes = new byte[4096];
			is.read(raw_bytes);
			String nums = new String(raw_bytes);
			nums = nums.replace('[', '\0');
			nums = nums.replace(']', '\0');
			String[] parts = nums.split(",");
			List<Integer> list = new ArrayList<Integer>();
			for(String next:parts){
				int n = Integer.parseInt(next);
				fibs.put(n,countRabbits(n));
				list.add(fibs.get(n));
			}
			Collection<Integer> coll = fibs.values();
			String res = "Posted:" + coll.toString();
			respond_to_client(ex, res);
			
		}catch(IOException e){System.err.println(e);}
	}
	private void doDelete(HttpExchange ex){
		Map<Integer,Integer> fibs = pub.getMap();
		fibs.clear();
		respond_to_client(ex, "All Entries deleted");
	}
	
	private int countRabbits(int n){
		n = Math.abs(n);
		if(n<2) return n;
		Map<Integer,Integer> fibs = pub.getMap();
		if(fibs.containsKey(n)) return fibs.get(n);
		if(fibs.containsKey(n-1)&& fibs.containsKey(n-2)){
			fibs.put(n,fibs.get(n-1)+fibs.get(n-2));
			return fibs.get(n);
		}
		int fib = 1,prev =0;
		for(int i =2;i<=n;i++){
			int temp = fib;
			fib += prev;
			prev = temp;
		}
		fibs.put(n, fib);
		return fib;
	}
	
}