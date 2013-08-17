package vazdor.form;

public class DiscoverHTMLType {
	
	public String discover(Class<?> javaType) {
		String htmlType = "input";
		if(javaType.getCanonicalName().equals("java.lang.String")) {
			htmlType = "input";
		}
		return htmlType;
	}
}