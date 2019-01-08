package controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConverteData {
	public static Date converteParaDate(String Data) {
        DateFormat formatodata = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date DataGuiaformatada3 = formatodata.parse(Data);
            return DataGuiaformatada3;
        } catch (ParseException ex) {
            return null;
        }
    }

}
