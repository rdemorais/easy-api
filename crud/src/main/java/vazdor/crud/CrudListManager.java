package vazdor.crud;

import java.util.List;
import java.util.Map;

import vazdor.crud.list.Column;
import vazdor.crud.list.ColumnRow;

public interface CrudListManager {
	public List<ColumnRow> loadRows(Class<?> crud, List<Column> cols, int from, int to);
	public List<Column> extractColumnsFromCrud(Class<?> crud, Map<String, String> mapForm);
}