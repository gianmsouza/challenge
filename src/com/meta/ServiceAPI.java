package com.meta;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ServiceAPI {

	static String webService = "http://api.worldbank.org/v2/country/";
	static int codigoSucesso = 200;

	public void buscarDados(String codPais) throws Exception {
		
		String urlChamada = webService + codPais + "/indicator/SI.POV.DDAY?format=json";

		try {
			URL url = new URL(urlChamada);
			HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

			if (conexao.getResponseCode() != codigoSucesso)
				throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());

			BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
			
			String jsonEmString = Util.converteJsonEmString(resposta);
			
	        System.out.println(jsonEmString);
	        
		} catch (Exception e) {
			throw new Exception("ERRO: " + e);
		}
	}
}
