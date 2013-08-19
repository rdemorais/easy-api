package vazdor.crud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("/META-INF/app-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CrudScanTest {
	
	@Autowired
	private CRUDRegister crudRegister;
	
	@Test
	public void testScan()  {
		System.out.println(crudRegister.lookupCrud("crud1"));
	}
}
