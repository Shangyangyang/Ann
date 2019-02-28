package cn.ainannan.sys.service;

import org.springframework.stereotype.Service;

import cn.ainannan.base.service.BaseService;
import cn.ainannan.sys.bean.User;
import cn.ainannan.sys.mapper.UserMapper;

@Service
public class UserService extends BaseService<UserMapper, User>{

	public User checkUserName(User user) {
		return dao.checkUserName(user);
	}

	public User getUserByUserName(User user) {
		return dao.getUserByUserName(user);
	}

	/**
	 * 新增登录记录
	 * @param user
	 */
	public void insertLoginRecord(User user) {
		dao.insertLoginRecord(user);
	}
}
