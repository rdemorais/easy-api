package vazdor.crud.list;

/**
 * Representa as colunas da lista
 * 
 * @author Rafael de Morais
 *
 */
public class Column {
	private String nameColumn;
	private int ord;
	public String getNameColumn() {
		return nameColumn;
	}
	public void setNameColumn(String nameColumn) {
		this.nameColumn = nameColumn;
	}
	public int getOrd() {
		return ord;
	}
	public void setOrd(int ord) {
		this.ord = ord;
	}
}