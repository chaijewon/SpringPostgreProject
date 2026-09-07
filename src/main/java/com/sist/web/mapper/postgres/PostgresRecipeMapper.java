package com.sist.web.mapper.postgres;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.sist.web.vo.*;
@Mapper
public interface PostgresRecipeMapper {
   /*
    *   <insert id="postgresRecipeInsert" 
        parameterType="com.sist.web.vo.RecipeVO">
    */
	public void postgresRecipeInsert(RecipeVO vo);
}
