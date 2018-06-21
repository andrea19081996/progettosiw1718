package apicella.bersani.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Attivita {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String nome;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date data;

	@DateTimeFormat(pattern="HH:mm")
	@Temporal(TemporalType.TIME)
	@Column(nullable=false)
	private Date orario;

	@ManyToMany(cascade= {CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Allievo> allievi;
	
	@ManyToOne
	private Centro centro;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getOrario() {
		return orario;
	}

	public void setOrario(Date orario) {
		this.orario = orario;
	}

	public Centro getCentro() {
		return centro;
	}

	public void setCentro(Centro centro) {
		this.centro = centro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public List<Allievo> getAllievi() {
		return allievi;
	}

	public void setAllievi(List<Allievo> allievi) {
		this.allievi = allievi;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((allievi == null) ? 0 : allievi.hashCode());
		result = prime * result + ((centro == null) ? 0 : centro.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((orario == null) ? 0 : orario.hashCode());
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
		Attivita other = (Attivita) obj;
		if (allievi == null) {
			if (other.allievi != null)
				return false;
		} else if (!allievi.equals(other.allievi))
			return false;
		if (centro == null) {
			if (other.centro != null)
				return false;
		} else if (!centro.equals(other.centro))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (orario == null) {
			if (other.orario != null)
				return false;
		} else if (!orario.equals(other.orario))
			return false;
		return true;
	}
	
	
}
