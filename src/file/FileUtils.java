package file;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import static utils.Utils.*;

public class FileUtils {
	public static String erroRetorno = "";
	public static FileUtils instance;

	public static void validarExtensao(String arquivoOrigem) throws Exception {
		String extensao = arquivoOrigem.substring(arquivoOrigem.lastIndexOf("."), arquivoOrigem.length());
		if (!".csv".equals(extensao)) {
			erroRetorno = "Extensão do arquivo diferente de csv!";
			JOptionPane.showMessageDialog(null, erroRetorno, "Erro", JOptionPane.ERROR_MESSAGE);
			throw new Exception("Erro Extensão arquivo");
		}
	}

	public static void conferirColunasIniciais(String linhasDoArquivo) throws Exception {
		String[] valor = linhasDoArquivo.split(";");
		Boolean validar = false;
		ArrayList<String> listaColunas = retornaListaColunasIniciais();
		for (int i = 0; i < listaColunas.size(); i++) {
			validar = false;
			for (int j = 0; j < valor.length; j++) {
				String coluna = valor[j];
				if (listaColunas.get(i).equalsIgnoreCase(coluna)) {
					validar = true;
					break;
				}
			}
			if (!validar) {
				erroRetorno = "Coluna " + listaColunas.get(i) + " não existe na planilha, favor verificar!";
				JOptionPane.showMessageDialog(null, erroRetorno, "Erro", JOptionPane.ERROR_MESSAGE);
				throw new Exception("Erro verificação coluna");
			}
		}
	}

	private static ArrayList<String> retornaListaColunasIniciais() {
		ArrayList<String> lista = new ArrayList<>();
		lista.add("cod_op");
		lista.add("contrato");
		lista.add("nome_banco");
		lista.add("data_ajuiz");
		lista.add("numero_processo");
		return lista;
	}

	public static void conferirPrimeiraLinha(String linhasDoArquivo) throws Exception {
		String[] valor = linhasDoArquivo.split(";");
		String nomeColuna = "";
		int posicao = 0;
		for (int i = 0; i < 4; i++) {
			posicao = +i + 1;
			String posicaoString = "" + posicao;
			valor[i] = valor[i].replaceAll("\"", "");

			// metodo que retorna o nome das colunas corretas do arquivo
			nomeColuna = retornaNomePrimeiraLinha(i);

			if (!valor[i].equalsIgnoreCase(nomeColuna)) {
				erroRetorno = "Erro ao importar! O nome da coluna de posição Nº" + posicaoString + " deve ser "
						+ nomeColuna;
				JOptionPane.showMessageDialog(null, erroRetorno, "Erro", JOptionPane.ERROR_MESSAGE);
				throw new Exception("Erro verificação Primeira linha");
			}
		}
	}

	private static String retornaNomePrimeiraLinha(int indice) {
		String nomecoluna = "";
		switch (indice) {
		case 0:
			nomecoluna = "cod_op";
			break;

		case 1:
			nomecoluna = "contrato";
			break;

		case 2:
			nomecoluna = "nome_banco";
			break;

		case 3:
			nomecoluna = "data_ajuiz";
			break;
		case 4:
			nomecoluna = "numero_processo";

		}
		return nomecoluna;
	}
	
	public static String stringValue(String coluna) {
		return getColuna(coluna);
	}
	
	public static Integer intValue(String coluna) {
		coluna = getColuna(coluna);
		Integer numero = convertStringToInteger(coluna);
		return isNotNull(numero) ? numero : null;
	}
	
	public static Date dateValue(String coluna) {
		coluna = getColuna(coluna);
		Date data = convertStringToDateHour(coluna);
		return isNotNull(data) ? data : null;
	}
	
	public static BigDecimal decimalValue(String coluna) {
		coluna = getColuna(coluna);
		if(coluna.isEmpty()) {
			return new BigDecimal(0);
		}
		return convertStringToDecimal(coluna);
	}

	public static String getColuna(String coluna) {
		if (coluna.contains("\"")) {
			coluna = coluna.replace("\"", "");
		}
		return coluna;
	}
	
}
