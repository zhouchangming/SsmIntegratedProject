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
	 * 用户调查调度	
	 */
	@RequestMapping("/queryindex.handler")
	public String queryindex(Model model,HttpSession session) throws Exception{
	
		return "/jsp/queryindex.jsp";
		
	}
	
	/*
	 * 统计结果调度
	 */
	@RequestMapping("/resultable.handler")
	public String resultable(Model model ) throws Exception{
		
		/*
		 * 返回  ResultCount  返回给前端 的是ResultCount 统计结果对象
		 */
		ResultCount resultCount = null;
		resultCount = baseService.infoProcessing();
		model.addAttribute("resultCount", resultCount);
		model.addAttribute("allCount", baseService.selectAll());
		return "/jsp/resultable.jsp";
		
	}
	/*
	 * 统计成功调度
	 */
	@RequestMapping("/submitsuccess.handler")
	public String submitsuccess(Model model,HttpSession session,StudentMessage message) throws Exception{
		/*
		 * 如果 用户session 有submited 的值 表示已经调查过 不能重复调查 
		 * 不向下执行
		 */
		if(session.getAttribute("submited")!=null){
			return "/jsp/submitsuccess.jsp";
		}
		
		/*
		 * 第一次提交 把提交数据 交给数据库 
		 */
		baseService.addMessage(message);
		
		session.setAttribute("submited", "you are already submit");
			
		return "/jsp/submitsuccess.jsp";
		
	}
	/*
	 * 把数据库清空   以便下次调查
	 */
	@RequestMapping("deleteAllData.handler")
	public String deleteAllData() throws Exception{
		
		baseService.deleteTable();
		
		return "/jsp/index.jsp";
	}
	
	
}
