package com.sist.web.mapper.oracle;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.web.vo.*;
@Mapper
public interface OracleRecipeMapper {
    /*
     *   <select id="oracleRecipeAllData" resultType="com.sist.web.vo.RecipeVO">
		    SELECT * 
		    FROM recipe
		    ORDER BY rcp_seq
		  </select>
     */
	public List<RecipeVO> oracleRecipeAllData();
}
