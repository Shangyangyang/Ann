package cn.ainannan.sys.user.service;

import org.springframework.stereotype.Service;

import cn.ainannan.base.service.BaseService;
import cn.ainannan.sys.user.bean.User;
import cn.ainannan.sys.user.mapper.UserMapper;

@Service
public class UserService extends BaseService<UserMapper, User>{

	public User checkUserName(User user) {
		return dao.checkUserName(user);
	}

}
