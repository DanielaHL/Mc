

public class interprete {
    //Funcion que recorre el bit 
    public static String convertir(String[] bit) {
        String aux=" ";//inicializando variable aux
        for(int x = 0 ; x<bit.length;x++){//Reccorre el bit y agrega los valores obtenidos en el metodo letras al resultado final, ejemplo A!+BCD+AD!
            aux=aux+letras(x,bit[x]);
        }
        return aux;
    }
    //Funcion que agrega una letra determinada dependiendo si hay un 1 o cero y su posicion
    private static String letras(int posicion,String valor){
        String aux="";
        switch(posicion){
            case 0:{
                if(valor.equals("1")){
                    aux="A";
                }else if(valor.equals("0")){
                    aux="A'";
                }
                break;
            }
            case 1:{
                if(valor.equals("1")){
                    aux="B";
                }else if(valor.equals("0")){
                    aux="B'";
                }
                break;
            }
            case 2:{
                if(valor.equals("1")){
                    aux="C";
                }else if(valor.equals("0")){
                    aux="C'";
                }
                break;
            }
            case 3:{
                if(valor.equals("1")){
                    aux="D";
                }else if(valor.equals("0")){
                    aux="D'";
                }
                break;
            }
            case 4:{
                if(valor.equals("1")){
                    aux="E";
                }else if(valor.equals("0")){
                    aux="E'";
                }
                break;
            }
            case 5:{  
                if(valor.equals("1")){
                    aux="F";
                }else if(valor.equals("0")){
                    aux="F'";
                }
                break;
            }
            case 7:{
                if(valor.equals("1")){
                    aux="G";
                }else if(valor.equals("0")){
                    aux="G'";
                }
                break;
            }
            case 8:{
                if(valor.equals("1")){
                    aux="H";
                }else if(valor.equals("0")){
                    aux="H'";
                }
                break;
            }
            case 9:{
                if(valor.equals("1")){
                    aux="I";
                }else if(valor.equals("0")){
                    aux="I'";
                }
                break;
            }
        }
        return aux;
    }
}
