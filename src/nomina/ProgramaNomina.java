package nomina;

public class ProgramaNomina {
    public static void main(String[] args) {
        Empleado asalariado = new EmpleadoAsalariado("Ana Torres", "A001", 3500000, 6);

        Empleado porHoras = new EmpleadoPorHoras("Luis Pérez", "H002", 20000, 45, 2, true);

        Empleado porComision = new EmpleadoComision("Marta Ruiz", "C003", 1500000, 22000000, 0.05);

        Empleado temporal = new EmpleadoTemporal("Carlos Díaz", "T004", 2000000, 6);

        mostrarResumen(asalariado);
        mostrarResumen(porHoras);
        mostrarResumen(porComision);
        mostrarResumen(temporal);
    }

    private static void mostrarResumen(Empleado empleado) {
        System.out.println("Empleado: " + empleado.getNombre());
        System.out.println("Identificacion: " + empleado.getIdentificacion());

        if (empleado instanceof EmpleadoTemporal temporal) {
            System.out.println("Duracion del contrato (meses): "
                    + temporal.getDuracionContratoMeses());
        }

        System.out.println("Salario bruto: " + empleado.calcularSalarioBruto());
        System.out.println("Deducciones (4%): " + empleado.calcularDeduccionesObligatorias());
        System.out.println("Salario neto: " + empleado.calcularSalarioNeto());
        System.out.println("Beneficios adicionales: " + empleado.calcularBeneficiosAdicionales());
        System.out.println("Aporte ARL empresa (0,522%): " + empleado.calcularAporteARL());
        System.out.println("------------------------------");
    }
}
