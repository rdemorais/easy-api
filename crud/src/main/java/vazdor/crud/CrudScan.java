package vazdor.crud;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class CrudScan implements ApplicationContextAware, InitializingBean{

	private ApplicationContext applicationContext;
	
	@Autowired
	private CRUDRegister crudRegister;
	
	public void afterPropertiesSet() throws Exception {
		final Map<String, Object> cruds = applicationContext.getBeansWithAnnotation(VazdorCrud.class);
		final Map<String, Object> formMaps = applicationContext.getBeansWithAnnotation(VazdorFormMapping.class);
		
		for (final Object vazdorCrud : cruds.values()) {
			final Class<? extends Object> crudClass = vazdorCrud.getClass();
			final VazdorCrud anot = crudClass.getAnnotation(VazdorCrud.class);
			crudRegister.registerCrud(anot.id(), crudClass);
		}
		
		for (final Object vazdorFormM : formMaps.values()) {
			final Class<? extends Object> fmClass = vazdorFormM.getClass();
			final VazdorFormMapping anot = fmClass.getAnnotation(VazdorFormMapping.class);
			crudRegister.registerFormMapping(anot.idCrud(), fmClass);
		}
	}

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}
}