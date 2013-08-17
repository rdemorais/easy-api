package vazdor.form.dform;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Map;

import vazdor.form.DiscoverHTMLType;
import vazdor.form.FormGenExcludeField;
import vazdor.form.FormGenerator;
import vazdor.form.FormMapping;

/**
 * Recebe um {@link Serializable} e, via reflection, obtem os campos e gera um
 * formulário no padrão DForm.
 * 
 * É preciso fornecer um {@link FormMapping} para dizer ao método como capturar o nome
 * amigágel de cada campo.
 * 
 * @author Rafael de Morais - 17.08.13
 * 
 */
public class DFormGenerator implements FormGenerator<String> {

	private DiscoverHTMLType discoverHtmlType = new DiscoverHTMLType();
	private String action;
	private String method;
	
	public DFormGenerator(String action, String method) {
		this.action = action;
		this.method = method;
	}
	
	public String gen(Serializable pojo, FormMapping formM) {
		
		Map<String, String> formMap = formM.mapForm();
		Field fields[] = pojo.getClass().getDeclaredFields();
		StringBuffer jsonForm = new StringBuffer(inicio());
		for (int i = 0; i < fields.length; i++) {
			try {
				Field f = fields[i];
				if(!f.isAnnotationPresent(FormGenExcludeField.class)) {
					f.setAccessible(true);
					String name = f.getName();
					String id = f.getName();
					String caption = formMap.get(f.getName());
					String type = discoverHtmlType.discover(f.getType());
					String value = "";
					if(f.get(pojo) != null) {
						value = f.get(pojo).toString();					
					}
					
					jsonForm.append(fieldJson(name, id, caption, type, value));
					
					if(i < fields.length && i != fields.length -1) {
						jsonForm.append(",");
					}					
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		jsonForm.append(fim());
		return jsonForm.toString();
	}
	
	private String inicio() {
		return "{'action': '" + action + "', 'method': '"+method+"', 'html': [";
	}
	
	private String fieldJson(String name, String id, String caption, String type, String value) {
		return "{'name': '" + name + "', 'id': '" + id + "', 'caption': '" + caption + "', 'type': '" + type + "', 'value': '" + value + "'}";
	}
	
	private String fim() {
		return "]}";
	}
}