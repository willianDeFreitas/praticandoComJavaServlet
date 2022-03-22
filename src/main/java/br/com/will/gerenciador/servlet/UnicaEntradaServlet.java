package br.com.will.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.will.gerenciador.acao.AlteraEmpresa;
import br.com.will.gerenciador.acao.ListaEmpresas;
import br.com.will.gerenciador.acao.MostraEmpresa;
import br.com.will.gerenciador.acao.NovaEmpresa;
import br.com.will.gerenciador.acao.RemoveEmpresa;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");
		String nome = "";
		
		if (paramAcao.equals("ListaEmpresas")) {
			ListaEmpresas listaEmpresas = new ListaEmpresas();
			nome = listaEmpresas.executa(request, response);
		} else if (paramAcao.equals("RemoveEmpresa")) {
			RemoveEmpresa removeEmpresa = new RemoveEmpresa();
			nome = removeEmpresa.executa(request, response);
		} else if (paramAcao.equals("MostraEmpresa")) {
			MostraEmpresa mostraEmpresa = new MostraEmpresa();
			nome = mostraEmpresa.executa(request, response);
		} else if (paramAcao.equals("AlteraEmpresa")) {
			AlteraEmpresa alteraEmpresa = new AlteraEmpresa();
			nome = alteraEmpresa.executa(request, response);
		} else if (paramAcao.equals("NovaEmpresa")) {
			NovaEmpresa novaEmpresa = new NovaEmpresa();
			nome = novaEmpresa.executa(request, response);
		}
		
		String[] tipoEEndereco = nome.split(":");
		if (tipoEEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher(tipoEEndereco[1]);
			rd.forward(request, response);			
		} else {
			response.sendRedirect(tipoEEndereco[1]);
		}
		
	}

}
