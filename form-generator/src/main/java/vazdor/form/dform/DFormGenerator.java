package vazdor.form.dform;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import vazdor.form.DiscoverHTMLType;
import vazdor.form.FormGenExcludeField;
import vazdor.form.FormGenHTMLConfig;
import vazdor.form.FormGenStrategyRender;
import vazdor.form.FormGenerator;
import vazdor.form.HTMLType;

/**
 * Recebe um {@link Serializable} e, via reflection, obtem os campos e gera um
 * formulário no padrão DForm.
 * 
 * É preciso fornecer um {@link FormMapping} para dizer ao método como capturar
 * o nome amigágel de cada campo.
 * 
 * @author Rafael de Morais - 17.08.13
 * 
 */
public class DFormGenerator implements FormGenerator<String> {

	private DiscoverHTMLType discoverHtmlType = new DiscoverHTMLType();

	private ObjectMapper mapper;

	public DFormGenerator() {
		mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Inclusion.NON_NULL);
	}

	public String gen(Serializable pojo, String action, String method) {
		if (pojo.getClass().isAnnotationPresent(FormGenStrategyRender.class)) {
			FormGenStrategyRender strategyRender = pojo.getClass()
					.getAnnotation(FormGenStrategyRender.class);
			switch (strategyRender.strategy()) {
			case INLINE_FORM:
				return inlineStrategy(pojo, action, method);
			case BOOTSTRAP_GROUP:
				return bootstrapGroupStrategy(pojo, action, method);
			default:
				break;
			}
		} else {
			return inlineStrategy(pojo, action, method);
		}
		return "";
	}

	private String bootstrapGroupStrategy(Serializable pojo, String action,
			String method) {
		return "";
	}

	private String inlineStrategy(Serializable pojo, String action,
			String method) {
		Field fields[] = pojo.getClass().getDeclaredFields();
		String friendlyName = "";
		FormGenHTMLConfig htmlConfig = null;
		DForm dForm = new DForm();
		DFormOutput output;
		dForm.setAction(action);
		dForm.setMethod(method);

		try {
			for (int i = 0; i < fields.length; i++) {

				Field f = fields[i];
				output = new DFormOutput();
				if (!f.isAnnotationPresent(FormGenExcludeField.class)) {
					f.setAccessible(true);
					boolean incCaption = true;
					if (f.isAnnotationPresent(FormGenHTMLConfig.class)) {
						htmlConfig = f.getAnnotation(FormGenHTMLConfig.class);
						friendlyName = htmlConfig.friendlyName();
						if (htmlConfig.type() == HTMLType.HIDDEN) {
							incCaption = false;
						}
					}
					output.setName(f.getName());
					output.setId(f.getName());
					String caption;
					if (!friendlyName.equals("") && incCaption) {
						caption = friendlyName;
					} else {
						caption = f.getName();
					}
					String type = discoverHtmlType.discover(htmlConfig,
							f.getType());
					String value = "";
					if (f.get(pojo) != null) {
						value = f.get(pojo).toString();
					}
					output.setCaption(caption);
					output.setType(type);
					output.setValue(value);

					dForm.addDFormOutput(output);
					htmlConfig = null;
					friendlyName = "";
				}
			}
			return mapper.writeValueAsString(dForm);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
}