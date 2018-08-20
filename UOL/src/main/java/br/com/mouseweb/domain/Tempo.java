package br.com.mouseweb.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tempo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@JsonSerialize(using = DateSerializer.class)
	@Column(name = "min_temp")
	private String min_temp;
	
	@JsonSerialize(using = DateSerializer.class)
	@Column(name = "max_temp")
	private String max_temp;
	
	@ManyToMany
	@JoinTable(name = "CLIENTE_TEMPO", 
			joinColumns = @JoinColumn(name = "tempo_id"),
			inverseJoinColumns = @JoinColumn(name = "cliente_id"))
	private List<Cliente> cliente = new ArrayList<>();

	public Tempo() {
		
	}
	
	public Tempo(Integer id, String min_temp, String max_temp) {
		super();
		this.id = id;
		this.min_temp = min_temp;
		this.max_temp = max_temp;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public List<Cliente> getCliente() {
		return cliente;
	}

	public void setCliente(List<Cliente> cliente) {
		this.cliente = cliente;
	}

	public String getMin_temp() {
		return min_temp;
	}

	public void setMin_temp(String min_temp) {
		this.min_temp = min_temp;
	}

	public String getMax_temp() {
		return max_temp;
	}

	public void setMax_temp(String max_temp) {
		this.max_temp = max_temp;
	}

	@Override
	public String toString() {
		return "Tempo [id=" + id + ", min_temp=" + min_temp + ", max_temp=" + max_temp + "]";
	}
	
}
