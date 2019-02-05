package domain;

public interface AbstractEntity {

	/**
	 * @return A refer�ncia para a chave prim�ria (Primary Key) de cada objeto persistido.
	 * 		   Caso o objeto ainda n�o tenha sido persistido, deve retornar <code>null</code>.
	 */
	public Number getId();
	
}
