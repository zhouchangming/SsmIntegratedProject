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
	 * @see cn.aynu.service.BaseService#infoProcessing() ��Ϣ ���� ÿ��ѡ���� ��ÿ��ѡ�� ������Ӧ��list
	 * ��
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
			 * ����ͳ���� ������ ����ѭ���� ��Ҫ������ѭ���� �ڼ���listǰ �������
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
	 * ��ĳ���İٷֱ�;
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
		rowhead.createCell((short) 0).setCellValue("�ܼƣ�" + sum);
		rowhead.createCell((short) 1).setCellValue("(A)������ ѧ�Ļ�����");
		rowhead.createCell((short) 2).setCellValue("(B)������ ѧ��һ��");
		rowhead.createCell((short) 3).setCellValue("(C)�����Σ��������ܶ�");
		rowhead.createCell((short) 4).setCellValue("(D)û����,�γ̱���û��˼");
		rowhead.createCell((short) 5).setCellValue("(E)û���Σ��о��γ̽���û��");
		rowhead.createCell((short) 6).setCellValue("�ܼ�:�����ΰٷֱ�(A,B,C)");
		rowhead.createCell((short) 7).setCellValue("�ܼ�:û���ΰٷֱ�(D,E)");
		List lp = new ArrayList<>();
		lp.add("����");
		lp.add("JavaEE��SSM��ܿ�");
		lp.add("Oracle���ݿ�");
		lp.add("���������γ�");
		lp.add("������̵��ۿ�");
		lp.add("��ҵ��Ŀʵս��");
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
