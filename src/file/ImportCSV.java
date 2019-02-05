package file;

import static file.FileUtils.dateValue;
import static file.FileUtils.decimalValue;
import static file.FileUtils.getColuna;
import static file.FileUtils.intValue;
import static file.FileUtils.stringValue;
import static file.FileUtils.validarExtensao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import dao.CartaoDAO;
import domain.Bandeira;
import domain.Cartao;
import domain.TipoTransacao;
import old.CartaoDAOOld;
import old.CartaoDAOJPA;

public class ImportCSV {

	@SuppressWarnings("resource")
	public static void execute(String arquivoOrigem) throws Exception {
		try {

			validarExtensao(arquivoOrigem);

			File arquivoCSV = new File(arquivoOrigem);

			Scanner leitor = new Scanner(arquivoCSV);
			String linhasDoArquivo = new String();

			String colunasIniciais = leitor.nextLine();
			// metodo para conferir as colunas da primeira linha
			// fileUtils.conferirColunasIniciais(colunasIniciais) ;

			// metodo realizado para validar a primeira linha de acordo com os
			// campos descritos no arquivo cvs
			// fileUtils.conferirPrimeiraLinha(colunasIniciais);
			List<Cartao> cartoes = new ArrayList<>();
			while (leitor.hasNext()) {
				linhasDoArquivo = leitor.nextLine();
				cartoes.add(getCartao(linhasDoArquivo));
			}

			save(cartoes);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private List<Cartao> getListBD(){
		try {
			return new CartaoDAO().findAll();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Problemas ao localizar Cartões " + e.getLocalizedMessage());
		}
		return null;
	}
	
	

	private static void save(List<Cartao> cartoes) {
		CartaoDAO dao = new CartaoDAO();
		dao.salvar(cartoes);
		
		dao = new CartaoDAO();
		
		try {
			List<Cartao> list = dao.findAll();
			System.out.println(list);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Problemas ao localizar contaton" + e.getLocalizedMessage());
		}

		JOptionPane.showMessageDialog(null, "Dados importados com sucesso!");
	}

	private static Cartao getCartao(String linhasDoArquivo) {
		String[] colunas = linhasDoArquivo.split(";");
		Cartao c = new Cartao();
		c.setDtTransacao(dateValue(colunas[0]));
		c.setTipoTransacaoId(TipoTransacao.toEnum(getColuna(colunas[1])).getCod());
		c.setBandeiraId(Bandeira.toEnum(getColuna(colunas[2])).getCod());
		c.setMeioCaptura(stringValue(colunas[3]));
		c.setStoneId(stringValue(colunas[4]));
		c.setVlrBruto(decimalValue(colunas[5]));
		c.setVlrLiquido(decimalValue(colunas[6]));
		c.setNrCartao(stringValue(colunas[7]));
		c.setSerialNember(intValue(colunas[8]));
		c.setUltStatus(stringValue(colunas[9]));
		c.setDtUltStatus(dateValue(colunas[10]));
		return c;
	}
}
