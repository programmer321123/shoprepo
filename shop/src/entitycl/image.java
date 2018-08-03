package entitycl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pimages")
public class image {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "idpimages", updatable = false, nullable = false)
private int id;
@Column(name="image")
private String imageins;
@Column(name="productid")
private int pid;

public image() {
	
}
public image(String im,int idp) {
	this.setImageins(im);
	this.setPid(idp);
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getImageins() {
	return imageins;
}
public void setImageins(String imageins) {
	this.imageins = imageins;
}
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}



}
