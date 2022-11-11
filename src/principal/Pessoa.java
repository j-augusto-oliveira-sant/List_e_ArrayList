package principal;

import java.time.LocalDateTime;

public class Pessoa {
	private String nome;
	private String email;
	private String data_nasc;
	

	public Pessoa(String nome, String email, String data_nasc){
		this.nome = nome;
		this.email = email;
		this.setData_nasc(data_nasc);
	}
	
	public int getIdade() {
		String[] data = this.data_nasc.split("-");
		String[] data_now = String.valueOf(LocalDateTime.now()).split("T")[0].split("-");
		int idade = Integer.parseInt(data_now[0])-Integer.parseInt(data[2]);
		return idade-1;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(String data_nasc) {
		this.data_nasc = data_nasc;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pessoa [nome=");
		builder.append(nome);
		builder.append(", email=");
		builder.append(email);
		builder.append(", data_nasc=");
		builder.append(data_nasc);
		builder.append(", getIdade()=");
		builder.append(getIdade());
		builder.append("]");
		return builder.toString();
	}

	
}
