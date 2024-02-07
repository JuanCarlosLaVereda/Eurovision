package es.ieslavereda;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] paisesArray = new String[]{"Suecia" , "Israel" , "Italia" ,
                "Finlandia" , "Estonia" , "Australia" , "Bélgica" , "Austria" , "España" ,
                "Republica Checa" , "Lituania" , "Armenia" , "Chipre" , "Suiza" , "Ucrania" ,
                "Francia" , "Noruega" , "Portugal" , "Eslovenia" , "Moldavia" , "Albania" ,
                "Reino Unido" , "Serbia" , "Polonia" , "Croacia", "Alemania"};

        List<Pais> listPaises = new LinkedList<>();
        for (int i = 0; i <paisesArray.length; i++) {
            listPaises.add(new Pais(paisesArray[i], "Cantante" + i));
        }
        Collections.sort(listPaises);
        System.out.println(listPaises);

        Iterator<Pais> iterator = listPaises.iterator();
        while (iterator.hasNext()){
            iterator.next().votarAll(listPaises);
        }

        iterator = listPaises.iterator();
        System.out.println("----------------------------");
        System.out.println("- Listado de todos los paises por orden alfabetico junto con las votaciones realizadas ordenadas de mayor a menor: ");
        while (iterator.hasNext()){
            Pais pais = iterator.next();
            List<Pais> listVotos = new ArrayList<>(pais.getPaisesVotados().keySet());
            List<Integer> listPuntos = new ArrayList<>(pais.getPaisesVotados().values());
            System.out.println("Pais: " + pais + "\nVotaciones: " + listVotos + "\nPuntuaciones: " + listPuntos);
            System.out.println("///////");
        }
        System.out.println(
        );


    }
}