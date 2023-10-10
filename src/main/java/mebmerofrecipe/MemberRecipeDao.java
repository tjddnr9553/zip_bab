package mebmerofrecipe;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MemberRecipeDao {
    //레시피 번호로 검색
    @Select("Select * from \"MemberRecipe\" where \"memberRecipeId\"=#{memberRecipeId}")
    MemberRecipe select(@Param("memberRecipeId") int memberOfRecipeId);

    //레시피 전체 목록 출력
    @Select("Select * from \"MemberRecipe\"")
    List<MemberRecipe> selectAll();

    //요리제목으로 검색
    @Select("Select * from \"MemberRecipe\" where \"title\" in #{title}")
    List<MemberRecipe> selectByTitle(@Param("title") String title);

    //재료정보로 검색
    @Select("Select * from \"MemberRecipe\" where \"ingredientInfo\" in #{ingredientInfo}")
    List<MemberRecipe> selectByIngredientInfo(@Param("ingredientInfo") String ingredientInfo);

    @Insert("insert into \"MemberRecipe\"( \"memberRecipeId\", \"memberId\", \"title\", \"subTitle\", \"way\", \"ingredientInfo\", \"manual_01\",\n" +
            " \"manual_02\", \"manual_03\",\"manual_04\",\"manual_05\",\"manual_06\",\"manual_07\",\"manual_08\",\n" +
            "  \"manual_09\", \"manual_10\", \"manual_11\", \"manual_12\",\"manual_img_01\", \"manual_img_02\",\n" +
            "  \"manual_img_03\", \"manual_img_04\", \"manual_img_05\", \"manual_img_06\", \"manual_img_07\",\n" +
            "  \"manual_img_08\", \"manual_img_09\", \"manual_img_10\", \"manual_img_11\", \"manual_img_12\",\n" +
            "  \"manual_img_13\", \"manual_img_14\", \"manual_img_15\", \"manual_img_16\", \"manual_img_17\",\n" +
            "  \"manual_img_18\", \"manual_img_19\", \"manual_img_20\",  \"completePicture\", \"calorie\"," +
            "  \"writeTime\", \"editTime\", ) values ( MemberOfRecipe.nextval, #{memberRecipeId}, #{memberId}, #{title], #{subTitle], #{way], #{ingredientInfo}" +
            " ,#{manual_01}, #{manual_02}, #{manual_03}, #{manual_04}, #{manual_05}, #{manual_06}, #{manual_07}, #{manual_08}" +
            " ,#{manual_09} , #{manual_10}, #{manual_11}, #{manual_12} , #{manual_img_01}, #{manual_img_02}, #{manual_img_03}" +
            " , #{manual_img_04},#{manual_img_05},#{manual_img_06},#{manual_img_07},#{manual_img_08},#{manual_img_09}" +
            " ,#{manual_img_10} ,#{manual_img_11} ,#{manual_img_12} ,#{manual_img_13} ,#{manual_img_14} ,#{manual_img_15}" +
            " ,#{manual_img_16} ,#{manual_img_17} ,#{manual_img_18} ,#{manual_img_19} ,#{manual_img_20} ,#{completePicture}" +
            " ,#{calorie} ,#{writeTime}, ,#{editTime}")
    void addMemberRecipe(MemberRecipe memberRecipe);

    // TODO: 2023/10/09 Update문 만들어야 한다!

    // TODO: 2023/10/09 Pageing selects 만들어야 한다!

    @Delete("delete from \"MemberRecipe\" where \"memberRecipeId\"=#{memberRecipeId}")
    void delete(@Param("memberRecipeId") String memberRecipeId);
}
