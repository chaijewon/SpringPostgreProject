package com.sist.web.mapper.postgres;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.sist.web.vo.*;
// AI / Next 
/** * ============================================================ 
 * * PostgreSQL Recipe Mapper * 
 * ============================================================ 
 * * * PostgreSQL + pgVector에서 
 * * 레시피의 embedding과 검색 embedding을 비교한다. 
 * * 
 * * pgVector 연산자 * * <=> * * Cosine distance를 계산한다. 
 * * * 값이 작을수록 더 유사하다. * * 
 * 따라서 * * ORDER BY embedding <=> 
 * 검색벡터 * * 를 사용하면 가장 유사한 레시피부터 가져올 수 있다. 
 * * ============================================================ */
import java.util.*;
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
	
	/** * ======================================================== * pgVector 유사 레시피 검색 * ======================================================== * 
	 * * @param embedding 검색용 embedding * @param limit 가져올 레시피 개수 * 
	 * * @return 유사 레시피 목록 
	 * */ 
	public List<Map<String, Object>> findSimilarRecipes( 
			@Param("embedding") String embedding, 
			@Param("limit") int limit );
}
