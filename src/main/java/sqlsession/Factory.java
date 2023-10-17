package sqlsession;

import bookmark.BookmarkDao;
import follow.FollowDao;
import io.github.cdimascio.dotenv.Dotenv;
import member.MemberDao;
import memberrecipe.MemberRecipeDao;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import recipe.RecipeDao;
import recipereview.RecipeReviewDao;
import review.ReviewDao;

public class Factory {
	private static SqlSessionFactory sqlSessionFactory;
	// 초기화 블록:멤버 변수 초기화하는 블록

	static {
		if (sqlSessionFactory == null) {
			// Dotenv 객체 생성
			Dotenv dotenv = Dotenv.load();

			// 환경변수에서 데이터베이스 연결 정보 가져오기
			String driver = dotenv.get("DB_DRIVER");
			String url = dotenv.get("DB_URL");
			String username = dotenv.get("DB_USERNAME");
			String password = dotenv.get("DB_PASSWORD");

			// DataSource 생성 및 설정
			PooledDataSource dataSource = new PooledDataSource();
			dataSource.setDriver(driver);
			dataSource.setUrl(url);
			dataSource.setUsername(username);
			dataSource.setPassword(password);

			// TransactionFactory 및 Environment 생성
			TransactionFactory transactionFactory = new JdbcTransactionFactory();
			Environment environment = new Environment.Builder("mybatis_test")
					.transactionFactory(transactionFactory)
					.dataSource(dataSource)
					.build();

			// Configuration 생성 및 설정
			Configuration configuration = new Configuration(environment);

			Class[] mapperClasses = {
					MemberDao.class,
					RecipeDao.class,
					ReviewDao.class,
					MemberRecipeDao.class,
					BookmarkDao.class,
					FollowDao.class,
					RecipeReviewDao.class,
			};

			for (Class mapperClass : mapperClasses) {
				configuration.addMapper(mapperClass);
			}

			sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
//			String resource = "/config.xml";
//			Reader reader = Resources.getResourceAsReader(resource);
//
//			if (sqlSessionFactory == null) {
//				// sqlSessionFactory 객체 생성
//				// Builder: 객체 생성에 필요한 설정이 가능하고 설정한 내용으로 객체를 생성해줌
//				// build(): config.xml의 내용을 설정에 활용하여 설정함
//				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//
//				// 구현할 맵퍼 등록
//				Class[] mapper = {
//						MemberDao.class,
//            			RecipeDao.class,
//            			ReviewDao.class,
//				};
//				for (Class m : mapper) {
//					// sqlSessionFactory에 맵퍼를 등록
//					sqlSessionFactory.getConfiguration().addMapper(m);
//				}
		}
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}