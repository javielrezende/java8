package com.javielrezende.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {

    public static void main(String... args) {

//----------------------------------------------------------------------------------------------------------
// -------------------------------Aula Lambda---------------------------------------------------------------
//1 - Sem Lambda
        System.out.println("Teste 1 - Rodando sem Lambda");
        Runnable run = new Runnable() {
            @Override
            public void run() {
            }
        };
        new Thread(run).start();
//1 - Fim

//1 - Com lambda
        System.out.println("Teste 1 - Rodando com Lambda");
        new Thread(() -> System.out.println("Hello JR - Java 8")).start();
//1 - Fim

//2 - Sem lambda
        System.out.println("Teste 2 - Rodando sem Lambda");
        List<String> strs = Arrays.asList("Roger", "Rezende", "Curso", "Java 8");
        System.out.println("Sem Lambda");
        for (String str : strs) {
            System.out.println(str);
        }
//2 - Fim

//2 - Com Lambda
        System.out.println("Teste 2 - Rodando sem Lambda");
        System.out.println("");
        System.out.println("Com lambda");
        strs.forEach(str -> System.out.println(str));
//2 - Fim

//2 - Com lambda implementando filtro, coletando e jogando em outra lista
        System.out.println("Teste 2 - Rodando com Lambda, implementando filtro, coleta e joga em outra lista");
        List<String> result = strs.stream().filter(str -> str.startsWith("R")).collect(Collectors.toList());
        result.forEach(System.out::println);
//2 - Fim

// -------------------------------Aula Method References---------------------------------------------------------------
//1 - Acessando método normalmente
        // A cada iteração de um str imprime-se um say
        /*result.forEach(str -> {
            Person.say();
        });*/
//1 - Fim

//1 - Acessando com ... method reference
        System.out.println("Teste 1 - Rodando com method references");
        result.forEach(Person::say);
//1 - Fim

// -------------------------------Aula Functional Interface---------------------------------------------------------------
//1 - Acessando método normalmente
        System.out.println("Teste 1 - Rodando com interface normal");
        MyInterface myInterface = new MyInterface() {
            @Override
            public void print() {
                System.out.println("Java 7 implementation - Funcional Interface");
            }
        };
        myInterface.print();
//1 - Fim

//1 - Com Java 8
        System.out.println("Teste 1 - Rodando com functiuonal interfaces");
        MyInterface my1 = () -> {
            System.out.println("Java 8 implementation - Funcional Interface");
        };
        my1.print();
        my1.body();
//1 - Fim

// -------------------------------Aula Streams---------------------------------------------------------------
//1 - Filtrando numeros diferentes de 0
        System.out.println("Aula Stream");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 0, 9, 10, 0);
        List<String> texts = Arrays.asList("a", "b", "c", "", "", "e", "f", "g");

        List<Integer> filteredNumers = numbers.stream()
                .filter(number -> number != 0)
                .collect(Collectors.toList());

        List<String> filteredTexts = texts.stream()
                .filter(text -> !text.isEmpty())
                .collect(Collectors.toList());

        System.out.println("Filtra letras diferentes de vazio");
        filteredNumers.forEach(System.out::println);
        System.out.println("");
        System.out.println("Filtra numeros diferentes de 0");
        filteredTexts.forEach(System.out::println);

        System.out.println("Cria um random com limite de dois resultados");
        Random hash = new Random();
        hash.doubles()
                .limit(2)
                .forEach(System.out::println);

// -------------------------------Aula Optional---------------------------------------------------------------
//1 - Filtrando numeros diferentes de 0












    }

}
