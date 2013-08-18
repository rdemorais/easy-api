package vazdor.crud.impl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import vazdor.crud.CRUDRegister;
import vazdor.crud.CrudListManager;
import vazdor.crud.DFormManager;
import vazdor.form.FormGenerator;

public class DFormManagerImpl implements DFormManager {

	@Autowired
	private CRUDRegister crudRegister;
	
	@Autowired
	private FormGenerator<String> dformGenerator;
	
	@Autowired
	private CrudListManager crudListManager;
	
	@PersistenceContext
	protected EntityManager em;
	
	public String list(String idCrud) {
		try {
			Class<?> clazz = crudRegister.lookupCrud(idCrud);
			
		} catch (ClassNotFoundException e) {
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