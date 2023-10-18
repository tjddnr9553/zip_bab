package recipe;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import recipe.dto.RecipePrefDto;

import java.util.ArrayList;

@Mapper
public interface RecipeDao {
    //레시피 번호로 검색
    @Select("Select * from \"Recipe\" where \"recipeId\"=#{recipeId}")
    Recipe select(@Param("recipeId") int recipeId);

    //요리방법으로 검색
//    @Select("SELECT * FROM (SELECT a.*, ROWNUM rnum FROM (SELECT * FROM \"Recipe\" WHERE \"way\" = #{way}) a WHERE ROWNUM <= #{pageNum}) WHERE rnum >= #{amount}")
//    ArrayList<Recipe> selectByWay(@Param("pageNum") int pageNum, @Param("amount") int amount, @Param("way") String way);

    //레시피 전체 목록 출력
    @Select("Select * from \"Recipe\" order by \"recipeId\"")
    ArrayList<Recipe> selectAll();

    //요리제목으로 검색
    @Select("Select * from \"Recipe\" where \"title\" like '%'||#{title}||'%'")
    ArrayList<Recipe> selectByTitle(@Param("title") String title);

    //재료정보로 검색
    //jdbcType=VARCHAR을 사용하여 데이터베이스 컬럼과 파라미터의 데이터 유형을 일치
    @Select("Select * from \"Recipe\" where \"ingredientInfo\" like '%'||#{ingredientInfo, jdbcType=VARCHAR}||'%'")
    ArrayList<Recipe> selectByIngredientInfo(@Param("ingredientInfo") String ingredientInfo);

    //요리제목으로 검색(페이징)
    @Select("Select * FROM (SELECT a.*, ROWNUM rnum FROM (Select * from \"Recipe\" where \"title\" like '%'||#{title}||'%') a WHERE ROWNUM <= #{pageNum}) WHERE rnum >= #{amount}")
    ArrayList<Recipe> selectByTitlePage(@Param("title") String title, @Param("pageNum") int pageNum,@Param("amount") int amount);

    //재료정보로 검색(페이징)
    //jdbcType=VARCHAR을 사용하여 데이터베이스 컬럼과 파라미터의 데이터 유형을 일치
    @Select("Select * FROM (SELECT a.*, ROWNUM rnum FROM (Select * from \"Recipe\" where \"ingredientInfo\" like '%'||#{ingredientInfo, jdbcType=VARCHAR}||'%') a WHERE ROWNUM <= #{pageNum}) WHERE rnum >= #{amount}")
    ArrayList<Recipe> selectByIngredientInfoPage(@Param("ingredientInfo") String ingredientInfo, @Param("pageNum") int pageNum, @Param("amount") int amount);

    //페이징 처리
    @Select("Select * FROM (SELECT a.*, ROWNUM rnum FROM (SELECT * FROM \"Recipe\") a WHERE ROWNUM <= #{pageNum})WHERE rnum >= #{amount}")
    ArrayList<Recipe> selectByPage(@Param("pageNum") int pageNum,@Param("amount") int amount);

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

    //전체 목록 (페이징 처리)
    @Select("SELECT " +
                "c.*, " +
                "(SELECT COUNT(*) FROM \"Bookmark\" b WHERE b.\"memberId\" = #{memberId} AND b.\"recipeId\" = c.\"recipeId\") AS \"isBooked\", " +
                "(SELECT COUNT(*) FROM \"Recipe\") AS \"totalCnt\" " +
            "FROM (" +
                "SELECT a.*, ROWNUM rnum " +
                "FROM (" +
                    "SELECT r.*, rp.\"rpId\", rp.\"recipeId\" as \"rp_recipeId\", NVL(rp.\"under_20\", 0) \"under_20\", NVL(rp.\"over_20\", 0) \"over_20\", NVL(rp.\"over_30\", 0) \"over_30\", NVL(rp.\"over_40\", 0) \"over_40\", NVL(rp.\"over_50\", 0) \"over_50\", NVL(rp.\"male\", 0) \"male\", NVL(rp.\"female\", 0) \"female\", NVL(rp.\"hits\", 0) \"hits\" " +
                    "FROM \"Recipe\" r " +
                    "LEFT JOIN \"RecipePreference\" rp ON r.\"recipeId\" = rp.\"recipeId\" " +
                    "ORDER BY r.\"recipeId\") a " +
                "WHERE ROWNUM <= #{endRow}) c " +
            "WHERE c.rnum >= #{startRow}")
    ArrayList<RecipePrefDto> selectAllByPage(@Param("startRow") int startRow, @Param("endRow") int endRow, @Param("memberId") int memberId);

    // title 검색 (페이징 처리)
    @Select("SELECT " +
                "c.*, " +
                "(SELECT COUNT(*) FROM \"Bookmark\" b WHERE b.\"memberId\" = #{memberId} AND b.\"recipeId\" = c.\"recipeId\") AS \"isBooked\", " +
                "(SELECT COUNT(*) FROM \"Recipe\" WHERE \"title\" like '%'||#{title}||'%') AS \"totalCnt\" " +
            "FROM (" +
                "SELECT a.*, ROWNUM rnum " +
                "FROM (" +
                    "SELECT r.*, rp.\"rpId\", rp.\"recipeId\" as \"rp_recipeId\", NVL(rp.\"under_20\", 0) \"under_20\", NVL(rp.\"over_20\", 0) \"over_20\", NVL(rp.\"over_30\", 0) \"over_30\", NVL(rp.\"over_40\", 0) \"over_40\", NVL(rp.\"over_50\", 0) \"over_50\", NVL(rp.\"male\", 0) \"male\", NVL(rp.\"female\", 0) \"female\", NVL(rp.\"hits\", 0) \"hits\" " +
                    "FROM \"Recipe\" r " +
                    "LEFT JOIN \"RecipePreference\" rp ON r.\"recipeId\" = rp.\"recipeId\" " +
                    "WHERE \"title\" like '%'||#{title}||'%' " +
                    "ORDER BY r.\"recipeId\") a " +
                "WHERE ROWNUM <= #{endRow}) c " +
            "WHERE c.rnum >= #{startRow}")
    ArrayList<RecipePrefDto> selectAllByTitle(@Param("startRow") int startRow, @Param("endRow") int endRow, @Param("title") String title, @Param("memberId") int memberId);

    // 재료 검색 (페이징 처리)
    @Select("SELECT " +
                "c.*, " +
                "(SELECT COUNT(*) FROM \"Bookmark\" b WHERE b.\"memberId\" = #{memberId} AND b.\"recipeId\" = c.\"recipeId\") AS \"isBooked\", " +
                "(SELECT COUNT(*) FROM \"Recipe\" WHERE \"ingredientInfo\" like '%'||#{ingredientInfo}||'%') AS \"totalCnt\" " +
            "FROM (" +
                "SELECT a.*, ROWNUM rnum " +
                "FROM (" +
                    "SELECT r.*, rp.\"rpId\", rp.\"recipeId\" as \"rp_recipeId\", NVL(rp.\"under_20\", 0) \"under_20\", NVL(rp.\"over_20\", 0) \"over_20\", NVL(rp.\"over_30\", 0) \"over_30\", NVL(rp.\"over_40\", 0) \"over_40\", NVL(rp.\"over_50\", 0) \"over_50\", NVL(rp.\"male\", 0) \"male\", NVL(rp.\"female\", 0) \"female\", NVL(rp.\"hits\", 0) \"hits\" " +
                    "FROM \"Recipe\" r " +
                    "LEFT JOIN \"RecipePreference\" rp ON r.\"recipeId\" = rp.\"recipeId\" " +
                    "WHERE \"ingredientInfo\" like '%'||#{ingredientInfo}||'%' " +
                    "ORDER BY r.\"recipeId\") a " +
                "WHERE ROWNUM <= #{endRow}) c " + // 30
            "WHERE c.rnum >= #{startRow}") // 1
    ArrayList<RecipePrefDto> selectAllByIngred(@Param("startRow") int startRow, @Param("endRow") int endRow, @Param("ingredientInfo") String ingredientInfo, @Param("memberId") int memberId);

    // 선호도 정렬(페이징 처리)
    @Select("SELECT " +
                "c.*, " +
                "(SELECT COUNT(*) FROM \"Bookmark\" b WHERE b.\"memberId\" = #{memberId} AND b.\"recipeId\" = c.\"recipeId\") AS \"isBooked\", " +
                "(SELECT COUNT(*) FROM \"Recipe\") AS \"totalCnt\" " +
            "FROM (" +
                "SELECT a.*, ROWNUM rnum " +
                "FROM (" +
                    "SELECT r.*, rp.\"rpId\", rp.\"recipeId\" as \"rp_recipeId\", NVL(rp.\"under_20\", 0) \"under_20\", NVL(rp.\"over_20\", 0) \"over_20\", NVL(rp.\"over_30\", 0) \"over_30\", NVL(rp.\"over_40\", 0) \"over_40\", NVL(rp.\"over_50\", 0) \"over_50\", NVL(rp.\"male\", 0) \"male\", NVL(rp.\"female\", 0) \"female\", NVL(rp.\"hits\", 0) \"hits\" " +
                    "FROM \"Recipe\" r " +
                    "LEFT JOIN \"RecipePreference\" rp ON r.\"recipeId\" = rp.\"recipeId\" " +
                    "ORDER BY ${order} DESC, 1) a " +
                "WHERE ROWNUM <= #{endRow}) c " +
            "WHERE c.rnum >= #{startRow}")
    ArrayList<RecipePrefDto> selectAllByPrefOrder(@Param("startRow") int startRow, @Param("endRow") int endRow, @Param("order") int order, @Param("memberId") int memberId);
}
