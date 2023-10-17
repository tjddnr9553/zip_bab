package recipereview;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import recipereview.dto.RecipeReviewMember;
import sqlsession.Factory;

import java.util.List;

public class RecipeReviewService {
    private SqlSessionFactory sqlSessionFactory;

    public RecipeReviewService() {
        sqlSessionFactory = Factory.getSqlSessionFactory();
    }

    public void addReview(RecipeReview r) {
        SqlSession session = sqlSessionFactory.openSession();
        RecipeReviewDao dao = session.getMapper(RecipeReviewDao.class);
        dao.addReview(r);
        session.commit();
        session.close();
    }


    public RecipeReview getReview(int num){
        SqlSession session = sqlSessionFactory.openSession();
        RecipeReviewDao dao = session.getMapper(RecipeReviewDao.class);
        RecipeReview r = dao.selectReview(num);
        session.close();
        return r;
    }

    public List<RecipeReview> getAll(){
        SqlSession session = sqlSessionFactory.openSession();
        RecipeReviewDao dao = session.getMapper(RecipeReviewDao.class);
        List<RecipeReview> r = dao.selectAll();
        session.close();
        return r;
    }

    public List<RecipeReview> getReviewByWriter(String writerId){
        SqlSession session = sqlSessionFactory.openSession();
        RecipeReviewDao dao = session.getMapper(RecipeReviewDao.class);
        List<RecipeReview> r = dao.selectReviewByWriter(writerId);
        session.close();
        return r;
    }

    public List<RecipeReview> getReviewByRecipe(int recipeId){
        SqlSession session = sqlSessionFactory.openSession();
        RecipeReviewDao dao = session.getMapper(RecipeReviewDao.class);
        List<RecipeReview> r = dao.selectReviewByRecipe(recipeId);
        session.close();
        return r;
    }

    public List<RecipeReviewMember> getReviewMember(int recipeId){
        SqlSession session = sqlSessionFactory.openSession();
        RecipeReviewDao dao = session.getMapper(RecipeReviewDao.class);
        List<RecipeReviewMember> rm = dao.selectReviewJoinMember(recipeId);
        session.close();
        return rm;
    }

    public void editReview(RecipeReview r){
        SqlSession session = sqlSessionFactory.openSession();
        RecipeReviewDao dao = session.getMapper(RecipeReviewDao.class);
        dao.editReview(r);
        session.commit();
        session.close();
    }

    public void delReview(int id){
        SqlSession session = sqlSessionFactory.openSession();
        RecipeReviewDao dao = session.getMapper(RecipeReviewDao.class);
        dao.delReview(id);
        session.commit();
        session.close();
    }

    // like
    public void addLike(int memberId, int reviewId) {
        SqlSession session = sqlSessionFactory.openSession();
        RecipeReviewDao dao = session.getMapper(RecipeReviewDao.class);
        dao.insertReviewLike(memberId, reviewId);
        session.commit();
        session.close();
    }

    public void delLike(int memberId, int reviewId) {
        SqlSession session = sqlSessionFactory.openSession();
        RecipeReviewDao dao = session.getMapper(RecipeReviewDao.class);
        dao.deleteReviewLike(memberId, reviewId);
        session.commit();
        session.close();
    }

    public boolean isLiked(int memberId, int reviewId) {
        SqlSession session = sqlSessionFactory.openSession();
        RecipeReviewDao dao = session.getMapper(RecipeReviewDao.class);
        int isExist = dao.isLikedReview(memberId, reviewId);
        session.close();
        return isExist != 0;
    }

    public List<RecipeReview> getLikedReviews(int recipeId) {
        SqlSession session = sqlSessionFactory.openSession();
        RecipeReviewDao dao = session.getMapper(RecipeReviewDao.class);
        List<RecipeReview> r = dao.selectLikedReviews(recipeId);
        session.close();
        return r;
    }

    public int getLikeCnt(int reviewId) {
        SqlSession session = sqlSessionFactory.openSession();
        RecipeReviewDao dao = session.getMapper(RecipeReviewDao.class);
        int likeCnt = dao.selectLikeCnt(reviewId);
        session.close();
        return likeCnt;
    }
    //like 끝

}
