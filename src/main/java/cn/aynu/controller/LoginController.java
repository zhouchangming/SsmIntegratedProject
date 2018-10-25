package cn.aynu.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.aynu.mapper.StudentMapper;
import cn.aynu.mapper.UserMapper;
import cn.aynu.po.DoubleChoses;
import cn.aynu.po.StudentMessage;
import cn.aynu.po.User;
import cn.aynu.service.BaseService;
import cn.aynu.service.imp.BaseServiceImp;

@Controller
public class LoginController {
	
	@Autowired
	BaseServiceImp baseService;
	

	/*
	 * ��¼�Ĵ�����  
	 */
	@RequestMapping("/login.handler")
	public String login(HttpSession Session,User user,Model model)throws Exception{
		
		/*
		 * ��֤  �˺����� ����һ��Ϊ�յ�¼ʧ��  ���ص�¼ҳ��
		 */
		if(user.getUsername()==null||user.getPassword()==null){
			return "/jsp/login.jsp";
		}
		/*
		 * ���û������� session ��ʾ��¼�ɹ�
		 */
		if(user.getPassword().equals(baseService.selectUserPassword(user))){
			Session.setAttribute("username", user.getUsername());
		}else{
			model.addAttribute("error", "�û����������");
			return "/jsp/login.jsp";
		}
		
		return "/resultable.handler";
	}
	
	
	/*
	 * �˳��Ĵ�����
	 */
	@RequestMapping("/loginout.handler")
	public String loginout(HttpSession Session )throws Exception{
		
		Session.invalidate();
		
		return "/jsp/login.jsp";
	}
	
	
	
	
}
