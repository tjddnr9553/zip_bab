package recipe;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface RecipeDao {
    //레시피 번호로 검색
    @Select("Select * from Recipe where recipe_id=#{recipe_id}")
    Recipe select(@Param("recipe_id") int recipe_id);

    //레시피 전체 목록 출력
    @Select("Select * from Recipe")
    ArrayList<Recipe> selectAll();

    //요리제목으로 검색
    @Select("Select * from Recipe where title in #{title}")
    ArrayList<Recipe> selectByTitle(@Param("title") String title);

    //재료정보로 검색
    @Select("Select * from Recipe where ingredient_info in #{ingredient_info}")
    ArrayList<Recipe> selectByIngredient_info(@Param("ingredient_info") String ingredient_info);


}
