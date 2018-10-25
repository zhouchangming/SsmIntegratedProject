package cn.aynu.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.aynu.mapper.StudentMapper;
import cn.aynu.po.ResultCount;
import cn.aynu.po.StudentMessage;
import cn.aynu.service.imp.BaseServiceImp;


@Controller
public class MessageControl {
	
	@Autowired
	BaseServiceImp baseService;
	
	/*
	 * �û��������	
	 */
	@RequestMapping("/queryindex.handler")
	public String queryindex(Model model,HttpSession session) throws Exception{
	
		return "/jsp/queryindex.jsp";
		
	}
	
	/*
	 * ͳ�ƽ������
	 */
	@RequestMapping("/resultable.handler")
	public String resultable(Model model ) throws Exception{
		
		/*
		 * ����  ResultCount  ���ظ�ǰ�� ����ResultCount ͳ�ƽ������
		 */
		ResultCount resultCount = null;
		resultCount = baseService.infoProcessing();
		model.addAttribute("resultCount", resultCount);
		model.addAttribute("allCount", baseService.selectAll());
		return "/jsp/resultable.jsp";
		
	}
	/*
	 * ͳ�Ƴɹ�����
	 */
	@RequestMapping("/submitsuccess.handler")
	public String submitsuccess(Model model,HttpSession session,StudentMessage message) throws Exception{
		/*
		 * ��� �û�session ��submited ��ֵ ��ʾ�Ѿ������ �����ظ����� 
		 * ������ִ��
		 */
		if(session.getAttribute("submited")!=null){
			return "/jsp/submitsuccess.jsp";
		}
		
		/*
		 * ��һ���ύ ���ύ���� �������ݿ� 
		 */
		baseService.addMessage(message);
		
		session.setAttribute("submited", "you are already submit");
			
		return "/jsp/submitsuccess.jsp";
		
	}
	/*
	 * �����ݿ����   �Ա��´ε���
	 */
	@RequestMapping("deleteAllData.handler")
	public String deleteAllData() throws Exception{
		
		baseService.deleteTable();
		
		return "/jsp/index.jsp";
	}
	
	
}
