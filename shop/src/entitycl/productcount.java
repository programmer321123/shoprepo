package entitycl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productcount")
public class productcount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idpc", updatable = false, nullable = false)
	private int idpc;
	@Column(name = "count")
	private int count;
	@Column(name="idcartao")
	private int idcartao;
	@Column(name = "idpro")
	private int idpro;
	@OneToOne
	@JoinColumn(name = "idpro", insertable = false, updatable = false)
	private product product;
	@ManyToOne
	@JoinColumn(name="idcartao", insertable = false, updatable = false)
	private cartandorders cto;
	
	

	
	public productcount() {
		
	}
	
	public productcount(int count,int idpro,int idcartao) {
		this.count = count;
		this.idpro = idpro;
		this.idcartao = idcartao;
		
	}
	
	
	public int getIdpc() {
		return idpc;
	}

	public void setIdpc(int idpc) {
		this.idpc = idpc;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getIdcartao() {
		return idcartao;
	}

	public void setIdcartao(int idcartao) {
		this.idcartao = idcartao;
	}

	public int getIdpro() {
		return idpro;
	}

	public void setIdpro(int idpro) {
		this.idpro = idpro;
	}

	public product getProduct() {
		return product;
	}

	public void setProduct(product product) {
		this.product = product;
	}
	public cartandorders getCt() {
		return cto;
	}

	public void setCt(cartandorders ct) {
		this.cto = ct;
	}
	


}
