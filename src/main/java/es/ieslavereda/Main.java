package es.ieslavereda;

import java.util.*;
import java.util.stream.Collectors;

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
            Collections.reverse(listPuntos);
            Collections.reverse(listVotos);
            System.out.println("Pais: " + pais + "\nVotaciones: " + listVotos + "\nPuntuaciones: " + listPuntos);
            System.out.println("///////");
        }

        System.out.println("----------------------------");
        System.out.println("- Listado de los paises ordenados por puntuaciones recibidas:");
        System.out.println(
                listPaises.stream()
                        .sorted(Pais.SORT_BY_PUNTOS.reversed())
                        .map(p->p.getNombre())
                        .collect(Collectors.joining(", "))
        );
        System.out.println(
                listPaises.stream()
                        .sorted(Pais.SORT_BY_PUNTOS.reversed())
                        .map(p->p.getPuntos())
                        .collect(Collectors.toList()).toString()
        );

        System.out.println("----------------------------");
        System.out.println("- Nombre del pais ganador junto con la puntacion total obtenida y paises que le han votado junto con los puntos asignados por cada uno de ellos:");

        Pais paisGanador = listPaises.stream()
                .max(Pais.SORT_BY_PUNTOS)
                .orElse(null);
        System.out.println("Ganador: " + paisGanador + "\nPuntuacion: " + paisGanador.getPuntos());
        Map<Pais, Integer> votosPaisGanador = new LinkedHashMap<>();
        iterator = listPaises.iterator();
        while (iterator.hasNext()){
            Pais pais = iterator.next();
            Integer voto = 0;
            if (pais.getPaisesVotados().containsKey(paisGanador)){
                voto = pais.getPaisesVotados().get(paisGanador);
                votosPaisGanador.put(pais, voto);
            }
        }
        System.out.print("Paises votantes: ");
        List<Pais> listPaisesVotosGanador = new LinkedList<>(votosPaisGanador.keySet());
        List<Integer> listPaisesVotosganadorPuntos = new LinkedList<>(votosPaisGanador.values());
        for (int i = 0; i < listPaisesVotosGanador.size(); i++) {
            System.out.print("\n" + listPaisesVotosGanador.get(i) + " " + listPaisesVotosganadorPuntos.get(i));
        }

        System.out.println("------------------------------");
        System.out.println("- Listado de canciones ordenadas por nombre:");


    }
}