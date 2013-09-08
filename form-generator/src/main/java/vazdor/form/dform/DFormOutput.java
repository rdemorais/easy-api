package vazdor.form.dform;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa a estrutura básica dos componentes. Os objetos desta classe devem ser serializados (JSON)
 * 
 * @author Rafael de Morais
 *
 */
public class DFormOutput implements Serializable{
	
	private static final long serialVersionUID = -340128092969985156L;
	
	private String id;
	private String name;
	private String caption;
	private String type;
	private String placeholder;
	private String value;
	private List<DFormOutput> html = new ArrayList<DFormOutput>();

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPlaceholder() {
		return placeholder;
	}
	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public List<DFormOutput> getHtml() {
		return html;
	}
	public void setHtml(List<DFormOutput> html) {
		this.html = html;
	}
	public void addHtml(DFormOutput output) {
		this.html.add(output);
	}
}