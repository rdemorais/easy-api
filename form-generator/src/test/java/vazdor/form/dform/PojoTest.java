package vazdor.form.dform;

import java.io.Serializable;

import vazdor.form.FormGenExcludeField;

public class PojoTest implements Serializable {
	
	/**
	 * 
	 */
	@FormGenExcludeField
	private static final long serialVersionUID = 2049656661538158577L;
	
	private String nome;
	private String telefone;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}