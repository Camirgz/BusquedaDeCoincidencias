package Clases;


public class Validaciones {

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
        if (input.equals("S")||input.equals("B")||input.equals("H")){
            return true;
        }
        return false;
    }

    public boolean array(String[] array) {
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

}
