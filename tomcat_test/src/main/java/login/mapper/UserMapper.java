package login.mapper;

import login.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    /**
     * 用户登陆
     * @param username
     * @param password
     * @return
     */
    @Select("select username,password from tb_user where username = #{username} and password = #{password}")
    User select(@Param("username") String username, @Param("password") String password);

    @Select("insert into tb_user(username,password) value(#{username},#{password})")
    User create(@Param("username") String username, @Param("password") String password);

    @Select("select username from tb_user where username = #{username}")
    User find(@Param("username") String username);
}
