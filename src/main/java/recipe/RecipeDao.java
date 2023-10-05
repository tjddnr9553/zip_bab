package recipe;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
    @Select("Select * from \"Recipe\" where \"title\" in #{title}")
    ArrayList<Recipe> selectByTitle(@Param("title") String title);

    //재료정보로 검색
    @Select("Select * from \"Recipe\" where \"ingredientInfo\" in #{ingredientInfo}")
    ArrayList<Recipe> selectByIngredientInfo(@Param("ingredientInfo") String ingredientInfo);


}
