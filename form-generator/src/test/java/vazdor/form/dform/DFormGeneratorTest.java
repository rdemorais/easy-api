package vazdor.form.dform;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import vazdor.form.FormGenerator;

import static org.junit.Assert.*;

@ContextConfiguration("/META-INF/app-formgen-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DFormGeneratorTest {
	
	String expected = "{'action': 'ac', 'method': 'post', 'html': [{'name': 'nome', 'id': 'nome', 'caption': 'Nome do Pojo', 'type': 'input', 'value': ''},{'name': 'telefone', 'id': 'telefone', 'caption': 'Fone', 'type': 'input', 'value': ''}]}";
	
	@Autowired
	private FormGenerator<String> dformGenerator;
	
	@Test
	public void testGFormGen() {
		assertEquals(expected, dformGenerator.gen(new PojoTest(), new PojoTestFormMapping(), "ac", "post"));
	}
}
