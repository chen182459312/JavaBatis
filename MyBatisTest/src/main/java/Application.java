

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.Date;
import java.util.List;


public class Application {

    public static void main(String[] args)  {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = factory.openSession();
            IUserDao dao=sqlSession.getMapper(IUserDao.class);
            List<User> list = dao.findAll();
            User usr = new User();
            String name = String.format("name_%d", System.currentTimeMillis() % 100 );
            usr.setName(name);
            Date date = new Date();
            usr.setBirthday(date );// System.currentTimeMillis()
            dao.insert(usr);
            sqlSession.commit();
            System.out.println("done.");
        } catch (Exception e) {
            System.out.println(e);
        }
        finally {
            System.out.println("finally.");
        }

    }
}
