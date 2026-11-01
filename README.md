# Sistema de nómina

Programa de ejemplo en Java que calcula el salario bruto, las deducciones, el salario neto y algunos beneficios de distintos tipos de empleados.

## Requisitos

- Java 26 o una versión compatible.
- IntelliJ IDEA.

## Tipos de empleados

- **Asalariado:** recibe un salario mensual. Si lleva más de cinco años en la empresa, obtiene un bono del 10 % de su salario. Recibe un bono de alimentación de $1.000.000.
- **Por horas:** recibe el pago de sus horas trabajadas. Las horas que superan 40 se pagan a 1,5 veces la tarifa normal. Si lleva más de un año y acepta el fondo de ahorro, se calcula un beneficio del 2 % de su salario.
- **Por comisión:** recibe un salario base y una comisión sobre las ventas. Si las ventas superan $20.000.000, recibe un bono adicional del 3 % sobre las ventas. También recibe un bono de alimentación de $1.000.000.
- **Temporal:** recibe un salario mensual y tiene una duración de contrato definida. No recibe bonos ni beneficios adicionales.

## Deducciones y aporte de empresa

- La deducción de seguro social y pensión se calcula como el 4 % del salario bruto.
- El salario neto es el salario bruto menos esa deducción.
- La ARL se calcula con la tarifa de Clase I, equivalente al 0,522 % del salario bruto, y se muestra aparte como aporte de la empresa.
- Los beneficios adicionales también se muestran aparte del salario neto.

## Metodología de desarrollo

1. Se revisaron las reglas del enunciado y se separaron los tipos de empleados y sus cálculos.
2. Se creó una clase abstracta `Empleado` con los datos y operaciones comunes.
3. Se crearon clases específicas para cada tipo de empleado, que calculan su salario bruto según sus reglas.
4. Se añadieron deducciones, beneficios y validaciones para evitar valores inválidos.
5. Se hicieron pruebas con resultados esperados, límites de bonos y datos inválidos.
6. Se guardaron los avances del proyecto mediante commits de Git.

## Cómo ejecutar el programa

En IntelliJ IDEA, abre `ProgramaNomina.java` y ejecuta el método `main`. El programa muestra ejemplos de los cuatro tipos de empleados.

## Cómo ejecutar las pruebas

En IntelliJ IDEA, abre `PruebasNomina.java` y ejecuta su método `main`. Las pruebas muestran `OK` cuando el resultado coincide con el esperado; si una prueba falla, se informa un error.