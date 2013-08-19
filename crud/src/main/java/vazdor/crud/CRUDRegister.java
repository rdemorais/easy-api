package vazdor.crud;


public interface CRUDRegister {
	public Class<?> lookupCrud(String id);
	
	public void registerCrud(String id, Class<?> crudClass);
}
