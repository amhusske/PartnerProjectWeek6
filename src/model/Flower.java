package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="flowers")
public class Flower {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="FLOWER_NAME")
	private String flowerName;
	
	
	@Column(name="COLORS")
	private String colors;
	
	
		public Flower() {
		super();
		// TODO Auto-generated constructor stub
	}


		public Flower(int id, String flowerName, String colors) {
			super();
			this.id = id;
			this.flowerName = flowerName;
			this.colors = colors;
		}


		public Flower(String flowerName, String colors) {
			super();
			this.flowerName = flowerName;
			this.colors = colors;
		}

		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getFlowerName() {
			return flowerName;
		}


		public void setFlowerName(String flowerName) {
			this.flowerName = flowerName;
		}

		public String getColors() {
			return colors;
		}


		public void setColors(String colors) {
			this.colors = colors;
		}


		@Override
		public String toString() {
			return "Flower [flowerName=" + flowerName + ", colors=" + colors + "]";
		}
	}


