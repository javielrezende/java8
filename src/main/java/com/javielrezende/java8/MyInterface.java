package com.javielrezende.java8;

// -------------------------------Criado na aula Functional Interface---------------------------------------------------------------


@FunctionalInterface
public interface MyInterface {
    void print();

    // Agora é possível colocar um default de um método e nao deixa-lo somente com a assinatura do método
    default void body(){
        System.out.println("This is my interface functional body");
    }

}
