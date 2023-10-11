package recipe;

import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface RecipeDao {
    //레시피 번호로 검색
    @Select("Select * from \"Recipe\" where \"recipeId\"=#{recipeId}")
    Recipe select(@Param("recipeId") int recipeId);

    //레시피 전체 목록 출력
    @Select("Select * from \"Recipe\"")
    ArrayList<Recipe> selectAll();

    //요리제목으로 검색
    @Select("Select * from \"Recipe\" where \"title\" like '%'||#{title}||'%'")
    ArrayList<Recipe> selectByTitle(@Param("title") String title);

    //재료정보로 검색
    //jdbcType=VARCHAR을 사용하여 데이터베이스 컬럼과 파라미터의 데이터 유형을 일치
    @Select("Select * from \"Recipe\" where \"ingredientInfo\" like '%'||#{ingredientInfo, jdbcType=VARCHAR}||'%'")
    ArrayList<Recipe> selectByIngredientInfo(@Param("ingredientInfo") String ingredientInfo);


    // 선호도 증가
    @Update("MERGE INTO \"RecipePreference\" rp\n" +
            "USING (SELECT #{recipeId} AS \"recipeId\", #{under_20} AS \"under_20\", #{over_20} AS \"over_20\", #{over_30} AS \"over_30\", #{over_40} AS \"over_40\", #{over_50} AS \"over_50\", #{male} AS \"male\", #{female} AS \"female\", #{hits} AS \"hits\" FROM dual) new_rp\n" +
            "ON (rp.\"recipeId\" = new_rp.\"recipeId\")\n" +
            "WHEN MATCHED THEN\n" +
            "    UPDATE SET rp.\"under_20\" = rp.\"under_20\" + new_rp.\"under_20\",\n" +
            "        rp.\"over_20\" = rp.\"over_20\" + new_rp.\"over_20\",\n" +
            "        rp.\"over_30\" = rp.\"over_30\" + new_rp.\"over_30\",\n" +
            "        rp.\"over_40\" = rp.\"over_40\" + new_rp.\"over_40\",\n" +
            "        rp.\"over_50\" = rp.\"over_50\" + new_rp.\"over_50\",\n" +
            "        rp.\"male\" = rp.\"male\" + new_rp.\"male\",\n" +
            "        rp.\"female\" = rp.\"female\" + new_rp.\"female\",\n" +
            "        rp.\"hits\" = rp.\"hits\" + 1" +
            "WHEN NOT MATCHED THEN\n" +
            "    INSERT (\"rpId\", \"recipeId\", \"under_20\", \"over_20\", \"over_30\", \"over_40\", \"over_50\", \"male\", \"female\", \"hits\")\n" +
            "    VALUES (RecipePreference_seq.nextval, new_rp.\"recipeId\", new_rp.\"under_20\", new_rp.\"over_20\", new_rp.\"over_30\", new_rp.\"over_40\", new_rp.\"over_50\", new_rp.\"male\", new_rp.\"female\", 1)")
    void upsertRecipePreference(RecipePref rp);
}
