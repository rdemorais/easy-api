package vazdor.form;

public class DiscoverHTMLType {
	
	public String discover(Class<?> javaType) {
		String htmlType = "NOT-FOUND";
		if(javaType.getCanonicalName().equals("java.lang.String")) {
			htmlType = "input";
		}
		return htmlType;
	}
}