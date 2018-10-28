package cn.aynu.service.imp;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
	 * @see cn.aynu.service.BaseService#infoProcessing() 信息 处理 每个选择题 的每个选项 都在相应的list
	 * 里
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
			 * 加入统计列 共两列 不在循环内 需要放在内循环外 在加入list前 放入队列
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
	private String countPercent(Integer num, Integer countAll) {
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

	@Override
	public void putExcel(ResultCount resultCount) throws Exception {
		int sum = selectAll();
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("Excel Sheet");
		HSSFRow rowhead = sheet.createRow((short) 0);
		rowhead.createCell((short) 0).setCellValue("总计：" + sum);
		rowhead.createCell((short) 1).setCellValue("(A)在听课 学的还可以");
		rowhead.createCell((short) 2).setCellValue("(B)在听课 学的一般");
		rowhead.createCell((short) 3).setCellValue("(C)在听课，但听不很懂");
		rowhead.createCell((short) 4).setCellValue("(D)没听课,课程本身没意思");
		rowhead.createCell((short) 5).setCellValue("(E)没听课，感觉课程将来没用");
		rowhead.createCell((short) 6).setCellValue("总计:在听课百分比(A,B,C)");
		rowhead.createCell((short) 7).setCellValue("总计:没听课百分比(D,E)");
		List lp = new ArrayList<>();
		lp.add("问题");
		lp.add("JavaEE的SSM框架课");
		lp.add("Oracle数据库");
		lp.add("计算机网络课程");
		lp.add("软件工程导论课");
		lp.add("企业项目实战课");
		for (int i = 1; i < lp.size(); i++) {
			List l1 = new ArrayList();
			switch (i) {
			case 1:
				l1 = resultCount.getOne();
				break;
			case 2:
				l1 = resultCount.getTwo();
				break;
			case 3:
				l1 = resultCount.getThree();
				break;
			case 4:
				l1 = resultCount.getFour();
				break;
			case 5:
				l1 = resultCount.getFive();
				break;
			}
			HSSFRow row = sheet.createRow((short) i);
			row.createCell((short) 0).setCellValue(lp.get(i).toString());
			row.createCell((short) 1).setCellValue(l1.get(0).toString());
			row.createCell((short) 2).setCellValue(l1.get(1).toString());
			row.createCell((short) 3).setCellValue(l1.get(2).toString());
			row.createCell((short) 4).setCellValue(l1.get(3).toString());
			row.createCell((short) 5).setCellValue(l1.get(4).toString());
			row.createCell((short) 6).setCellValue(l1.get(5).toString());
			row.createCell((short) 7).setCellValue(l1.get(6).toString());
		}

		FileOutputStream fileOut;
		fileOut = new FileOutputStream("d:\\excelFile.xls");
		wb.write(fileOut);
		fileOut.close();
		System.out.println("Data is saved in excel file.");
	}

}
