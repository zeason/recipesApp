package com.codecheck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codecheck.json.JsonManager;
import com.codecheck.json.form.JsonForm;
import com.codecheck.service.RecipeService;

@RestController
public class RecipesController {

	@Autowired
	RecipeService service;

	@RequestMapping(value = "/recipes", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String postRecipes(@RequestBody JsonForm recipes) {
		if (recipes.getRecipes().stream().anyMatch(r -> {
			if (StringUtils.isEmpty(r.getTitle()) || StringUtils.isEmpty(r.getMakingTime())
					|| StringUtils.isEmpty(r.getServes()) || StringUtils.isEmpty(r.getIngredients())
					|| null == r.getCost())
				return true;
			return false;
		})) {
			recipes.setMessage("Recipe creation failed!");
			recipes.setRequired("title, making_time, serves, ingredients, cost");
		} else {
			service.addRecipes(recipes);
			recipes.setMessage("Recipe successfully created!");
		}
		return JsonManager.toJson(recipes);
	}

	@RequestMapping(value = "/recipes", method = RequestMethod.GET)
	public String getRecipes() {
		return JsonManager.toJson(service.getRecipes(null));
	}

	@RequestMapping(value = "/recipes/{id}", method = RequestMethod.GET)
	public String getRecipe(@PathVariable Integer id) {
		JsonForm form = new JsonForm();
		form.setMessage("Recipe details by id");
		form.setRecipes(service.getRecipes(id));
		return JsonManager.toJson(form);
	}

	@RequestMapping(value = "/recipes/{id}", method = RequestMethod.PATCH)
	public String patchRecipe(@PathVariable Integer id, @RequestBody JsonForm recipe) {
		if (recipe.getRecipes() == null || recipe.getRecipes().size() < 1) {
			recipe.setMessage("recipe requeired");
		} else {
			boolean result = service.updateRecipe(id, recipe.getRecipes().get(0));
			if (result == true)
				recipe.setMessage("Recipe successfully updated!");
			else
				recipe.setMessage("No Recipe found");
		}
		return JsonManager.toJson(recipe);
	}

	@RequestMapping(value = "/recipes/{id}", method = RequestMethod.DELETE)
	public String deleteRecipe(@PathVariable Integer id) {
		boolean result = service.deleteRecipe(id);
		JsonForm form = new JsonForm();
		if (result == true)
			form.setMessage("Recipe successfully removed!");
		else
			form.setMessage("No Recipe found");
		return JsonManager.toJson(form);
	}
}
