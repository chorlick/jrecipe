package com.jrecipe.model.domain;
import java.io.Serializable;

/**
 * The RecipeStep represents an individual step
 * in a greater {@link Recipe}. 
 * 
 * @author Chris Horlick
 * @version 0.0.1
 * @since 0.0.1
 */
public class RecipeStep implements Serializable {
	
    /**
	 * private unique id for Serializable class.
	 */
	private static final long serialVersionUID = -4640726823274534903L;

	/* unique id of the object */
	private Integer uid;
	
	/* display text for this object */
	private String text;
	
	/* index value of the step, used to help with order */
	private Integer step;

	/**
	 * Returns the private id of the object.
	 * 
	 * @return Integer Id of object.
	 */
	public Integer getUid() {
		return uid;
	}

	/**
	 * Sets the value of the id. 
	 * 
	 * @param uid Integer {@link RecipeStep#uid}
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}

	/**
	 * Returns the value textual description of the step.
	 * 
	 * @return String the value of the step.
	 */
	public String getText() {
		return text;
	}

	/**
	 * Used to set the text description of the step. 
	 * 
	 * @param text String the actual text displayed to the user. 
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Returns the step number associated with this step.
	 * 
	 * @return Integer step number associated with this step. 
	 */
	public Integer getStep() {
		return step;
	}

	/**
	 * Sets the step number of this step. 
	 * 
	 * @param step
	 */
	public void setStep(Integer step) {
		this.step = step;
	}

	/** 
	 * Hashcode for class. 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((step == null) ? 0 : step.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
		return result;
	}

	/** 
	 * The equals method for this object
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecipeStep other = (RecipeStep) obj;
		if (step == null) {
			if (other.step != null)
				return false;
		} else if (!step.equals(other.step))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		return true;
	}

	/**
	 *  Used to print the object to a string format
	 */
	@Override
	public String toString() {
		return "RecipeStep [uid=" + uid + ", text=" + text + ", step=" + step + "]";
	}
	
	/**
	 * Validate if the instance variables are valid
	 * 
	 * @return boolean - true if instance variables are valid, else false
	 */
	public Boolean validate() {
		if(this.getUid() == null || this.getUid() < 0) return  false;
		if(this.getStep() < 0) return false;
		if(this.getText().length() == 0) return false;
		
		return true;
			
	}
}