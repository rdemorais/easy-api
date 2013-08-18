package vazdor.crud.list;

import java.util.List;

public class CrudList {
	private String id;
	private String crudId;
	private List<Column> columns;
	private List<ColumnRow> rows;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCrudId() {
		return crudId;
	}
	public void setCrudId(String crudId) {
		this.crudId = crudId;
	}
	public List<Column> getColumns() {
		return columns;
	}
	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}
	public List<ColumnRow> getRows() {
		return rows;
	}
	public void setRows(List<ColumnRow> rows) {
		this.rows = rows;
	}
}