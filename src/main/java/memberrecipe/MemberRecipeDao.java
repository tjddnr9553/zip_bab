package memberrecipe;

import memberrecipe.dto.MemberRecipePrefDto;
import org.apache.ibatis.annotations.*;
import recipe.RecipePref;

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
            ",\"ingredientInfo\"=#{ingredientInfo}, \"manual_01\"=#{manual_01},\"manual_02\"=#{manual_02},\"manual_03\"=#{manual_03}" +
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

    // 전체 목록(페이징)
    @Select("SELECT " +
                "c.*, " +
                "(SELECT COUNT(*) FROM \"MemberRecipeBookmark\" b WHERE b.\"memberId\" = #{memberId} AND b.\"recipeId\" = c.\"memberRecipeId\") AS \"isBooked\", " +
                "(SELECT COUNT(*) FROM \"MemberRecipe\") AS \"totalCnt\" " +
            "FROM (" +
                "SELECT a.*, ROWNUM rnum " +
                "FROM (" +
                    "SELECT r.*, rp.\"rpId\", rp.\"recipeId\" as \"rp_recipeId\", NVL(rp.\"under_20\", 0) \"under_20\", NVL(rp.\"over_20\", 0) \"over_20\", NVL(rp.\"over_30\", 0) \"over_30\", NVL(rp.\"over_40\", 0) \"over_40\", NVL(rp.\"over_50\", 0) \"over_50\", NVL(rp.\"male\", 0) \"male\", NVL(rp.\"female\", 0) \"female\", NVL(rp.\"hits\", 0) \"hits\" " +
                    "FROM \"MemberRecipe\" r " +
                    "LEFT JOIN \"MemberRecipePreference\" rp ON r.\"memberRecipeId\" = rp.\"recipeId\" " +
                    "ORDER BY r.\"memberRecipeId\") a " +
                "WHERE ROWNUM <= #{endRow}) c " +
            "WHERE c.rnum >= #{startRow}")
    List<MemberRecipePrefDto> selectAllByPage(@Param("startRow") int startRow, @Param("endRow") int endRow, @Param("memberId") int memberId);

    // title 검색 (페이징)
    @Select("SELECT " +
                "c.*, " +
                "(SELECT COUNT(*) FROM \"MemberRecipeBookmark\" b WHERE b.\"memberId\" = #{memberId} AND b.\"recipeId\" = c.\"memberRecipeId\") AS \"isBooked\", " +
                "(SELECT COUNT(*) FROM \"MemberRecipe\" WHERE \"title\" like '%'||#{title}||'%') AS \"totalCnt\" " +
            "FROM (" +
                "SELECT a.*, ROWNUM rnum " +
                "FROM (" +
                    "SELECT r.*, rp.\"rpId\", rp.\"recipeId\" as \"rp_recipeId\", NVL(rp.\"under_20\", 0) \"under_20\", NVL(rp.\"over_20\", 0) \"over_20\", NVL(rp.\"over_30\", 0) \"over_30\", NVL(rp.\"over_40\", 0) \"over_40\", NVL(rp.\"over_50\", 0) \"over_50\", NVL(rp.\"male\", 0) \"male\", NVL(rp.\"female\", 0) \"female\", NVL(rp.\"hits\", 0) \"hits\" " +
                    "FROM \"MemberRecipe\" r " +
                    "LEFT JOIN \"MemberRecipePreference\" rp ON r.\"memberRecipeId\" = rp.\"recipeId\" " +
                    "WHERE \"title\" like '%'||#{title}||'%' " +
                    "ORDER BY r.\"memberRecipeId\") a " +
                "WHERE ROWNUM <= #{endRow}) c " +
            "WHERE c.rnum >= #{startRow}")
    List<MemberRecipePrefDto> selectMemberRecipesByTitle(@Param("startRow") int startRow, @Param("endRow") int endRow, @Param("memberId") int memberId, @Param("title") String title);

    // 재료 검색 (페이징)
    @Select("SELECT " +
                "c.*, " +
                "(SELECT COUNT(*) FROM \"MemberRecipeBookmark\" b WHERE b.\"memberId\" = #{memberId} AND b.\"recipeId\" = c.\"memberRecipeId\") AS \"isBooked\", " +
                "(SELECT COUNT(*) FROM \"MemberRecipe\" WHERE \"ingredientInfo\" like '%'||#{ingredientInfo}||'%') AS \"totalCnt\" " +
            "FROM (" +
                "SELECT a.*, ROWNUM rnum " +
                "FROM (" +
                    "SELECT r.*, rp.\"rpId\", rp.\"recipeId\" as \"rp_recipeId\", NVL(rp.\"under_20\", 0) \"under_20\", NVL(rp.\"over_20\", 0) \"over_20\", NVL(rp.\"over_30\", 0) \"over_30\", NVL(rp.\"over_40\", 0) \"over_40\", NVL(rp.\"over_50\", 0) \"over_50\", NVL(rp.\"male\", 0) \"male\", NVL(rp.\"female\", 0) \"female\", NVL(rp.\"hits\", 0) \"hits\" " +
                    "FROM \"MemberRecipe\" r " +
                    "LEFT JOIN \"MemberRecipePreference\" rp ON r.\"memberRecipeId\" = rp.\"recipeId\" " +
                    "WHERE \"ingredientInfo\" like '%'||#{ingredientInfo}||'%' " +
                    "ORDER BY r.\"memberRecipeId\") a " +
                "WHERE ROWNUM <= #{endRow}) c " + // 30
            "WHERE c.rnum >= #{startRow}") // 1
    List<MemberRecipePrefDto> selectMemberRecipesByIngred(@Param("startRow") int startRow, @Param("endRow") int endRow, @Param("memberId") int memberId, @Param("ingredientInfo") String ingredientInfo);

    // 선호도 정렬 (페이징)
    @Select("SELECT " +
                "c.*, " +
                "(SELECT COUNT(*) FROM \"MemberRecipeBookmark\" b WHERE b.\"memberId\" = #{memberId} AND b.\"recipeId\" = c.\"memberRecipeId\") AS \"isBooked\", " +
                "(SELECT COUNT(*) FROM \"MemberRecipe\") AS \"totalCnt\" " +
            "FROM (" +
                "SELECT a.*, ROWNUM rnum " +
                "FROM (" +
                    "SELECT r.*, rp.\"rpId\", rp.\"recipeId\" as \"rp_recipeId\", NVL(rp.\"under_20\", 0) \"under_20\", NVL(rp.\"over_20\", 0) \"over_20\", NVL(rp.\"over_30\", 0) \"over_30\", NVL(rp.\"over_40\", 0) \"over_40\", NVL(rp.\"over_50\", 0) \"over_50\", NVL(rp.\"male\", 0) \"male\", NVL(rp.\"female\", 0) \"female\", NVL(rp.\"hits\", 0) \"hits\" " +
                    "FROM \"MemberRecipe\" r " +
                    "LEFT JOIN \"MemberRecipePreference\" rp ON r.\"memberRecipeId\" = rp.\"recipeId\" " +
                    "ORDER BY ${order} DESC, 1) a " +
                "WHERE ROWNUM <= #{endRow}) c " +
            "WHERE c.rnum >= #{startRow}")
    List<MemberRecipePrefDto> selectMemberRecipesByPrefOrder(@Param("startRow") int startRow, @Param("endRow") int endRow, @Param("memberId") int memberId, @Param("order") int order);

    // 북마크 확인
    @Select("SELECT COUNT(*) FROM \"MemberRecipeBookmark\" WHERE \"recipeId\" = #{recipeId} AND \"memberId\" = #{memberId}")
    int isBooked(@Param("recipeId") int recipeId, @Param("memberId") int memberId);

    // 북마크 추가
    @Insert("INSERT INTO \"MemberRecipeBookmark\" VALUES(MemberRecipeBookmark_seq.nextval, #{recipeId}, #{memberId})")
    void addBookmark(@Param("recipeId") int recipeId, @Param("memberId") int memberId);

    // 북마크 삭제
    @Delete("DELETE FROM \"MemberRecipeBookmark\" WHERE \"recipeId\" = #{recipeId} AND \"memberId\" = #{memberId}")
    void delBookmark(@Param("recipeId") int recipeId, @Param("memberId") int memberId);

    // 선호도 증가
    @Update("MERGE INTO \"MemberRecipePreference\" rp\n" +
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
            "    VALUES (MemberRecipePreference_seq.nextval, new_rp.\"recipeId\", new_rp.\"under_20\", new_rp.\"over_20\", new_rp.\"over_30\", new_rp.\"over_40\", new_rp.\"over_50\", new_rp.\"male\", new_rp.\"female\", 1)")
    void upsertRecipePreference(RecipePref rp);
}
