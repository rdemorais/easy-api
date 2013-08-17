package vazdor.form.dform;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import vazdor.form.FormMapping;

public class PojoTestFormMapping implements FormMapping {

	@Override
	public Map<String, String> mapForm(Serializable pojo) {
		Map<String, String> mapF = new HashMap<String, String>();
		mapF.put("nome", "Nome do Pojo");
		mapF.put("telefone", "Fone");
		return mapF;
	}

}
