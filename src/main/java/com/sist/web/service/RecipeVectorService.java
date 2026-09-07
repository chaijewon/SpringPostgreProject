package com.sist.web.service;

import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.stereotype.Service;

import com.sist.web.mapper.oracle.OracleRecipeMapper;
import com.sist.web.mapper.postgres.PostgresRecipeMapper;

import lombok.RequiredArgsConstructor;
import java.util.*;
import com.sist.web.vo.*;
@Service
@RequiredArgsConstructor
public class RecipeVectorService {
    private final PostgresRecipeMapper pMapper;
    private final OracleRecipeMapper oMapper;
    private final EmbeddingModel model;
    
    public void recipeVectorInsert() {
    	List<RecipeVO> list=
    			  oMapper.oracleRecipeAllData();
    	System.out.println("recipe데이터:"+list.size());
    	
    	for(RecipeVO recipe:list)
    	{
    		  // 검색용 문서 생성
            String content =
                    createContent(recipe);

            // Spring AI Embedding
            float[] vector =
                    model.embed(content);

            // float[] → PostgreSQL vector 문자열
            String embedding =
                    convertVector(vector);


            // Vector VO
            RecipeVectorVO vo =
                    RecipeVectorVO.builder()
                        .recipe_id(
                            (long) recipe.getRcp_seq()
                        )
                        .content(content)
                        .embedding(embedding)
                        .build();


            // PostgreSQL recipe_vector 저장
            pMapper.recipeVectorInsert(vo);


            System.out.println(
                "Vector 저장 : "
                + recipe.getRcp_seq()
                + " / "
                + recipe.getRcp_nm()
            );
        }


        System.out.println(
            "================================="
        );

        System.out.println(
            "Recipe Vector 생성 완료"
        );

        System.out.println(
            "================================="
        );
    	
    }
    private String createContent(RecipeVO vo)
    {
    	return """
    			레시피명: %s
    			조리방법: %s
    			요리종류: %s
    			영양정보: %s kcal
    			탄수화물: %s
    			단백질: %s
    			지방: %s 
    			나트륨: %s
    			해시태그 : %s
    			주재료: %s
    			조리정보: %s
    			요리팁: %s
    		   """.formatted(
    			  vo.getRcp_nm(),
    			  vo.getRcp_way2(),
    			  vo.getRcp_pat2(),
    			  vo.getInfo_eng(),
    			  vo.getInfo_car(),
    			  vo.getInfo_pro(),
    			  vo.getInfo_fat(),
    			  vo.getInfo_na(),
    			  vo.getHash_tag(),
    			  vo.getRcp_parts_dtls(),
    			  vo.getAtt_file_no_mk(),
    			  vo.getRcp_na_tip()
    		   );
    }
    private String convertVector(float[] vector)
    {
    	  StringBuilder sb =
                  new StringBuilder("[");
          for (int i = 0; i < vector.length; i++) {

              if (i > 0) {
                  sb.append(",");

              }

              sb.append(vector[i]);
          }
          sb.append("]");
          return sb.toString();
    }
}
