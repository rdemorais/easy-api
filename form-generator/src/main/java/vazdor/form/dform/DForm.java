package vazdor.form.dform;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DForm implements Serializable{
	
	private static final long serialVersionUID = 692873376341134476L;

	private String action;
	private String method;
	private String clazz;
	private List<DFormOutput> html = new ArrayList<DFormOutput>();
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public List<DFormOutput> getHtml() {
		return html;
	}
	public void setHtml(List<DFormOutput> html) {
		this.html = html;
	}
	public void addDFormOutput(DFormOutput dFormOutput) {
		this.html.add(dFormOutput);
	}
}