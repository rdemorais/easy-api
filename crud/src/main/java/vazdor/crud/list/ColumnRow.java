package vazdor.crud.list;

public class ColumnRow {
	private String value;
	private Column column;

	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Column getColumn() {
		return column;
	}
	public void setColumn(Column column) {
		this.column = column;
	}
}