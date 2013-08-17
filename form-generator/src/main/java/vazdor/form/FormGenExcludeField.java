package vazdor.form;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Um atributo com esta anota��o n�o constar� na lista de campos gerados para o form
 * 
 * @author Rafael de Morais
 *
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FormGenExcludeField {

}
