package com.sist.web.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import com.sist.web.vo.*;
import java.util.*;
import com.sist.web.mapper.*;
import com.sist.web.mapper.oracle.OracleRecipeMapper;
import com.sist.web.mapper.postgres.PostgresRecipeMapper;
@Service
@RequiredArgsConstructor
public class RecipeService {
   private final OracleRecipeMapper oMapper;
   private final PostgresRecipeMapper pMapper;
   
   public void recipeInsert()
   {
	   List<RecipeVO> list=
			   oMapper.oracleRecipeAllData();
	   for(RecipeVO vo:list)
	   {
		   pMapper.postgresRecipeInsert(vo);
	   }
   }
   //RecipeVector 
}
