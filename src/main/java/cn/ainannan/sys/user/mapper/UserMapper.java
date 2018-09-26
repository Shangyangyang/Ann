package cn.ainannan.sys.user.mapper;


import org.springframework.stereotype.Repository;

import cn.ainannan.base.dao.BaseDao;
import cn.ainannan.sys.user.bean.User;

@Repository
public interface UserMapper extends BaseDao<User> {

	User checkUserName(User user);

}
