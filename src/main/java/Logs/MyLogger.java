/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Joaquin
 */
public class MyLogger {

    // Crea el logger
    private static final Logger logger = LoggerFactory.getLogger(MyLogger.class);

    public static void main(String[] args) {
        // Mensajes de log en diferentes niveles
        logger.info("Este es un mensaje de info");
        logger.debug("Este es un mensaje de debug");
        logger.error("Este es un mensaje de error");
    }
}
