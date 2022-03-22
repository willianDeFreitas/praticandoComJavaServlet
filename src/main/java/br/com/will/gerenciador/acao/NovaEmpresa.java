package br.com.will.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.will.gerenciador.modelo.Banco;
import br.com.will.gerenciador.modelo.Empresa;

public class NovaEmpresa {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String nomeEmpresa = request.getParameter("nomeEmpresa");
		String dataAbertura = request.getParameter("dataAbertura");
		
		Date dataAberturaFmt = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAberturaFmt = sdf.parse(dataAbertura);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAberturaFmt);
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		request.setAttribute("nomeEmpresa", empresa.getNome());
		
		return "redirect:entrada?acao=ListaEmpresas";		
	}

}
