package com.calculadoraimc.imc.model;

/**
 *
 * @author alvarolopez
 */
public class CalculadoraIMC {

    public double calcular(double peso, double altura) {
        if (altura <= 0) {
            throw new IllegalArgumentException("La altura debe ser mayor que 0");
        }
        return peso / (altura * altura);
    }

    public String clasificar(double imc) {
        if (imc < 18.5) {
            return "Bajo Peso";
        } else if (imc >= 18.5 && imc <= 24.9) {
            return "Peso Normal";
        } else if (imc >= 25.0 && imc <= 29.9) {
            return "Sobrepeso";
        } else {
            return "Obesidad";
        }
    }
}
