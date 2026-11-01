package nomina;

public abstract class Empleado {
    private String nombre;
    private String identificacion;

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

    public abstract double calcularSalarioBruto();

    public double calcularDeduccionesObligatorias() {
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
        return calcularSalarioBruto() * 0.00522;
    }

    public double calcularBeneficiosAdicionales() {
        return 0;
    }
}