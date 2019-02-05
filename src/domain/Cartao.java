package domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cartao implements Serializable, AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer bandeiraId;
	private Integer tipoTransacaoId;
	private Date dtTransacao;
	private Date dtUltStatus;
	private String meioCaptura;
	private String stoneId;
	private BigDecimal vlrBruto;
	private BigDecimal vlrLiquido;
	private String nrCartao;
	private Integer serialNember;
	private String ultStatus;

	public Cartao(Integer id, Integer bandeiraId, Integer tipoTransacaoId, Date dtTransacao, Date dtUltStatus,
			String meioCaptura, String stoneId, BigDecimal vlrBruto, BigDecimal vlrLiquido, String nrCartao,
			Integer serialNember, String ultStatus) {
		this.id = id;
		this.bandeiraId = bandeiraId;
		this.tipoTransacaoId = tipoTransacaoId;
		this.dtTransacao = dtTransacao;
		this.dtUltStatus = dtUltStatus;
		this.meioCaptura = meioCaptura;
		this.stoneId = stoneId;
		this.vlrBruto = vlrBruto;
		this.vlrLiquido = vlrLiquido;
		this.nrCartao = nrCartao;
		this.serialNember = serialNember;
		this.ultStatus = ultStatus;
	}

	public Cartao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bandeira getBandeira() {
		return Bandeira.toEnum(bandeiraId);
	}

	public TipoTransacao getTipoTransacao() {
		return TipoTransacao.toEnum(tipoTransacaoId);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBandeiraId() {
		return bandeiraId;
	}

	public void setBandeiraId(Integer bandeiraId) {
		this.bandeiraId = bandeiraId;
	}

	public Integer getTipoTransacaoId() {
		return tipoTransacaoId;
	}

	public void setTipoTransacaoId(Integer tipoTransacaoId) {
		this.tipoTransacaoId = tipoTransacaoId;
	}

	public Date getDtTransacao() {
		return dtTransacao;
	}

	public void setDtTransacao(Date dtTransacao) {
		this.dtTransacao = dtTransacao;
	}

	public Date getDtUltStatus() {
		return dtUltStatus;
	}

	public void setDtUltStatus(Date dtUltStatus) {
		this.dtUltStatus = dtUltStatus;
	}

	public String getMeioCaptura() {
		return meioCaptura;
	}

	public void setMeioCaptura(String meioCaptura) {
		this.meioCaptura = meioCaptura;
	}

	public String getStoneId() {
		return stoneId;
	}

	public void setStoneId(String stoneId) {
		this.stoneId = stoneId;
	}

	public BigDecimal getVlrBruto() {
		return vlrBruto;
	}

	public void setVlrBruto(BigDecimal vlrBruto) {
		this.vlrBruto = vlrBruto;
	}

	public BigDecimal getVlrLiquido() {
		return vlrLiquido;
	}

	public void setVlrLiquido(BigDecimal vlrLiquido) {
		this.vlrLiquido = vlrLiquido;
	}

	public String getNrCartao() {
		return nrCartao;
	}

	public void setNrCartao(String nrCartao) {
		this.nrCartao = nrCartao;
	}

	public Integer getSerialNember() {
		return serialNember;
	}

	public void setSerialNember(Integer serialNember) {
		this.serialNember = serialNember;
	}

	public String getUltStatus() {
		return ultStatus;
	}

	public void setUltStatus(String ultStatus) {
		this.ultStatus = ultStatus;
	}

	@Override
	public String toString() {
		return "Cartao [id=" + id + ", bandeiraId=" + bandeiraId + ", tipoTransacaoId=" + tipoTransacaoId
				+ ", dtTransacao=" + dtTransacao + ", dtUltStatus=" + dtUltStatus + ", meioCaptura=" + meioCaptura
				+ ", stoneId=" + stoneId + ", vlrBruto=" + vlrBruto + ", vlrLiquido=" + vlrLiquido + ", nrCartao="
				+ nrCartao + ", serialNember=" + serialNember + ", ultStatus=" + ultStatus + "]";
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
		Cartao other = (Cartao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
