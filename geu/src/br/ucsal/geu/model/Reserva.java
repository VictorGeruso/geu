package br.ucsal.geu.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva {
	
	private Integer id;
	private String titulo;
	private String descricao;
	private String justificativa;
	private String solicitante;
	private String telefone;
	private LocalDate data;
	private LocalTime horaInicio;
	private LocalTime horaFim;
	private Espaco espaco;
	
	public Reserva(Integer id, String titulo, String descricao, String justificativa, String solicitante,
			String telefone, LocalDate data, LocalTime horaInicio, LocalTime horaFim, Espaco espaco) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.justificativa = justificativa;
		this.solicitante = solicitante;
		this.telefone = telefone;
		this.data = data;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
		this.espaco = espaco;
	}

	public Reserva() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(LocalTime horaFim) {
		this.horaFim = horaFim;
	}

	public Espaco getEspaco() {
		return espaco;
	}

	public void setEspaco(Espaco espaco) {
		this.espaco = espaco;
	}
	
}
