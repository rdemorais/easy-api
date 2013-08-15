package vazdor.locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@ContextConfiguration("/META-INF/app-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class VazdorLocaleTest {
	
	@Autowired
	private VazdorMessage vazdorMessage;
	
	@Autowired
	private VazdorLocale vazdorLocale;
	
	@Test
	public void testBemVindoPT_BR() {
		assertEquals(vazdorMessage.getMessage("seja.bem.vindo"), "Seja bem vindo");
	}
	
	@Test
	public void testBemVindoEN_US() {
		vazdorLocale.setLocaleSelecionado("en_US");
		//TODO Ajustar. Não funciona em alguns momentos
		assertEquals(vazdorMessage.getMessage("seja.bem.vindo"), "Welcome");
	}
}