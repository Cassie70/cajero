/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appatm;

/**
 *
 * @author Cassandra
 */
import java.util.Date;

public class Transaccion {
    private final Date fecha;
    private final String tipo;
    private final double monto;

    public Transaccion(String tipo, double monto) {
        this.fecha = new Date(); // Asigna la fecha y hora actual
        this.tipo = tipo;
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public double getMonto() {
        return monto;
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "fecha=" + fecha +
                ", tipo='" + tipo + '\'' +
                ", monto=" + monto +
                '}';
    }
}

