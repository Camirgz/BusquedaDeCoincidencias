package Clases;

import java.util.Scanner;

public class Interaccion {
    //Iniciar
    Validaciones validacion = new Validaciones();
    Scanner scanner = new Scanner(System.in);


    public void eleccion(){
        System.out.println("=== Bienvenido al sistema de sospechosos del OIJ ===");
        //Poner codigo acá para pedir datos de usuarios
        System.out.println("Ingrese los datos del sospechoso/a por buscar");
        while(true){
            System.out.println("Ingrese [S] para salir, [B] para buscar o [H] para ver el historial");
            String entrada = scanner.nextLine();
            if(validacion.input(entrada)){
                if(entrada.equals("B")){
                    buscar();
                    mostrarCoincidencias();
                }
                if (entrada.equals("H")){
                    mostrarHistorial();
                }
                if (entrada.equals("S")){
                    System.out.println("Gracias!");
                    break;
                }
            }
        }

    }

    public void buscar() {
        String[] arrayBuscar = new String[8];
        //Nombre
        while (true) {
            System.out.println("Nombre: ");
            String nombre = scanner.nextLine();
            if (validacion.strings(nombre)) {
                arrayBuscar[0] = nombre;
                break;
            }
        }

        //Provincia
        while (true) {
            System.out.println("Provincia: ");
            String provincia = scanner.nextLine();
            if (validacion.strings(provincia)) {
                arrayBuscar[1] = provincia;
                break;
            }
        }

        //Canton
        while (true) {
            System.out.println("Canton: ");
            String canton = scanner.nextLine();
            if (validacion.strings(canton)) {
                arrayBuscar[2] = canton;
                break;
            }
        }

        //Edad
        while (true) {
            System.out.println("Edad: ");
            String edad = scanner.nextLine();
            if (validacion.edad(edad)) {
                arrayBuscar[3] = edad;
                break;
            }
        }

        //Género
        while (true) {
            System.out.println("Género: ");
            String genero = scanner.nextLine();
            if (validacion.genero(genero)) {
                arrayBuscar[4] = genero;
                break;
            }
        }

        //Estado Civil
        while (true) {
            System.out.println("Estado Civil: ");
            String estado = scanner.nextLine();
            if (validacion.estadoCivil(estado)) {
                arrayBuscar[5] = estado;
                break;
            }
        }

        //Color de Pelo
        while (true) {
            System.out.println("Color pelo: ");
            String pelo = scanner.nextLine();
            if (validacion.pelo(pelo)) {
                arrayBuscar[6] = pelo;
                break;
            }
        }

        //Altura
        while (true) {
            System.out.println("Altura: ");
            String altura = scanner.nextLine();
            if (validacion.altura(altura)) {
                arrayBuscar[7] = altura;
                break;
            }
        }
        Sospechoso SospechosoABuscar = new Sospechoso(arrayBuscar);
    }

    public void mostrarHistorial(){
        System.out.println("Historial");
    }

    public void mostrarCoincidencias(){
        System.out.println("Las coincidencias son:");
    }
}
