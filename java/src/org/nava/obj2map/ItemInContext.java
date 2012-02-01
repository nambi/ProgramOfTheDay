package org.nava.obj2map;

public class ItemInContext {
	private String name;
	private Long id;
	private Double value;

	public ItemInContext(Long id, String name, Double value) {
		this.id = id;
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String toString() {
		return "[ id :" + this.id + " , name :" + this.name + ", value:"
				+ this.value + "]";
	}
}
 

