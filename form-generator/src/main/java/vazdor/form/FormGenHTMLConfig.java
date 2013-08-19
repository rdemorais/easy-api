package vazdor.form;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Esta anota��o tem a fun��o de configurar um atributo do Pojo em rela��o ao campo html e nome amig�vel
 * 
 * @author Rafael de Morais
 *
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FormGenHTMLConfig {
	HTMLType type();
	String friendlyName();
}
