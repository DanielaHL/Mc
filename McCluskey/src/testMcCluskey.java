
/*
Fundamentos de Diseño Digital
Practica 01:  Métodos minimización: Quine-Mac Cluskey
Jazmin Abigail Mena Zamora 
Daniela Margarita Honorato Lopez
2CM1
12/Octubre/2018
*/

public class testMcCluskey {

    public static void main(String[] args) {
        // TODO code application logic here
        int min[] = new int[]{1,3,4,5,7,9,10,11,15};
        //Creando arreglos con los bits que se van a  simplificar
        String b1[] = new String[]{"0","0","0","1"};
        String b2[] = new String[]{"0","0","1","1"};
        String b3[] = new String[]{"0","1","0","0"};
        String b4[] = new String[]{"0","1","0","1"};
        String b5[] = new String[]{"0","1","1","1"};
        String b6[] = new String[]{"1","0","0","1"};
        String b7[] = new String[]{"1","0","1","0"};
        String b8[] = new String[]{"1","0","1","1"};
        String b9[] = new String[]{"1","1","1","1"};
//        String b10[] = new String[]{"1","1","1","0"};
//        String b11[] = new String[]{"1","1","1","1"};
        //Creando variables de tipo elemento que reciben el bit y la posicion(numero) al que pertenece dicho bit.
        elemento e1 = new elemento(b1,"1");
        elemento e2 = new elemento(b2,"3");
        elemento e3 = new elemento(b3,"4");
        elemento e4 = new elemento(b4,"5");
        elemento e5 = new elemento(b5,"7");
        elemento e6 = new elemento(b6,"9");
        elemento e7 = new elemento(b7,"10");
        elemento e8 = new elemento(b8,"11");
        elemento e9 = new elemento(b9,"15");
//        elemento e10 = new elemento(b10,"14");
//        elemento e11 = new elemento(b11,"15");
        //Crea un objeto para agregar los elementos a la tabla
        McCluskey m = new McCluskey(min);
        m.agregar(e1);
        m.agregar(e2);
        m.agregar(e3);
        m.agregar(e4);
        m.agregar(e5);
        m.agregar(e6);
        m.agregar(e7);
        m.agregar(e8);
        m.agregar(e9);
//        m.agregar(e10);
//        m.agregar(e11);
//        
        m.agrupacion();
        System.out.println("Resultado: "+m.getResultado());
        System.out.println();
    }  
}
