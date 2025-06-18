package br.dev.julio.tarefas_ds1ta.ui;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;

import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import br.dev.julio.tarefas_ds1ta.model.Status;
import br.dev.julio.tarefas_ds1ta.dao.FuncionarioDAO;
import br.dev.julio.tarefas_ds1ta.dao.TarefaDAO;
import br.dev.julio.tarefas_ds1ta.model.Funcionario;
import br.dev.julio.tarefas_ds1ta.model.Tarefa;

public class TarefaFrame {
	
	private JComboBox<Status> comboStatus;
	 private JComboBox<Funcionario> comboFuncionarios;

	public TarefaFrame(JFrame tela){
		criarTela(tela);
	}
	private void criarTela(JFrame parent){
		
		JDialog tela = new JDialog(parent, true);
		tela.setSize(400, 600);
		tela.setTitle("Cadastro de Tarefas");
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		
		JLabel labelNome = new JLabel("Título:");
		labelNome.setBounds(10, 10, 150, 30);
		JTextField txtTarefa = new JTextField();
		txtTarefa.setBounds(10, 40, 200, 30);
		
		JLabel labelDescricao = new JLabel("Descrição:");
		labelDescricao.setBounds(10, 75, 150, 30);
		JTextField txtDescricao = new JTextField();
		txtDescricao.setBounds(10, 105, 350, 30);
		
		JLabel labeldataInicial = new JLabel("Data Inicial:");
		labeldataInicial.setBounds(10, 135, 150, 30);
		JSpinner spinnerDataInicial = criarSpinnerData();
		spinnerDataInicial.setBounds(10, 165, 200, 30);
		
		JLabel labelPrazo = new JLabel("Prazo:");
		labelPrazo.setBounds(10, 195, 150, 30);
		JTextField textPrazo = new JTextField();
		textPrazo.setBounds(10, 225, 200, 30);
		
		
		JLabel labelDataConclusao = new JLabel("Data conclusão:");
		labelDataConclusao.setBounds(10, 255, 150, 30);
		JSpinner spinnerDataConclusao = criarSpinnerData();
		spinnerDataConclusao.setBounds(10, 285, 200, 30);
		
		JLabel labelStatus = new JLabel("Status:");
		labelStatus.setBounds(10, 315, 150, 30);
		comboStatus = new JComboBox<>(Status.values());
		comboStatus.setBounds(10, 345, 200, 30);
		
		JLabel labelResponsavel = new JLabel("Responsável:");
		labelResponsavel.setBounds(10, 375, 150, 30);

		List<Funcionario> funcionarios = new FuncionarioDAO(null).getFuncionarios();
		comboFuncionarios = new JComboBox<>(funcionarios.toArray(new Funcionario[0])); // Use new Funcionario[0] para evitar tamanho fixo

		// Personaliza a exibição para mostrar apenas o nome
		comboFuncionarios.setRenderer(new DefaultListCellRenderer() {
		    @Override
		    public Component getListCellRendererComponent(
		        JList<?> list, Object value, int index, 
		        boolean isSelected, boolean cellHasFocus
		    ) {
		        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		        if (value instanceof Funcionario) {
		            Funcionario func = (Funcionario) value;
		            setText(func.getNome()); // Exibe apenas o nome
		        }
		        return this;
		    }
		});

		comboFuncionarios.setBounds(10, 405, 200, 30);
        
        JButton buttonSalvar = new JButton("Salvar");
        buttonSalvar.setBounds(10, 460, 170, 50);
        
        JButton buttonSair = new JButton("Sair");
        buttonSair.setBounds(200, 460, 170, 50);
		
		Container painel = tela.getContentPane();
		painel.add(labelNome);
		painel.add(txtTarefa);
		painel.add(labelDescricao);
		painel.add(txtDescricao);
		painel.add(labeldataInicial);
		painel.add(spinnerDataInicial);
		painel.add(labelPrazo);
		painel.add(textPrazo);
		painel.add(labelDataConclusao);
		painel.add(spinnerDataConclusao);
		painel.add(labelStatus);
		painel.add(comboStatus);
		painel.add(labelResponsavel);
		painel.add(comboFuncionarios);
		painel.add(buttonSalvar);
		painel.add(buttonSair);
		
buttonSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Tarefa t = new Tarefa();
				t.setNome(txtTarefa.getText());
				t.setDescricao(txtDescricao.getText());
				t.setDataInicio(spinnerDataInicial.getToolkit());
				
				TarefaDAO dao = new TarefaDAO(t);
				dao.salvar();
				
				JOptionPane.showMessageDialog(tela, t.getNome() + " gravado com sucesso!");
				
				
			}
		});

buttonSair.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int resposta = JOptionPane.showConfirmDialog(tela, "Sair do sistema?");
		if (resposta == 0) {
			tela.dispose();
		}
	}
});
		
		
		tela.setVisible(true);
		
	}
	private JSpinner criarSpinnerData() {
        JSpinner spinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "dd/MM/yyyy");
        spinner.setEditor(editor);
        return spinner;
    }
	 
    }
	
