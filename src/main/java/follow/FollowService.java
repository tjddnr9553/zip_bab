package follow;

import member.Member;
import member.MemberDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import sqlsession.Factory;

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
}
