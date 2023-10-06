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
	@Insert("insert into \"Member\" values(Member_seq.nextval, #{username}, #{nickname}, #{password}, #{email}, #{birthday}, #{gender})")
	void addMember(Member m);

	@Select("select * from \"Member\" where \"password\"=#{password}")
	Member getMember(@Param("password") String password);

	@Select("select * from \"Member\"")
	ArrayList<Member> selectAll();

	@Update("update \"Member\" set \"password\"=#{password} where password=#{password}")
	void editMember(Member m);

	@Delete("delete from \"Member\" where \"username\"=#{username}")
	void delMember(@Param("username") String username);
}