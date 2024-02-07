package Formatos;

import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class Formateador extends Formatter {
	
	@Override
	public String format(LogRecord record) {
		int ope1, ope2, resu;
		String opera;
		String lerroa = record.getMessage();
		String[] zatiak;
		zatiak = lerroa.split(";");
		ope1 = Integer.parseInt(zatiak[0]);
		opera = zatiak[1];
		ope2 = Integer.parseInt(zatiak[2]);
		resu = Integer.parseInt(zatiak[3]);
		return "<tr>\n" + "<td>" + ope1 + "</td>\n" + "<td>" + opera + "</td>\n" + "<td>" + ope2 + "</td>\n" + "<td>"
				+ resu + "</td>\n" + "</tr>\n";
	}

	@Override
	public String getHead(Handler h) {
		return "<html>\n <head>\n  <link href=\"./style.css\""
				+ " rel=\"stylesheet\">\n </head>\n <body> \n <table>\n <tr>\n <th>Operando1</th>\n"
				+ " <th>Operacion</th>\n <th>Operando2</th>\n <th>Resultado</th>\n </tr>\n";
	}

	@Override
	public String getTail(Handler h) {
		return " </table>\n </body>\n </html>\n";
	}
}

