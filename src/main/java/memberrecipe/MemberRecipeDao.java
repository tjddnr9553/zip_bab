package memberrecipe;

import member.Member;
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
            "  \"completePicture\", \"calorie\", \"writeTime\", \"editTime\" ) values ( MemberRecipe_seq.nextval, #{memberId}, #{title}, #{subTitle}, #{way}, #{ingredientInfo}" +
            " ,#{manual_01}, #{manual_02}, #{manual_03}, #{manual_04}, #{manual_05}, #{manual_06}, #{manual_07}, #{manual_08}" +
            " ,#{manual_09} , #{manual_10}, #{manual_11}, #{manual_12} , #{manual_img_01}, #{manual_img_02}, #{manual_img_03}" +
            " , #{manual_img_04},#{manual_img_05},#{manual_img_06},#{manual_img_07},#{manual_img_08},#{manual_img_09}" +
            " ,#{manual_img_10} ,#{manual_img_11} ,#{manual_img_12} ,#{completePicture}" +
            " ,#{calorie} ,sysdate, sysdate)")
    void addMemberRecipe(MemberRecipe memberRecipe);

    @Delete("delete from \"MemberRecipe\" where \"memberRecipeId\"=#{memberRecipeId}")
    void delete(@Param("memberRecipeId") int memberRecipeId);

    @Update("update \"MemberRecipe\" set \"title\"=#{title}, \"subTitle\"=#{subTitle}, \"way\"=#{way}" +
            "\"ingredientInfo\"=#{ingredientInfo}, \"manual_01\"=#{manual_01},\"manual_02\"=#{manual_02},\"manual_03\"=#{manual_03}" +
            ",\"manual_04\"=#{manual_04},\"manual_05\"=#{manual_05},\"manual_06\"=#{manual_06},\"manual_07\"=#{manual_07}" +
            " ,\"manual_08\"=#{manual_08}, \"manual_09\"=#{manual_09}, \"manual_10\"=#{manual_10}, \"manual_11\"=#{manual_11}" +
            ", \"manual_12\"=#{manual_12} , \"calorie\"=#{calorie} where \"memberRecipeId\"=#{memberRecipeId} ")
    void edit(MemberRecipe memberRecipe);

    @Update("update \"MemberRecipe\" set \"manual_img_01\"=#{manual_img_01}, \"manual_img_02\"=#{manual_img_02}," +
            " \"manual_img_03\"=#{manual_img_03}, \"manual_img_04\"=#{manual_img_04}, \"manual_img_05\"=#{manual_img_05}"  +
            ", \"manual_img_06\"=#{manual_img_06}, \"manual_img_07\"=#{manual_img_07}, \"manual_img_08\"=#{manual_img_08}" +
            ", \"manual_img_09\"=#{manual_img_09}, \"manual_img_10\"=#{manual_img_10}, \"manual_img_11\"=#{manual_img_11}" +
            ", \"manual_img_12\"=#{manual_img_12}, \"completePicture\"=#{completePicture} where \"memberRecipeId\"=#{memberRecipeId}")
    void updateImg(MemberRecipe memberRecipe);
}
