package vazdor.crud;

import java.util.List;

import vazdor.crud.list.Column;
import vazdor.crud.list.Row;

public interface CrudListManager {
	/**
	 * Carrega a lista de objetos com base nas colunas configuradas no crud através da anotação
	 * {@link CrudListColumn} 
	 * 
	 * @param crud A classe do crud
	 * @param cols as colunas selecionadas para aparecer na lista
	 * @param offset o inicio dos registros
	 * @param max o número máximo de registros
	 * @return A lista {@link Row} a partir do banco de dados
	 */
	public List<Row> loadRows(Class<?> crud, List<Column> cols, int offset, int max);
	/**
	 * Extrai as colunas marcadas com a anotação {@link CrudListColumn}
	 * 
	 * @param crud
	 * @param mapForm
	 * @return
	 */
	public List<Column> extractColumnsFromCrud(Class<?> crud);
}