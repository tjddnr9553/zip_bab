package recipe;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import recipe.dto.RecipePrefDto;
import sqlsession.Factory;

import java.util.ArrayList;

public class RecipeService {
    private SqlSessionFactory sqlSessionFactory;

    public RecipeService() {
        sqlSessionFactory = Factory.getSqlSessionFactory();
    }

    //레시피 번호로 검색
    public Recipe getById(int recipeId) {
        SqlSession session = sqlSessionFactory.openSession();
        RecipeDao dao = (RecipeDao) session.getMapper(RecipeDao.class);
        Recipe r = dao.select(recipeId);
        session.close();
        return r;
    }

    //요리방법으로 검색
//    public ArrayList<Recipe> getByWay(int pageNum, int amount, String way) {
//        SqlSession session = sqlSessionFactory.openSession();
//        RecipeDao dao = (RecipeDao) session.getMapper(RecipeDao.class);
//        ArrayList<Recipe> list = dao.selectByWay(pageNum, amount, way);
//        session.close();
//        return list;
//    }

    //레시피 전체 목록 출력
    public ArrayList<Recipe> getAll() {
        SqlSession session = sqlSessionFactory.openSession();
        RecipeDao dao = (RecipeDao) session.getMapper(RecipeDao.class);
        ArrayList<Recipe> list = dao.selectAll();
        session.close();
        return list;
    }

    //요리제목으로 검색
    public ArrayList<Recipe> getByTitle(String title) {
        SqlSession session = sqlSessionFactory.openSession();
        RecipeDao dao = (RecipeDao) session.getMapper(RecipeDao.class);
        ArrayList<Recipe> list = dao.selectByTitle(title);
        session.close();
        return list;
    }

    //쟤료정보로 검색
    public ArrayList<Recipe> getByIngredientInfo(String ingredientInfo) {
        SqlSession session = sqlSessionFactory.openSession();
        RecipeDao dao = (RecipeDao) session.getMapper(RecipeDao.class);
        ArrayList<Recipe> list = dao.selectByIngredientInfo(ingredientInfo);
        session.close();
        return list;
    }

    //요리제목으로 검색(페이징)
    public ArrayList<Recipe> getByTitlePage(String title, int pageNum, int amount) {
        SqlSession session = sqlSessionFactory.openSession();
        RecipeDao dao = (RecipeDao) session.getMapper(RecipeDao.class);
        ArrayList<Recipe> list = dao.selectByTitlePage(title, pageNum, amount);
        session.close();
        return list;
    }

    //쟤료정보로 검색(페이징)
    public ArrayList<Recipe> getByIngredientInfoPage(String ingredientInfo, int pageNum, int amount) {
        SqlSession session = sqlSessionFactory.openSession();
        RecipeDao dao = (RecipeDao) session.getMapper(RecipeDao.class);
        ArrayList<Recipe> list = dao.selectByIngredientInfoPage(ingredientInfo, pageNum, amount);
        session.close();
        return list;
    }

    //페이징 처리
    public ArrayList<Recipe> getByPage(int pageNum, int amount) {
        SqlSession session = sqlSessionFactory.openSession();
        RecipeDao dao = (RecipeDao) session.getMapper(RecipeDao.class);
        ArrayList<Recipe> list = dao.selectByPage(pageNum, amount);
        session.close();
        return list;
    }

    // 선호도 증가
    public void increaseRpCnt(RecipePref rp) {
        SqlSession session = sqlSessionFactory.openSession();
        RecipeDao dao = (RecipeDao) session.getMapper(RecipeDao.class);
        dao.upsertRecipePreference(rp);
        session.commit();
        session.close();
    }

    // 전체 목록 (페이징 처리)
    public ArrayList<RecipePrefDto> getAllByPage(int startRow, int endRow, int memberId) {
        SqlSession session = sqlSessionFactory.openSession();
        RecipeDao dao = (RecipeDao) session.getMapper(RecipeDao.class);
        ArrayList<RecipePrefDto> list = dao.selectAllByPage(startRow, endRow, memberId);
        session.close();
        return list;
    }

    public ArrayList<RecipePrefDto> getAllByTitle(int startRow, int endRow, String title, int memberId) {
        SqlSession session = sqlSessionFactory.openSession();
        RecipeDao dao = (RecipeDao) session.getMapper(RecipeDao.class);
        ArrayList<RecipePrefDto> list = dao.selectAllByTitle(startRow, endRow, title, memberId);
        session.close();
        return list;
    }

    public ArrayList<RecipePrefDto> getAllByIngred(int startRow, int endRow, String ingred, int memberId) {
        SqlSession session = sqlSessionFactory.openSession();
        RecipeDao dao = (RecipeDao) session.getMapper(RecipeDao.class);
        ArrayList<RecipePrefDto> list = dao.selectAllByIngred(startRow, endRow, ingred, memberId);
        session.close();
        return list;
    }

    public ArrayList<RecipePrefDto> getAllByPrefOrder(int startRow, int endRow, int order, int memberId) {
        SqlSession session = sqlSessionFactory.openSession();
        RecipeDao dao = (RecipeDao) session.getMapper(RecipeDao.class);
        ArrayList<RecipePrefDto> list = dao.selectAllByPrefOrder(startRow, endRow, order, memberId);
        session.close();
        return list;
    }
}
