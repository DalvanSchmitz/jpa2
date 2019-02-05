package view;

import static file.ImportCSV.execute;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.ImageIcon;

public class ViewArquivo extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewArquivo frame = new ViewArquivo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewArquivo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCaminho = new JLabel("");
		lblCaminho.setBounds(117, 81, 307, 14);
		contentPane.add(lblCaminho);

		JButton btnImportar = new JButton("Importar");
		btnImportar.setIcon(new ImageIcon(ViewArquivo.class.getResource("/icon/Find-icon2 (Custom).png")));
		btnImportar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnImportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser file = new JFileChooser("C:\\Users\\ninom\\Desktop");
				file.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int i = file.showSaveDialog(null);
				if (i == 1) {
					lblCaminho.setText("");
				} else {
					File arquivo = file.getSelectedFile();
					lblCaminho.setText(arquivo.getPath());
					importarArquivo(arquivo.getPath());
				}
			}
		});
		btnImportar.setBounds(41, 75, 113, 30);
		contentPane.add(btnImportar);

		@SuppressWarnings("rawtypes")
		JList list = new JList();
		list.setBounds(185, 245, 96, -6);
		contentPane.add(list);
		
		JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setIcon(new ImageIcon(ViewArquivo.class.getResource("/icon/import-icon (Custom).png")));
		button.setText("Voltar");
		button.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		button.setBounds(185, 200, 96, 34);
		contentPane.add(button);
	}
	
	private void importarArquivo(String arquivoOrigem) {
		try {
			if (arquivoOrigem.isEmpty()) {
				String erroRetorno = "Arquivo não anexado no sistema!";
				JOptionPane.showMessageDialog(null, erroRetorno, "Erro", JOptionPane.ERROR_MESSAGE);
				throw new Exception(erroRetorno);
			}
			
			execute(arquivoOrigem);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
