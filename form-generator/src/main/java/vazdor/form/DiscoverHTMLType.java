package vazdor.form;

public class DiscoverHTMLType {
	
	public String discover(FormGenHTMLConfig htmlConfig, Class<?> javaType) {
		if(htmlConfig != null) {
			return htmlConfig.type().getHtml();
		}
		String htmlType = "input";
		if(javaType.getCanonicalName().equals("java.lang.String")) {
			htmlType = "input";
		}else if(javaType.getCanonicalName().equals("java.lang.Boolean") || javaType.getCanonicalName().equals("boolean")) {
			htmlType = "radio";
		}
		return htmlType;
	}
}