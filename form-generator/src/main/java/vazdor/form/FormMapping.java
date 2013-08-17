package vazdor.form;

import java.util.Map;

/**
 * Mapeia o pojo ao formulário de forma a obter o nome amigável do campo.
 * 
 * nomeCampo -> Nome do Campo
 * 
 * @author Rafael de Morais
 *
 */
public interface FormMapping {
	public abstract Map<String, String> mapForm();
}
