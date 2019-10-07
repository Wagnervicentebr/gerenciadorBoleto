package com.example.gerenciadorboleto.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import com.example.gerenciadorboleto.enuns.StatusBoleto;

@Entity
public class Boleto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codBoleto;
	
	@NotEmpty(message =" Descrição não pode ser vazia")
	@Size(min = 10, max = 60, message = "descrição obrigatoria! min 10, max 60 caracteres")
	private String descricao;
	
	@NotNull(message = "Data de vencimento não pode ser nula")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date vencimento;
	
	@NotNull(message = "Valor não pode ser nulo")
	@DecimalMin(value = "10", message = "Valor não pode ser menor que R$10,00" )
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal valor;
	
	@Enumerated(EnumType.STRING)
	private StatusBoleto status;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getVencimento() {
		return vencimento;
	}
	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public StatusBoleto getStatus() {
		return status;
	}
	public void setStatus(StatusBoleto status) {
		this.status = status;
	}
	public Integer getCodBoleto() {
		return codBoleto;
	}
	public void setCodBoleto(Integer codBoleto) {
		this.codBoleto = codBoleto;
	}
	
	public boolean isPendente() {
		return StatusBoleto.PENDENTE.equals(this.status); 
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codBoleto == null) ? 0 : codBoleto.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Boleto other = (Boleto) obj;
		if (codBoleto == null) {
			if (other.codBoleto != null)
				return false;
		} else if (!codBoleto.equals(other.codBoleto))
			return false;
		return true;
	}
	
	
}
