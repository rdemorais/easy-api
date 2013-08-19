package vazdor.form;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Esta anotação tem a função de configurar um atributo do Pojo em relação ao campo html e nome amigável
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
