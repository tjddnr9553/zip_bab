package review;

import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ReviewDao {
    @Insert("INSERT INTO \"Review\" VALUES(Review_seq.nextval, #{memberId}, #{recipeId}, #{content}, SYSDATE)")
    @SelectKey(statement="SELECT Review_seq.nextval FROM dual", keyProperty="reviewId", before=true, resultType=int.class)
    void addReview(Review r);

    @Select("SELECT * FROM \"Review\" WHERE \"reviewId\" = #{reviewId}")
    Review selectReview(@Param("reviewId") int reviewId);

    @Select("SELECT * FROM \"Review\" ORDER BY \"reviewId\" DESC")
    List<Review> selectAll();

    @Select("SELECT * FROM \"Review\" WHERE \"memberId\" = #{writerId} ORDER BY \"reviewId\" DESC")
    List<Review> selectReviewByWriter(@Param("writerId") String writerId);

    @Select("SELECT * FROM \"Review\" WHERE \"recipeId\" = #{recipeId} ORDER BY \"reviewId\" DESC")
    List<Review> selectReviewByRecipe(@Param("recipeId") int recipeId);

    @Select("SELECT r.*, " +
            "m.*, " +
            "(SELECT COUNT(*) FROM \"Like\" l WHERE r.\"reviewId\" = l.\"reviewId\") as \"likeCnt\" " +
            "FROM \"Review\" r " +
            "JOIN \"Member\" m ON (r.\"memberId\" = m.\"memberId\") " +
            "WHERE r.\"recipeId\" = #{recipeId} " +
            "ORDER BY \"reviewId\" DESC")
    List<ReviewMember> selectReviewJoinMember(@Param("recipeId") int recipeId);

    @Update("UPDATE \"Review\" SET \"content\" = #{content} WHERE \"reviewId\" = #{reviewId}")
    void editReview(Review r);

    @Delete("DELETE FROM \"Review\" WHERE \"reviewId\" = #{reviewId}")
    void delReview(@Param("reviewId") int reviewId);

    // review 좋아요 시작
    @Insert("INSERT INTO \"Like\" VALUES(Like_seq.nextval, #{reviewId}, #{memberId})")
    void insertReviewLike(@Param("memberId") int memberId, @Param("reviewId") int reviewId);

    @Delete("DELETE FROM \"Like\" WHERE \"memberId\" = #{memberId} AND \"reviewId\" = #{reviewId}")
    void deleteReviewLike(@Param("memberId") int memberId, @Param("reviewId") int reviewId);

    // 존재 유무
    @Select("SELECT count(*) FROM \"Like\" l WHERE l.\"memberId\" = #{memberId} AND l.\"reviewId\" = #{reviewId}")
    int isLikedReview(@Param("memberId") int memberId, @Param("reviewId") int reviewId);

    @Select("SELECT r.* FROM \"Like\" l JOIN \"Review\" r ON l.\"memberId\" = r.\"memberId\" WHERE \"memberId\" = #{memberId}")
    List<Review> selectLikedReviews(@Param("memberId") int memberId);

    @Select("SELECT COUNT(*) FROM \"Like\" WHERE \"reviewId\" = #{reviewId}")
    int selectLikeCnt(@Param("reviewId") int reviewId);
    // review 좋아요 끝

}
