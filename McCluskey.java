
import java.util.ArrayList;
import java.util.Arrays;

public class McCluskey {
    private int min;//Variable que contiene el valor minimo de unos que se registro
    private int max;//Variable que contiene el valor maximo de unos que se registro
    private int minterminos[];//Variable que guarda las posiciones de los minterminos
    private ArrayList<elemento> tabla;//Variable que guarda los bits que en su funcion tienen uno/minterminos
    private String resultado;//Variable que guarda el resultado final --> ejemplo: A!BC!+ABD
public McCluskey(int minterminos[]){//Constructor que inicializa las variables anteriores y construye el objeto de McClauskey
        this.minterminos = minterminos;
        this.tabla = new ArrayList<>();
        this.resultado=" ";
        
        this.min = 50;
        this.max = 0;
    }
public void agregar(elemento e){//Funcion que agrega los elementos a la tabla y busca cuales tienen mayor y menor numero de unos.
        this.tabla.add(e);//Metodo que agrega los elementos a la tabla
        if(e.getNumUnos()<min){
            min = e.getNumUnos();
        }
        if(e.getNumUnos()>max){
            max = e.getNumUnos();
        }
    }
public void agrupacion(){
        //Arreglos auxiliares en donde se guardan por numero de unos en cada bit-->segunda tabla
        ArrayList<elemento> cero = new ArrayList<>();
        ArrayList<elemento> uno = new ArrayList<>();
        ArrayList<elemento> dos = new ArrayList<>();
        ArrayList<elemento> tres = new ArrayList<>();
        ArrayList<elemento> cuatro = new ArrayList<>();
        //Se recorre toda la tabla  y dependiendo del numero de unos se agrupa en su respectivo arreglo
        for(int x = 0 ; x< tabla.size(); x++){
           if(tabla.get(x).getNumUnos()==0){
               cero.add(tabla.get(x));
           }else if(tabla.get(x).getNumUnos()==1){
               uno.add(tabla.get(x));
           }else if(tabla.get(x).getNumUnos()==2){
               dos.add(tabla.get(x));
           }else if(tabla.get(x).getNumUnos()==3){
               tres.add(tabla.get(x));
           }else if(tabla.get(x).getNumUnos()==4){
               cuatro.add(tabla.get(x));
           }
        }
        //Arreglos auxiliares en donde se guardan las comparaciones entre cada agrupacion -->tercera tabla
        ArrayList<elemento> ccero_uno = new ArrayList<>();
        ArrayList<elemento> cuno_dos = new ArrayList<>();
        ArrayList<elemento> cdos_tres = new ArrayList<>();
        ArrayList<elemento> ctres_cuatro = new ArrayList<>();
        //Verifica que haya una agrupacion o elementos en el arreglo de ceros
        if(cero.size()>0){
            for(int i = 0 ; i<uno.size();i++){
                String c[] = new String[uno.get(i).getBit().length];//Al arreglo de uno dame la fila i, de ese elemento dame su bit, de ese bit dame su longitud                                 
                for(int j =0 ; j<uno.get(0).getBit().length ; j++){
                    if(uno.get(i).getBit()[j].equals("1")){
                        c[j]="X";
                    }else{
                        c[j]="0";
                    }
                }
                elemento e = new elemento(c,"0,"+uno.get(i).getPosicionTabla());
                ccero_uno.add(e);
            }
        }
        for(int i = 0 ; i<uno.size();i++){
            for(int j = 0 ; j<dos.size();j++){
                if(uno.get(i).getPosicionU()[0]==dos.get(j).getPosicionU()[0]){
                    
                    String[] aux = new String[uno.get(0).getBit().length];
                    
                    for(int z = 0 ; z<uno.get(0).getBit().length;z++){
                        if(uno.get(i).getBit()[z].equals(dos.get(j).getBit()[z])){
                            aux[z]=uno.get(i).getBit()[z];
                        }else{
                            aux[z]="X";
                        }
                    }
                    elemento e = new elemento(aux,""+uno.get(i).getPosicionTabla()+","+dos.get(j).getPosicionTabla());
                    cuno_dos.add(e);
                }else if(uno.get(i).getPosicionU()[0]== dos.get(j).getPosicionU()[1]){
                    String[] aux = new String[uno.get(0).getBit().length];
                    
                    for(int z = 0 ; z<uno.get(0).getBit().length;z++){
                        if(uno.get(i).getBit()[z].equals(dos.get(j).getBit()[z])){
                            aux[z]=uno.get(i).getBit()[z];
                        }else{
                            aux[z]="X";
                        }
                    }
                    elemento e = new elemento(aux,""+uno.get(i).getPosicionTabla()+","+dos.get(j).getPosicionTabla());
                    cuno_dos.add(e);
                }
            }
        }
        int c = 0;
        for(int i = 0 ; i<dos.size();i++){
            for(int j = 0 ; j<tres.size();j++){
                for(int y = 0 ; y<dos.get(i).getPosicionU().length; y++){
                    for(int z = 0 ; z<tres.get(j).getPosicionU().length;z++){
                        if(dos.get(i).getPosicionU()[y]==
                                tres.get(j).getPosicionU()[z]){
                            c++;
                        }
                    }
                }
                if(c>=2){
                    String[] aux = new String[uno.get(0).getBit().length];
                                    
                    for(int q = 0 ; q<dos.get(0).getBit().length;q++){
                        if(dos.get(i).getBit()[q].equals(tres.get(j).getBit()[q])){
                            aux[q]=dos.get(i).getBit()[q];
                        }else{
                            aux[q]="X";
                        }
                    }
                  elemento e = new elemento(aux,""+dos.get(i).getPosicionTabla()+","+tres.get(j).getPosicionTabla());
                    cdos_tres.add(e);
                }
                c=0;
            }
        }
        for(int i = 0 ; i<tres.size();i++){
            for(int j = 0 ; j<cuatro.size();j++){
                for(int y = 0 ; y<tres.get(i).getPosicionU().length; y++){
                    for(int z = 0 ; z<cuatro.get(j).getPosicionU().length;z++){
                        if(tres.get(i).getPosicionU()[y]==
                                cuatro.get(j).getPosicionU()[z]){
                            c++;
                        }
                    }
                }
                if(c>=3){
                    String[] aux = new String[uno.get(0).getBit().length];
                                    
                    for(int q = 0 ; q<tres.get(0).getBit().length;q++){
                        if(tres.get(i).getBit()[q].equals(cuatro.get(j).getBit()[q])){
                            aux[q]=tres.get(i).getBit()[q];
                        }else{
                            aux[q]="X";
                        }
                    }

                    elemento e = new elemento(aux,""+tres.get(i).getPosicionTabla()+","+cuatro.get(j).getPosicionTabla());
                    ctres_cuatro.add(e);
                }
                
                c=0;
            }
        }
        ArrayList<elemento> ccero_uno_uno_dos = new ArrayList<>();
        ArrayList<elemento> cuno_dos_dos_tres = new ArrayList<>();
        ArrayList<elemento> cdos_tres_tres_cuatro = new ArrayList<>();
        
        if(cero.size()>0){
            for(int x = 0 ; x < ccero_uno.size() ; x++){
                for(int y = 0 ; y<cuno_dos.size() ; y++){
                    if(ccero_uno.get(x).getPosicionX()[0]==cuno_dos.get(y).getPosicionX()[0]){ //recorrer posiciones en caso de tener mas X

                        String[] aux = new String[uno.get(0).getBit().length];

                        for(int q = 0 ; q<ccero_uno.get(0).getBit().length;q++){
                            if(ccero_uno.get(x).getBit()[q].equals(cuno_dos.get(y).getBit()[q])){
                                aux[q]=ccero_uno.get(x).getBit()[q];
                            }else{
                                aux[q]="X";
                            }
                        }
                        ccero_uno.get(x).setMarca(1);
                        cuno_dos.get(y).setMarca(1);
                        elemento e = new elemento(aux,""+ccero_uno.get(x).getPosicionTabla()+","+cuno_dos.get(y).getPosicionTabla());
                        ccero_uno_uno_dos.add(e);
                    }
                }
            }
        }
        for(int i = 0 ; i<cuno_dos.size();i++){
            for(int j = 0 ; j<cdos_tres.size();j++){
                for(int y = 0 ; y<cuno_dos.get(i).getPosicionU().length; y++){
                    for(int z = 0 ; z<cdos_tres.get(j).getPosicionU().length;z++){
                        if(cuno_dos.get(i).getPosicionX()[0]==cdos_tres.get(j).getPosicionX()[0]){ //recorrer posiciones en caso de tener mas X
                            if(cuno_dos.get(i).getPosicionU()[y]==
                                    cdos_tres.get(j).getPosicionU()[z]){
                                c=2;
                            } 
                        }
                    }
                }
                if(c>=2){
                    String[] aux = new String[uno.get(0).getBit().length];
                                    
                    for(int q = 0 ; q<cuno_dos.get(0).getBit().length;q++){
                        if(cuno_dos.get(i).getBit()[q].equals(cdos_tres.get(j).getBit()[q])){
                            aux[q]=cuno_dos.get(i).getBit()[q];
                        }else{
                            aux[q]="X";
                        }
                    }
                    cuno_dos.get(i).setMarca(1);
                    cdos_tres.get(j).setMarca(1);
                    elemento e = new elemento(aux,""+cuno_dos.get(i).getPosicionTabla()+","+cdos_tres.get(j).getPosicionTabla());
                    cuno_dos_dos_tres.add(e);
                }
                c=0;
            }
        }
        for(int i = 0 ; i<cdos_tres.size();i++){
            for(int j = 0 ; j<ctres_cuatro.size();j++){
                for(int y = 0 ; y<cdos_tres.get(i).getPosicionU().length; y++){
                    for(int z = 0 ; z<ctres_cuatro.get(j).getPosicionU().length;z++){
                        if(cdos_tres.get(i).getPosicionX()[0]==ctres_cuatro.get(j).getPosicionX()[0]){
                            if(cdos_tres.get(i).getPosicionU()[y]==
                                    ctres_cuatro.get(j).getPosicionU()[z]){
                                c=3;
                            } 
                        }
                    }
                }
                if(c>=3){
                    String[] aux = new String[uno.get(0).getBit().length];
                                    
                    for(int q = 0 ; q<cdos_tres.get(0).getBit().length;q++){
                        if(cdos_tres.get(i).getBit()[q].equals(ctres_cuatro.get(j).getBit()[q])){
                            aux[q]=cdos_tres.get(i).getBit()[q];
                        }else{
                            aux[q]="X";
                        }
                    }
                    cdos_tres.get(i).setMarca(1);
                    ctres_cuatro.get(j).setMarca(1);
                    elemento e = new elemento(aux,""+cdos_tres.get(i).getPosicionTabla()+","+ctres_cuatro.get(j).getPosicionTabla());
                    cdos_tres_tres_cuatro.add(e);
                }
                
                c=0;
            }
        }
        ArrayList<elemento> cfinal = new ArrayList<>();
        
        if(cero.size()>0){
            for(int x = 0 ; x<ccero_uno.size();x++){
                if(ccero_uno.get(x).getMarca()==0){
                    cfinal.add(ccero_uno.get(x));
                }
            }
        }
        for(int x = 0 ; x<cuno_dos.size();x++){
            if(cuno_dos.get(x).getMarca()==0){
                cfinal.add(cuno_dos.get(x));
            }
        }
        for(int x = 0 ; x<cdos_tres.size();x++){
            if(cdos_tres.get(x).getMarca()==0){
                cfinal.add(cdos_tres.get(x));
            }
        }
        for(int x = 0 ; x<ctres_cuatro.size();x++){
            if(ctres_cuatro.get(x).getMarca()==0){
                cfinal.add(ctres_cuatro.get(x));
            }
        }
        if(ccero_uno_uno_dos.size()>=2){
            elemento aux = ccero_uno_uno_dos.get(0);
            for(int x = 1 ; x<ccero_uno_uno_dos.size(); x++){
                if(Arrays.equals(aux.getBit(), ccero_uno_uno_dos.get(x).getBit())){
                    ccero_uno_uno_dos.remove(0);
                    aux = ccero_uno_uno_dos.get(0);
                    x=1;
                }
            }
        }
        if(cuno_dos_dos_tres.size()>=2){
            elemento aux = cuno_dos_dos_tres.get(0);
            for(int x = 1 ; x<cuno_dos_dos_tres.size(); x++){
                if(Arrays.equals(aux.getBit(), cuno_dos_dos_tres.get(x).getBit())){
                    cuno_dos_dos_tres.remove(0);
                    aux = cuno_dos_dos_tres.get(0);
                    x=1;
                }
            }
        }
        if(cdos_tres_tres_cuatro.size()>=2){
            elemento aux = cdos_tres_tres_cuatro.get(0);
            for(int x = 1 ; x<cdos_tres_tres_cuatro.size(); x++){
                if(Arrays.equals(aux.getBit(), cdos_tres_tres_cuatro.get(x).getBit())){
                    cdos_tres_tres_cuatro.remove(0);
                    aux = cdos_tres_tres_cuatro.get(0);
                    x=1;
                }
            }
        }
        if(cero.size()>0){
            for(int x = 0 ; x<ccero_uno_uno_dos.size(); x++){
                cfinal.add(ccero_uno_uno_dos.get(x));
            }
        }    
        for(int x = 0 ; x<cuno_dos_dos_tres.size(); x++){
            cfinal.add(cuno_dos_dos_tres.get(x));
        }
        for(int x = 0 ; x<cdos_tres_tres_cuatro.size(); x++){
            cfinal.add(cdos_tres_tres_cuatro.get(x));
        }
        for(int x = 0 ; x<cfinal.size();x++){
            if(x==0){
                this.resultado = this.resultado+interprete.convertir(cfinal.get(x).getBit());
            }else{
                this.resultado = this.resultado+"+ "+interprete.convertir(cfinal.get(x).getBit());
            }
        }
    }
    public String getResultado() {
        return resultado;
    } 
}//Clase

