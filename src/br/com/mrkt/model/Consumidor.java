package br.com.mrkt.model;

import java.util.ArrayList;

/***
 * Classe responsavel por conter atributos e metodos de acesso do Consumidor.
 * @author Lenno Sousa
 * @date Mar 9, 2019
 *
 */
public class Consumidor {

	private int idConsumidor;
	private String nome;
	private String sobrenome;
	private Usuario usuario;
	private Endereco endereco;
	private ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
	private DocumentoPF documentoPF;
	private NotificacaoPendente notificacaoPendente;
	private PreferenciasConsumidor preferenciasConsumidor;
	
	public Consumidor() { }

	public Consumidor(int idConsumidor, String nome, String sobrenome, Usuario usuario, Endereco endereco, ArrayList<Endereco> enderecos, DocumentoPF documentoPF, NotificacaoPendente notificacaoPendente, PreferenciasConsumidor preferenciasConsumidor) {
		this.idConsumidor = idConsumidor;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.usuario = usuario;
		this.endereco = endereco;
		this.enderecos = enderecos;
		this.documentoPF = documentoPF;
		this.notificacaoPendente = notificacaoPendente;
		this.preferenciasConsumidor = preferenciasConsumidor;
	}

	public int getIdConsumidor() {
		return idConsumidor;
	}

	public void setIdConsumidor(int idConsumidor) {
		this.idConsumidor = idConsumidor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public ArrayList<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(ArrayList<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public DocumentoPF getDocumentoPF() {
		return documentoPF;
	}

	public void setDocumentoPF(DocumentoPF documentoPF) {
		this.documentoPF = documentoPF;
	}

	public NotificacaoPendente getNotificacaoPendente() {
		return notificacaoPendente;
	}

	public void setNotificacaoPendente(NotificacaoPendente notificacaoPendente) {
		this.notificacaoPendente = notificacaoPendente;
	}

	public PreferenciasConsumidor getPreferenciasConsumidor() {
		return preferenciasConsumidor;
	}

	public void setPreferenciasConsumidor(PreferenciasConsumidor preferenciasConsumidor) {
		this.preferenciasConsumidor = preferenciasConsumidor;
	}

}
