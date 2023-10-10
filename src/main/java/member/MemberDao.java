package member;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MemberDao {
	@Insert("insert into \"Member\" values(Member_seq.nextval, #{loginId}, #{nickname}, #{password}, #{email}, #{birthday}, #{gender}, #{profile})")
	void addMember(Member m);

	@Select("select * from \"Member\" where \"loginId\"=#{loginId}")
	Member getMember(@Param("loginId") String loginId);


	@Select("select * from \"Member\"")
	ArrayList<Member> selectAll();

	@Update("update \"Member\" set \"nickname\"=#{nickname}, \"profile\"=#{profile} where \"loginId\"=#{loginId}")
	void editMember(@Param("loginId") String loginId , @Param("nickname") String nickname , @Param("profile") String profile );

	@Delete("delete from \"Member\" where \"loginId\"=#{loginId}")
	void delMember(@Param("loginId") String loginId);
}