package review;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import sqlsession.Factory;

import java.util.ArrayList;

public class ReviewService {
    private SqlSessionFactory sqlSessionFactory;

    public ReviewService() {
        sqlSessionFactory = Factory.getSqlSessionFactory();
    }

    public void addReview(Review r) {
        SqlSession session = sqlSessionFactory.openSession();
        ReviewDao dao = (ReviewDao) session.getMapper(ReviewDao.class);
        dao.addReview(r);
        session.commit();
        session.close();
    }


    public Review getReview(int num){
        SqlSession session = sqlSessionFactory.openSession();
        ReviewDao dao = (ReviewDao) session.getMapper(ReviewDao.class);
        Review r = dao.selectReview(num);
        session.close();
        return r;
    }

    public ArrayList<Review> getAll(){
        SqlSession session = sqlSessionFactory.openSession();
        ReviewDao dao = (ReviewDao) session.getMapper(ReviewDao.class);
        ArrayList<Review> r = dao.selectAll();
        session.close();
        return r;
    }

    public ArrayList<Review> getReviewByWriter(String writerId){
        SqlSession session = sqlSessionFactory.openSession();
        ReviewDao dao = (ReviewDao) session.getMapper(ReviewDao.class);
        ArrayList<Review> r = dao.selectReviewByWriter(writerId);
        session.close();
        return r;
    }

    public ArrayList<Review> getReviewByRecipe(int recipeId){
        SqlSession session = sqlSessionFactory.openSession();
        ReviewDao dao = (ReviewDao) session.getMapper(ReviewDao.class);
        ArrayList<Review> r = dao.selectReviewByRecipe(recipeId);
        session.close();
        return r;
    }

    public ArrayList<ReviewMember> getReviewMember(int recipeId){
        SqlSession session = sqlSessionFactory.openSession();
        ReviewDao dao = (ReviewDao) session.getMapper(ReviewDao.class);
        ArrayList<ReviewMember> rm = dao.selectReviewJoinMember(recipeId);
        session.close();
        return rm;
    }

    public void editReview(Review r){
        SqlSession session = sqlSessionFactory.openSession();
        ReviewDao dao = (ReviewDao) session.getMapper(ReviewDao.class);
        dao.editReview(r);
        session.commit();
        session.close();
    }

    public void delReview(int id){
        SqlSession session = sqlSessionFactory.openSession();
        ReviewDao dao = (ReviewDao) session.getMapper(ReviewDao.class);
        dao.delReview(id);
        session.commit();
        session.close();
    }

}
