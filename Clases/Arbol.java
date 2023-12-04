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
        private int lugar;
        
        public int getLugar(){
            return this.lugar;
        }
        
        public void setLugar(int lugar){
            this.lugar = lugar;
        }
        
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
            while ((indice_coincidencia <= auxiliar.getIndice_Coincidencia() && auxiliar.getHijo_izquierda() != null) ||
                (indice_coincidencia > auxiliar.getIndice_Coincidencia() && auxiliar.getHijo_derecha() != null)) {
                if (auxiliar.getHijo_izquierda() != null && indice_coincidencia <= auxiliar.getIndice_Coincidencia() ) {
                    auxiliar = auxiliar.getHijo_izquierda();
                } else if (auxiliar.getHijo_derecha() != null && indice_coincidencia > auxiliar.getIndice_Coincidencia()) {
                    auxiliar = auxiliar.getHijo_derecha();
                }
            }
            if ( indice_coincidencia <= auxiliar.getIndice_Coincidencia() ) {
                auxiliar.setHijo_izquierda( new Nodo(sospechoso, indice_coincidencia));
            }
            else if ( indice_coincidencia > auxiliar.getIndice_Coincidencia() ) {
                auxiliar.setHijo_derecha( new Nodo(sospechoso, indice_coincidencia) );
            }
        }
    }
    
    public void eliminar (int lugar){
        
        Nodo eliminado = buscarNodo (lugar);
        
        Nodo nueva_raiz;
        if (eliminado.getHijo_derecha()!=null){
                nueva_raiz = buscarHijoExtremoIzquierda(eliminado.getHijo_derecha());
                Nodo papa_nueva_raiz = buscarPapa (nueva_raiz, nueva_raiz.getLugar());
                papa_nueva_raiz.setHijo_derecha(null);
        } else{
                nueva_raiz = buscarHijoExtremoDerecha(eliminado.getHijo_izquierda());
                Nodo papa_nueva_raiz = buscarPapa (nueva_raiz, nueva_raiz.getLugar());
                papa_nueva_raiz.setHijo_izquierda(null);
        }

        if (lugar == 1){
            nueva_raiz.setHijo_izquierda(this.raiz.getHijo_izquierda());
            nueva_raiz.setHijo_derecha(this.raiz.getHijo_derecha());
            this.raiz = nueva_raiz;
        } else{
            Nodo papa_eliminado = buscarPapa (eliminado, lugar);
            
            nueva_raiz.setHijo_izquierda(eliminado.getHijo_izquierda());
            nueva_raiz.setHijo_derecha(eliminado.getHijo_derecha());
            
            if (papa_eliminado.getHijo_izquierda()!= null && papa_eliminado.getHijo_izquierda().getLugar()==lugar){
                papa_eliminado.setHijo_izquierda(nueva_raiz);
            } else if (papa_eliminado.getHijo_derecha()!= null && papa_eliminado.getHijo_derecha().getLugar()==lugar){
                papa_eliminado.setHijo_derecha(nueva_raiz);
            }
        } 
    }
    
    public Nodo buscarPapa (Nodo hijo, int lugar){
        Nodo papa_potencial_1 = buscarNodo (hijo.getLugar()+1);
        Nodo papa_potencial_2 = buscarNodo (hijo.getLugar()-1);
        Nodo papa;
        
        if (papa_potencial_1.getHijo_derecha().getLugar()!=lugar || papa_potencial_1.getHijo_izquierda().getLugar()!=lugar){
            papa = papa_potencial_2;
        } else{
            papa = papa_potencial_1;
        }
        return papa;
    }
    
    public Nodo buscarHijoExtremoIzquierda(Nodo inicio){
        
        if (inicio.getHijo_izquierda() != null){
            inicio = buscarHijoExtremoIzquierda (inicio);
        }
        
        return inicio;
    }
    
    public Nodo buscarHijoExtremoDerecha(Nodo inicio){
        if (inicio.getHijo_izquierda() != null){
            inicio = buscarHijoExtremoDerecha (inicio);
        }
        
        return inicio;
    }
    
    private void imprimirInterno (Nodo inicio) {
            
        if (inicio.getHijo_derecha() != null) {
            imprimirInterno (inicio.getHijo_derecha());
        }
        
        System.out.println("-" + inicio.getLugar() + "-------------------------------------------");
        inicio.getSospechoso().imprimirSospechoso();
        
        if (inicio.getHijo_izquierda() != null) {
            imprimirInterno (inicio.getHijo_izquierda());
        }
    }
    
    private Nodo buscarNodoInterno (Nodo inicio, int lugar){
        if (inicio.getHijo_derecha() != null) {
            if (inicio.getLugar() == lugar){
                return inicio;
            }
        }
        else if (inicio.getHijo_izquierda() != null) {
            if (inicio.getLugar() == lugar){
                return inicio;
            }
        }
        else{
            return inicio;
        }
        return null;
    }
    
    public Nodo buscarNodo (int lugar){
        return buscarNodoInterno(this.raiz, lugar);
    }
    
    private int contadorTemporal;
    
        public void asignarLugar (Nodo inicio) {
            
        if (inicio.getHijo_derecha() != null) {
            asignarLugar (inicio.getHijo_derecha());
        }
        
        contadorTemporal++;
        inicio.setLugar(contadorTemporal);
        
        if (inicio.getHijo_izquierda() != null) {
            asignarLugar (inicio.getHijo_izquierda());
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
