package org.example.Validaciones;

public class TiposValidaciones {

    /*
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vuelo v = new Vuelo("a", 64, 64);
        boolean valido = false;
        int cantidadAsientos = 0;

        while (!valido) {
            System.out.println("Ingresar numero de asientos");
            String entrada = sc.nextLine();

            try {
                cantidadAsientos = Integer.parseInt(entrada);
                v.reservarAsientos(cantidadAsientos);
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Ingrese num entero valido");
            }catch (ReservaNoValidaExeption e) {
                System.out.println("Error al ingresar numero de asientos "+ e.getMessage());
            }
        }

    }

      public int reservarAsientos(int cantidad) throws ReservaNoValidaExeption{

        if (cantidad >= 0 || cantidad > 64) {
                throw new ReservaNoValidaExeption();
            } else {
                return numeroTotalAsiento -= cantidad;
            }

    }

    package org.example;

public class ReservaNoValidaExeption extends Exception{
    public ReservaNoValidaExeption() {
        super("La cantidad solicitada excede los asientos disponibles o ingreso un campo alfabetico");
    }
}

     */
}
