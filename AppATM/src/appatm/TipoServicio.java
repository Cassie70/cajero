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

public class TipoServicio {
    private TipoServicio tipo;
    private Date fecha;
    private double monto;

    public TipoServicio(TipoServicio tipo, double monto) {
        this.tipo = tipo;
        this.fecha = new Date(); // Asigna la fecha y hora actual
        this.monto = monto;
    }

    public TipoServicio getTipo() {
        return tipo;
    }

    public void setTipo(TipoServicio tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Servicio{" +
                "tipo=" + tipo +
                ", fecha=" + fecha +
                ", monto=" + monto +
                '}';
    }
}

