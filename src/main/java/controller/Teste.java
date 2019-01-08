package controller;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar cal = new GregorianCalendar();
		cal = Calendar.getInstance();
		int ultDia = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int mes = cal.get(Calendar.MONTH);
		mes = mes+1;
		int ano = cal.get(Calendar.YEAR);
		String data = ano+"-"+mes+"-"+ultDia;
		System.out.println(data);
		
		//int dataInicio = cal.getMinimum(GregorianCalendar.DAY_OF_MONTH);
		//System.out.println(dataInicio);
		//int d = Calendar.getInstance().getActualMinimum(Calendar.DAY_OF_MONTH);
		//Date date = new Date(d);
		//System.out.println(date);
		//int ano = Calendar.getInstance().get(Calendar.YEAR);
		//int mes = Calendar.getInstance().get(Calendar.MONTH);
		//Date dataInicio = new Date(ano+"/"+mes+"/"+Calendar.getInstance().getActualMinimum(Calendar.DAY_OF_MONTH));
		//Date dataFim = new Date(ano+"/"+mes+"/"+Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH));
		//System.out.println("Data inicio: "+dataInicio+"/n"+"Data Fim: "+dataFim);

	}

}
