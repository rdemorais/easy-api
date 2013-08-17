package vazdor.crud.impl;

import java.util.Map;

import org.springframework.stereotype.Component;

import vazdor.crud.CRUDRegister;
import vazdor.form.FormMapping;

@Component
public class CRUDRegisterImpl implements CRUDRegister {
	
	private Map<String, String> mapCruds;
	private Map<String, String> mapFormMap;

	public Class<?> lookupCrud(String id) throws ClassNotFoundException {
		return Class.forName(mapCruds.get(id));
	}
	
	public FormMapping lookupFormMapping(String id) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		return (FormMapping) Class.forName(mapFormMap.get(id)).newInstance();
	}

	public Map<String, String> getMapCruds() {
		return mapCruds;
	}

	public void setMapCruds(Map<String, String> mapCruds) {
		this.mapCruds = mapCruds;
	}

	public Map<String, String> getMapFormMap() {
		return mapFormMap;
	}

	public void setMapFormMap(Map<String, String> mapFormMap) {
		this.mapFormMap = mapFormMap;
	}
}