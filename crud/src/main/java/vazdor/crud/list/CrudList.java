package vazdor.crud.list;

import java.util.List;

public class CrudList {
	private String id;
	private List<Column> columns;
	private List<Row> rows;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Column> getColumns() {
		return columns;
	}
	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}
	public List<Row> getRows() {
		return rows;
	}
	public void setRows(List<Row> rows) {
		this.rows = rows;
	}
}