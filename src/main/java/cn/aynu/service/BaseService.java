package cn.aynu.service;

import cn.aynu.po.DoubleChoses;
import cn.aynu.po.ResultCount;
import cn.aynu.po.StudentMessage;
import cn.aynu.po.User;


public interface BaseService {
	/*
	 * 扩展方法  用于 教师统计信息  
	 */
	
	public ResultCount infoProcessing()throws Exception;
	
	
	/*
	 * 基础  方法
	 */
	public void  addUser(User user)throws Exception;
	
	public String selectUserPassword(User user ) throws Exception;
		
	public int selectAll()throws Exception;
	
	public void deleteTable()throws Exception;
	
	public void addMessage(StudentMessage message)throws Exception;
	
	public void putExcel(ResultCount resultCount)throws Exception;
}
