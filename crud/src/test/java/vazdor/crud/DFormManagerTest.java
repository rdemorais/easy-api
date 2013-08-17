package vazdor.crud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@ContextConfiguration("/META-INF/app-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DFormManagerTest {
	
	private String expected = "{'action': 'action', 'method': 'post', 'html': [{'name': 'nome', 'id': 'nome', 'caption': 'Nome teste', 'type': 'input', 'value': ''},{'name': 'endereco', 'id': 'endereco', 'caption': 'Digite o endereco', 'type': 'input', 'value': ''}]}";
	
	@Autowired
	private DFormManager dFormManager;
	
	@Test
	public void testBlankForm() {
		assertEquals(expected, dFormManager.blankForm("crud1", "action", "post"));
	}
	
	@Test
	public void testLoad() {
		System.out.println(dFormManager.load("crud1", 1L, "ac", "post"));
	}
}
