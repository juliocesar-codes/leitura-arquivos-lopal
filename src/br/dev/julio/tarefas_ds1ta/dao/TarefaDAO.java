package br.dev.julio.tarefas_ds1ta.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;


import br.dev.julio.tarefas_ds1ta.model.Tarefa;

public class TarefaDAO {

	private Tarefa tarefa;
	
	private FileWriter fw;
	private BufferedWriter bw;
	private FileReader fr;
	private BufferedReader br;
	
	private String arquivo = "/Users/25132583/tarefasDS1TA/tarefas.csv";
	
	public TarefaDAO(Tarefa tarefa){
		this.tarefa = tarefa;
		try {
			fw = new FileWriter(arquivo, true);
			bw = new BufferedWriter(fw);
			fr = new FileReader(arquivo);
			br = new BufferedReader(fr);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void salvar(){
		try {
			bw.write(tarefa.toString());
			bw.flush();
			System.out.println(tarefa.getNome() + " gravado com sucelso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<Tarefa> getTarefas(){
		List<Tarefa> tarefas = new ArrayList<>();
		
		try {
			 String linha = "";
			 
			 while ((linha = br.readLine()) != null) {
		     String[] tarefaVetor= linha.split(",");
		     

	            if (tarefaVetor.length >= 4) { 
	                Tarefa tarefa = new Tarefa();
	                tarefa.setNome(tarefaVetor[0]);
	                tarefa.setDescricao(tarefaVetor[1]);
	                
	            } else {
	              
	            }
			}
		} catch (Exception e) {
			 System.err.println("Erro ao ler dados das tarefas: " + e.getMessage());
		        e.printStackTrace();
		}
		return tarefas;
	}
}
