package vazdor.crud.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import vazdor.crud.CRUDRegister;
import vazdor.form.FormMapping;

@Component
public class CRUDRegisterImpl implements CRUDRegister {
	
	private Map<String, Class<?>> mapCruds = new HashMap<String, Class<?>>();
	private Map<String, Class<?>> mapFormMap = new HashMap<String, Class<?>>();

	public Class<?> lookupCrud(String id) {
		return mapCruds.get(id);
	}
	
	public FormMapping lookupFormMapping(String id) throws InstantiationException, IllegalAccessException{
		return (FormMapping) mapFormMap.get(id).newInstance();
	}

	public void registerCrud(String id, Class<?> crudClass) {
		mapCruds.put(id, crudClass);
	}

	public void registerFormMapping(String id, Class<?> formMapping) {
		mapFormMap.put(id, formMapping);
	}
}