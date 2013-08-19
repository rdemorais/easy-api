package vazdor.crud;

import vazdor.form.FormMapping;

public interface CRUDRegister {
	public Class<?> lookupCrud(String id);
	public FormMapping lookupFormMapping(String id) throws InstantiationException, IllegalAccessException;
	
	public void registerCrud(String id, Class<?> crudClass);
	public void registerFormMapping(String id, Class<?> formMapping);
}
