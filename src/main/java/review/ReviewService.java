package review;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import sqlsession.Factory;

import java.util.List;

public class ReviewService {
    private SqlSessionFactory sqlSessionFactory;

    public ReviewService() {
        sqlSessionFactory = Factory.getSqlSessionFactory();
    }

    public void addReview(Review r) {
        SqlSession session = sqlSessionFactory.openSession();
        ReviewDao dao = session.getMapper(ReviewDao.class);
        dao.addReview(r);
        session.commit();
        session.close();
    }


    public Review getReview(int num){
        SqlSession session = sqlSessionFactory.openSession();
        ReviewDao dao = session.getMapper(ReviewDao.class);
        Review r = dao.selectReview(num);
        session.close();
        return r;
    }

    public List<Review> getAll(){
        SqlSession session = sqlSessionFactory.openSession();
        ReviewDao dao = session.getMapper(ReviewDao.class);
        List<Review> r = dao.selectAll();
        session.close();
        return r;
    }

    public List<Review> getReviewByWriter(String writerId){
        SqlSession session = sqlSessionFactory.openSession();
        ReviewDao dao = session.getMapper(ReviewDao.class);
        List<Review> r = dao.selectReviewByWriter(writerId);
        session.close();
        return r;
    }

    public List<Review> getReviewByRecipe(int recipeId){
        SqlSession session = sqlSessionFactory.openSession();
        ReviewDao dao = session.getMapper(ReviewDao.class);
        List<Review> r = dao.selectReviewByRecipe(recipeId);
        session.close();
        return r;
    }

    public List<ReviewMember> getReviewMember(int recipeId){
        SqlSession session = sqlSessionFactory.openSession();
        ReviewDao dao = session.getMapper(ReviewDao.class);
        List<ReviewMember> rm = dao.selectReviewJoinMember(recipeId);
        session.close();
        return rm;
    }

    public void editReview(Review r){
        SqlSession session = sqlSessionFactory.openSession();
        ReviewDao dao = session.getMapper(ReviewDao.class);
        dao.editReview(r);
        session.commit();
        session.close();
    }

    public void delReview(int id){
        SqlSession session = sqlSessionFactory.openSession();
        ReviewDao dao = session.getMapper(ReviewDao.class);
        dao.delReview(id);
        session.commit();
        session.close();
    }

    // like
    public void addLike(int memberId, int reviewId) {
        SqlSession session = sqlSessionFactory.openSession();
        ReviewDao dao = session.getMapper(ReviewDao.class);
        dao.insertReviewLike(memberId, reviewId);
        session.commit();
        session.close();
    }

    public void delLike(int memberId, int reviewId) {
        SqlSession session = sqlSessionFactory.openSession();
        ReviewDao dao = session.getMapper(ReviewDao.class);
        dao.deleteReviewLike(memberId, reviewId);
        session.commit();
        session.close();
    }

    public boolean isLiked(int memberId, int reviewId) {
        SqlSession session = sqlSessionFactory.openSession();
        ReviewDao dao = session.getMapper(ReviewDao.class);
        int isExist = dao.isLikedReview(memberId, reviewId);
        session.close();
        return isExist != 0;
    }

    public List<Review> getLikedReviews(int recipeId) {
        SqlSession session = sqlSessionFactory.openSession();
        ReviewDao dao = session.getMapper(ReviewDao.class);
        List<Review> r = dao.selectLikedReviews(recipeId);
        session.close();
        return r;
    }

    public int getLikeCnt(int reviewId) {
        SqlSession session = sqlSessionFactory.openSession();
        ReviewDao dao = session.getMapper(ReviewDao.class);
        int likeCnt = dao.selectLikeCnt(reviewId);
        session.close();
        return likeCnt;
    }
    //like 끝

}
