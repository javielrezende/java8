package com.javielrezende.java8;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String... args) throws InterruptedException {

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
//1 - Exemplos da classe Optional

        System.out.println("");
        System.out.println("Aula Optional");
        System.out.println("Sem a classe Optional em funcionamento");
        List<Person> people = new ArrayList<Person>();
        Person person1 = new Person("Roger");
        Person person2 = new Person("Igor");
        Person person3 = new Person("Miguel");
        Person person4 = new Person("Dionatan");
        Person person5 = new Person(null);

        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);
        people.add(person5);

        people.forEach(p -> {
            System.out.println(p.getName());
        });

        System.out.println("");
        System.out.println("Com a classe Optional em funcionamento");
        Optional<Person> op = Optional.of(person1);
        op.ifPresent(p -> {
            System.out.println(p.getName());
        });

        System.out.println("");
        System.out.println("Outro exemplo - Tentando pegar um nome nulo com ofNullable");
        String name = person5.getName();
        Optional<String> op1 = Optional.ofNullable(name);
        op1.ifPresent(System.out::println);


// -------------------------------Aula Date-Time---------------------------------------------------------------
//1 - Exemplos da classe Date-Time
        System.out.println("Utilizando Java Date-time");
        System.out.println("Horario local");

        Instant now = Instant.now();

        Thread.sleep(1000);
        Instant now2 = Instant.now();

        Duration dur = Duration.between(now, now2);
        System.out.println("Diferença entre as duas datas é de " + dur.getSeconds() + " segundos");

        System.out.println("");
        System.out.println("Novas datas co Local Date");

        LocalDate local = LocalDate.now();
        LocalDate birthday = LocalDate.of(2016, 8, 6);

        Period period = Period.between(birthday, local);
        System.out.println("Verificando a idade atual");
        System.out.printf("%s %s %s", period.getDays(), period.getMonths(), period.getYears());






    }

}
