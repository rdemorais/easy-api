package vazdor.form.dform;

import org.junit.Test;

import vazdor.form.FormGenerator;

import static org.junit.Assert.*;

public class DFormGeneratorTest {
	
	String expected = "{'action': 'ac', 'method': 'post', 'html': [{'name': 'nome', 'id': 'nome', 'caption': 'Nome do Pojo', 'type': 'input', 'value': ''},{'name': 'telefone', 'id': 'telefone', 'caption': 'Fone', 'type': 'input', 'value': ''}]}";
	
	@Test
	public void testGFormGen() {
		FormGenerator<String> dFormGen = new DFormGenerator("ac", "post");
		assertEquals(expected, dFormGen.gen(new PojoTest(), new PojoTestFormMapping()));
	}
}
