package com.calculadoraimc.imc.controller;

import com.calculadoraimc.imc.model.CalculadoraIMC;
import com.calculadoraimc.imc.view.VentanaIMC;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author alvarolopez
 */

public class IMCController implements ActionListener {

    private final VentanaIMC vista;
    private final CalculadoraIMC calculadora;

    public IMCController(VentanaIMC vista) {
        this.vista = vista;
        this.calculadora = new CalculadoraIMC();
        this.vista.getBtnCalcular().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnCalcular()) {
            calcularIMC();
        }
    }

    private void calcularIMC() {
        String textoPeso = vista.getTxtPeso().getText().trim().replace(",", ".");
        String textoAltura = vista.getTxtAltura().getText().trim().replace(",", ".");

        try {
            double peso = Double.parseDouble(textoPeso);
            double altura = Double.parseDouble(textoAltura);

            if (peso <= 0 || altura <= 0) {
                vista.getLblResultado().setText("Tu IMC es: ");
                vista.getLblClasificacion().setText("Error: Datos inválidos");
                vista.getLblClasificacion().setForeground(Color.RED);
                return;
            }

            double imc = calculadora.calcular(peso, altura);
            String clasificacion = calculadora.clasificar(imc);

            vista.getLblResultado().setText(String.format("Tu IMC es: %.2f", imc));
            vista.getLblClasificacion().setText("Clasificación: " + clasificacion);

            switch (clasificacion) {
                case "Peso Normal":
                    vista.getLblClasificacion().setForeground(new Color(0, 150, 0));
                    break;
                case "Bajo Peso":
                case "Sobrepeso":
                    vista.getLblClasificacion().setForeground(Color.ORANGE);
                    break;
                case "Obesidad":
                    vista.getLblClasificacion().setForeground(Color.RED);
                    break;
                default:
                    vista.getLblClasificacion().setForeground(Color.BLACK);
                    break;
            }

        } catch (NumberFormatException ex) {
            vista.getLblResultado().setText("Tu IMC es: ");
            vista.getLblClasificacion().setText("Error: Introduce solo números válidos");
            vista.getLblClasificacion().setForeground(Color.RED);
        }
    }
}
