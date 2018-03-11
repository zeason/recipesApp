package com.codecheck.json.form;

import java.io.Serializable;
import java.util.List;

import com.codecheck.bean.Recipe;

public class JsonForm implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9201990951469054424L;
	private String message;
	private String required;
	private List<Recipe> recipes;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRequired() {
		return required;
	}

	public void setRequired(String required) {
		this.required = required;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

}
