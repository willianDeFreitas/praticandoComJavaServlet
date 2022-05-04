package br.com.will.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> empresas = new ArrayList<>();
	private static List<Usuario> usuarios = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	static {
		Empresa empresa = new Empresa();
		empresa.setId(chaveSequencial++);
		empresa.setNome("Empresa1");
		Empresa empresa2 = new Empresa();
		empresa2.setNome("Empresa2");
		empresa2.setId(chaveSequencial++);
		
		empresas.add(empresa);
		empresas.add(empresa2);
		
		Usuario u1 = new Usuario();
		u1.setLogin("will");
		u1.setSenha("1234");
		Usuario u2 = new Usuario();
		u2.setLogin("amanda");
		u2.setSenha("12345");
		
		usuarios.add(u1);
		usuarios.add(u2);
	}
	
	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.empresas.add(empresa);
	}

	public List<Empresa> getEmpresas(){
		return Banco.empresas;
	}

	public void removeEmpresa(Integer id) {
		Iterator<Empresa> it = empresas.iterator();

		while(it.hasNext()) {
			Empresa emp = it.next();
			
			if(emp.getId() == id) {
				it.remove();
			}
		}
	}

	public Empresa buscaEmpresaId(Integer id) {
		for (Empresa empresa : empresas) {
			if(empresa.getId() == id) {
				return empresa;
			}
			
		}
		return null;
	}

	public Usuario existeUsuario(String login, String senha) {
		for(Usuario usuario : usuarios) {
			if(usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		return null;
	}
}
