package com.cperez.utils;

import com.cperez.exceptions.BussinesException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class Props {

    private static File archivo;

    private static Properties properties = new Properties();

    private Props(final File archivo) throws BussinesException{
        if(!archivo.exists()){
            throw new BussinesException("Archivo properties no existe");
        }
        try {
            InputStream inputStream = new FileInputStream(archivo);
            properties.load(inputStream);
            setArchivo(archivo);
        }catch (IOException ex){
            throw new BussinesException("No puede recuperar el archivo" + archivo.getAbsolutePath());
        }
    }

    public static void build(String archivo) throws BussinesException{
        build(new File(archivo));
    }

    public static void build(File archivo) throws BussinesException {
        new Props(archivo);
    }

    public static File getArchivo() {
        return Props.archivo;
    }

    public static Properties getProperties() {
        return properties;
    }

    public static void setArchivo(File archivo) {
        Props.archivo = archivo;
    }

    public static void setProperties(Properties properties) {
        Props.properties = properties;
    }

    public static String getParameter(String key){
        return properties.getProperty(key);
    }
}
