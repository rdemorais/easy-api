package vazdor.crud;

import java.util.HashMap;
import java.util.Map;

import vazdor.form.FormMapping;

@VazdorFormMapping(idCrud="crud1")
public class CrudTestFormMapping implements FormMapping {

	@Override
	public Map<String, String> mapForm() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("nome", "Nome teste");
		map.put("endereco", "Digite o endereco");
		return map;
	}

}
