package com.javielrezende.java8;

public class Person {

    // -------------------------------Criado na aula Method References---------------------------------------------------------------

    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Como este método está sendo mostrado em um foreach, e iterado a cada passagem dele,
    // ele precisa de um parametro para funcionar corretamente...
    public static void say(String r){
        System.out.println("A ner Person is sayng something... " + r);
    }

}
