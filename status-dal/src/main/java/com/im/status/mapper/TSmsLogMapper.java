package com.im.status.mapper;

import com.im.status.model.user.TSmsLog;

import java.util.List;
import java.util.Map;

public interface TSmsLogMapper {

	public List<TSmsLog> select(TSmsLog tSmsLog);
	public TSmsLog selectById(String id);
	public void deleteById(String id);
	public void delete(Map<String, Object> map);
	public void insert(TSmsLog tSmsLog);
	public void updateByIdSelective(TSmsLog tSmsLog);
	public void updateById(TSmsLog tSmsLog);
	public long selectCount(TSmsLog tSmsLog);

}
