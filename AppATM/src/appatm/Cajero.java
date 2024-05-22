package appatm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cajero {
    private final List<Usuario> usuarios;
    private Usuario usuarioActual;

    public Cajero() {
        this.usuarios = new ArrayList<>();
        // Puedes añadir usuarios predeterminados aquí
        usuarios.add(new Usuario("Juan Perez", "123456", "1234", 1000));
        usuarios.add(new Usuario("Maria Gomez", "654321", "5678", 2000));
    }

    public boolean iniciarSesion(String id, String nip) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id) && usuario.getNip().equals(nip)) {
                usuarioActual = usuario;
                return true;
            }
        }
        return false;
    }

    public int seleccionarOperacion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione una operación:");
        System.out.println("1. Depositar dinero");
        System.out.println("2. Retirar dinero");
        System.out.println("3. Pagar servicio");
        System.out.println("4. Consultar saldo");
        System.out.println("5. Pagar crédito");
        System.out.println("6. Ver transacciones");
        System.out.println("0. Finalizar");
        return scanner.nextInt();
    }

    public void ejecutarOperacion(int opcion) {
        Scanner scanner = new Scanner(System.in);
        switch (opcion) {
            case 1:
                System.out.print("Ingrese el monto a depositar: ");
                double deposito = scanner.nextDouble();
                usuarioActual.depositar(deposito);
                break;
            case 2:
                System.out.print("Ingrese el monto a retirar: ");
                double retiro = scanner.nextDouble();
                usuarioActual.retirar(retiro);
                break;
            case 3:
                System.out.println("Seleccione el tipo de servicio:");
                for (Servicio tipo : Servicio.values()) {
                    System.out.println(tipo.ordinal() + 1 + ". " + tipo);
                }
                int tipoServicioIndice = scanner.nextInt() - 1;
                Servicio tipoServicio = Servicio.values()[tipoServicioIndice];
                System.out.print("Ingrese el monto a pagar por el servicio: ");
                double pagoServicio = scanner.nextDouble();
                usuarioActual.pagarServicio(tipoServicio, pagoServicio);
                break;
            case 4:
                System.out.println("Su saldo es: " + usuarioActual.consultarSaldo());
                break;
            case 5:
                System.out.print("Ingrese el monto a pagar por el crédito: ");
                double pagoCredito = scanner.nextDouble();
                usuarioActual.pagarCredito(pagoCredito);
                break;
            case 6:
                System.out.println("Transacciones:");
                for (Transaccion transaccion : usuarioActual.getTransacciones()) {
                    System.out.println(transaccion);
                }
                break;
            case 0:
                System.out.println("Gracias por usar el cajero");
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese su ID: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese su NIP: ");
        String nip = scanner.nextLine();

        if (iniciarSesion(id, nip)) {
            int opcion;
            do {
                opcion = seleccionarOperacion();
                if (opcion != 0) {
                    ejecutarOperacion(opcion);
                }
            } while (opcion != 0);
        } else {
            System.out.println("ID o NIP incorrectos");
        }
    }

    public static void main(String[] args) {
        Cajero cajero = new Cajero();
        cajero.iniciar();
    }
}
