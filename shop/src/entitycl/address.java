package entitycl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idaddress", updatable = false, nullable = false)
    private int idad;
	@Column(name="street")
	private String street;
	@Column(name="zipcode")
	private String zipcode;
	@Column(name="city")
	private String city;
	@Column(name="idu")
	private int idu;
	@ManyToOne
	@JoinColumn(name="idu", insertable = false, updatable = false)
	private user us;
	
	

	public address() {
		
	}
	
	public address(int id,String street,String zipcode,String city, int idu) {
		this.idad = id;
		this.street = street;
		this.zipcode = zipcode;
		this.city = city;
		this.idu = idu;
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getIdad() {
		return idad;
	}
	public void setIdad(int idad) {
		this.idad = idad;
	}
	public int getIdu() {
		return idu;
	}
	public void setIdu(int iduser) {
		this.idu = iduser;
	}

	public user getUs() {
		return us;
	}

	public void setUs(user us) {
		this.us = us;
	}
	
	@Override
	public String toString() {
		return "{\"idad\":" + idad + ",\"street\":\"" + street + "\",\"zipcode\":\"" + zipcode + "\", \"city\":\"" + city + "\",\"idu\":"
				+ idu + "}";
	}
	

}
