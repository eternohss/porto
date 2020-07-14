package com.porto.financial.portopar.portoinvestments.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown=true)
public class AddressResponse {
	
	@JsonProperty("cep")
	private String zipCode;
	
	@JsonProperty("logradouro")
	private String publicArea;
	
	@JsonProperty("complemento")
	private String addOnAdress;
	
	@JsonProperty("bairro")
	private String neighborhood;
	
	@JsonProperty("localidade")
	private String locality;
	
	@JsonProperty("estado")
	private String state;
	
	@JsonProperty("unidade")
	private String unity;
	
	private String ibge;
	
	private String gia;

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPublicArea() {
		return publicArea;
	}

	public void setPublicArea(String publicArea) {
		this.publicArea = publicArea;
	}

	public String getAddOnAdress() {
		return addOnAdress;
	}

	public void setAddOnAdress(String addOnAdress) {
		this.addOnAdress = addOnAdress;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUnity() {
		return unity;
	}

	public void setUnity(String unity) {
		this.unity = unity;
	}

	public String getIbge() {
		return ibge;
	}

	public void setIbge(String ibge) {
		this.ibge = ibge;
	}

	public String getGia() {
		return gia;
	}

	public void setGia(String gia) {
		this.gia = gia;
	}
}