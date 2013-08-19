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
}