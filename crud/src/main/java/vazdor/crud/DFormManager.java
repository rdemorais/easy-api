package vazdor.crud;

import java.io.Serializable;

import vazdor.crud.list.CrudList;

public interface DFormManager {
	public void create(String idCrud, String jsonForm);
	public void update(String idCrud, String jsonForm, Serializable pk);
	public void delete(String idCrud, Serializable pk);
	public CrudList list(String idCrud, int offset, int max);
	public String load(String idCrud, Serializable pk, String action, String method);
	public String blankForm(String idCrud, String action, String method);
}
