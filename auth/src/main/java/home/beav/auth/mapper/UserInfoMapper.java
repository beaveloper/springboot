package home.beav.auth.mapper;

import home.beav.auth.vo.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper {

    UserInfo findUserAccount(String userId);

    int saveUser(UserInfo userInfo);

}
