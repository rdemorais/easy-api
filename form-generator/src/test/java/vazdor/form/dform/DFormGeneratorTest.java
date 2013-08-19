package vazdor.form.dform;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import vazdor.form.FormGenerator;
import vazdor.form.HTMLFieldsPojo;

@ContextConfiguration("/META-INF/app-formgen-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DFormGeneratorTest {
	
	@Autowired
	private FormGenerator<String> dformGenerator;
	
	@Test
	public void testGFormGen() {
		HTMLFieldsPojo pojo = new HTMLFieldsPojo();
		pojo.setInputField("value input");
		pojo.setRadio(true);
		pojo.setTextArea("text area value");
		pojo.setToIgnore("");
		
		System.out.println(dformGenerator.gen(pojo, "ac", "get"));
	}
}
