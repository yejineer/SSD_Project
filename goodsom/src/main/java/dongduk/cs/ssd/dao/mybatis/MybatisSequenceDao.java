package dongduk.cs.ssd.dao.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import dongduk.cs.ssd.dao.SequenceDao;
import dongduk.cs.ssd.dao.mybatis.mapper.SequenceMapper;
import dongduk.cs.ssd.domain.Sequence;

@Repository
public class MybatisSequenceDao implements SequenceDao {

	@Autowired
	protected SequenceMapper sequenceMapper;

	public int getNextId(String name) throws DataAccessException {
		Sequence sequence = new Sequence();
		sequence.setName(name);
		sequence = sequenceMapper.getSequence(sequence);
		return sequence.getNextId();
	}
}
