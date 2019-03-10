package br.com.mrkt.model;

/***
 * Classe responsavel por conter os atributos e metodos de acesso do Usuario.
 * @author Lenno Sousa
 * @date Mar 9, 2019
 *
 */
public class Usuario {
		
	private int idUsuario;
	private int tipoUsuario;
	private String email;
	private String senha;
	private int status;
	
	public Usuario() {}

	public Usuario(int idUsuario, int tipoUsuario, String email, String senha, int status) {
		this.idUsuario = idUsuario;
		this.tipoUsuario = tipoUsuario;
		this.email = email;
		this.senha = senha;
		this.status = status;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
