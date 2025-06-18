package br.dev.julio.tarefas_ds1ta.model;

import java.awt.Toolkit;
import java.time.LocalDate;

import br.dev.julio.tarefas_ds1ta.utils.Utils;

public class Tarefa {

	private String nome;
	private String descricao;
	private Toolkit dataInicio;
	private int prazo;
	private LocalDate dataPrevisaoDeEntrega;
	private LocalDate dataEntrega;
	private Status status;
	private Funcionario responsavel;
	private String matricula;
	
	
	public Tarefa(String nome) {
		this.nome = nome;
		this.matricula = Utils.gerarUUID8();
	}
	
	public Tarefa(String nome, String cargo) {
		this.nome = nome;
		this.prazo = prazo;
		this.matricula = Utils.gerarUUID8();
	}
	
	public Tarefa() {
		this.matricula = Utils.gerarUUID8();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Toolkit getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Toolkit toolkit) {
		this.dataInicio = toolkit;
	}

	public int getPrazo() {
		return prazo;
	}

	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}

	public LocalDate getDataPrevisaoDeEntrega() {
		return dataPrevisaoDeEntrega;
	}

	public void setDataPrevisaoDeEntrega(LocalDate dataPrevisaoDeEntrega) {
		this.dataPrevisaoDeEntrega = dataPrevisaoDeEntrega;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Funcionario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Funcionario responsavel) {
		this.responsavel = responsavel;
	}

	public Object getMatricula() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public static char[] size() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public String toString() {
		return matricula + "," + nome + "," + responsavel + "\n";
	}

}
