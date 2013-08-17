package vazdor.form;

import java.io.Serializable;

/**
 * A implementa��o desta interface deve fornecer um pojo e ter� como resultado um
 * objeto representando o formul�rio HTML gerado.
 * 
 * @author Rafael de Morais
 *
 * @param <T>
 */
public interface FormGenerator<T> {
	public T gen(Serializable pojo, FormMapping formM);
}