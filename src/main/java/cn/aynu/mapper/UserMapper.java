package cn.aynu.mapper;

import cn.aynu.po.User;

public interface UserMapper {
	
	public void  addUser(User user)throws Exception;
	
	public String selectUserPassword(User user ) throws Exception;
	
}
