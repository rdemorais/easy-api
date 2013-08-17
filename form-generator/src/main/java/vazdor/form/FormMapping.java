package vazdor.form;

import java.util.Map;

/**
 * Mapeia o pojo ao formul�rio de forma a obter o nome amig�vel do campo.
 * 
 * nomeCampo -> Nome do Campo
 * 
 * @author Rafael de Morais
 *
 */
public interface FormMapping {
	public abstract Map<String, String> mapForm();
}
