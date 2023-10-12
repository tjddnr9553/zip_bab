package bookmark;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import sqlsession.Factory;

import java.util.ArrayList;

public class BookmarkService {
    private SqlSessionFactory sqlSessionFactory;

    public BookmarkService() {
        sqlSessionFactory = Factory.getSqlSessionFactory();
    }

    //북마크 전체 출력
    public ArrayList<Bookmark> getAll(){
        SqlSession session = sqlSessionFactory.openSession();
        BookmarkDao dao = session.getMapper(BookmarkDao.class);
        ArrayList<Bookmark> list = dao.selectAll();
        session.close();
        return list;
    }

    //북마크 레시피 번호로 조회
    public ArrayList<Bookmark> getByRecipeId(int recipeId){
        SqlSession session = sqlSessionFactory.openSession();
        BookmarkDao dao = session.getMapper(BookmarkDao.class);
        ArrayList<Bookmark> list = dao.selectByRecipeId(recipeId);
        session.close();
        return list;
    }

    //북마크 레시피 번호로 조회
    public ArrayList<Bookmark> getByMemberId(int memberId){
        SqlSession session = sqlSessionFactory.openSession();
        BookmarkDao dao = session.getMapper(BookmarkDao.class);
        ArrayList<Bookmark> list = dao.selectByMemberId(memberId);
        session.close();
        return list;
    }

    //북마크 체크
    public Bookmark checkBookmark(int recipeId, int memberId){
        SqlSession session = sqlSessionFactory.openSession();
        BookmarkDao dao = session.getMapper(BookmarkDao.class);
        Bookmark b = dao.check(recipeId, memberId);
        session.close();
        return b;
    }

    //북마크 추가
    public void addBookmark(Bookmark b){
        SqlSession session = sqlSessionFactory.openSession();
        BookmarkDao dao = session.getMapper(BookmarkDao.class);
        dao.insert(b);
        session.commit();
        session.close();
    }

    //북마크 삭제
    public void delBookmark(int recipeId, int memberId){
        SqlSession session = sqlSessionFactory.openSession();
        BookmarkDao dao = session.getMapper(BookmarkDao.class);
        dao.delete(recipeId, memberId);
        session.commit();
        session.close();
    }

}
