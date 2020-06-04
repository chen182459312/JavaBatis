

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

public interface IUserDao {

    @Insert("insert into em_us_tb (id,name,birthday) values (#{id},#{name},#{birthday});")
    void insert(User user);

    @Select("select * from em_us_tb")
    List<User> findAll();
}
