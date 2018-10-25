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
	 * 登录的处理器  
	 */
	@RequestMapping("/login.handler")
	public String login(HttpSession Session,User user,Model model)throws Exception{
		
		/*
		 * 验证  账号密码 其中一个为空登录失败  返回登录页面
		 */
		if(user.getUsername()==null||user.getPassword()==null){
			return "/jsp/login.jsp";
		}
		/*
		 * 吧用户名放入 session 表示登录成功
		 */
		if(user.getPassword().equals(baseService.selectUserPassword(user))){
			Session.setAttribute("username", user.getUsername());
		}else{
			model.addAttribute("error", "用户名密码错误");
			return "/jsp/login.jsp";
		}
		
		return "/resultable.handler";
	}
	
	
	/*
	 * 退出的处理器
	 */
	@RequestMapping("/loginout.handler")
	public String loginout(HttpSession Session )throws Exception{
		
		Session.invalidate();
		
		return "/jsp/login.jsp";
	}
	
	
	
	
}
