SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS timeline;
DROP TABLE IF EXISTS timeline_label;
DROP TABLE IF EXISTS timeline_label_quick;
DROP TABLE IF EXISTS timeline_pic;
DROP TABLE IF EXISTS timeline_similar;




/* Create Tables */

CREATE TABLE timeline
(
	-- 主键
	ID varchar(32) NOT NULL COMMENT '主键',
	-- 图片关联ID
	pic_id varchar(32) COMMENT '图片关联ID',
	-- 1雪碧2乐乐
	type varchar(4) COMMENT '1雪碧2乐乐',
	-- 标签
	label varchar(200) COMMENT '标签',
	-- 打分
	score decimal(10,1) COMMENT '打分',
	-- 简介
	reason varchar(500) COMMENT '简介',
	-- 创建时间
	create_date datetime COMMENT '创建时间',
	-- 创建人
	create_user varchar(32) COMMENT '创建人',
	-- 修改时间
	update_date datetime COMMENT '修改时间',
	-- 修改用户
	update_user varchar(32) COMMENT '修改用户',
	-- 1. 已删除
	-- 0. 未删除
	del_flag varchar(2) COMMENT '1. 已删除
0. 未删除',
	PRIMARY KEY (ID)
);


CREATE TABLE timeline_label
(
	-- 主键
	ID varchar(32) NOT NULL COMMENT '主键',
	-- 标签名
	NAME varchar(50) COMMENT '标签名',
	-- 1地点2物品3表情4动作
	TYPE varchar(4) COMMENT '1地点2物品3表情4动作',
	-- 1雪碧2乐乐
	BELONG varchar(4) COMMENT '1雪碧2乐乐',
	-- 1已通过0未通过
	STATUS varchar(2) COMMENT '1已通过0未通过',
	-- 说明
	REASON varchar(200) COMMENT '说明',
	-- 选择次数
	SELECT_NUM int COMMENT '选择次数',
	-- 字体颜色
	FONTCOLOR varchar(20) COMMENT '字体颜色',
	-- 背影颜色
	BGCOLOR varchar(20) COMMENT '背影颜色',
	-- 创建时间
	create_date datetime COMMENT '创建时间',
	-- 创建人
	create_user varchar(32) COMMENT '创建人',
	-- 修改时间
	update_date datetime COMMENT '修改时间',
	-- 修改用户
	update_user varchar(32) COMMENT '修改用户',
	-- 1. 已删除
	-- 0. 未删除
	del_flag varchar(2) COMMENT '1. 已删除
0. 未删除',
	PRIMARY KEY (ID)
);


CREATE TABLE timeline_label_quick
(
	-- 主键
	id varchar(32) NOT NULL COMMENT '主键',
	-- 别名
	name varchar(50) COMMENT '别名',
	-- 标签组
	labels varchar(200) COMMENT '标签组',
	-- 1雪碧2乐乐
	belong varchar(4) COMMENT '1雪碧2乐乐',
	-- 创建时间
	create_date datetime COMMENT '创建时间',
	-- 创建人
	create_user varchar(32) COMMENT '创建人',
	-- 修改时间
	update_date datetime COMMENT '修改时间',
	-- 修改用户
	update_user varchar(32) COMMENT '修改用户',
	-- 1. 已删除
	-- 0. 未删除
	del_flag varchar(2) COMMENT '1. 已删除
0. 未删除',
	PRIMARY KEY (id)
);


CREATE TABLE timeline_pic
(
	-- 主键
	ID varchar(32) NOT NULL COMMENT '主键',
	-- 短ID
	short_ID varchar(8) COMMENT '短ID',
	-- 文件名
	filename varchar(200) COMMENT '文件名',
	-- 路径
	path varchar(300) COMMENT '路径',
	-- 访问路径
	src varchar(300) COMMENT '访问路径',
	-- 缩略图路径
	src_thumbnail varchar(200) COMMENT '缩略图路径',
	-- 后缀名
	suffix varchar(10) COMMENT '后缀名',
	-- 大小
	size int COMMENT '大小',
	-- md5码
	MD5 varchar(64) COMMENT 'md5码',
	-- 图片指纹
	finger_print varchar(64) COMMENT '图片指纹',
	-- 拍摄时间
	shot_date datetime COMMENT '拍摄时间',
	-- 类似图片主键
	similar_id varchar(400) COMMENT '类似图片主键',
	-- 状态
	state varchar(2) COMMENT '状态',
	-- 创建时间
	create_date datetime COMMENT '创建时间',
	-- 创建人
	create_user varchar(32) COMMENT '创建人',
	-- 修改时间
	update_date datetime COMMENT '修改时间',
	-- 修改用户
	update_user varchar(32) COMMENT '修改用户',
	-- 1. 已删除
	-- 0. 未删除
	del_flag varchar(2) COMMENT '1. 已删除
0. 未删除',
	PRIMARY KEY (ID)
);


CREATE TABLE timeline_similar
(
	-- picid
	picid varchar(8) COMMENT 'picid',
	-- 比对图片的id
	otherid varchar(8) COMMENT '比对图片的id',
	-- 相似度
	similarity decimal(6,2) COMMENT '相似度',
	UNIQUE (picid, otherid)
);



