package com.cperez.controller;

import java.util.logging.Logger;

import com.cperez.exceptions.BussinesException;
import com.cperez.models.Holidays;
import com.cperez.models.ProjectDTO;
import com.cperez.utils.Constantes;
import com.cperez.utils.Excel;
import com.cperez.utils.Tools;

public class ProcesoController {
	
	private static Logger LOGGER = Logger.getLogger(ProcesoController.class.getName());

	private ProjectDTO dto;
	private Holidays holidays;

	public ProcesoController(ProjectDTO dto, Holidays holidays) {
		this.dto = dto;
		this.holidays = holidays;
	}
	
	
	public void start(){
		LOGGER.info(dto.toString());
		LOGGER.info(holidays.toString());
		int numPaso = 0; 
		String startTime, endTime; 
		startTime = Tools.dateToString(Constantes.FORMAT_RECORD_LOG, null);
		LOGGER.info(Constantes.START);
		try {
			LOGGER.info("Paso: "+ ++numPaso +" EJECUTAR SCRIPT PYTHON"); 
			Excel.eliminarHojaExcel(".\\resources\\Prueba.xlsx", ".\\resources", "Hoja10");
		} catch (BussinesException e) {
			LOGGER.warning("BussinesException :"+ e.getMessage());
		}finally {
			endTime = Tools.dateToString(Constantes.FORMAT_RECORD_LOG, null);
			LOGGER.info(Constantes.FINALLY);
			LOGGER.info(Constantes.INICIANDO_BOOT + startTime);
			LOGGER.info(Constantes.FIN_BOOT + endTime);
		}
	}

}
