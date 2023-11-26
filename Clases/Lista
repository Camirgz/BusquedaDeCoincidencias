public class Lista
{
    private Nodo cabeza;
    
    class Nodo {
        private Sospechoso sospechoso;
        private Nodo siguiente;
    
        public Nodo(Sospechoso contenido) {
            this.sospechoso = contenido;
        }
        
        public void imprimir() {
            sospechoso.imprimirSospechoso();
        }
        
        public Nodo getSiguiente() {
            return this.siguiente;
        }
        
        public void setSiguiente(Nodo n) {
            this.siguiente = n;
        }
    }
    
    public void agregar (String [] array) {
        Sospechoso datos = new Sospechoso (array);
        
        Nodo nuevo = new Nodo (datos);
        
        if (this.cabeza == null) {
            this.cabeza = nuevo;
        } else {
            Nodo auxiliar = this.cabeza;
            while (auxiliar.getSiguiente() != null) {
                auxiliar = auxiliar.getSiguiente();
            }
            auxiliar.setSiguiente(nuevo);
        }
    }
    
        public void imprimir () {
        Nodo auxiliar = this.cabeza;
        while (auxiliar != null) {
            auxiliar.imprimir();
            auxiliar = auxiliar.getSiguiente();
        }
    }
}
