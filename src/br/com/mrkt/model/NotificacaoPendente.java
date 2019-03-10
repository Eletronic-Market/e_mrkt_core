package br.com.mrkt.model;

/***
 * Classe responsavel por conter os atributos e metodos de acesso do NotificacaoPendente.
 * @author Lenno Sousa
 * @date Mar 9, 2019
 *
 */
public class NotificacaoPendente {

	private int idNotificacaoPendente;
	private String tipoNotificacao;
	
	public NotificacaoPendente() { }

	public NotificacaoPendente(int idNotificacaoPendente, String tipoNotificacao) {
		this.idNotificacaoPendente = idNotificacaoPendente;
		this.tipoNotificacao = tipoNotificacao;
	}

	public int getIdNotificacaoPendente() {
		return idNotificacaoPendente;
	}

	public void setIdNotificacaoPendente(int idNotificacaoPendente) {
		this.idNotificacaoPendente = idNotificacaoPendente;
	}

	public String getTipoNotificacao() {
		return tipoNotificacao;
	}

	public void setTipoNotificacao(String tipoNotificacao) {
		this.tipoNotificacao = tipoNotificacao;
	}
	
}
