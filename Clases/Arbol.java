public class Arbol{
    Nodo raiz;
    
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
    
    public void insertar (String [] informacion){
        if (this.raiz == null){
            this.raiz = new Nodo (informacion);
        } else{
            Nodo auxiliar = this.raiz;
            //while ((numero<auxiliar.get
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
