package com.cperez.utils;

import java.util.regex.Pattern;

public class Constantes {
	
	/**
	 * TEXT | SPECIAL
	 * **/
	public static final String FORMAT_RECORD_LOG = "HH:mm:ss.SS"; 
	
	/**
	 * PATTERNS
	 * **/
	public static final String PATTERN_DIAGONAL = Pattern.quote(Constantes.DIAGONAL); 
			
	/**
	 * CARACTERES
	 * **/
	public static final String DIAGONAL = "/"; 
	
	/**
	 * TEXTO
	 * **/
	public static final String INICIANDO_BOOT = "\nINICIO EJECUCION\n";
	public static final String FIN_BOOT = "\nFIN DE LA EJECUCION\n"; 
	public static final String START = "********** START **********";
	public static final String FINALLY = "********** FINALLY **********";
	public static final String UTILITY = "Utility class"; 
	
	/**
	 * FECHAS
	 * **/
	public static final String FORMAT_HOLIDAYS = "dd/MM/yyyy"; 

    /**
     * LOGS
     **/
    public static final String TRACK_IN = "\"Metodo\":\"{0}\", \"Entrada\":\"{1}\"";
    public static final String TRACK_OUT = "\"Metodo\":\"{0}\", \"Salida\":\"{1}\"";
    public static final String TRACK_MSJ = "\"Metodo\":\"{0}\", \"Mensaje\":\"{1}\"";
    public static final String TRACK_EX= "\"Metodo\":\"{0}\", \"Excepcion\":\"{1}\"";

    /**
     * LOGS CON TIEMPO
     **/
    public static final String TRACK_OUT_TIME= "\"Metodo\":\"{0}\", \"Salida\":\"{1}\", \"Tiempo Ejecucion\":\"{2}\"";
    public static final String TRACK_MSJ_TIME= "\"Metodo\":\"{0}\", \"Mensaje\":\"{1}\", \"Tiempo Ejecucion\":\"{2}\"";
    public static final String TRACK_EX_TIME= "\"Metodo\":\"{0}\", \"Excepcion\":\"{1}\", \"Tiempo Ejecucion\":\"{2}\"";

    /**
     * PROPERTIES
     **/
    public static final String SCRIPT_NOMBRE_BORRAR_HOJA = "script.excel.eliminar.hoja";
}
