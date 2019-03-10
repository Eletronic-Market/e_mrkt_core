package br.com.mrkt.model;

/***
 * Classe responsavel por conter os atributos e metodos de acesso do DocumentoPF.
 * @author Lenno Sousa
 * @date Mar 9, 2019
 *
 */
public class DocumentoPF {

	private int idDocumentoPF;
	private String cpf;
	
	public DocumentoPF() { }

	public DocumentoPF(int idDocumentoPF, String cpf) {
		this.idDocumentoPF = idDocumentoPF;
		this.cpf = cpf;
	}

	public int getIdDocumentoPF() {
		return idDocumentoPF;
	}

	public void setIdDocumentoPF(int idDocumentoPF) {
		this.idDocumentoPF = idDocumentoPF;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
