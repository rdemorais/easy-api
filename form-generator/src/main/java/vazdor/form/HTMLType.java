package vazdor.form;

/**
 * 
 * @author Rafael de Morais
 *
 */
public enum HTMLType {
	INPUT("input"),
	PASSWORD("password"),
	HIDDEN("hidden"),
	FILE("file"),
	TEXT_AREA("text"), 
	SELECT("select"), 
	RADIO("radio"), 
	CHECK("checkbox"),
	NUMBER("number"),
	URL("url"),
	TEL("tel"),
	EMAIL("email");
	
	private String html;
	
	private HTMLType(String html) {
		this.html = html;
	}
	public String getHtml() {
		return html;
	}
}