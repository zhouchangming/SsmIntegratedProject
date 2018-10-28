package cn.aynu.service;

import cn.aynu.po.DoubleChoses;
import cn.aynu.po.ResultCount;
import cn.aynu.po.StudentMessage;
import cn.aynu.po.User;


public interface BaseService {
	/*
	 * ��չ����  ���� ��ʦͳ����Ϣ  
	 */
	
	public ResultCount infoProcessing()throws Exception;
	
	
	/*
	 * ����  ����
	 */
	public void  addUser(User user)throws Exception;
	
	public String selectUserPassword(User user ) throws Exception;
		
	public int selectAll()throws Exception;
	
	public void deleteTable()throws Exception;
	
	public void addMessage(StudentMessage message)throws Exception;
	
	public void putExcel(ResultCount resultCount)throws Exception;
}
