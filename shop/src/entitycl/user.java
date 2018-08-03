package entitycl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class user {
	@Id
    @Column(name="idusers")
	private int id;
	 @Column(name="login")
	private String login;
	 @Column(name="password")
	private String password;
	 @Column(name = "name")
	 private String name;
	 @Column(name = "surname")
	 private String surname;
	 @Column(name = "phonenumber")
	 private String phonenumber;
	 @Column(name = "mail")
	 private String mail;
	 @Column(name="type")
	private String type;
	 @OneToMany(mappedBy="us", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	 private List<address> lad = new ArrayList<address>();
	 

	
	public user() {
		 
	 }
	 public user(String lo,String pas,String name,String surname,String phonenumber,String mail,String type) {
		 this.login = lo;
		 this.password = pas;
		 this.type = type;
		 this.name=name;
		 this.surname = surname;
		 this.phonenumber = phonenumber;
		 this.mail = mail;
	 }
	 public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public int getId() {
		 return this.id;
	 }
	 public void setId(int id) {
		 this.id = id;
	 }
	 
	 public String getLogin() {
		 return this.login;
	 }
	 public void setLogin(String l) {
		 this.login = l;
	 }
	 public String getPassword() {
		 return this.password;
	 }
	 public void setPassword(String p) {
		 this.password = p;
	 }
	 public String getType() {
		 return this.type;
	 }
	 public void setType(String t) {
		 this.type = t;
	 }
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
    public List<address> getLad() {
	    return lad;
	}
	public void setLad(List<address> lad) {
		this.lad = lad;
	}
	@Override
	public String toString() {
		return "{\"id\":" + id + ",\"login\":\"" + login + "\", \"name\":\"" + name + "\", \"surname\":\"" + surname + "\",\"phonenumber\":\""
				+ phonenumber + "\", \"mail\":\"" + mail + "\", \"type\":\"" + type + "\"}";
	}	
		

}
