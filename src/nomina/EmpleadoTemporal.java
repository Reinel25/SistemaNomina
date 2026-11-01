package nomina;

public class EmpleadoTemporal extends Empleado {
    private double salarioMensual;
    private int duracionContratoMeses;

    public EmpleadoTemporal(String nombre, String identificacion, double salarioMensual, int duracionContratoMeses) {
        super(nombre, identificacion);

        if (salarioMensual < 0 || duracionContratoMeses <= 0) {
            throw new IllegalArgumentException("El salario no puede ser negativo y el contrato debe durar al menos un mes.");
        }

        this.salarioMensual = salarioMensual;
        this.duracionContratoMeses = duracionContratoMeses;
    }

    @Override
    public double calcularSalarioBruto() {
        return salarioMensual;
    }

    public int getDuracionContratoMeses() {
        return duracionContratoMeses;
    }
}