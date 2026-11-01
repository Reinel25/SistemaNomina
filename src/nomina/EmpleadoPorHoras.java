package nomina;

public class EmpleadoPorHoras extends Empleado {
    private final double tarifaPorHora;
    private final double horasTrabajadas;
    private final int aniosEnLaEmpresa;
    private final boolean aceptaFondoAhorro;

    public EmpleadoPorHoras(String nombre, String identificacion, double tarifaPorHora, double horasTrabajadas, int aniosEnLaEmpresa, boolean aceptaFondoAhorro) {
        super(nombre, identificacion);

        if (horasTrabajadas < 0) {
            throw new IllegalArgumentException("Las horas trabajadas no pueden ser negativas.");
        }

        if (tarifaPorHora < 0) {
            throw new IllegalArgumentException("La tarifa por hora no puede ser negativa.");
        }

        this.tarifaPorHora = tarifaPorHora;
        this.horasTrabajadas = horasTrabajadas;
        this.aniosEnLaEmpresa = aniosEnLaEmpresa;
        this.aceptaFondoAhorro = aceptaFondoAhorro;
    }

    // Las horas sobre 40 se pagan a 1.5 veces la tarifa normal.
    @Override
    public double calcularSalarioBruto() {
        if (horasTrabajadas <= 40) {
            return horasTrabajadas * tarifaPorHora;
        }

        double horasNormales = 40;
        double horasExtra = horasTrabajadas - 40;
        return (horasNormales * tarifaPorHora) + (horasExtra * tarifaPorHora * 1.5);
    }

    // El fondo se calcula si lleva mas de un año y acepta participar.
    @Override
    public double calcularBeneficiosAdicionales() {
        if (aniosEnLaEmpresa > 1 && aceptaFondoAhorro) {
            return calcularSalarioBruto() * 0.02;
        }

        return 0;
    }
}