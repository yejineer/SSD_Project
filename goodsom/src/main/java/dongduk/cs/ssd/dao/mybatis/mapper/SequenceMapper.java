
package dongduk.cs.ssd.dao.mybatis.mapper;

import org.springframework.dao.DataAccessException;

import dongduk.cs.ssd.domain.Sequence;

public interface SequenceMapper {
	
  Sequence getSequence(Sequence sequence) throws DataAccessException;
  
  void updateSequence(Sequence sequence) throws DataAccessException;
}
