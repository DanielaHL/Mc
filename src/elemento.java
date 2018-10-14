
public class elemento {
    private String bit[]; //String que almacena arreglo de bits--> ejemplo: 0001
    private String posicionTabla;//Guarda la posicion de los bits en la tabla principal
    private int numUnos;//Variable que contiene el numero de bits que tiene un elemento/fila
    private int posicionU[];//Variable que contiene la posicion de los unos
    private int posicionX[];//Variable que contiene la posicion de las x
    private int marca;//Variable que nos dice si un elemento se comparó o no con otro-->1: se comparó, 0: no se ha comparado
    public elemento(String bit[],String posicion){
        this.bit = bit;
        this.posicionTabla = posicion;
        this.numUnos = 0;
        this.marca=0;
        contar();
        buscarPosicionU();
        buscarPosicionX();
    }
    public void contar(){
        for(int x = 0 ; x<bit.length ; x++){ //Contar numero de unos y x --> x=1
            if(bit[x].equals("1") || bit[x].equals("X")){
                this.numUnos++;
            }
        }
    }
    public void buscarPosicionU(){ //Funcion que busca, guarda y calcula la posicion de los unos.
        int aux = 0;
        for(int x = 0 ; x < bit.length; x++){
            if(bit[x].equals("1")){
                aux++;
            }
        }
        this.posicionU = new int[aux];
        int y =0;
        
        for(int x = 0 ; x<bit.length ; x++){
            if(bit[x].equals("1")){
                this.posicionU[y]=x;
                y++;
            }
        }
    }
    public void buscarPosicionX(){ //Funcion que busca, guarda y calcula la posicion de las x.
        int aux = 0;
        for(int x = 0 ; x < bit.length; x++){
            if(bit[x].equals("X")){
                aux++;
            }
        }
        
        this.posicionX = new int[aux];
        int y =0;
        
        for(int x = 0 ; x<bit.length ; x++){
            if(bit[x].equals("X")){
                this.posicionX[y]=x;
                y++;
            }
        }
    }
    //getters y setters de las variables
    public String[] getBit() { 
        return bit;
    }

    public String getPosicionTabla() {
        return posicionTabla;
    }

    public int getNumUnos() {
        return numUnos;
    }

    public int[] getPosicionU() {
        buscarPosicionU();
        return posicionU;
    }

    public int[] getPosicionX() {
        return posicionX;
    }

    public int getMarca() {
        return marca;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }
    
}