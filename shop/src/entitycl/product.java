package entitycl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="products")
public class product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idproduct", updatable = false, nullable = false)
     private int id;
	 @Column(name="name")
	private String name;
	 @Column(name="description")
	private String description;
	 @Column(name="price")
	private double price;
	 @Column(name="imgcount")
	 private int imgcount;
	 @Column(name="category")
	 private String category;
	 @Column(name = "ifactive")
		private int ifactive;
		@Transient
		private int count;
	
	
	public product() {
		 
	 }
	 public product(int id,String name,String description,double price,int imc,String category,int ifa) {
		this.id = id;
		 this.name = name;
		this.description = description;
		this.price = price;
		this.imgcount = imc;
		this.category=category;
		this.ifactive = ifa;
	 }
	 public int getId() {
		 return this.id;
	 }
	 public void setId(int i) {
		 this.id=i;
	 }
	 
	 public String getName() {
		 return this.name;
	 }
	 public void setName(String name) {
		 this.name = name;
	 }
	 public String getDescription() {
		 return this.description;
	 }
	 public void setDescription(String d) {
		 this.description = d;
	 }
	 public double getPrice() {
		 return this.price;
	 }
	 public void setPrice(double price) {
		 this.price = price;
	 }
	 public int getImgcount() {
		 return this.imgcount;
	 }
	 public void setImgcount(int c) {
		 this.imgcount = c;
	 }
	 public String getCategory() {
		 return this.category;
	 }
	 
	 public void setCategory(String c) {
		 this.category = c;
	 }
	 public int getpCount() {
			return count;
		}
	public void setpCount(int count) {
			this.count = count;
		}
	public int getIfactive() {
		return ifactive;
	}

	public void setIfactive(int ifactive) {
		this.ifactive = ifactive;
	}
		
		
	
		public String toJson(int count) {
			return "{\"id\":" + id + ",\"name\":\"" + name + "\",\"description\":\"" + description + "\",\"price\":\"" + price
					+ "\", \"imgcount\":" + imgcount + ",\"category\":\"" + category + "\",\"count\":"+count+ ",\"active\":"+ifactive+"}";
		}
	 
	 

}
