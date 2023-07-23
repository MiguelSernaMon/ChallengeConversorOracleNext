package source;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Menu {

	private int opcion;
	private String eleccion;
	private Conversor conversor = new Conversor();

	public Menu() {
		System.out.println("INICIO MENU");
		iniciarMenu();
	}

	public void cajaDeOpciones(String[] opciones, int tipoDeBotones) {

//		String[] opciones = { "De Moneda", "De temperatura" };

		JComboBox conversorType = new JComboBox(opciones);

		conversorType.setEditable(true);
		boolean inputError = true;
		do {

			try {
				this.opcion = JOptionPane.showConfirmDialog(null, conversorType, "Seleccione el tipo de conversor",
						tipoDeBotones);
				inputError = false;
			} catch (Exception e) {

				System.out.println("Ingrese un valor valido");
				JOptionPane.showMessageDialog(null, "Ingrese un dato valido");

			}
		} while (inputError);

		System.out.println(opcion);
		String option = (String) conversorType.getSelectedItem();
		System.out.println(option);
		this.eleccion = (String) conversorType.getSelectedItem();
	}

	/**
	 * Function that initializes the menu for choosing the type of converter
	 */
	public void iniciarMenu() {
		String[] opciones = { "De Moneda", "De temperatura" };

		cajaDeOpciones(opciones, 1);

		if (this.opcion == 0 && this.eleccion == "De temperatura") {

			conversorTemperatura();

		} else if (this.opcion == 0 && this.eleccion == "De Moneda") {

			conversorMonedas();

		}
		System.out.println(this.opcion);
	}

	/**
	 * Function who its responsible for money conversion menu
	 */
	public void conversorMonedas() {
		boolean inputError = true;
		double valorEntrada = 0;
		try {
			valorEntrada = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad a convertir"));
			inputError = false;
		} catch (Exception e) {

			System.out.println("Ingrese un valor valido");
			JOptionPane.showMessageDialog(null, "Ingrese un dato valido");
			this.opcion = 1;

		}

		System.out.println("moneditas");
		if(!inputError) {
			String[] opcDeConversion = { "De pesos a Dolar", "De pesos a Euros", "De pesos a Libras Esterlinas",
					"De pesos a Yen Japonés", "De pesos a Won coreano", "De Dolar a pesos", "De Euros a pesos",
					"De Libras Esterlinas a pesos", "De Yen Japonés a pesos", "De Won coreano a pesos" };
			cajaDeOpciones(opcDeConversion, 2);
		}
		

		if (this.opcion == 0) {
			callTypeConversor(valorEntrada);
		}

	}

	public void callTypeConversor(double valorEntrada) {

		// De pesos a monedas extranjeras
		if (this.eleccion == "De pesos a Dolar") {
			conversor.pesosToExteriorCurrency(valorEntrada, conversor.getDolar(), "dolares");
		} else if (this.eleccion == "De pesos a Euros") {
			conversor.pesosToExteriorCurrency(valorEntrada, conversor.getEuros(), "euros");
		} else if (this.eleccion == "De pesos a Libras Esterlinas") {
			conversor.pesosToExteriorCurrency(valorEntrada, conversor.getLibrasEsterlinas(), "libras esterlinas");
		} else if (this.eleccion == "De pesos a Yen Japonés") {
			conversor.pesosToExteriorCurrency(valorEntrada, conversor.getYenJapones(), "Yenes Japoneses");
		} else if (this.eleccion == "De pesos a Won coreano") {
			conversor.pesosToExteriorCurrency(valorEntrada, conversor.getWonCoreano(), "Wons coreanos");
		}
		// De monedas extranjeras a pesos
		else if (this.eleccion == "De Dolar a pesos") {
			conversor.exteriorCurrencyToPesos(valorEntrada, conversor.getDolar());
		} else if (this.eleccion == "De Euros a pesos") {
			conversor.exteriorCurrencyToPesos(valorEntrada, conversor.getEuros());
		} else if (this.eleccion == "De Libras Esterlinas a pesos") {
			conversor.exteriorCurrencyToPesos(valorEntrada, conversor.getLibrasEsterlinas());
		} else if (this.eleccion == "De Yen Japonés a pesos") {
			conversor.exteriorCurrencyToPesos(valorEntrada, conversor.getYenJapones());
		} else if (this.eleccion == "De Won coreano a pesos") {
			conversor.exteriorCurrencyToPesos(valorEntrada, conversor.getWonCoreano());
		}

		volverAlCiclo();

	}

	public void volverAlCiclo() {
		this.opcion = JOptionPane.showConfirmDialog(null, "desea volver a repetir");
		if (opcion == 0) {
			iniciarMenu();
		}
	}

	/**
	 * Temperature menu initialization function. Doesn't return anything
	 */
	public void conversorTemperatura() {
		System.out.println("temperatura");
		double valorEntrada = 0;
		boolean inputError = true;
		
		try {
			valorEntrada = Double.parseDouble(JOptionPane.showInputDialog("Ingrese los grados a convertir"));
			inputError = false;
		} catch (Exception e) {

			System.out.println("Ingrese un valor valido");

		}

		String[] opcDeConversion = { "De Fahrenheit a Centigrados", "De Centigrados a Fahrenheit" };
		if (!inputError) {

			cajaDeOpciones(opcDeConversion, 2);
			if (this.opcion == 0) {
				callTemperatureConversor(valorEntrada);
				volverAlCiclo();
			}

		}

	}

	public void callTemperatureConversor(double val) {

		if (this.eleccion == "De Fahrenheit a Centigrados") {
			conversor.fahrToCelsius(val);
		} else {
			conversor.celsiusToFahr(val);
		}

	}

}
