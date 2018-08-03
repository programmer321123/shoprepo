package entitycl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cartandorders")
public class cartandorders {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "idcartao", updatable = false, nullable = false)
 private int id;
@Column(name = "idwho")
 private int idwho;
@Column(name = "date")
 private int date;
@Column(name = "pstate")
private int pstate;

@Column(name = "dadid")
private Integer dadid;

@OneToMany(mappedBy="cto", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
private List<productcount> lpro = new ArrayList<productcount>();

@OneToOne
@JoinColumn(name = "dadid", insertable = false, updatable = false)
private address delad;

/*status
 * 1 incart
 * 2 waitng
 * 3 sent
 */
public cartandorders() {
	 
 }
 
 public cartandorders(int idwho,int date,int state) {
	 this.idwho = idwho;
	 this.date = date;
	 this.pstate = state;
 }
 
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public int getIdwho() {
	return idwho;
}
public void setIdwho(int idwho) {
	this.idwho = idwho;
}

public int getDate() {
	return date;
}

public void setDate(int date) {
	this.date = date;
}

public int getPstate() {
	return pstate;
}

public void setPstate(int pstate) {
	this.pstate = pstate;
}

public Integer getDadid() {
	return dadid;
}

public void setDadid(int dadid) {
	this.dadid = dadid;
}


public List<productcount> getLpro() {
	return lpro;
}

public void setLpro(List<productcount> lpro) {
	this.lpro = lpro;
}

public address getDelad() {
	return delad;
}

public void setDelad(address delad) {
	this.delad = delad;
}

public int idodpc(int proid) {
 for(productcount pc : lpro) {
	 if(pc.getIdpro()==proid)return pc.getIdpc();
 }
 return 0;
}

 public productcount findpc(int pid) {
	 for(productcount pc : lpro) {
		 if(pc.getIdpro()==pid)return pc;
	 }
	 return null;
 }


}
