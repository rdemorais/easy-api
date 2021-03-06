package vazdor.crud;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Registra uma classe como sendo um crud
 * 
 * @author Rafael de Morais
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface VazdorCrud {
	/**
	 * Id do crud
	 * @return
	 */
	String id();
}
