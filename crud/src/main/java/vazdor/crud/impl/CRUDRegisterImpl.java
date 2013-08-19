package vazdor.crud.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import vazdor.crud.CRUDRegister;

@Component
public class CRUDRegisterImpl implements CRUDRegister {
	
	private Map<String, Class<?>> mapCruds = new HashMap<String, Class<?>>();

	public Class<?> lookupCrud(String id) {
		return mapCruds.get(id);
	}
	
	public void registerCrud(String id, Class<?> crudClass) {
		mapCruds.put(id, crudClass);
	}
}