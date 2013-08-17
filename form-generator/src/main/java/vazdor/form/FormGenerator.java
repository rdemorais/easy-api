package vazdor.form;

import java.io.Serializable;

/**
 * A implementação desta interface deve fornecer um pojo e terá como resultado um
 * objeto representando o formulário HTML gerado.
 * 
 * @author Rafael de Morais
 *
 * @param <T>
 */
public interface FormGenerator<T> {
	public T gen(Serializable pojo, FormMapping formM);
}