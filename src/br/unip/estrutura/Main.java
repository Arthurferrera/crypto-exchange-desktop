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

		Calendar calendar = new GregorianCalendar();
		calendar.add(Calendar.MONTH, -1);
		String dataMenos = (calendar.get(Calendar.MONTH) + 1) + "";
		System.out.println(dataMenos);
	}

}
