package recipereview;

import org.apache.ibatis.annotations.*;
import recipereview.dto.RecipeReviewMember;

import java.util.List;

public interface RecipeReviewDao {
    @Insert("INSERT INTO \"RecipeReview\" VALUES(RecipeReview_seq.nextval, #{memberId}, #{recipeId}, #{content}, SYSDATE)")
    void addReview(RecipeReview r);

    @Select("SELECT * FROM \"RecipeReview\" WHERE \"reviewId\" = #{reviewId}")
    RecipeReview selectReview(@Param("reviewId") int reviewId);

    @Select("SELECT * FROM \"RecipeReview\" ORDER BY \"reviewId\" DESC")
    List<RecipeReview> selectAll();

    @Select("SELECT * FROM \"RecipeReview\" WHERE \"memberId\" = #{writerId} ORDER BY \"reviewId\" DESC")
    List<RecipeReview> selectReviewByWriter(@Param("writerId") String writerId);

    @Select("SELECT * FROM \"RecipeReview\" WHERE \"recipeId\" = #{recipeId} ORDER BY \"reviewId\" DESC")
    List<RecipeReview> selectReviewByRecipe(@Param("recipeId") int recipeId);

    @Select("SELECT r.*, m.*, " +
                "(SELECT COUNT(*) FROM \"RecipeReviewLike\" l WHERE r.\"reviewId\" = l.\"reviewId\") as \"likeCnt\" " +
            "FROM \"RecipeReview\" r " +
            "JOIN \"Member\" m ON (r.\"memberId\" = m.\"memberId\") " +
            "WHERE r.\"recipeId\" = #{recipeId} " +
            "ORDER BY \"reviewId\" DESC")
    List<RecipeReviewMember> selectReviewJoinMember(@Param("recipeId") int recipeId);

    @Update("UPDATE \"RecipeReview\" SET \"content\" = #{content} WHERE \"reviewId\" = #{reviewId}")
    void editReview(RecipeReview r);

    @Delete("DELETE FROM \"RecipeReview\" WHERE \"reviewId\" = #{reviewId}")
    void delReview(@Param("reviewId") int reviewId);

    // review 좋아요 시작
    @Insert("INSERT INTO \"RecipeReviewLike\" VALUES(RecipeReviewLike_seq.nextval, #{reviewId}, #{memberId})")
    void insertReviewLike(@Param("memberId") int memberId, @Param("reviewId") int reviewId);

    @Delete("DELETE FROM \"RecipeReviewLike\" WHERE \"memberId\" = #{memberId} AND \"reviewId\" = #{reviewId}")
    void deleteReviewLike(@Param("memberId") int memberId, @Param("reviewId") int reviewId);

    // 존재 유무
    @Select("SELECT COUNT(*) FROM \"RecipeReviewLike\" l WHERE l.\"memberId\" = #{memberId} AND l.\"reviewId\" = #{reviewId}")
    int isLikedReview(@Param("memberId") int memberId, @Param("reviewId") int reviewId);

    @Select("SELECT r.* FROM \"RecipeReviewLike\" l JOIN \"RecipeReview\" r ON l.\"memberId\" = r.\"memberId\" WHERE \"memberId\" = #{memberId}")
    List<RecipeReview> selectLikedReviews(@Param("memberId") int memberId);

    @Select("SELECT COUNT(*) FROM \"RecipeReviewLike\" WHERE \"reviewId\" = #{reviewId}")
    int selectLikeCnt(@Param("reviewId") int reviewId);
    // review 좋아요 끝

}
