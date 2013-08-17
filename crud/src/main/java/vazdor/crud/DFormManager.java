package vazdor.crud;

import java.io.Serializable;

public interface DFormManager {
	public String list(String idCrud);
	public String load(String idCrud, Serializable pk, String action, String method);
	public String blankForm(String idCrud, String action, String method);
}
