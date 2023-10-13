package bookmark;

import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
@Mapper
public interface BookmarkDao {
    @Select("Select * from \"Bookmark\"")
    ArrayList<Bookmark> selectAll();

    @Select("Select * from \"Bookmark\" where \"recipeId\" = #{recipeId}")
    ArrayList<Bookmark> selectByRecipeId(@Param("recipeId") int recipeId);

    @Select("Select * from \"Bookmark\" where \"memberId\" = #{memberId}")
    ArrayList<Bookmark> selectByMemberId(@Param("memberId") int memberId);

    @Select("Select * from \"Bookmark\" where \"recipeId\" = #{recipeId} and \"memberId\" = #{memberId}")
    Bookmark check(@Param("recipeId") int recipeId, @Param("memberId") int memberId);

    @Insert("Insert into \"Bookmark\" values (Bookmark_seq.nextval, #{recipeId}, #{memberId})")
    void insert(Bookmark b);

    @Delete("DELETE FROM \"Bookmark\" where \"recipeId\" = #{recipeId} and \"memberId\" = #{memberId}")
    void delete(@Param("recipeId") int recipeId, @Param("memberId") int memberId);
}
