package vazdor.crud;

import java.io.Serializable;

import vazdor.crud.list.CrudList;

public interface DFormManager {
	public void create(String idCrud, String jsonForm);
	public CrudList list(String idCrud, int offset, int max);
	public String load(String idCrud, Serializable pk, String action, String method);
	public String blankForm(String idCrud, String action, String method);
}
