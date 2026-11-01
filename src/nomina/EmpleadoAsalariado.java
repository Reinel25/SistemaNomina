package nomina;

public class EmpleadoAsalariado extends Empleado {
    private double salarioMensual;
    private int añosEnLaEmpresa;

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

    @Override
    public double calcularSalarioBruto() {
        double bono = 0;

        if (añosEnLaEmpresa > 5) {
            bono = salarioMensual * 0.10;
        }

        return salarioMensual + bono;
    }

    @Override
    public double calcularBeneficiosAdicionales() {
        return 1000000;
    }
}
