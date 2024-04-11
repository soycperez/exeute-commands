package com.cperez.utils;

import com.cperez.exceptions.BussinesException;
import java.util.logging.Logger;

public class Excel {

	private static Logger LOGGER = Logger.getLogger(Excel.class.getName());

	public static boolean eliminarHojaExcel(String pathExcel, String pathResources, String nombreHoja) throws BussinesException {
		String script = pathResources + Props.getParameter(Constantes.SCRIPT_NOMBRE_BORRAR_HOJA);
		LOGGER.info("Nombre del script" + script);
		String comando = "python " + script + " \"" + pathExcel + "\" \"" + nombreHoja + "\"";
		LOGGER.info("Comando a ejecutar: " + comando);
		String response = Tools.execCommand(comando);
		if (response.contains("OK") == false) {
			String msgError = "Error al ejecutar el Script " + comando + " Detalle: \n" + response;
			LOGGER.warning(msgError);
			throw new BussinesException(msgError);
		} else {
			return true;
		}
	}
}
