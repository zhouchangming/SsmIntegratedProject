package cn.aynu.mapper;

import cn.aynu.po.DoubleChoses;
import cn.aynu.po.StudentMessage;


public interface StudentMapper {
	/*
	 * ͨ��choses ����ʵ�ֶ����ѡ��Ĳ�ѯ
	 */
	public Integer selectChoose(DoubleChoses choses)throws Exception;
	/*
	 * ��ѯ����
	 */
	public Integer selectAll()throws Exception;
	/*
	 * ɾ�� ������
	 */
	public void deleteTable()throws Exception;
	/*
	 * ���ѧ��������Ϣ
	 */
	public void addMessage(StudentMessage message)throws Exception;
	
	
}
