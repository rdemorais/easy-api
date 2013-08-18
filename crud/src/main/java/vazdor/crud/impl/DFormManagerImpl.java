package vazdor.crud.impl;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import vazdor.crud.CRUDRegister;
import vazdor.crud.CrudListManager;
import vazdor.crud.DFormManager;
import vazdor.crud.list.Column;
import vazdor.crud.list.ColumnRow;
import vazdor.crud.list.CrudList;
import vazdor.form.FormGenerator;
import vazdor.form.FormMapping;

public class DFormManagerImpl implements DFormManager {

	@Autowired
	private CRUDRegister crudRegister;
	
	@Autowired
	private FormGenerator<String> dformGenerator;
	
	@Autowired
	private CrudListManager crudListManager;
	
	@PersistenceContext
	protected EntityManager em;

	private ObjectMapper mapper;
	
	public DFormManagerImpl() {
		mapper = new ObjectMapper();
	}
	
	@Transactional
	public void create(String idCrud, String jsonForm) {
		try {
			Class<?> clazz = crudRegister.lookupCrud(idCrud);
			Serializable crud = (Serializable) mapper.readValue(jsonForm, clazz);
			em.persist(crud);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public CrudList list(String idCrud, int offset, int max) {
		try {
			Class<?> clazz = crudRegister.lookupCrud(idCrud);
			FormMapping formMap = crudRegister.lookupFormMapping(idCrud);
			List<Column> cols = crudListManager.extractColumnsFromCrud(clazz, formMap.mapForm());
			List<ColumnRow> rows = crudListManager.loadRows(clazz, cols, offset, max);
			
			CrudList crudList = new CrudList();
			crudList.setCrudId(idCrud);
			crudList.setColumns(cols);
			crudList.setRows(rows);
			
			return crudList;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String load(String idCrud, Serializable pk, String action, String method) {
		Class<?> clazz;
		try {
			clazz = crudRegister.lookupCrud(idCrud);
			Serializable obj = (Serializable) em.find(clazz, pk);
			return dformGenerator.gen(obj, crudRegister.lookupFormMapping(idCrud),action, method);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}		
		return null;
	}

	public String blankForm(String idCrud, String action, String method) {
		Class<?> clazz;
		try {
			clazz = crudRegister.lookupCrud(idCrud);
			return dformGenerator.gen((Serializable)clazz.newInstance(), crudRegister.lookupFormMapping(idCrud),action, method);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}