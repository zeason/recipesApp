package com.codecheck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codecheck.bean.Recipe;
import com.codecheck.json.form.JsonForm;
import com.codecheck.mapper.RecipeMapper;

@Service
public class RecipeService {

	@Autowired
	RecipeMapper mapper;

	public void addRecipes(JsonForm recipes) {
		mapper.bulkInsert(recipes.getRecipes());
		return;
	}

	public List<Recipe> getRecipes(Integer id) {
		return mapper.findRecipes(id);
	}

	public boolean updateRecipe(Integer id, Recipe recipe) {
		recipe.setId(id);
		if (mapper.findRecipes(id).size() > 0)
			mapper.updateRecipe(recipe);
		else
			return false;
		return true;
	}

	public boolean deleteRecipe(Integer id) {
		if (mapper.findRecipes(id).size() > 0)
			mapper.deleteRecipe(id);
		else
			return false;
		return true;
	}
}
