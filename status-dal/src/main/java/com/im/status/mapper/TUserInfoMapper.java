package com.im.status.mapper;

import com.im.status.model.user.TUserInfo;

import java.util.List;
import java.util.Map;

public interface TUserInfoMapper {

	public List<TUserInfo> select(TUserInfo tUserInfo);
	public TUserInfo selectById(String id);
	public void deleteById(String id);
	public void delete(Map<String, Object> map);
	public void insert(TUserInfo tUserInfo);
	public void updateByIdSelective(TUserInfo tUserInfo);
	public void updateById(TUserInfo tUserInfo);
	public long selectCount(TUserInfo tUserInfo);

}
