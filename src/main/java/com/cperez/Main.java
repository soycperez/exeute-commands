package com.cperez;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import com.cperez.controller.ProcesoController;
import com.cperez.models.Holidays;
import com.cperez.models.ProjectDTO;
import com.cperez.utils.Props;
import com.cperez.utils.Tools;
import com.cperez.utils.Constantes;
import com.cperez.utils.ConstantesArchivos;

public class Main {

	private static Logger LOGGER = Logger.getLogger(Main.class.getName());

	private static ProjectDTO dto;

	public static void main(String[] args) throws Exception {
		/** Lectura del archivo configuration.properties **/
		Props.build(args[0]);

		/** Mapeamos atributos que seran frecuentes al DTO del proyectoi **/
		mapArgsToProject(args);
		
		Holidays holidays = new Holidays(new File(dto.getPathWorspace(), ConstantesArchivos.FESTIVOS_TXT)); 
		
		LOGGER.info(dto.toString());
		LOGGER.info(holidays.toString());
		
		ProcesoController proceso = new ProcesoController(dto, holidays); 
		if(holidays.isWorkingDay()) {
			proceso.start(); 
		}
	}

	/**
	 * @param args para la ejecución del proyecto, se ingresan desde un CI/CD o
	 * desde eclipse como argumentos en el menu de "run > run/debug configurations > arguments" <br>
	 * args[0] = configuration.properties <br>
	 * args[1] = ruta donde se encuentra el archivo festivos.txt o el WORKSPACE del proyecto <br>
	 * args[2] = fechaEjecucion("hoy"||"dd-MM-yyyy") <br>
	 * ****OPCIONALES****
	 * args[] = nueva propiedad en ProjectDTO
	 */
	public static void mapArgsToProject(String[] args) {
		dto = new ProjectDTO();
		dto.setPathWorspace(new File(args[1]));
		if (args[2].equals("hoy")) {
			dto.setFechaEjecucion(new SimpleDateFormat(Constantes.FORMAT_HOLIDAYS).format(new Date()));
		} else {
			dto.setFechaEjecucion(new SimpleDateFormat(Constantes.FORMAT_HOLIDAYS)
					.format(Tools.getDateFormat(Constantes.FORMAT_HOLIDAYS, args[2])));
		}
	}
}