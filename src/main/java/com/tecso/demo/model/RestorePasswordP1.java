package com.tecso.demo.model;

public class RestorePasswordP1 {
	
	private String documento;
	private String tipoDocumento;	
	private String usuario;
	
	public RestorePasswordP1() {
		
	}

	public RestorePasswordP1(String documento, String tipoDocumento, String usuario) {
		super();
		this.documento = documento;
		this.tipoDocumento = tipoDocumento;
		this.usuario = usuario;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}	

}
