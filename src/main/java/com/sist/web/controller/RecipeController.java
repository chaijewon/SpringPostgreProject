package com.sist.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.service.RecipeService;

import lombok.RequiredArgsConstructor;
import com.sist.web.vo.*;
@RestController
@RequiredArgsConstructor
public class RecipeController {
   private final RecipeService rs;
   @GetMapping("/recipe")
   public String recipe_insert()
   {
	   rs.recipeInsert();
	   return "데이터 저장 완료";
   }
}
