package nomina;

public class EmpleadoAsalariado extends Empleado {
    private final double salarioMensual;
    private final int añosEnLaEmpresa;

    public EmpleadoAsalariado(
            String nombre,
            String identificacion,
            double salarioMensual,
            int añosEnLaEmpresa
    ) {
        super(nombre, identificacion);

        if (salarioMensual < 0 || añosEnLaEmpresa < 0) {
            throw new IllegalArgumentException(
                    "El salario y los años en la empresa no pueden ser negativos.");
        }

        this.salarioMensual = salarioMensual;
        this.añosEnLaEmpresa = añosEnLaEmpresa;
    }

    // El bono es del 10% y se aplica al superar cinco anos en la empresa.
    @Override
    public double calcularSalarioBruto() {
        double bono = 0;

        if (añosEnLaEmpresa > 5) {
            bono = salarioMensual * 0.10;
        }

        return salarioMensual + bono;
    }

    // La empresa cubre un bono mensual de alimentacion de $1.000.000.
    @Override
    public double calcularBeneficiosAdicionales() {

        return 1000000;
    }
}
