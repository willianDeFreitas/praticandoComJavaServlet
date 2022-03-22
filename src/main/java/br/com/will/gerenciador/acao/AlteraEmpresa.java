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

public class AlteraEmpresa {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("altera empresa");
		String nomeEmpresa = request.getParameter("nomeEmpresa");
		String dataAbertura = request.getParameter("dataAbertura");
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Date dataAberturaFmt = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAberturaFmt = sdf.parse(dataAbertura);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaId(id);
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAberturaFmt);
		
		return "redirect:entrada?acao=ListaEmpresas";
	}

}
