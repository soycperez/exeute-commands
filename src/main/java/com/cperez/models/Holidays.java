package com.cperez.models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.cperez.utils.Constantes;
import com.cperez.utils.Tools;

import lombok.Data;

@Data
public class Holidays {
	private String day;
	private List<String> holidays = new ArrayList<>();
	private int numberOfWorkingDay;
	private boolean workingDay;
	private String filepathHolidays;

	public Holidays() {
		throw new IllegalStateException(Constantes.UTILITY);
	}

	public Holidays(File fileHolidays) throws Exception {
		this(fileHolidays, Tools.dateToString(Constantes.FORMAT_HOLIDAYS, null));
		this.filepathHolidays = fileHolidays.toString();
	}

	public Holidays(File fileHolidays, String day) throws Exception {
		setDay(day);
		setHolidays(fileHolidays);
		countCurrentWorkingDay();
	}

	public void setHolidays(File fileHolidays) throws Exception {
		BufferedReader bufferedReader = null;
		List<String> holidays = new ArrayList<>();
		try {
			bufferedReader = new BufferedReader(new FileReader(fileHolidays));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				if (!line.isEmpty()) {
					holidays.add(line);
				}
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.holidays = holidays;
			bufferedReader.close();
		}
	}

	public void countCurrentWorkingDay() {
		int numDiaHabil = 0;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constantes.FORMAT_HOLIDAYS);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(Tools.getDateFormat(Constantes.FORMAT_HOLIDAYS, this.day));

		String[] date = day.split(Constantes.PATTERN_DIAGONAL);
		calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(date[0]));

		int diaActual = calendar.get(Calendar.DAY_OF_MONTH);
		for (int diaMes = 1; diaMes <= diaActual; diaMes++) {
			calendar.set(Calendar.DAY_OF_MONTH, diaMes);
			String dias = simpleDateFormat.format(calendar.getTime());
			// Si es día habil aumenta el iterador
			if (workingDays(dias)) {
				numDiaHabil++; 
				if(diaMes == diaActual) {
					setWorkingDay(true);
				}
			}
		}
		setNumberOfWorkingDay(numDiaHabil);
	}

	public boolean workingDays(String dayToCheck) {
		// El día es laboral
		Boolean dia = true;

		// Instancias para comparar las fechas
		Calendar calToCheck = Calendar.getInstance();
		Calendar calHolidays = Calendar.getInstance();

		// La fecha del parametro se pasa a tipo calendar
		calToCheck.setTime(Tools.getDateFormat(Constantes.FORMAT_HOLIDAYS, dayToCheck));

		// Se comparan todas las fechas del txt con el día del parametro
		for (String holiday : holidays) {
			// Representamos el calendario con la fecha parseada según el SimpleFormatDate
			calHolidays.setTime(Tools.getDateFormat(Constantes.FORMAT_HOLIDAYS, holiday));
			int numHoliday = calHolidays.get(Calendar.DAY_OF_YEAR);
			int yearHoliday = calHolidays.get(Calendar.YEAR);
			int numOfToday = calToCheck.get(Calendar.DAY_OF_YEAR);
			int year = calToCheck.get(Calendar.YEAR);
			if (numHoliday == numOfToday && yearHoliday == year) {
				dia = false;
				break;
			}
			if (numHoliday > numOfToday) {
				break;
			}
		}

		if (dia) {
			// Si el argumento fecha es igual a domingo o sabado, día=false
			if (calToCheck.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY
					|| calToCheck.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
				dia = false;
			}
		}
		return dia;
	}

}
