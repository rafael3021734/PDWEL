package model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "contascomuns")
public class ContaComum implements Serializable
{
	/* ATRIBUTOS */
	
	private static final long serialVersionUID = 1l;
	
	@Id
	@Column(name = "numeroconta")
	protected long numeroConta;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "aberturaconta", nullable = false)
	protected Calendar aberturaConta;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fechamentoconta")
	protected Calendar fechamentoConta;
	
	@Column(name = "situacaoconta")
	protected int situacaoConta;
	
	@Column(name = "senhaconta")
	protected int senhaConta;
	
	@Column(name = "saldoconta")
	protected double saldoConta;
	
	// FetchType.LAZY -> Diz ao provedor de persist?ncia para n?o buscar as entidades associadas no banco de dados at? que elas sejam necess?rias.
	@ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	@JoinTable(name = "pessoas_contascomuns", joinColumns = { @JoinColumn(name = "numeroconta", referencedColumnName = "numeroconta") }, 
    inverseJoinColumns = { @JoinColumn(name = "idpessoa", referencedColumnName = "id") })
	protected Set<Pessoa> pessoas;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "contaMovimento", fetch = FetchType.LAZY)
	protected Set<Movimento> movimentosConta;
	
	/* CONSTRUTORES */
	
	public ContaComum()
	{
		this.pessoas = new HashSet<Pessoa>();
		this.movimentosConta = new HashSet<Movimento>();
	}
	
	public ContaComum(long numeroConta, Calendar aberturaConta, Calendar fechamentoConta, int situacaoConta,
			int senhaConta, double saldoConta)
	{
		this.numeroConta = numeroConta;
		this.aberturaConta = aberturaConta;
		this.fechamentoConta = fechamentoConta;
		this.situacaoConta = situacaoConta;
		this.senhaConta = senhaConta;
		this.saldoConta = saldoConta;
		this.pessoas = new HashSet<Pessoa>();
		this.movimentosConta = new HashSet<Movimento>();
	}

	/* GETTERS AND SETTERS */
	
	public long getNumeroConta()
	{
		return numeroConta;
	}
	
	public void setNumeroConta(long numeroConta)
	{
		this.numeroConta = numeroConta;
	}
	
	public Calendar getAberturaConta()
	{
		return aberturaConta;
	}
	
	public void setAberturaConta(Calendar aberturaConta)
	{
		this.aberturaConta = aberturaConta;
	}
	
	public Calendar getFechamentoConta()
	{
		return fechamentoConta;
	}
	
	public void setFechamentoConta(Calendar fechamentoConta)
	{
		this.fechamentoConta = fechamentoConta;
	}
	
	public int getSituacaoConta()
	{
		return situacaoConta;
	}
	
	public void setSituacaoConta(int situacaoConta)
	{
		this.situacaoConta = situacaoConta;
	}
	
	public int getSenhaConta()
	{
		return senhaConta;
	}
	
	public void setSenhaConta(int senhaConta)
	{
		this.senhaConta = senhaConta;
	}
	
	public double getSaldoConta()
	{
		return saldoConta;
	}
	
	public void setSaldoConta(double saldoConta)
	{
		this.saldoConta = saldoConta;
	}
	
	public Set<Movimento> getMovimentosConta()
	{
		return movimentosConta;
	}

	public void setMovimentosConta(Set<Movimento> movimentosConta)
	{
		this.movimentosConta = movimentosConta;
	}
	
	public Set<Pessoa> getPessoas()
	{
		return pessoas;
	}

	public void setPessoas(Set<Pessoa> pessoas)
	{
		this.pessoas = pessoas;
	}
}
