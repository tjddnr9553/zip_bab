package memberrecipe;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import sqlsession.Factory;

import java.util.List;

@Slf4j
public class MemberRecipeService {
    private SqlSessionFactory sqlSessionFactory;

    public MemberRecipeService() {
        sqlSessionFactory = Factory.getSqlSessionFactory();
    }

    //레시피 번호로 검색
    public MemberRecipe getById(int memberRecipeId) {
        SqlSession session = sqlSessionFactory.openSession();
        MemberRecipeDao dao = session.getMapper(MemberRecipeDao.class);
        MemberRecipe memberRecipe = dao.select(memberRecipeId);
        session.close();

        return memberRecipe;
    }

    //레시피 전체 목록 출력
    public List<MemberRecipe> getAll() {
        SqlSession session = sqlSessionFactory.openSession();
        MemberRecipeDao dao = session.getMapper(MemberRecipeDao.class);
        List<MemberRecipe> list = dao.selectAll();
        session.close();

        return list;
    }

    // TODO: 2023/10/09 페이징 처리 select 만들어야함 (선택한 페이지 숫자, 표시 개수)
    public List<MemberRecipe> getPage(int pageNumber, int count) {
        return null;
    }

    //요리제목으로 검색
    public List<MemberRecipe> getByTitle(String title) {
        SqlSession session = sqlSessionFactory.openSession();
        MemberRecipeDao dao = session.getMapper(MemberRecipeDao.class);
        List<MemberRecipe> list = dao.selectByTitle(title);
        session.close();

        return list;
    }

    //쟤료정보로 검색
    public List<MemberRecipe> getByIngredientInfo(String ingredientInfo) {
        SqlSession session = sqlSessionFactory.openSession();
        MemberRecipeDao dao = session.getMapper(MemberRecipeDao.class);
        List<MemberRecipe> list = dao.selectByIngredientInfo(ingredientInfo);
        session.close();

        return list;
    }

    public void addMemberRecipe(MemberRecipe memberRecipe) {
        SqlSession session = sqlSessionFactory.openSession();
        MemberRecipeDao dao = session.getMapper(MemberRecipeDao.class);
        dao.addMemberRecipe(memberRecipe);
        session.commit();
        session.close();
    }

    public void delMemberRecipe(int memberRecipeId) {
        SqlSession session = sqlSessionFactory.openSession();
        MemberRecipeDao dao = session.getMapper(MemberRecipeDao.class);
        dao.delete(memberRecipeId);
        session.commit();
        session.close();
    }

    public void editMemberRecipe(MemberRecipe memberRecipe) {
        SqlSession session = sqlSessionFactory.openSession();
        MemberRecipeDao dao = session.getMapper(MemberRecipeDao.class);
        dao.edit(memberRecipe);
        session.commit();
        session.close();
    }

    public void editMemberRecipeImg(MemberRecipe memberRecipe) {
        SqlSession session = sqlSessionFactory.openSession();
        MemberRecipeDao dao = session.getMapper(MemberRecipeDao.class);
        dao.updateImg(memberRecipe);
        session.commit();
        session.close();
    }
}
