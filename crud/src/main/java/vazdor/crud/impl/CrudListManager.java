package vazdor.crud.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import vazdor.crud.CrudListColumn;
import vazdor.crud.list.Column;

public class CrudListManager {
	
	public List<Column> extractColumnsFromCrud(Class<?> crud, Map<String, String> mapForm) {
		List<Column> cols = new ArrayList<Column>();
		Field fields[] = crud.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			field.setAccessible(true);
			if(field.isAnnotationPresent(CrudListColumn.class)) {
				cols.add(new Column(field.getName(), mapForm.get(field.getName()), i));
			}
		}
		return cols;
	}
}