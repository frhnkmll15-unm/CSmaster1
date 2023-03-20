package com.juaracoding.CSmaster.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class DivisiDTO {


	public String getDescripsiDivisi;
	private Long idDivisi;

	@NotNull
	@NotEmpty
	private String namaDivisi;

	@NotNull(message = "CODE NULL ")
	@NotEmpty(message = " CODE EMPTY")
	private String kodeDivisi;
	private String descripsiDivisi;

	public Long getIdDivisi() {
		return idDivisi;
	}

	public void setIdDivisi(Long idDivisi) {
		this.idDivisi = idDivisi;
	}

	public String getNamaDivisi() {
		return namaDivisi;
	}

	public void setNamaDivisi(String namaDivisi) {
		this.namaDivisi = namaDivisi;
	}

	public String getKodeDivisi() {
		return kodeDivisi;
	}

	public void setKodeDivisi(String kodeDivisi) {
		this.kodeDivisi = kodeDivisi;
	}

	public String getDescripsiDivisi(String descripsiDivisi)

	{return descripsiDivisi;}

	public void setDescripsiDivisi(String descripsiDivisi) {
		this.descripsiDivisi = descripsiDivisi;
	}
}
