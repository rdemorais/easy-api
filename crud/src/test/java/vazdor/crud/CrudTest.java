package vazdor.crud;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import vazdor.form.FormGenExcludeField;

@Entity(name="Atributo")
@Table(name="tb_atributo_att")
public class CrudTest implements Serializable {
	/**
	 * 
	 */
	@FormGenExcludeField
	private static final long serialVersionUID = 1620579860667529599L;
	
	@Id
	@Column(name="cod_crud")
	@GeneratedValue(strategy=GenerationType.TABLE)
	@FormGenExcludeField
	private Long id;
	
	@CrudListColumn
	private String nome;
	
	@CrudListColumn
	private String endereco;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}