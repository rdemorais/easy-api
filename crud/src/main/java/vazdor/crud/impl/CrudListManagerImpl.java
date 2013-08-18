package vazdor.crud.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import vazdor.crud.CrudListColumn;
import vazdor.crud.list.Column;
import vazdor.crud.list.Row;

public class CrudListManagerImpl {
	
	@PersistenceContext
	protected EntityManager em;
	
	public List<Row> loadRows(Class<?> crud, List<Column> cols, int from, int to) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<?> criteria = builder.createQuery(crud);
		TypedQuery<?> q = em.createQuery(criteria);
		System.out.println(q.getResultList());
		return null;
	}
	
	/**
	 * Extrai as colunas marcadas com a anotação {@link CrudListColumn}
	 * 
	 * @param crud
	 * @param mapForm
	 * @return
	 */
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