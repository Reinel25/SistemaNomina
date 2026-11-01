package nomina;

public class EmpleadoComision extends Empleado {
    private double salarioBase;
    private double ventas;
    private double porcentajeComision;

    public EmpleadoComision(String nombre, String identificacion, double salarioBase, double ventas, double porcentajeComision) {
        super(nombre, identificacion);

        if (salarioBase < 0 || ventas < 0 || porcentajeComision < 0) {
            throw new IllegalArgumentException("El salario base, las ventas y la comisión no pueden ser negativos.");
        }

        this.salarioBase = salarioBase;
        this.ventas = ventas;
        this.porcentajeComision = porcentajeComision;
    }

    @Override
    public double calcularSalarioBruto() {
        double comision = ventas * porcentajeComision;
        double bonoAdicional = 0;

        if (ventas > 20000000) {
            bonoAdicional = ventas * 0.03;
        }

        return salarioBase + comision + bonoAdicional;
    }

    @Override
    public double calcularBeneficiosAdicionales() {
        return 1000000;
    }
}