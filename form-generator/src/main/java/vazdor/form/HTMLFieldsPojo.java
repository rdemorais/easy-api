package vazdor.form;

import java.io.Serializable;

public class HTMLFieldsPojo implements Serializable {

	/**
	 * 
	 */
	@FormGenExcludeField
	private static final long serialVersionUID = -3626030653316456743L;

	@FormGenExcludeField
	private String toIgnore;
	
	@FormGenHTMLConfig(friendlyName="Input field name", type=HTMLType.INPUT)
	private String inputField;
	
	@FormGenHTMLConfig(friendlyName="Texta area á é", type=HTMLType.TEXT_AREA)
	private String textArea;
	
	//to discover
	private boolean radio;
	
	@FormGenHTMLConfig(friendlyName="Password field", type=HTMLType.PASSWORD)
	private String passwd;
	
	@FormGenHTMLConfig(friendlyName="this should be hidden", type=HTMLType.HIDDEN)
	private String hidden;
	
	@FormGenHTMLConfig(friendlyName="File field", type=HTMLType.FILE)
	private String file;
	
	@FormGenHTMLConfig(friendlyName="Check box field", type=HTMLType.CHECK)
	private String check;
	
	@FormGenHTMLConfig(friendlyName="Number field", type=HTMLType.NUMBER)
	private Long number;
	
	@FormGenHTMLConfig(friendlyName="URL Field", type=HTMLType.URL)
	private String url;
	
	@FormGenHTMLConfig(friendlyName="Tel field", type=HTMLType.TEL)
	private String tel;
	
	@FormGenHTMLConfig(friendlyName="email field", type=HTMLType.EMAIL)
	private String email;
	
	
	public String getToIgnore() {
		return toIgnore;
	}
	public void setToIgnore(String toIgnore) {
		this.toIgnore = toIgnore;
	}
	public String getInputField() {
		return inputField;
	}
	public void setInputField(String inputField) {
		this.inputField = inputField;
	}
	public String getTextArea() {
		return textArea;
	}
	public void setTextArea(String textArea) {
		this.textArea = textArea;
	}
	public boolean isRadio() {
		return radio;
	}
	public void setRadio(boolean radio) {
		this.radio = radio;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getHidden() {
		return hidden;
	}
	public void setHidden(String hidden) {
		this.hidden = hidden;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getCheck() {
		return check;
	}
	public void setCheck(String check) {
		this.check = check;
	}
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}