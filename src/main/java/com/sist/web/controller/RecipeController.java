package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.service.RecipeService;
import com.sist.web.service.RecipeVectorService;

import lombok.RequiredArgsConstructor;
import com.sist.web.vo.*;
@RestController
@RequiredArgsConstructor

public class RecipeController {
   
   private final RecipeService rs;

   private final RecipeVectorService ss;
   @GetMapping("/recipe")
   public String recipe_insert()
   {
	   rs.recipeInsert();
	   return "데이터 저장 완료";
   }
   @GetMapping("/vector")
   public String recipe_vector()
   {
	   ss.recipeVectorInsert();
	   return "데이터 저장 완료";
   }
}
