package vazdor.crud;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import vazdor.form.FormGenExcludeField;
import vazdor.form.FormGenHTMLConfig;
import vazdor.form.HTMLType;

@Entity(name="Atributo")
@Table(name="tb_atributo_att")
@VazdorCrud(id="crud1")
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
	@FormGenHTMLConfig(friendlyName="Nome teste", type=HTMLType.INPUT)
	private String nome;
	
	@CrudListColumn
	@FormGenHTMLConfig(friendlyName="Digite o endereco", type=HTMLType.INPUT)
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}