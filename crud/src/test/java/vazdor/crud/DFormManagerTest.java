package vazdor.crud;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("/META-INF/app-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DFormManagerTest {
	
	private String expected = "{'action': 'action', 'method': 'post', 'html': [{'name': 'nome', 'id': 'nome', 'caption': 'Nome teste', 'type': 'input', 'value': ''},{'name': 'endereco', 'id': 'endereco', 'caption': 'Digite o endereco', 'type': 'input', 'value': ''}]}";
	private String jsonToCreate = "{\"nome\":\"nome codigo\",\"endereco\":\"endereco do codigo\"}";
	private String jsonToUpdate = "{\"nome\":\"nome up\"}";
	
	@Autowired
	private DFormManager dformManager;
	
	@Test
	public void testBlankForm() {
		assertEquals(expected, dformManager.blankForm("crud1", "action", "post"));
	}
	
	@Test
	public void testLoad() {
		System.out.println(dformManager.load("crud1", 1L, "ac", "post"));
	}
	
	@Test
	public void testList() {
		System.out.println(dformManager.list("crud1", 0, 0));
	}
	
	@Test
	public void testCreate() throws JsonGenerationException, JsonMappingException, IOException {
		dformManager.create("crud1", jsonToCreate);
	}
	
	@Test
	public void testUpdate() {
		dformManager.update("crud1", jsonToUpdate, 32768L);
	}
	
	//@Test
	public void testDelete() {
		dformManager.delete("crud1", 1L);
	}
}