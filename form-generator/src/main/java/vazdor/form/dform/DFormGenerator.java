package vazdor.form.dform;

import java.io.Serializable;
import java.lang.reflect.Field;

import vazdor.form.DiscoverHTMLType;
import vazdor.form.FormGenExcludeField;
import vazdor.form.FormGenHTMLConfig;
import vazdor.form.FormGenerator;
import vazdor.form.HTMLType;

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
	
	public DFormGenerator() {
		
	}
	
	public String gen(Serializable pojo, String action, String method) {
		
		Field fields[] = pojo.getClass().getDeclaredFields();
		StringBuffer jsonForm = new StringBuffer(inicio(action, method));
		String friendlyName = "";
		FormGenHTMLConfig htmlConfig = null;
		
		for (int i = 0; i < fields.length; i++) {
			try {
				Field f = fields[i];
				if(!f.isAnnotationPresent(FormGenExcludeField.class)) {
					f.setAccessible(true);
					boolean incCaption = true;
					if(f.isAnnotationPresent(FormGenHTMLConfig.class)) {
						htmlConfig = f.getAnnotation(FormGenHTMLConfig.class);
						friendlyName = htmlConfig.friendlyName();
						if(htmlConfig.type() == HTMLType.HIDDEN) {
							incCaption = false;
						}
					}
					String name = f.getName();
					String id = f.getName();
					String caption;
					if(!friendlyName.equals("") && incCaption) {
						caption = friendlyName;
					}else {
						caption = f.getName();
					}
					String type = discoverHtmlType.discover(htmlConfig, f.getType());
					String value = "";
					if(f.get(pojo) != null) {
						value = f.get(pojo).toString();					
					}
					
					jsonForm.append(fieldJson(name, id, caption, type, value));
					
					if(i < fields.length && i != fields.length -1) {
						jsonForm.append(",");
					}
					htmlConfig = null;
					friendlyName = "";
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
	
	private String inicio(String action, String method) {
		return "{'action': '" + action + "', 'method': '"+method+"', 'html': [";
	}
	
	private String fieldJson(String name, String id, String caption, String type, String value) {
		return "{'name': '" + name + "', 'id': '" + id + "', 'caption': '" + caption + "', 'type': '" + type + "', 'value': '" + value + "'}";
	}
	
	private String fim() {
		return "]}";
	}
}