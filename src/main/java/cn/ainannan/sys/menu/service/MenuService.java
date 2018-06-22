package cn.ainannan.sys.menu.service;

import org.springframework.stereotype.Service;

import cn.ainannan.base.service.CrudService;
import cn.ainannan.sys.menu.bean.Menu;
import cn.ainannan.sys.menu.mapper.MenuMapper;

@Service
public class MenuService extends CrudService<MenuMapper, Menu>{

}
