import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Interaccion{
    
    Lista sospechosos = new Lista();
    
    public void interaccion(){
        System.out.println("=== Bienvenido al sistema de sospechosos del OIJ ===");
        CargarArchivos();
        MenuPrincipal();
    }
    
    public void CargarArchivos(){
        Scanner in = new Scanner (System.in);
        
        boolean continuar = true;
        
        while (continuar){
            continuar = false;
            
            System.out.println("Ingrese el nombre del archivo: ");
            
            String csvFile = in.nextLine();
            
            try{
                BufferedReader br = new BufferedReader(new FileReader(csvFile));
                String line;
    
                while ((line = br.readLine()) != null) {
                    String[] datos = line.split(",");
                    
                    if (validaciones(datos)){
                        sospechosos.agregar(datos);
                    }
                }
            } catch (IOException e) {
                System.out.println("Error tipo: " + e.getMessage());
                System.out.println("Intente de nuevo");
                continuar = true;
            }
        }
        
        System.out.println("El archivo fue validado\n");
    }
    
    public void MenuPrincipal(){
        Scanner scanner = new Scanner (System.in);
        
        System.out.println("Ingrese los datos del sospechoso/a por buscar");

        while(true){
            System.out.println("Ingrese nombre por buscar: ");
            String nombre = scanner.nextLine();
            if(strings(nombre)){
                break;
            }
        }

        while(true){
            System.out.println("Ingrese provincia por buscar: ");
            String provincia = scanner.nextLine();
            if (strings(provincia)) {
                break;
            }
        }

        while(true){
            System.out.println("Ingrese canton por buscar: ");
            String canton = scanner.nextLine();
            if (strings(canton)) {
                break;
            }
        }

        while(true){
            System.out.println("Ingrese edad por buscar: ");
            String edad = scanner.nextLine();
            if(edad(edad)){
                break;
            }
        }

        while(true){
            System.out.println("Ingrese genero por buscar: ");
            String genero = scanner.nextLine();
            if(genero(genero)){
                break;
            }
        }

        while(true){
            System.out.println("Ingrese color de pelo por buscar: ");
            String colorPelo = scanner.nextLine();
            if (pelo(colorPelo)) {
            break;
            }
        }

        while(true){
            System.out.println("Ingrese altura por buscar: ");
            String altura = scanner.nextLine();
            if(altura(altura)){
                break;
            }
        }
        
        while(true){
            System.out.println("Ingrese [S] para salir, [B] para buscar o [H] para ver el historial");
            String entrada = scanner.nextLine();
            if(input(entrada)){
                if(entrada.equalsIgnoreCase("B")){
                    mostrarCoincidencias();
                    //metodo para hacer el arbol binario a partir del sistema de puntos.
                }
                if (entrada.equalsIgnoreCase("H")){
                    mostrarHistorial();
                    //metodo para mostrar la lista de historial.
                }
                if (entrada.equalsIgnoreCase("S")){
                    System.out.println("Gracias!");
                    break;
                }
            }
        }
    }
    
    public boolean strings(String nombre) {
        for (char caracter : nombre.toCharArray()) {
            if (Character.isDigit(caracter)) {
                return false;
            }
        }
        return true;
    }

    public boolean edad(String edadStr) {
        int edad = Integer.parseInt(edadStr);
        if (edad >= 18 && edad <= 100) {
            return true;
        }
        return false;
    }

    public boolean genero(String genero) {
        genero = genero.toLowerCase();
        genero = genero.trim();
        if (genero.equals("masculino")) {
            return true;
        } else if (genero.equals("femenino")) {
            return true;
        } else if (genero.equals("otro")) {
            return true;
        }
        return false;
    }

    public boolean estadoCivil(String estadoCivil) {
        estadoCivil = estadoCivil.toLowerCase();
        estadoCivil = estadoCivil.trim();
        if (estadoCivil.equals("casado")||estadoCivil.equals("casada")) {
            return true;
        } else if (estadoCivil.equals("soltero")||estadoCivil.equals("soltera")) {
            return true;
        } else if (estadoCivil.equals("viudo")|| estadoCivil.equals("viuda")) {
            return true;
        } else if (estadoCivil.equals("divorciado") || estadoCivil.equals("divorciada")) {
            return true;
        }
        return false;
    }

    public boolean pelo(String pelo) {
        pelo = pelo.toLowerCase();
        pelo = pelo.trim();
        if (pelo.equals("negro")) {
            return true;
        } else if (pelo.equals("moreno")) {
            return true;
        } else if (pelo.equals("castanno")) {
            return true;
        } else if (pelo.equals("rubio")) {
            return true;
        }
        return false;
    }

    public boolean altura(String alturaStr) {
        int altura = Integer.parseInt(alturaStr);
        if (altura >= 100 && altura <= 200) {
            return true;
        }
        return false;
    }

    public boolean input(String input){
        if (input.equalsIgnoreCase("S")||input.equalsIgnoreCase("B")||input.equalsIgnoreCase("H")){
            return true;
        }
        return false;
    }

    public boolean validaciones(String[] array) {
        try {
            //Validaciones
            int contador = 0;
            if (array.length != 8) {
                contador++;
            }
            if (!strings(array[0])) {
                contador++;
            }
            if (!strings(array[1])) {
                contador++;
            }
            if (!strings(array[2])) {
                contador++;
            }
            if (!edad(array[3])) {
                contador++;
            }
            if (!genero(array[4])) {
                contador++;
            }
            if (!estadoCivil(array[5])) {
                contador++;
            }
            if (!pelo(array[6])) {
                contador++;
            }
            if (!altura(array[7])) {
                contador++;
            }
            //Return
            if (contador == 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
    
        public void mostrarHistorial(){
        System.out.println("Historial");
    }

    public void mostrarCoincidencias(){
        System.out.println("Las coincidencias son:");
    }
}
