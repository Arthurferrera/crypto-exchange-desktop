package br.unip.estrutura;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

	public static void main(String[] args) {
		FrmLogin login = new FrmLogin();
		
		login.setSize(370, 240);
		login.setResizable(false);
		login.setVisible(true);
		
		//instancia com a data do sistema
//		Calendar calendar = new GregorianCalendar();
//		ArrayList<String> datas = new ArrayList<>();
//		
//		String data = calendar.get(Calendar.DAY_OF_MONTH) + "/" + 
//			(calendar.get(Calendar.MONTH) + 1);
		
//		datas.add(data);
//		
//		for(int i = 1; i < 7; i++) {
//			calendar.add(Calendar.DAY_OF_MONTH, -1);
//			String dataMenos = calendar.get(Calendar.DAY_OF_MONTH) + "/" + 
//					(calendar.get(Calendar.MONTH) + 1);
//			datas.add(dataMenos);
//			System.out.println(dataMenos);
//		}
//		
//		System.out.println(datas);
		
		

	}

}
