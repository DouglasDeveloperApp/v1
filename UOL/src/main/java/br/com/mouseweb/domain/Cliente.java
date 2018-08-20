package br.com.mouseweb.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import br.com.mouseweb.enums.TipoCliente;

@Entity
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Integer idade;
	private Integer tipo;

	@OneToMany(mappedBy="cliente")
	private List<LocalizacaoIpv4> localizacaoIpv4s = new ArrayList<>();
	
	@OneToMany(mappedBy="cliente")
	private List<Tempo> tempos = new ArrayList<>();
	
	public Cliente() {
		
	}
	
	public Cliente(Integer id, String nome, Integer idade, TipoCliente tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.tipo = tipo.getCod();
	}
	
	public List<LocalizacaoIpv4> getLocalizacaoIpv4s() {
		return localizacaoIpv4s;
	}

	public void setLocalizacaoIpv4s(List<LocalizacaoIpv4> localizacaoIpv4s) {
		this.localizacaoIpv4s = localizacaoIpv4s;
	}

	public List<Tempo> getTempos() {
		return tempos;
	}

	public void setTempos(List<Tempo> tempos) {
		this.tempos = tempos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	public TipoCliente getTipo() {
		return TipoCliente.toEnum(tipo);
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo.getCod();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
