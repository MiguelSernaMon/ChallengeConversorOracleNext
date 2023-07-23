package source;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Conversor {
	
	//------Para las currencies
	private double dolar = 4000d;
	private double euros = 4420d;
	private double librasEsterlinas = 5100d;
	private double yenJapones = 24d;
	private double wonCoreano = 3d;
	
	
	public void pesosToExteriorCurrency(double valor, double moneda, String nombreMoneda) {
		DecimalFormat df = new DecimalFormat("#");
        df.setMaximumFractionDigits(10);
		JOptionPane.showMessageDialog(null, "Tienes " + df.format(valor/moneda) + " " + nombreMoneda);
//		return valor/moneda;
	}
	
	public void exteriorCurrencyToPesos (double valor, double moneda) {
		DecimalFormat df = new DecimalFormat("#");
        df.setMaximumFractionDigits(10);
		JOptionPane.showMessageDialog(null, "Tienes " + df.format(moneda * valor) + " " + "pesos");
//		return valor * moneda;
	}
	
	public void celsiusToFahr(double celsius) {
		DecimalFormat df = new DecimalFormat("#");
        df.setMaximumFractionDigits(10);
		JOptionPane.showMessageDialog(null, "Tienes " + df.format((celsius * (9.0/5.0)) + 32.0) + " " + "Grados Fahrenheit");
		
	}
	
	public void fahrToCelsius(double fahr) {
		System.out.println(fahr);
		DecimalFormat df = new DecimalFormat("#");
        df.setMaximumFractionDigits(10);
		JOptionPane.showMessageDialog(null, "Tienes " + df.format((fahr - 32.0) * (5.0/9.0)) + " " + "Grados Centigrados");
	}



	public double getDolar() {
		return dolar;
	}



	public void setDolar(double dolar) {
		this.dolar = dolar;
	}



	public double getEuros() {
		return euros;
	}



	public void setEuros(double euros) {
		this.euros = euros;
	}



	public double getLibrasEsterlinas() {
		return librasEsterlinas;
	}



	public void setLibrasEsterlinas(double librasEsterlinas) {
		this.librasEsterlinas = librasEsterlinas;
	}



	public double getYenJapones() {
		return yenJapones;
	}



	public void setYenJapones(double yenJapones) {
		this.yenJapones = yenJapones;
	}



	public double getWonCoreano() {
		return wonCoreano;
	}



	public void setWonCoreano(double wonCoreano) {
		this.wonCoreano = wonCoreano;
	}
}
