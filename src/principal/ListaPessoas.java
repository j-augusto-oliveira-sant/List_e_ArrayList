package principal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class ListaPessoas {
	List<Pessoa> lista = new ArrayList<Pessoa>();
	
	public List<Pessoa> getLista() {
		return lista;
	}
	
	public void setLista(List<Pessoa> lista) {
		this.lista = lista;
	}
	
	//validacoes
	private boolean is_name_already_in(Pessoa pessoa) {
		int res = buscar_pelo_nome(pessoa.getNome());
		if (res==-1) {
			return false;
		}
		else {
			return true;
		}
	}
	private boolean is_bigger3(Pessoa pessoa) {
		String nome = pessoa.getNome();
		if (nome.length()>3) 
			return true;
		else
			return false;
	}
	//

	public boolean add(Pessoa pessoa) {
		if (is_name_already_in(pessoa) || !(is_bigger3(pessoa))) {
			return false;
		} else {
			lista.add(pessoa);
			return true;
		}
	}
	
	public int buscar_pelo_nome(String nome) {
		for (int i=0;i<lista.size();i++) {
			if (lista.get(i).getNome().equals(nome)) {
				return i;
			}
		}
		return -1;
	}
	
	public Pessoa buscar_nome_aprox(String nome) {
		for (Pessoa pessoa: lista) {
			if (pessoa.getNome().contains(nome)) {
				return pessoa;
			}
		}
		return lista.get(0);
	}
	
	public boolean remover_pelo_nome(String nome) {
		int res = buscar_pelo_nome(nome);
		if (res!=-1) {
			lista.remove(res);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean alterar_pelo_nome(String nome, Pessoa pessoa) {
		int res = buscar_pelo_nome(nome);
		if (res!=-1) {
			lista.set(res, pessoa);
			return true;
		} else {
			return false;
		}
	}
	
	public String aniversariantes_do_mes() {
		StringBuilder res = new StringBuilder();
		res.append("Aniversariantes: \n");
		for (Pessoa pessoa: lista) {
			String mes_now = String.valueOf(LocalDateTime.now()).split("T")[0].split("-")[1];
			String mes = pessoa.getData_nasc().split("-")[1];
			if (mes.equals(mes_now)) {
				res.append(pessoa.getNome()+"\n");
			}
		}
		return res.toString();
	}
	
	public String show_dominios() {
		//mostrar dominios dos emails registrados
		StringBuilder res = new StringBuilder();
		Set<String> dominios = new HashSet<String>();
		for (Pessoa pessoa: lista) {
			String email = pessoa.getEmail();
			String dominio = email.split("@")[1];
			String[] dominio_letters = dominio.split("");
			dominio = "";
			for (String letter: dominio_letters) {
				if (letter.equals("."))
					break;
				else
					dominio = dominio+letter;
			}
			if (!dominios.contains(dominio))
				dominios.add(dominio);
				res.append(dominio.toUpperCase()+"\n");
		}
		return res.toString();
	}
	
	public String show_list() {
		StringBuilder res = new StringBuilder();
		for (Pessoa pessoa: lista) {
			res.append(pessoa.toString()+"\n");
		}
		return res.toString();
	}
	
}
