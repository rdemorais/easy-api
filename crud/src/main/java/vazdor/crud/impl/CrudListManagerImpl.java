package vazdor.crud.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import org.apache.log4j.Logger;

import vazdor.crud.CrudListColumn;
import vazdor.crud.CrudListManager;
import vazdor.crud.list.Column;
import vazdor.crud.list.ColumnRow;
import vazdor.crud.list.Row;
import vazdor.form.FormGenExcludeField;
import vazdor.form.FormGenHTMLConfig;

public class CrudListManagerImpl implements CrudListManager {
	
	private static final Logger logger = Logger.getLogger(CrudListManagerImpl.class);
	
	@PersistenceContext
	protected EntityManager em;
	
	public List<Row> loadRows(Class<?> crud, List<Column> cols, int offset, int max) {
		logger.debug("Carregando linhas do banco. Cols: " + cols);
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

		ColumnRow cRow;
		List<Row> rows = new ArrayList<Row>();
		Row row;
		for (Tuple tuple : tupleResult) {
			row = new Row();
			for (int i = 0; i < cols.size(); i++) {
				if(i == 0) {
					//TODO Melhorar esta parte para identificar automaticamente o id
					row.setPk(tuple.get(i));
				}
				cRow = new ColumnRow();
				cRow.setValue(tuple.get(i));
				row.addColumnRow(cols.get(i).getId(), cRow);
			}
			
			rows.add(row);
		}
		return rows;
	}
	
	public List<Column> extractColumnsFromCrud(Class<?> crud) {
		List<Column> cols = new ArrayList<Column>();
		Field fields[] = crud.getDeclaredFields();
		FormGenHTMLConfig htmlConfig = null;
		String friendlyName = "";
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			field.setAccessible(true);
			if(field.isAnnotationPresent(CrudListColumn.class)) {
				if(field.isAnnotationPresent(FormGenHTMLConfig.class)){
					htmlConfig = field.getAnnotation(FormGenHTMLConfig.class);
					friendlyName = htmlConfig.friendlyName();
				}else {
					friendlyName = field.getName();
				}
				if(!field.isAnnotationPresent(FormGenExcludeField.class)) {
					cols.add(new Column(field.getName(), friendlyName, i));
				}				
			}
		}
		return cols;
	}
}