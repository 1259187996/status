package com.im.status.mapper;

import com.im.status.model.user.TUserLoginLog;

import java.util.List;
import java.util.Map;

public interface TUserLoginLogMapper {

	public List<TUserLoginLog> select(TUserLoginLog tUserLoginLog);
	public TUserLoginLog selectById(String id);
	public void deleteById(String id);
	public void delete(Map<String, Object> map);
	public void insert(TUserLoginLog tUserLoginLog);
	public void updateByIdSelective(TUserLoginLog tUserLoginLog);
	public void updateById(TUserLoginLog tUserLoginLog);
	public long selectCount(TUserLoginLog tUserLoginLog);

}
