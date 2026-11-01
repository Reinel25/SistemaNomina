package nomina;

public class EmpleadoComision extends Empleado {
    private final double salarioBase;
    private final double ventas;
    private final double porcentajeComision;

    public EmpleadoComision(String nombre, String identificacion, double salarioBase, double ventas, double porcentajeComision) {
        super(nombre, identificacion);

        if (salarioBase < 0 || ventas < 0 || porcentajeComision < 0) {
            throw new IllegalArgumentException("El salario base, las ventas y la comisión no pueden ser negativos.");
        }

        this.salarioBase = salarioBase;
        this.ventas = ventas;
        this.porcentajeComision = porcentajeComision;
    }

    // Suma salario base, comision y el 3% extra si supera $20.000.000 en ventas.
    @Override
    public double calcularSalarioBruto() {
        double comision = ventas * porcentajeComision;
        double bonoAdicional = 0;

        if (ventas > 20000000) {
            bonoAdicional = ventas * 0.03;
        }

        return salarioBase + comision + bonoAdicional;
    }

    // La empresa cubre un bono mensual de alimentacion de $1.000.000.
    @Override
    public double calcularBeneficiosAdicionales() {

        return 1000000;
    }
}