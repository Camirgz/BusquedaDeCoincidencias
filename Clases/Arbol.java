public class Arbol{
    Nodo raiz;
    
    public Nodo getRaiz(){
        return this.raiz;
    }
    
    public class Nodo{
        private Sospechoso sospechoso;
        private int indice_coincidencia;
        private Nodo hijo_izquierda;
        private Nodo hijo_derecha;
        
        public Nodo (String [] informacion){
            this.sospechoso = new Sospechoso (informacion);
        }
        
        public Nodo (Sospechoso sospechoso){
            this.sospechoso = sospechoso;
        }
        
        public Nodo (Sospechoso sospechoso, int indice_coincidencia){
            this.sospechoso = sospechoso;
            this.indice_coincidencia = indice_coincidencia;
        }
        
        public void setHijo_izquierda (Nodo a){
            this.hijo_izquierda = a;
        }
        
        public void setHijo_derecha (Nodo a){
            this.hijo_derecha = a;
        }
        
        public void setIndice_coincidencia (int a){
            this.indice_coincidencia = a;
        }
        
        public Nodo getHijo_izquierda (){
            return this.hijo_izquierda;
        }
        
        public Nodo getHijo_derecha(){
            return this.hijo_derecha;
        }
        
        public Sospechoso getSospechoso (){
            return this.sospechoso;
        }
        
        public int getIndice_Coincidencia(){
            return this.indice_coincidencia;
        }
    }
    
    public void insertar(Sospechoso sospechoso, int indice_coincidencia) {
        if (this.raiz == null) {
            this.raiz = new Nodo (sospechoso, indice_coincidencia);
        } else {
            Nodo auxiliar = this.raiz;
            while ((indice_coincidencia < auxiliar.getIndice_Coincidencia() && auxiliar.getHijo_izquierda() != null) ||
                (indice_coincidencia > auxiliar.getIndice_Coincidencia() && auxiliar.getHijo_derecha() != null)) {
                if (auxiliar.getHijo_izquierda() != null && indice_coincidencia < auxiliar.getIndice_Coincidencia() ) {
                    auxiliar = auxiliar.getHijo_izquierda();
                } else if (auxiliar.getHijo_derecha() != null && indice_coincidencia > auxiliar.getIndice_Coincidencia()) {
                    auxiliar = auxiliar.getHijo_derecha();
                }
            }
            if ( indice_coincidencia < auxiliar.getIndice_Coincidencia() ) {
                auxiliar.setHijo_izquierda( new Nodo(sospechoso, indice_coincidencia));
            }
            else if ( indice_coincidencia > auxiliar.getIndice_Coincidencia() ) {
                auxiliar.setHijo_derecha( new Nodo(sospechoso, indice_coincidencia) );
            }
        }
    }
    
    //eliminar nodo
    
        private void imprimirInterno (Nodo inicio) {
        int contador = 1;
            
        if (inicio.getHijo_derecha() != null) {
            imprimirInterno (inicio.getHijo_derecha());
        }
        inicio.getSospechoso().imprimirSospechoso();
        System.out.println("" + contador + "\n");
        contador++;
        if (inicio.getHijo_izquierda() != null) {
            imprimirInterno (inicio.getHijo_izquierda());
        }
    }
    
    public void imprimir () {
        if (this.raiz != null) {
            this.imprimirInterno(this.raiz);
        } else {
            System.out.println("No hay ningún sospechoso");
        }
    }
    
    public boolean compararArray(String [] array1, String [] array2){
        boolean igual = true;
        
        if (array1.length!=array2.length){
            igual = false;
        } else{
            for (int i = 0; i<array1.length; i++){
                if (!array1[i].equals(array2[i])){
                    igual = false;
                }
            }
        }
        return igual;
    }
}
