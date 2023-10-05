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
    public Recipe getById(int recipe_id) {
        SqlSession session = sqlSessionFactory.openSession();
        RecipeDao dao = (RecipeDao) session.getMapper(RecipeDao.class);
        Recipe r = dao.select(recipe_id);
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
    public ArrayList<Recipe> getByIngredient_info(String ingredient_info) {
        SqlSession session = sqlSessionFactory.openSession();
        RecipeDao dao = (RecipeDao) session.getMapper(RecipeDao.class);
        ArrayList<Recipe> list = dao.selectByIngredient_info(ingredient_info);
        session.close();
        return list;
    }
}
