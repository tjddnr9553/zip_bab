package follow;

import follow.handler.Follow;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import sqlsession.Factory;

import java.util.List;

public class FollowService {

    private SqlSessionFactory sqlSessionFactory;

    public FollowService() {
        sqlSessionFactory = Factory.getSqlSessionFactory();
    }

    public void addFollow(int followerId, int followingId) {
        SqlSession session = sqlSessionFactory.openSession();
        FollowDao dao = session.getMapper(FollowDao.class);
        dao.addFollow(followerId,followingId);
        session.commit();
        session.close();
    }

    public void delFollow(int followerId, int followingId) {
        SqlSession session = sqlSessionFactory.openSession();
        FollowDao dao = session.getMapper(FollowDao.class);
        dao.delFollow(followerId,followingId);
        session.commit();
        session.close();
    }

    public List<Integer> getFollowingId(int memberId) {
        SqlSession session = sqlSessionFactory.openSession();
        FollowDao dao = session.getMapper(FollowDao.class);
        List<Integer> following = dao.getFollowingId(memberId);
        session.commit();
        session.close();

        return following;
    }

    public List<Integer> getFollowerId(int memberId) {
        SqlSession session = sqlSessionFactory.openSession();
        FollowDao dao = session.getMapper(FollowDao.class);
        List<Integer> follower = dao.getFollowerId(memberId);
        session.commit();
        session.close();


        return follower;
    }

    public int getFollower(int memberId){
        SqlSession session = sqlSessionFactory.openSession();
        FollowDao dao = session.getMapper(FollowDao.class);
        int count = dao.getFollower(memberId);
        session.commit();
        session.close();
        return count;
    }



    public int getFollowing(int memberId){
        SqlSession session = sqlSessionFactory.openSession();
        FollowDao dao = session.getMapper(FollowDao.class);
        int count = dao.getFollowing(memberId);
        session.commit();
        session.close();

        return count;
    }
    public boolean isFollowed(int followerId, int followingId){
        SqlSession session = sqlSessionFactory.openSession();
        FollowDao dao = session.getMapper(FollowDao.class);
        int count = dao.getFollowCheck(followerId,followingId);
        session.close();

        return count==1;
    }

}
