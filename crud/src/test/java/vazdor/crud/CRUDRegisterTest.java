package vazdor.crud;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("/META-INF/app-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CRUDRegisterTest {
	
	@Autowired
	private CRUDRegister crudRegister;
	
	@Test
	public void testCrudRegisterLookup() throws ClassNotFoundException {
		Class<?> crud1 =  crudRegister.lookupCrud("crud1");
		assertEquals(crud1.getCanonicalName(), "vazdor.crud.CrudTest");
	}
}