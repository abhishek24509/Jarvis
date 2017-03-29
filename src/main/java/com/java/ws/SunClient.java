package com.java.ws;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.Certificate;

import javax.net.ssl.HttpsURLConnection;

public class SunClient {
	//private static final String url_s ="https://www.google.com";
	private static final String url_s ="https://service-2.ariba.com/Supplier.aw";
	public static void main(String[] args){
		new SunClient().do_It();
	}
	private void do_It(){
		try {
			URL url = new URL(url_s);
			HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
			conn.setDoInput(true);
			conn.setRequestMethod("GET");
			conn.connect();
			dump_features(conn);
			
		}catch(MalformedURLException e){System.err.println(e);
		}
		catch(IOException e){System.out.println(e);}
	}
	
	private void dump_features(HttpsURLConnection conn){
		try{
			print("status code  "+ conn.getResponseCode());
			print("cipher suite  "+conn.getCipherSuite());
			Certificate[] certs = conn.getServerCertificates();
			for(Certificate c : certs){
				print("\t Cert. type   "+c.getType());
				print("\t Hash code    "+c.hashCode());
				print("\tAlgorithm     "+c.getPublicKey().getAlgorithm());
				print("\tFormat     "+c.getPublicKey().getFormat());
				print("");
			}
			
		}catch(Exception e){System.err.print(e);}
	}
	private void print(String s){System.out.println(s);}
}
