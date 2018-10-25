package cn.aynu.mapper;

import cn.aynu.po.DoubleChoses;
import cn.aynu.po.StudentMessage;


public interface StudentMapper {
	/*
	 * 通过choses 对象实现对题号选项的查询
	 */
	public Integer selectChoose(DoubleChoses choses)throws Exception;
	/*
	 * 查询所有
	 */
	public Integer selectAll()throws Exception;
	/*
	 * 删除 表数据
	 */
	public void deleteTable()throws Exception;
	/*
	 * 添加学生调查信息
	 */
	public void addMessage(StudentMessage message)throws Exception;
	
	
}
