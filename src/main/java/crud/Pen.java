package crud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pen {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int pen_id;

	@Column
	private String name;

	@Column
	private String color;

	public int getPen_id() {
		return pen_id;
	}

	public void setPen_id(int pen_id) {
		this.pen_id = pen_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "Pen [pen_id=" + pen_id + ", name=" + name + ", color=" + color + "]";
	}

}
