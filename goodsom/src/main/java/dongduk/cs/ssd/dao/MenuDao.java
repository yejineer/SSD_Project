package dongduk.cs.ssd.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import dongduk.cs.ssd.domain.Menu;

public interface MenuDao {
	
	List<Menu> getMenuList() throws DataAccessException;

	Menu getMenu(int menuId) throws DataAccessException;
}
