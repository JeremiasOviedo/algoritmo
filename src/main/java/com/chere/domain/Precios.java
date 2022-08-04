package com.chere.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class Precios {

    private int precioIndividual;

    private int precioMediaDocena;

    private int precioDocena;

    public Precios() {

        precioIndividual = 120;
        precioMediaDocena = 700;
        precioDocena = 1300;

    }

    public int getPrecioIndividual() {
        return precioIndividual;
    }

    public void setPrecioIndividual(int precioIndividual) {
        this.precioIndividual = precioIndividual;
    }

    public int getPrecioMediaDocena() {
        return precioMediaDocena;
    }

    public void setPrecioMediaDocena(int precioMediaDocena) {
        this.precioMediaDocena = precioMediaDocena;
    }

    public int getPrecioDocena() {
        return precioDocena;
    }

    public void setPrecioDocena(int precioDocena) {
        this.precioDocena = precioDocena;
    }

    @Override
    public String toString() {
        return "Precios{" + "precioIndividual=" + precioIndividual + ", precioMediaDocena=" + precioMediaDocena + ", precioDocena=" + precioDocena + '}';
    }

    public int algoritmo(int cantidad) {

        int valorTotal = 0;

        if (cantidad % 12 == 0) {

            valorTotal = (cantidad / 12) * precioDocena;

        } else if (cantidad % 12 < 6) {

            valorTotal = (cantidad / 12) * precioDocena + (cantidad % 12) * precioIndividual;

        } else if (cantidad % 12 >= 6) {

            valorTotal = (cantidad / 12) * precioDocena + precioMediaDocena;
            valorTotal += ((cantidad % 12) - 6) * precioIndividual;
        }

        System.out.println("Valor Total: " + valorTotal);

        return valorTotal;

    }

    public void cambiarPrecios(Precios precio) {
        
        setPrecioIndividual(precio.getPrecioIndividual());
        setPrecioMediaDocena(precio.getPrecioMediaDocena());
        setPrecioDocena(precio.getPrecioDocena());

    }
}
