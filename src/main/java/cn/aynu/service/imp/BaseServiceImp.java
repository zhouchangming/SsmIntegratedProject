package cn.aynu.service.imp;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.aynu.mapper.StudentMapper;
import cn.aynu.mapper.UserMapper;
import cn.aynu.po.DoubleChoses;
import cn.aynu.po.ResultCount;
import cn.aynu.po.StudentMessage;
import cn.aynu.po.User;
import cn.aynu.service.BaseService;

public class BaseServiceImp implements BaseService {

	@Autowired
	StudentMapper studentMapper;
	@Autowired
	UserMapper userMapper;

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.aynu.service.BaseService#infoProcessing() 
	 *  信息 处理 每个选择题 的每个选项 都在相应的list 里
	 * 
	 */
	@Override
	public ResultCount infoProcessing() throws Exception {

		Integer countAll = studentMapper.selectAll();
		ResultCount resultCount = new ResultCount();
		
		DoubleChoses doubleChoses = new DoubleChoses();
		String[] select = { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten" };
		String[] op = { "A", "B", "C", "D", "E" };

		for (int i = 0; i < select.length; i++) {
			Integer learn = 0;
			Integer learned = 0;
			List<String> list = new LinkedList<String>();
			for (int j = 0; j < op.length; j++) {

				Integer num = null;
				doubleChoses.setFirst(select[i]);
				doubleChoses.setSecond(op[j]);

				num = studentMapper.selectChoose(doubleChoses);

				if (j <= 2) {
					learn = learn + num;
				} else {
					learned = learned + num;
				}
				String tem = countPercent(num, countAll);
				list.add(tem);
			}
			/*
			 * 加入统计列  共两列  不在循环内 需要放在内循环外 在加入list前 放入队列
			 */
			list.add(countPercent(learn, countAll));
			list.add(countPercent(learned, countAll));
			switch (i) {
			case 0:
				resultCount.setOne(list);

				break;
			case 1:
				resultCount.setTwo(list);

				break;
			case 2:
				resultCount.setThree(list);

				break;
			case 3:
				resultCount.setFour(list);

				break;
			case 4:
				resultCount.setFive(list);

				break;
			case 5:
				resultCount.setSix(list);

				break;
			case 6:
				resultCount.setSeven(list);

				break;
			case 7:
				resultCount.setEight(list);

				break;
			case 8:
				resultCount.setNine(list);

				break;
			case 9:
				resultCount.setTen(list);

				break;
			default:
				break;
			}
			list = null;

		}

		return resultCount;

	}
	/*
	 * 求某数的百分比;
	 */
	private String countPercent(Integer num,Integer countAll) {
		NumberFormat numberFormat = NumberFormat.getPercentInstance();
		numberFormat.setMaximumFractionDigits(2);
		double d = (double) num / countAll;
		String tem = numberFormat.format(d);
		return tem;
	}

	@Override
	public void addUser(User user) throws Exception {
		userMapper.addUser(user);

	}

	@Override
	public String selectUserPassword(User user) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.selectUserPassword(user);
	}

	@Override
	public void deleteTable() throws Exception {
		studentMapper.deleteTable();

	}

	@Override
	public void addMessage(StudentMessage message) throws Exception {
		studentMapper.addMessage(message);

	}

	@Override
	public int selectAll() throws Exception {
		// TODO Auto-generated method stub
		return studentMapper.selectAll();
	}

}
