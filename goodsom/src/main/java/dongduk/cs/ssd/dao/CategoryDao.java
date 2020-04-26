package dongduk.cs.ssd.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import dongduk.cs.ssd.domain.Category;

public interface CategoryDao {
	
	List<Category> getCategoryList(String menuId) throws DataAccessException;

	Category getCategory(String categoryId) throws DataAccessException;

}
