package dongduk.cs.ssd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import dongduk.cs.ssd.dao.MenuDao;
import dongduk.cs.ssd.domain.Menu;

/**
 * @author Hyekyung Kim
 * @since 2020.05.05
 */

public class MenuServiceImpl implements MenuService{

	@Autowired
	private MenuDao menuDao;
	
	@Override
	public List<Menu> getMenuList() {
		return menuDao.getMenuList();
	}

	@Override
	public Menu getMenu(int menuId) {
		return menuDao.getMenu(menuId);
	}
	
}
