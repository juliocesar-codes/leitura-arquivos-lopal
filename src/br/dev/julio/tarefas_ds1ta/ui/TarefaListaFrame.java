package br.dev.julio.tarefas_ds1ta.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.dev.julio.tarefas_ds1ta.dao.FuncionarioDAO;
import br.dev.julio.tarefas_ds1ta.dao.TarefaDAO;
import br.dev.julio.tarefas_ds1ta.model.Funcionario;
import br.dev.julio.tarefas_ds1ta.model.Tarefa;

public class TarefaListaFrame {
	private JLabel labelTitulo;
	private JButton btnNovo;
	
	private JTable tabelaTarefas;
	private DefaultTableModel modelTarefas;
	private JScrollPane scroll;
	
	private String[] colunas = {"CÓDIGO", "NOME", "RESPONSÁVEL"};
	
	public TarefaListaFrame(JFrame tela) {
		criarTela(tela);
	}
private void criarTela(JFrame parent) {
		
		JDialog tela = new JDialog(parent, true);
		tela.setSize(600, 500);
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		
		Container painel = tela.getContentPane();
		
		labelTitulo = new JLabel("Cadastro de Tarefas");
		labelTitulo.setFont(new Font("arial", Font.BOLD, 28));
		labelTitulo.setForeground(new Color(100, 0, 100));
		labelTitulo.setBounds(10, 10, 400, 40);
		
		modelTarefas = new DefaultTableModel(colunas, 1);
		carregarDados();
		tabelaTarefas = new JTable(modelTarefas);
		scroll = new JScrollPane(tabelaTarefas);
		scroll.setBounds(10, 60, 550, 340);
		
		btnNovo = new JButton("Novo");
		btnNovo.setBounds(10, 410, 150, 40);
		
btnNovo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TarefaFrame(parent);
				carregarDados();
				
			}
		});
		
		painel.add(labelTitulo);
		painel.add(scroll);
		painel.add(btnNovo);
		
		
		tela.setVisible(true);
		
	}
private Object[][] carregarDados() {
	TarefaDAO dao = new TarefaDAO(null);
	List<Tarefa> tarefas = dao.getTarefas();
	
	Object[][] dados = new Object[tarefas.size()][3];
	
	int i = 0;
	for(Tarefa t : tarefas) {
		dados[i][0] = t.getMatricula();
		dados[i][1] = t.getNome();
		dados[i][2] = t.getResponsavel();
		i++;
	}
	modelTarefas.setDataVector(dados, colunas);;
	return dados;
	
}

}
