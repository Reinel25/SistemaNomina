package nomina;

public class PruebasNomina {
    public static void main(String[] args) {
        EmpleadoAsalariado asalariado =
                new EmpleadoAsalariado("Ana", "A1", 3_500_000, 6);

        comprobar("Bono del asalariado", 3_850_000,
                asalariado.calcularSalarioBruto());
        comprobar("Deduccion del asalariado", 154_000,
                asalariado.calcularDeduccionesObligatorias());
        comprobar("Salario neto del asalariado", 3_696_000,
                asalariado.calcularSalarioNeto());
        comprobar("ARL del asalariado", 20_097,
                asalariado.calcularAporteARL());

        EmpleadoPorHoras porHoras =
                new EmpleadoPorHoras("Luis", "H1", 20_000, 45, 2, true);

        comprobar("Pago de horas extra", 950_000,
                porHoras.calcularSalarioBruto());
        comprobar("Fondo de ahorro", 19_000,
                porHoras.calcularBeneficiosAdicionales());

        EmpleadoComision porComision =
                new EmpleadoComision("Marta", "C1", 1_500_000,
                        22_000_000, 0.05);

        comprobar("Comision y bono por ventas", 3_260_000,
                porComision.calcularSalarioBruto());

        EmpleadoTemporal temporal =
                new EmpleadoTemporal("Carlos", "T1", 2_000_000, 6);

        comprobar("Salario temporal sin bonos", 2_000_000,
                temporal.calcularSalarioBruto());
        comprobar("Temporal sin beneficios adicionales", 0,
                temporal.calcularBeneficiosAdicionales());

        EmpleadoAsalariado asalariadoCincoAnos =
                new EmpleadoAsalariado("Elena", "A2", 3_500_000, 5);

        comprobar("Sin bono con exactamente cinco años", 3_500_000,
                asalariadoCincoAnos.calcularSalarioBruto());

        EmpleadoComision comisionEnLimite =
                new EmpleadoComision("Pedro", "C2", 1_500_000,
                        20_000_000, 0.05);

        comprobar("Sin bono con ventas de exactamente 20 millones", 2_500_000,
                comisionEnLimite.calcularSalarioBruto());

        comprobarRechazo("Rechaza horas negativas",
                () -> new EmpleadoPorHoras("Luis", "H2", 20_000, -1, 2, true));

        comprobarRechazo("Rechaza ventas negativas",
                () -> new EmpleadoComision("Marta", "C2", 1_500_000, -100, 0.05));

        comprobarRechazo("Rechaza salario negativo",
                () -> new EmpleadoAsalariado("Ana", "A2", -1, 6));

        comprobarRechazo("Rechaza contrato de cero meses",
                () -> new EmpleadoTemporal("Carlos", "T2", 2_000_000, 0));

        System.out.println("Pruebas terminadas.");
    }

    private static void comprobar(String nombre, double esperado, double obtenido) {
        if (Math.abs(esperado - obtenido) > 0.01) {
            throw new AssertionError(
                    nombre + ": se esperaba " + esperado + ", pero se obtuvo " + obtenido
            );
        }

        System.out.println("OK: " + nombre);
    }
    private static void comprobarRechazo(String nombre, Runnable accion) {
        try {
            accion.run();
        } catch (IllegalArgumentException errorEsperado) {
            System.out.println("OK: " + nombre);
            return;
        }

        throw new AssertionError(nombre + ": se esperaba un error de validacion.");
    }
}