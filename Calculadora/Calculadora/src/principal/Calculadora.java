package principal;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import Formatos.Formateador;
import menu.Menu;
import operaciones.Operaciones;

public class Calculadora{
	public static final Logger LOGGER = Logger.getLogger("Logs");
	/**
	 * Muestra los resultados.
	 * @param args
	 */
    public static void main(String[] args) {
    	LOGGER.setUseParentHandlers(false);
    	Handler consoleHandler = new ConsoleHandler();
    	consoleHandler.setLevel(Level.WARNING);
    	Handler fileHandler = null;
    	try {
    		fileHandler = new FileHandler("./logs/resultadosCalculadora.html" , true);
			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	LOGGER.setLevel(Level.FINE);
    	fileHandler.setLevel(Level.FINE);
    	LOGGER.addHandler(consoleHandler);
    	LOGGER.addHandler(fileHandler);
    	fileHandler.setFormatter(new Formateador());
    	
        int resultado = 0;
        String operacion = "";
        int[] operandos = new int [2];
        
        Menu menu = new Menu();
        Operaciones operaciones = new Operaciones();
        
        do{
            operandos = menu.pedirNumeros();
            operacion = menu.menuOpciones();
            
            if (operacion.equalsIgnoreCase("+")){
                resultado = operaciones.sumar(operandos[0], operandos[1]);
                System.out.println ("Resultado: " + resultado);
            	LOGGER.log(Level.FINE,"Suma echa correctamente.");
            } else if (operacion.equalsIgnoreCase("-")){
                resultado = operaciones.restar(operandos[0], operandos[1]);
                System.out.println ("Resultado: " + resultado);
                LOGGER.log(Level.FINE,"Resta echa correctamente.");
            } else if (operacion.equalsIgnoreCase("*")){
                resultado = operaciones.multiplicar(operandos[0], operandos[1]);
                System.out.println ("Resultado: " + resultado);
                LOGGER.log(Level.FINE,"Multiplo echo correctamente.");
            } else if (operacion.equalsIgnoreCase("/")){
            	try {
                resultado = operaciones.dividir(operandos[0], operandos[1]);
                System.out.println ("Resultado: " + resultado);
                LOGGER.log(Level.FINE,"Division echa correctamente.");
            	}catch (Exception e) {
					// TODO: handle exception
				}
            } else if (operacion.equalsIgnoreCase("%")){
                resultado = operaciones.resto(operandos[0], operandos[1]);
                System.out.println ("Resultado: " + resultado);
                LOGGER.log(Level.FINE,"Porcentaje echo correctamente.");
            } else {
                System.out.println ("Operaci�n no v�lida");
                
            }
        }   while (menu.repetir());
    }
}