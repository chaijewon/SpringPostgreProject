package com.sist.web.mapper.postgres;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.sist.web.vo.*;
// AI / Next 
@Mapper
public interface PostgresRecipeMapper {
   /*
    *   <insert id="postgresRecipeInsert" 
        parameterType="com.sist.web.vo.RecipeVO">
    */
	public void postgresRecipeInsert(RecipeVO vo);
	/*
	 *  <insert id="recipeVectorInsert" 
	 *  parameterType="com.sist.web.vo.RecipeVectorVO">
	 */
	public void recipeVectorInsert(RecipeVectorVO vo);
}
