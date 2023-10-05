package recipe;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
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
}
