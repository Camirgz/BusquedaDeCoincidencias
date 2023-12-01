 public class Lista
{
    private Nodo cabeza;
    
    class Nodo {
        private Sospechoso sospechoso;
        private Nodo siguiente;
        private Arbol busqueda;
    
        public Nodo(Sospechoso contenido) {
            this.sospechoso = contenido;
        }
        
        public Nodo(Arbol busqueda){
            this.busqueda = busqueda;
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
        
        public Sospechoso getSospechoso(){
            return this.sospechoso;
        }
        
        public Arbol getBusqueda(){
            return this.busqueda;
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
    
    public void agregarHistorial(Arbol busqueda){
        
        Nodo nuevo = new Nodo (busqueda);
        
        if (this.cabeza == null){
            this.cabeza = nuevo;
        } else{
            Nodo auxiliar = this.cabeza;
            while (auxiliar.getSiguiente()!=null){
                auxiliar = auxiliar.getSiguiente();
            }
            auxiliar.setSiguiente(nuevo);
        }
    }
    
        public void imprimir () {
        Nodo auxiliar = this.cabeza;
        while (auxiliar != null) {
            auxiliar.getSospechoso().imprimirSospechoso();
            auxiliar = auxiliar.getSiguiente();
        }
    }
    
    public void imprimirHistorial(){
        Nodo auxiliar = this.cabeza;
        while(auxiliar!=null){
            auxiliar.getBusqueda().imprimir();
            auxiliar = auxiliar.getSiguiente();
        }
        System.out.println("----------FIN--------");
    }
    
    public Nodo getCabeza(){
        return this.cabeza;
    }
    
    public Arbol Busqueda(String nombre, String provincia, String canton, String edad_str, String genero, String estadoCivil, String pelo, String altura_str, Lista sospechosos){
        
        Arbol busqueda = new Arbol();
    
        String [] nombre_busqueda = nombre.split(" ");
        int edad_busqueda= Integer.parseInt(edad_str);
        int altura_busqueda = Integer.parseInt(altura_str);
        
        if (sospechosos.getCabeza()==null){
            System.out.println("No hay sospechosos");
        } else{
            Nodo auxiliar = sospechosos.getCabeza();
            while (auxiliar.getSiguiente()!=null){
                
                int indice_coincidencia = 0;
                
                //nombre
                String [] nombre_completo = auxiliar.getSospechoso().getNombre().split(" ");
                for (int i = 0; i<nombre_busqueda.length; i++){
                    for (int k = 0; k<nombre_completo.length; k++){
                        if (nombre_completo[k].equals(nombre_busqueda[i])){
                            indice_coincidencia++;
                        }
                    }
                }
                
                //provincia y canton
                if (auxiliar.getSospechoso().getProvincia().equals(provincia)){
                    indice_coincidencia++;
                    if (auxiliar.getSospechoso().getCanton().equals(canton)){
                        indice_coincidencia = indice_coincidencia + 2;
                    }
                }
                
                //edad
                int edad = auxiliar.getSospechoso().getEdad();
                if (edad<=edad_busqueda+5 || edad>=edad_busqueda-5){
                    indice_coincidencia = indice_coincidencia +2;
                    if (edad == edad_busqueda){
                        indice_coincidencia++;
                    }
                }
                
                //genero
                if (auxiliar.getSospechoso().getGenero().equals(genero)){
                    indice_coincidencia = indice_coincidencia + 3;
                }
                
                //pelo
                if (auxiliar.getSospechoso().getPelo().equals(pelo)){
                    indice_coincidencia++;
                }
                
                //altura
                int altura = auxiliar.getSospechoso().getAltura();
                if (altura<=altura_busqueda+4 || altura>=altura_busqueda-5){
                    indice_coincidencia = indice_coincidencia +2;
                }
                
                busqueda.insertar(auxiliar.getSospechoso(), indice_coincidencia);
                
                auxiliar = auxiliar.getSiguiente();
            }
            
            int indice_coincidencia = 0;
                
            //nombre
            String [] nombre_completo = auxiliar.getSospechoso().getNombre().split(" ");
            for (int i = 0; i<nombre_busqueda.length; i++){
                for (int k = 0; k<nombre_completo.length; k++){
                    if (nombre_completo[k].equals(nombre_busqueda[i])){
                        indice_coincidencia++;
                    }
                }
            }
            
            //provincia y canton
            if (auxiliar.getSospechoso().getProvincia().equals(provincia)){
                indice_coincidencia++;
                if (auxiliar.getSospechoso().getCanton().equals(canton)){
                    indice_coincidencia = indice_coincidencia + 2;
                }
            }
            
            //edad
            int edad = auxiliar.getSospechoso().getEdad();
            if (edad<=edad_busqueda+5 || edad>=edad_busqueda-5){
                indice_coincidencia = indice_coincidencia +2;
                if (edad == edad_busqueda){
                    indice_coincidencia++;
                }
            }
            
            //genero
            if (auxiliar.getSospechoso().getGenero().equals(genero)){
                indice_coincidencia = indice_coincidencia + 3;
            }
            
            //pelo
            if (auxiliar.getSospechoso().getPelo().equals(pelo)){
                indice_coincidencia++;
            }
            
            //altura
            int altura = auxiliar.getSospechoso().getAltura();
            if (altura<=altura_busqueda+4 || altura>=altura_busqueda-5){
                indice_coincidencia = indice_coincidencia +2;
            }
            
            busqueda.insertar(auxiliar.getSospechoso(), indice_coincidencia);
        }
        
        busqueda.imprimir();
        
        return busqueda;
    }
}
