package vazdor.crud;

import vazdor.form.FormMapping;

public interface CRUDRegister {
	public Class<?> lookupCrud(String id) throws ClassNotFoundException;
	public FormMapping lookupFormMapping(String id) throws ClassNotFoundException, InstantiationException, IllegalAccessException;
}
