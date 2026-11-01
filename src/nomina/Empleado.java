package nomina;

/** Clase base de los empleados y de los calculos comunes de nomina. */

public abstract class Empleado {
    private final String nombre;
    private final String identificacion;

    public Empleado(String nombre, String identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }


    /** Calcula el salario bruto segun las reglas de cada tipo de empleado. */

    public abstract double calcularSalarioBruto();

    public double calcularDeduccionesObligatorias() {
        // Seguro social y pension: 4% del salario bruto.
        return calcularSalarioBruto() * 0.04;
    }

    public double calcularSalarioNeto() {
        double salarioNeto = calcularSalarioBruto() - calcularDeduccionesObligatorias();

        if (salarioNeto < 0) {
            throw new IllegalStateException("El salario neto no puede ser negativo.");
        }

        return salarioNeto;
    }

    public double calcularAporteARL() {
        // Tarifa ARL Clase I: 0.522%, asumida por la empresa.
        return calcularSalarioBruto() * 0.00522;
    }

    public double calcularBeneficiosAdicionales() {

        return 0;
    }
}