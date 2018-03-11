package com.codecheck.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.codecheck.bean.Recipe;

public interface RecipeMapper {
	public void bulkInsert(List<Recipe> list);

	public List<Recipe> findRecipes(@Param("id") Integer id);

	public void updateRecipe(@Param("bean") Recipe bean);

	public void deleteRecipe(@Param("id") Integer id);
}
