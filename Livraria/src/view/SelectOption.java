package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Livraria;
import conexao.AcessoBanco;
import controle.ControleLivraria;

public class SelectOption {
	private JFrame frmSistemaDeLivraria;
	private JTextField codLivro;
	private JTextField precov;
	private JTextField nomeLivro;
	private JTextField precoa;
	private JTextField secLivro;
	private JTextField qtdeLivro;
	private JButton cadastra, altera, cancelar, remove, novo, consulta, sai;
	private JPanel panel;
	private GroupLayout paneLayout; 
	private JLabel lblNewLabel_1, lblNewLabel, lblNooDoLivro, lblSeoDoLivro, lblSeoDoLivro_1_1, lblSeoDoLivro_1_1_1, lblSeoDoLivro_1_1_1_1;


	Livraria livraria = new Livraria();
	ControleLivraria cl = new ControleLivraria();
	AcessoBanco ab = new AcessoBanco();
	int flog = 0;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectOption window = new SelectOption();
					window.frmSistemaDeLivraria.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public SelectOption() {
		initialize();
	}

	private void initialize() {
		frmSistemaDeLivraria = new JFrame();
		frmSistemaDeLivraria.setTitle("SISTEMA DE LIVRARIA");
		frmSistemaDeLivraria.setBounds(400, 100, 544, 500);
		frmSistemaDeLivraria.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSistemaDeLivraria.getContentPane().setLayout(null);
		frmSistemaDeLivraria.setUndecorated(true);
		frmSistemaDeLivraria.setBackground(new Color(102, 102, 255));

		panel = new JPanel();
		panel.setBackground(new Color(102, 102, 255));

		JLabel jLabel3 = new JLabel();
		jLabel3.setBounds(57, 100, 350, 15);
		jLabel3.setFont(new Font("Dialog", 1, 24)); 
		jLabel3.setForeground(new Color(255, 255, 255));
		jLabel3.setText("SISTEMA DE LIVRARIA");
		frmSistemaDeLivraria.getContentPane().add(jLabel3);


		paneLayout = new GroupLayout(panel);
		panel.setLayout(paneLayout);
		

		paneLayout.setHorizontalGroup(paneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(paneLayout.createSequentialGroup()
					.addGap(31, 31, 31)
					.addComponent(jLabel3)
					.addContainerGap(188, Short.MAX_VALUE)));
		paneLayout.setVerticalGroup(paneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING, paneLayout.createSequentialGroup()
						.addContainerGap(100, Short.MAX_VALUE)
						.addComponent(jLabel3).addGap(39, 39, 39)));

	
		GroupLayout layout = new GroupLayout(frmSistemaDeLivraria.getContentPane());
		frmSistemaDeLivraria.getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(panel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
						GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
				
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
									.addComponent(panel, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										));


		lblNewLabel_1 = new JLabel("INSIRA OS DADOS E SELECIONE A OP\u00C7\u00C3O APROPRIADA");
		lblNewLabel_1.setBounds(57, 189, 327, 14);
		lblNewLabel_1.setFont(new Font("Dialog", 1, 10));
		lblNewLabel_1.setForeground(new Color(20, 20, 255));
		frmSistemaDeLivraria.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel = new JLabel("C\u00F3digo do Livro:");
		lblNewLabel.setBounds(112, 212, 96, 14);
		frmSistemaDeLivraria.getContentPane().add(lblNewLabel);
		
		lblNooDoLivro = new JLabel("Nome do Livro:");
		lblNooDoLivro.setBounds(112, 237, 96, 14);
		frmSistemaDeLivraria.getContentPane().add(lblNooDoLivro);
		
		lblSeoDoLivro = new JLabel("Se\u00E7\u00E3o do Livro:");
		lblSeoDoLivro.setBounds(112, 262, 96, 14);
		frmSistemaDeLivraria.getContentPane().add(lblSeoDoLivro);
		
		lblSeoDoLivro_1_1 = new JLabel("Quantidade:");
		lblSeoDoLivro_1_1.setBounds(112, 287, 119, 14);
		frmSistemaDeLivraria.getContentPane().add(lblSeoDoLivro_1_1);
		
		lblSeoDoLivro_1_1_1 = new JLabel("Pre\u00E7o aquisi\u00E7\u00E3o:");
		lblSeoDoLivro_1_1_1.setBounds(112, 312, 106, 14);
		frmSistemaDeLivraria.getContentPane().add(lblSeoDoLivro_1_1_1);
		
		lblSeoDoLivro_1_1_1_1 = new JLabel("Pre\u00E7o venda:");
		lblSeoDoLivro_1_1_1_1.setBounds(112, 337, 119, 14);
		frmSistemaDeLivraria.getContentPane().add(lblSeoDoLivro_1_1_1_1);
		
		codLivro = new JTextField();
		codLivro.setBounds(210, 209, 50, 20);
		frmSistemaDeLivraria.getContentPane().add(codLivro);
		codLivro.setColumns(10);
		
		precov = new JTextField();
		precov.setEditable(false);
				
		nomeLivro = new JTextField();
		nomeLivro.setColumns(10);
		nomeLivro.setEnabled(false);
		nomeLivro.setBounds(210, 234, 250, 20);
		frmSistemaDeLivraria.getContentPane().add(nomeLivro);

		secLivro = new JTextField();
		secLivro.setColumns(10);
		secLivro.setEnabled(false);
		secLivro.setBounds(210, 259, 250, 20);
		frmSistemaDeLivraria.getContentPane().add(secLivro);

		qtdeLivro = new JTextField();
		qtdeLivro.setColumns(10);
		qtdeLivro.setEnabled(false);
		qtdeLivro.setBounds(210, 284, 86, 20);
		frmSistemaDeLivraria.getContentPane().add(qtdeLivro);

		
		precoa = new JTextField();
		precoa.setColumns(10);
		precoa.setEnabled(false);
		precoa.setBounds(210, 309, 86, 20);
		frmSistemaDeLivraria.getContentPane().add(precoa);

		precov.setColumns(10);
		precov.setBounds(210, 334, 86, 20);
		frmSistemaDeLivraria.getContentPane().add(precov);
		
				
		cadastra = new JButton("Cadastrar");
		cadastra.setBounds(119, 370, 89, 23);
		cadastra.setBackground(new Color(250, 250, 250, 250));
		cadastra.setEnabled(false);
		cadastra.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//livraria.setCodLivro(Integer.parseInt(codLivro.getText()));
				
				if(nomeLivro.getText().isEmpty() || secLivro.getText().isEmpty() || qtdeLivro.getText().isEmpty() || precoa.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Preencha todos os campos habilitados");
				}else if (flog == 1) {
					livraria.setNomeLivro(nomeLivro.getText());
					livraria.setSecLivro(secLivro.getText());
					livraria.setQtdeLivro(Integer.parseInt(qtdeLivro.getText()));
					livraria.setPrecoa(Double.parseDouble(precoa.getText()));

					precov.setText(String.valueOf((livraria.getPrecoa() * 0.2) + livraria.getPrecoa()));
					livraria.setPrecov(Double.parseDouble(precov.getText()));
					cl.salvar(livraria);
					limpar();
				}else{
					livraria.setCodLivro((Integer.parseInt(codLivro.getText())));
					livraria.setNomeLivro(nomeLivro.getText());
					livraria.setSecLivro(secLivro.getText());
					livraria.setQtdeLivro(Integer.parseInt(qtdeLivro.getText()));
					livraria.setPrecoa(Double.parseDouble(precoa.getText()));

					precov.setText(String.valueOf((livraria.getPrecoa() * 0.2) + livraria.getPrecoa()));
					livraria.setPrecov(Double.parseDouble(precov.getText()));
					cl.Editar(livraria);
					limpar();
				}
				
			}
		});
		frmSistemaDeLivraria.getContentPane().add(cadastra);
		cadastra.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				tbnCadastraMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				tbnCadastraMouseExited(evt);
			}
		});

		altera = new JButton("Alterar");
		altera.setBounds(218, 370, 89, 23);
		altera.setBackground(new Color(250, 250, 250, 250));
		altera.setEnabled(false);
		frmSistemaDeLivraria.getContentPane().add(altera);
		altera.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				tbnAlteraMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				tbnAlteraMouseExited(evt);
			}
		});
		altera.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				flog =2;
				cadastra.setEnabled(true);
				altera.setEnabled(false);
				remove.setEnabled(false);
			}
		});
		
		remove = new JButton("Remover");
		remove.setBounds(317, 370, 89, 23);
		remove.setBackground(new Color(250, 250, 250, 250));
		remove.setEnabled(false);
		frmSistemaDeLivraria.getContentPane().add(remove);
		remove.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				tbnRemoveMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				tbnRemoveMouseExited(evt);
			}
		});
		remove.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				int resposta =0;
				resposta = JOptionPane.showConfirmDialog(null,"Deseja realmente remover o livro");
				if(resposta == JOptionPane.YES_OPTION){
					livraria.setCodLivro(Integer.parseInt(codLivro.getText()));
					cl.remover(livraria);
					limpar();
					altera.setEnabled(false);
				}
			}
		});
		
		consulta = new JButton("Consultar");
		consulta.setBounds(416, 370, 89, 23);
		consulta.setBackground(new Color(250, 250, 250, 250));
		frmSistemaDeLivraria.getContentPane().add(consulta);
		consulta.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				tbnConsultaMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				tbnConsultaMouseExited(evt);
			}
		});
		consulta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(codLivro.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "digite o código do livro");
				}else{
					livraria.setPesquisa(codLivro.getText());
					Livraria modelo = cl.buscarLivro(livraria);
					codLivro.setText(String.valueOf(modelo.getCodLivro()));
					if(modelo.getCodLivro() ==0){
						limpar();
						altera.setEnabled(!true);
						remove.setEnabled(!true);
					}else{
							nomeLivro.setText(modelo.getNomeLivro());
						secLivro.setText(modelo.getSecLivro());

						qtdeLivro.setText(String.valueOf(modelo.getQtdeLivro()));
						precoa.setText(String.valueOf(modelo.getPrecoa()));
						precov.setText(String.valueOf(modelo.getPrecov()));
						nomeLivro.setEnabled(true);
						secLivro.setEnabled(true);
						qtdeLivro.setEnabled(true);
						precoa.setEnabled(true);
						cancelar.setEnabled(true);
						altera.setEnabled(true);
						remove.setEnabled(true);
						novo.setEnabled(false);

					}
				}		
			}
		});
		
		cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
				codLivro.setEnabled(true);
				nomeLivro.setEnabled(!true);
				secLivro.setEnabled(!true);
				qtdeLivro.setEnabled(!true);
				precoa.setEnabled(!true);
				cadastra.setEnabled(!true);
				novo.setEnabled(true);
				consulta.setEnabled(!false);
				altera.setEnabled(!true);
				remove.setEnabled(!true);
				
			}
		});
		cancelar.setBounds(71, 404, 180, 23);
		cancelar.setEnabled(false);
		cancelar.setBackground(new Color(250, 250, 250, 250));
		frmSistemaDeLivraria.getContentPane().add(cancelar);
		cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				tbnCancelarMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				tbnCancelarMouseExited(evt);
			}
		});
		
		sai = new JButton("Sair");
		sai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		sai.setBounds(260, 404, 196, 23);
		sai.setBackground(new Color(250, 250, 250, 250));
		frmSistemaDeLivraria.getContentPane().add(sai);
		sai.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				tbnSairMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				tbnSairMouseExited(evt);
			}
		});


		novo = new JButton("Novo");
		novo.setBounds(21, 370, 89, 23);
		novo.setBackground(new Color(250, 250, 250, 250));
		frmSistemaDeLivraria.getContentPane().add(novo);
		
		
		novo.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				tbnNovoMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				tbnNovoMouseExited(evt);
			}
		});
		
		novo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				flog = 1;
				codLivro.setEnabled(!true);
				nomeLivro.setEnabled(true);
				secLivro.setEnabled(true);
				qtdeLivro.setEnabled(true);
				precoa.setEnabled(true);
				cadastra.setEnabled(true);
				cancelar.setEnabled(true);
				consulta.setEnabled(false);
			}
		});	
	}

	public void tbnNovoMouseEntered(java.awt.event.MouseEvent evt){
		novo.setBackground(new Color(102, 102, 255));
		novo.setForeground(new Color(235, 235, 235));
		novo.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	public void tbnNovoMouseExited(java.awt.event.MouseEvent evt) {
		novo.setBackground(new Color(250, 250, 250));
		novo.setForeground(new Color(1, 2, 1));
	}

	public void tbnSairMouseEntered(java.awt.event.MouseEvent evt) {
		sai.setBackground(new Color(102, 102, 255));
		sai.setForeground(new Color(235, 235, 235));
		sai.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	public void tbnSairMouseExited(java.awt.event.MouseEvent evt) {
		sai.setBackground(new Color(250, 250, 250));
		sai.setForeground(new Color(1, 2, 1));
	}

	public void tbnCancelarMouseEntered(java.awt.event.MouseEvent evt) {
		cancelar.setBackground(new Color(102, 102, 255));
		cancelar.setForeground(new Color(235, 235, 235));
		cancelar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	public void tbnCancelarMouseExited(java.awt.event.MouseEvent evt) {
		cancelar.setBackground(new Color(250, 250, 250));
		cancelar.setForeground(new Color(1, 2, 1));
	}

	public void tbnConsultaMouseEntered(java.awt.event.MouseEvent evt) {
		consulta.setBackground(new Color(102, 102, 255));
		consulta.setForeground(new Color(235, 235, 235));
		consulta.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	public void tbnConsultaMouseExited(java.awt.event.MouseEvent evt) {
		consulta.setBackground(new Color(250, 250, 250));
		consulta.setForeground(new Color(1, 2, 1));
	}

	public void tbnRemoveMouseEntered(java.awt.event.MouseEvent evt) {
		remove.setBackground(new Color(102, 102, 255));
		remove.setForeground(new Color(235, 235, 235));
		remove.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	public void tbnRemoveMouseExited(java.awt.event.MouseEvent evt) {
		remove.setBackground(new Color(250, 250, 250));
		remove.setForeground(new Color(1, 2, 1));
	}

	public void tbnAlteraMouseEntered(java.awt.event.MouseEvent evt) {
		altera.setBackground(new Color(102, 102, 255));
		altera.setForeground(new Color(235, 235, 235));
		altera.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	public void tbnAlteraMouseExited(java.awt.event.MouseEvent evt) {
		altera.setBackground(new Color(250, 250, 250));
		altera.setForeground(new Color(1, 2, 1));
	}

	public void tbnCadastraMouseEntered(java.awt.event.MouseEvent evt) {
		cadastra.setBackground(new Color(102, 102, 255));
		cadastra.setForeground(new Color(235, 235, 235));
		cadastra.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	public void tbnCadastraMouseExited(java.awt.event.MouseEvent evt) {
		cadastra.setBackground(new Color(250, 250, 250));
		cadastra.setForeground(new Color(1, 2, 1));
	}
	
	public void limpar(){
		codLivro.setText("");
		nomeLivro.setText("");
		secLivro.setText("");
		qtdeLivro.setText("");
		precoa.setText("");
		precov.setText("");
	}
}
