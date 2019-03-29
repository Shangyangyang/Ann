# Ann
个人学习项目 springboot + mybatis + mysql

[配套的前端项目vue + element](https://github.com/Shangyangyang/AnnFront)

### 进度罗列
	1. 照片显示到页面中									（完成）
	2. 前端定时向后台获取进度的功能					（完成）2018年8月29日 下午9:10:03
	3. 前端功能模块-保存照片到图片库				（完成）2018年8月29日 下午9:10:03
	4. 尝试在使用长时间未响应的功能时，动态调整超时时间	（完成）2018年8月30日 下午8:13:09
	5. 前端功能模块-清除文件不存在但数据库中仍有的数据		（完成）2018年8月30日 下午8:13:09
	6. 去重功能雏形							（完成）2018年9月17日 下午8:58:28
	7. springboot过滤器研究					（完成）2018年9月17日 下午8:58:28
	8. 礼金增删改查							（完成）2018年9月4日 下午4:48:21
	9. 导出为excel研究						（完成）2018年9月3日 下午12:33:08
	10. 解决前端日期显示带一串零的问题				（完成）2018年8月30日 下午10:07:38
	11. 后端代码生成研究						（完成）2018年9月26日 下午2:10:28
	12. 礼金导出为excel功能						（完成）2018年9月4日 下午7:36:15
	13. 拍摄时间填充功能						（完成）2018年9月19日 下午7:36:15
	14. 时光轴功能后端代码						（完成）2018年9月29日 下午1:36:15
	15. 时光轴功能筛选照片功能					（完成）2018年9月29日 下午1:36:15
	16. 登录功能的探索-1 过滤器的拦截				（完成）2019年2月26日 下午1:36:15
	17. 登录功能的探索-2 用户的验证					（完成）2019年2月26日 下午1:36:15
	18. 登录功能的探索-3 登录功能					（完成）2019年2月28日 下午12:36:15
		1. 前端页面			（完成）2019年2月26日 下午1:36:15
		2. 密码验证			（完成）2019年2月27日 上午10:36:15
		3. 验证码图片		（完成）2019年2月28日 上午10:36:15
			需要配套的nginx和reids session，不能独立运行。
		4. 写缓存			（完成）2019年2月28日 下午12:36:15
		
	19. 把excel导出换成最新版的，					（）
	20. 相册筛选功能-添加查看所有标签的功能			（完成）2019年3月1日 下午12:36:15
		1. 表设计			（完成）2019年3月1日 下午12:36:15
		2. 代码生成			（完成）2019年3月1日 下午12:36:15
		3. 循环添加已存在的	（完成）2019年3月1日 下午12:36:15
		4. 添加标签的组件		（完成）2019年3月1日 下午12:36:15
		5. 审核标签页面		（完成）2019年3月1日 下午12:36:15
		6. 标签选择组件		（完成）2019年3月4日 下午17:36:15
			1. 用tag展示			（完成）2019年3月1日 下午12:36:15
			2. 选择tag，并在下方动态展示	（完成）2019年3月1日 下午12:36:15
			3. 可删除的tag			（完成）2019年3月4日 下午12:36:15
			4. 查询筛选功能			（完成）2019年3月4日 下午12:36:15
			5. 做成点击展开的dialog		（完成）2019年3月4日 下午12:36:15
			6. 完成子组件与父组件的通信功能	（完成）2019年3月4日 下午17:36:15
		7. 标签表增加两个字段，	（完成）2019年3月8日 下午2:48:15
			一个是字体颜色，一个是背景颜色，这样可以保证每次调用都是同一种颜色，增加用户的记忆。
		
	26. 快捷标签功能							（完成）2019年3月28日 下午6:27:58
		1. 设计表						（完成）2019年3月28日 下午6:27:58
			1. 可以快速的选择一组标签， 可以新建组、编辑组、带别名。
			2. 数据库保存为id,name;id,name;id,name;
		2. 页面功能						（完成）2019年3月28日 下午6:27:58
			增删改查
		3. 后端功能						（完成）2019年3月28日 下午6:27:58
			代码生成
		4. 形成组件，可以做成下拉框，
			把选中的快捷选择的值放到标签选择里去。	（完成）2019年3月28日 下午6:27:58
		
		
	28. 将相册筛选-雪碧的首页设计成列表				（）
		1. 列表展示						（2019年3月29日 下午2:46:09）
		2. 查询条件						（）
		3. 点击图片放大显示，就是加上那个组件		（2019年3月29日 下午3:15:41）

----
	
	27. 图片增加腾讯标签查询，把返回结果保存在表中		（暂停，接口不能用了。）
	29. 重写下拉列表组件、单选组件					（暂停，下拉组件已经有了，单选等用到再做）
	
	21. 用户角色功能设计						（）
	22. 动态加载菜单							（）
	23. 探索代码生成模块						（）
	25. 用websocket开发一个网络聊天室				（）
	34. 用websocket解决进度条超时的问题				（）
	
	24. 学习项目的消息队列功能					（）
	30. 研究系统在线人数是怎么实现的				（）
	31. 研究JMS的实现原理、如果快速配置				（）
	32. 研究vue + element中的缓存如果配置的			（）
	33. 研究element下的break组件实现原理，
		是怎么做到统一应用的。					（）
	
	