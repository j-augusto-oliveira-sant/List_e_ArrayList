package principal;

public class Main {
	public static void main(String[] args) {
		Pessoa pessoa1 = new Pessoa("Novo","dadad@gmail.com","10-12-2000");
		Pessoa pessoa2 = new Pessoa("Novo2","gggdad@gmail.com","23-11-1963");
		Pessoa pessoa3 = new Pessoa("3ovo3","gggdad@yahoo.com","12-11-1935");
		Pessoa pessoa4 = new Pessoa("3vo3","gggdad@usp.com.br","01-05-1444");
		ListaPessoas pessoas = new ListaPessoas();
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		pessoas.add(pessoa4);
		System.out.println(pessoas.show_list());
		System.out.println(pessoas.show_dominios());
		System.out.println(pessoas.aniversariantes_do_mes());
	} 
}
