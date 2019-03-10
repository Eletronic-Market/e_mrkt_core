package br.com.mrkt.model;

/***
 * Classe responsavel por conter os atributos e metodos de acesso do PreferenciasConsumidor.
 * @author Lenno Sousa
 * @date Mar 9, 2019
 *
 */
public class PreferenciasConsumidor {

	private int idPreferencia;
	private int bebidasAlcoolicas;
	private int tabaco;
	private int carnes;
	private int vegano;
	private int naturais;
	private int automotivo;
	private int camping;
	private int jardinagem;
	private int petshop;
	
	public PreferenciasConsumidor() { }
	
	

	public PreferenciasConsumidor(int idPreferencia, int bebidasAlcoolicas, int tabaco, int carnes, int vegano, int naturais, int automotivo, int camping, int jardinagem, int petshop) {
		this.idPreferencia = idPreferencia;
		this.bebidasAlcoolicas = bebidasAlcoolicas;
		this.tabaco = tabaco;
		this.carnes = carnes;
		this.vegano = vegano;
		this.naturais = naturais;
		this.automotivo = automotivo;
		this.camping = camping;
		this.jardinagem = jardinagem;
		this.petshop = petshop;
	}

	public int getIdPreferencia() {
		return idPreferencia;
	}

	public void setIdPreferencia(int idPreferencia) {
		this.idPreferencia = idPreferencia;
	}

	public int getBebidasAlcoolicas() {
		return bebidasAlcoolicas;
	}

	public void setBebidasAlcoolicas(int bebidasAlcoolicas) {
		this.bebidasAlcoolicas = bebidasAlcoolicas;
	}

	public int getTabaco() {
		return tabaco;
	}

	public void setTabaco(int tabaco) {
		this.tabaco = tabaco;
	}

	public int getCarnes() {
		return carnes;
	}

	public void setCarnes(int carnes) {
		this.carnes = carnes;
	}

	public int getVegano() {
		return vegano;
	}

	public void setVegano(int vegano) {
		this.vegano = vegano;
	}

	public int getNaturais() {
		return naturais;
	}

	public void setNaturais(int naturais) {
		this.naturais = naturais;
	}

	public int getAutomotivo() {
		return automotivo;
	}

	public void setAutomotivo(int automotivo) {
		this.automotivo = automotivo;
	}

	public int getCamping() {
		return camping;
	}

	public void setCamping(int camping) {
		this.camping = camping;
	}

	public int getJardinagem() {
		return jardinagem;
	}

	public void setJardinagem(int jardinagem) {
		this.jardinagem = jardinagem;
	}

	public int getPetshop() {
		return petshop;
	}

	public void setPetshop(int petshop) {
		this.petshop = petshop;
	}
	
	
}
