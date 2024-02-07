package es.ieslavereda;

import java.util.*;

public class Pais implements Comparable<Pais>{

    public static Comparator<Pais> SORT_BY_PUNTOS = (p1,p2) -> p1.getPuntos()- p2.getPuntos();
    private String nombre;
    private String cantante;
    private Integer puntos;
    private Map<Pais, Integer> paisesVotados;

    public Pais(String nombre, String cantante){
        this.nombre = nombre;
        this.cantante = cantante;
        paisesVotados = new LinkedHashMap<>();
        puntos = 0;
    }
    public String getCantante() {
        return cantante;
    }
    public String getNombre() {
        return nombre;
    }
    public void addPuntos(Integer puntos) {
        this.puntos += puntos;
    }
    public Integer getPuntos() {
        return puntos;
    }
    public Map<Pais, Integer> getPaisesVotados() {
        return paisesVotados;
    }

    public boolean votar(Pais pais, Integer puntuacion){
        if (paisesVotados.size() == 10 || puntuacion<1 || puntuacion>12 || puntuacion == 11 || puntuacion == 9
                || paisesVotados.containsKey(pais) || pais.equals(this)){
            return false;
        }
        List<Integer> puntosList = new LinkedList<>(paisesVotados.values());
        Collections.sort(puntosList);
        if (puntosList.contains(puntuacion)){
            return false;
        }
        paisesVotados.put(pais, puntuacion);
        pais.addPuntos(puntuacion);
        return true;
    }

    public void votarAll(Collection<Pais> paises){
        List<Pais> paisesLinked = new LinkedList<>(paises);
        Collections.shuffle(paisesLinked);
        List<Pais> paises10 = new LinkedList<>();
        Iterator<Pais> iterator = paisesLinked.iterator();
        while (paises10.size()!=10){
            Pais pais = iterator.next();
            if (!(pais.equals(this))){
                paises10.add(pais);
            }
        }

        int i=1;
        for (Pais pais:paises10) {
            if (i ==9){
                i = 10;
            } else if (i==11) {
                i=12;
            }
            votar(pais, i);
            i++;
        }

    }

/*    @Override
    public int hashCode(){
        return nombre.hashCode()+puntos.hashCode();
    }*/

    @Override
    public int compareTo(Pais pais){
        return nombre.compareTo(pais.getNombre());
    }

    @Override
    public String toString(){
        return nombre;
    }

    @Override
    public boolean equals(Object obj){
        if (obj==null || !(obj instanceof Pais)){
            return false;
        }
        Pais pais = (Pais) obj;
        return nombre.equals(pais.getNombre());
    }


}
