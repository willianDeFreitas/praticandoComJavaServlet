package br.com.will.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.will.gerenciador.modelo.Banco;
import br.com.will.gerenciador.modelo.Empresa;

public class ListaEmpresas {
	
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("listando empresas");
		Banco banco = new Banco();
		List<Empresa> empresas = banco.getEmpresas();
		
		request.setAttribute("empresas", empresas);
		
		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");
		rd.forward(request, response);
	}

}
