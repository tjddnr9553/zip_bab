package follow;

import org.apache.ibatis.annotations.*;

@Mapper
public interface FollowDao {
    @Insert("insert into \"Follow\" values(Follow_seq.nextval,#{followerId}, #{followingId})")
    void addFollow(@Param("followerId") int followerId,@Param("followingId") int followingId);
    
    @Select("select count(*) from \"Follow\" where \"followerId\" = #{memberId}")
    int getFollower(@Param("memberId") int memberId);

    @Select("select count(*) from \"Follow\" where \"followingId\" = #{memberId}")
    int getFollowing(@Param("memberId") int memberId);

    @Select("select count(*) from \"Follow\" where \"followerId\"=#{followerId} and \"followingId\"=#{followingId}")
    int getFollowCheck(@Param("followerId") int followerId,@Param("followingId") int followingId);

    @Delete("delete from \"Follow\" where \"followerId\"=#{followerId} and \"followingId\"=#{followingId}")
    int delFollow(@Param("followerId") int followerId,@Param("followingId") int followingId);
}
