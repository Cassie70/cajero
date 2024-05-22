/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appatm;

/**
 *
 * @author Cassandra
 */
import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private String id;
    private String nip;
    private Cuenta cuenta;
    private List<Transaccion> transacciones;

    public Usuario(String nombre, String id, String nip, double saldoInicial) {
        this.nombre = nombre;
        this.id = id;
        this.nip = nip;
        this.cuenta = new Cuenta(saldoInicial);
        this.transacciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public double consultarSaldo() {
        return cuenta.consultarSaldo();
    }

    public void depositar(double monto) {
        cuenta.depositar(monto);
        transacciones.add(new Transaccion("Depósito", monto));
    }

    public void retirar(double monto) {
        cuenta.retirar(monto);
        transacciones.add(new Transaccion("Retiro", monto));
    }

    public void pagarServicio(Servicio tipo, double monto) {
        cuenta.pagarServicio(monto);
        transacciones.add(new Transaccion("Pago de Servicio: " + tipo, monto));
    }

    public void pagarCredito(double monto) {
        cuenta.pagarCredito(monto);
        transacciones.add(new Transaccion("Pago de Crédito", monto));
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }
}


   