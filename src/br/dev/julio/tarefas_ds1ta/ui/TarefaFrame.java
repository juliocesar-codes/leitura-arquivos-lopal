package br.dev.julio.tarefas_ds1ta.ui;

import java.awt.Container;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.dev.julio.tarefas_ds1ta.dao.FuncionarioDAO;
import br.dev.julio.tarefas_ds1ta.model.Funcionario;

public class TarefaFrame {

	public TarefaFrame(JFrame tela){
		criarTela(tela);
	}
	private void criarTela(JFrame parent){
		
		JDialog tela = new JDialog(parent, true);
		tela.setSize(400, 400);
		tela.setTitle("Cadastro de Tarefas");
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		
		JLabel labelNome = new JLabel("Tarefa:");
		labelNome.setBounds(10, 10, 150, 30);
		JTextField txtTarefa = new JTextField();
		txtTarefa.setBounds(10, 40, 200, 30);
		
		JLabel labelDescricao = new JLabel("Descricao:");
		labelDescricao.setBounds(10, 75, 150, 30);
		JTextField txtDescricao = new JTextField();
		txtDescricao.setBounds(10, 200, 150, 30);
		
		
		Container painel = tela.getContentPane();
		painel.add(labelNome);
		painel.add(txtTarefa);
		painel.add(labelDescricao);
		painel.add(txtDescricao);
		
		
		tela.setVisible(true);
	}
}
