package com.im.status.mapper;

import com.im.status.model.req.UserReq;
import com.im.status.model.user.TUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TUserMapper {

	public List<TUser> select(@Param("params") UserReq userReq);
	public TUser selectById(@Param("id") String id);
	public void deleteById(@Param("id")String id);
	public void delete(@Param("params") UserReq userReq);
	public void insert(TUser tUser);
	public void updateByIdSelective(@Param("params") UserReq userReq);
	public long selectCount(@Param("params") UserReq userReq);

}
