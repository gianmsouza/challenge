package com.meta;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) throws Exception {
		
		System.out.println("Informe o código do país: ");
		
		Scanner sc = new Scanner(System.in);
		
		String codPais = sc.nextLine();
		
		ServiceAPI service = new ServiceAPI();
		
		try {
			service.buscarDados(codPais);
		} catch (Exception e) {
			System.out.println("Erro ao pesquisar o país");
		}
		
		sc.close();
	}
}
