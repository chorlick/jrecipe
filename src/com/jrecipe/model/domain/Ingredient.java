package com.jrecipe.model.domain;

import java.io.Serializable;

/**
 * Ingredient represents a single ingredient used in
 * a {@link Recipe}. It holds information about the name 
 * of the ingredient, the unit of measurements, and the actual
 * measurement.
 * 
 * @author Chris Horlick
 * @version 0.0.1
 * @since 0.0.1
 */
public class Ingredient implements Serializable {
    		
    /**
	 * private unique id for Serializable class.
	 */
	private static final long serialVersionUID = -5336064785973347525L;

	private Integer id;
    
    private String name;
    
    private String unit;
    
    private String value;
    
    /**
     * Public void constructor for Ingredient.
     */
    public Ingredient() { }
    
    /**
     * Public constructor that accepts all of the fields of the 
     * class as arguments.
     * 
     * @param uid unique identifier for object
     * @param name text description of the ingredient
     * @param unit unit of measurement for ingredient
     * @param value actual measurement for the ingredient
     */
    public Ingredient(Integer uid, String name, String unit, String value) {
		super();
		this.id = uid;
		this.name = name;
		this.unit = unit;
		this.value = value;
	}

	/**
	 * @return returns the id
	 */
	public Integer getId() { return id; }
    
    /**
     * UID setter for Ingredient
     * {@link Ingredient#id}
     * 
     * @param id
     */
    public void setUid(Integer id) { this.id = id; }
    
    /**
     * Getter for ingredient description
     * 
     * @return String Description of ingredient
     */
    public String getName() { return name; }
    
    /**
     * Name setter for Ingredient
     * {@link Ingredient#name}
     * 
     * @param name
     */
    public void setName(String name) { this.name = name; }
    
    /**
     * Getter for Ingredient units
     * 
     * @return String units of ingredient measurement
     */
    public String getUnit() { return unit; }
    
    /**
     * Unit setter for Ingredient
     * {@link Ingredient#unit}
     * 
     * @param unit String text description of unit
     */
    public void setUnit(String unit ) {this.unit = unit; }
    
    /**
     * Returns the Ingredient measurement value
     * 
     * @return String measurement value
     */
    public String getValue() { return value; }
    
    /**
     * Setter for measurement value
     * {@link Ingredient#value}
     * 
     * @param value String measurement value
     */
    public void setValue(String value) { this.value = value; }
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		Ingredient other = (Ingredient) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (unit == null) {
			if (other.unit != null)
				return false;
		} else if (!unit.equals(other.unit))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", name=" + name + ", unit=" + unit + ", value=" + value + "]";
	}
	
	/**
	 * Validate if the instance variables are valid
	 * 
	 * @return boolean - true if instance variables are valid, else false
	 */
	public Boolean validate() {
		if(this.getId() == null || this.getId() < 0) return  false;
		if(this.getName().length() == 0) return false;
		if(this.getUnit().length() == 0) return false;
		if(this.getValue().length() == 0) return false;
		return true;
			
	}
}