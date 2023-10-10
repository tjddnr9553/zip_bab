package review;

import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

public interface ReviewDao {
    @Insert("INSERT INTO \"Review\" VALUES(Review_seq.nextval, #{memberId}, #{recipeId}, #{content}, SYSDATE)")
    void addReview(Review r);

    @Select("SELECT * FROM \"Review\" WHERE \"reviewId\" = #{reviewId}")
    Review selectReview(@Param("reviewId") int reviewId);

    @Select("SELECT * FROM \"Review\" ORDER BY \"reviewId\" DESC")
    ArrayList<Review> selectAll();

    @Select("SELECT * FROM \"Review\" WHERE \"memberId\" = #{writerId} ORDER BY \"reviewId\" DESC")
    ArrayList<Review> selectReviewByWriter(@Param("writerId") String writerId);

    @Select("SELECT * FROM \"Review\" WHERE \"recipeId\" = #{recipeId} ORDER BY \"reviewId\" DESC")
    ArrayList<Review> selectReviewByRecipe(@Param("recipeId") int recipeId);

    @Select("SELECT r.*, m.* FROM \"Review\" r JOIN \"Member\" m ON r.\"memberId\" = m.\"memberId\" WHERE \"recipeId\" = #{recipeId} ORDER BY \"reviewId\" DESC")
    ArrayList<ReviewMember> selectReviewJoinMember(@Param("recipeId") int recipeId);

    @Update("UPDATE \"Review\" SET \"content\" = #{content} WHERE \"reviewId\" = #{reviewId}")
    void editReview(Review r);

    @Delete("DELETE FROM \"Review\" WHERE \"reviewId\" = #{reviewId}")
    void delReview(@Param("reviewId") int reviewId);
}
