package br.dev.julio.tarefas_ds1ta.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class GerenciamentoDeTarefas {

	private  JButton btnFuncionarios;
	private JButton btnTarefas;
	
	public GerenciamentoDeTarefas(JFrame tela) {
		criarTela(tela);
	}
	
	private void criarTela(JFrame parent){
		JFrame tela = new JFrame("Gerenciamento De Tarefas");
		tela.setSize(600, 300);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		
		Container painel = tela.getContentPane();
		
		btnFuncionarios = new JButton("Funcionarios");
		btnFuncionarios.setBounds(10, 100, 280, 75);
		
		btnFuncionarios.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new GerenciamentoDeTarefas(tela);
				
			}
		});
		
		btnTarefas = new JButton("Tarefas");
		btnTarefas.setBounds(310, 100, 280, 75);

		btnFuncionarios.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FuncionariosListaFrame(tela);
				
			}
		});
		
		btnTarefas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TarefaListaFrame(tela);
				
			}
		});
		
		
		painel.add(btnFuncionarios);
		painel.add(btnTarefas);
		
		tela.setVisible(true);
		
		
		
		
	}
}
