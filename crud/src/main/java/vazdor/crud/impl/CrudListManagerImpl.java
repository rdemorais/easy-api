package vazdor.crud.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import vazdor.crud.CrudListColumn;
import vazdor.crud.CrudListManager;
import vazdor.crud.list.Column;
import vazdor.crud.list.ColumnRow;

public class CrudListManagerImpl implements CrudListManager {
	
	@PersistenceContext
	protected EntityManager em;
	
	public List<ColumnRow> loadRows(Class<?> crud, List<Column> cols, int offset, int max) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Tuple> criteria = builder.createTupleQuery();
		Root<?> crudRoot = criteria.from(crud);
		List<Selection<?>> selectCols = new ArrayList<Selection<?>>();
		for (Column column : cols) {
			selectCols.add(crudRoot.get(column.getId()));
		}
		criteria.multiselect(selectCols);
		List<Tuple> tupleResult;
		
		TypedQuery<Tuple> tq = em.createQuery(criteria);
		
		if(offset > 0) {
			tq.setFirstResult(offset);
		}
		if(max > 0) {
			tq.setMaxResults(max);
		}
		
		tupleResult = tq.getResultList();

		ColumnRow row;
		List<ColumnRow> rows = new ArrayList<ColumnRow>();
		for (Tuple tuple : tupleResult) {
			for (int i = 0; i < cols.size(); i++) {
				row = new ColumnRow();
				row.setValue((String)tuple.get(i));
				row.setColumn(cols.get(i));
				rows.add(row);	
			}
		}
		return rows;
	}
	
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