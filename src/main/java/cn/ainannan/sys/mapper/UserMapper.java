package cn.ainannan.sys.mapper;


import org.springframework.stereotype.Repository;

import cn.ainannan.base.dao.BaseDao;
import cn.ainannan.sys.bean.User;

@Repository
public interface UserMapper extends BaseDao<User> {

	User checkUserName(User user);

	User getUserByUserName(User user);

	/**
	 * 新增登录记录
	 * @param user
	 */
	void insertLoginRecord(User user);
}
