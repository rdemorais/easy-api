package vazdor.crud.list;

public class ColumnRow {
	private Object value;
	private Column column;

	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public Column getColumn() {
		return column;
	}
	public void setColumn(Column column) {
		this.column = column;
	}
	@Override
	public String toString() {
		return "ColumnRow [value=" + value + ", column=" + column.getId() + "]";
	}
	
}