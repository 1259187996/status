package com.im.status.mapper;

import com.im.status.model.user.TUserPwdLog;

import java.util.List;
import java.util.Map;

public interface TUserPwdLogMapper {

	public List<TUserPwdLog> select(TUserPwdLog tUserPwdLog);
	public TUserPwdLog selectById(String id);
	public void deleteById(String id);
	public void delete(Map<String, Object> map);
	public void insert(TUserPwdLog tUserPwdLog);
	public void updateByIdSelective(TUserPwdLog tUserPwdLog);
	public void updateById(TUserPwdLog tUserPwdLog);
	public long selectCount(TUserPwdLog tUserPwdLog);

}
