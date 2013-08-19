package vazdor.form;

public enum HTMLType {
	INPUT("input"), 
	TEXT_AREA("textArea"), 
	SELECT("select"), 
	RADIO("radio"), 
	CHECK("check");
	
	private String html;
	
	private HTMLType(String html) {
		this.html = html;
	}
	public String getHtml() {
		return html;
	}
}