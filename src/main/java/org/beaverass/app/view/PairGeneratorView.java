package org.beaverass.app.view;

import org.beaverass.app.PairGenerator;
import org.beaverass.app.exception.UnknownCommandException;
import org.beaverass.app.parser.FileParserByNewLine;
import org.beaverass.app.parser.FileParserBySemicolon;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class PairGeneratorView {

    private PairGenerator pairGenerator;

    public void run() throws UnknownCommandException, IOException {
        int option = start();

        if(option == 1) {
            createPair();
        }else if(option == 2){
            System.out.println("Ахахахахах, думал я так прост? А ну быстро генири пару!!!");
            createPair();
        } else {
            throw new UnknownCommandException("Неизвестная команда попробуйте снова!");
        }
    }

    private int start(){

        String message =  "\t\t\t\t\tПривет, это генератор рандомных пар!"
                + "\n Вот что я умею: "
                + "\n - Чтобы сгенирировать пару нажми 1"
                + "\n - Чтобы выйти нажми 2";

        System.out.println(message);

        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }

    private void createPair() throws IOException, UnknownCommandException {

        pickFileParser();

        printResultPairs();

    }

    private void pickFileParser() throws UnknownCommandException {
        System.out.println("Выбирите расположение кандидатов в файле: " + "\n1. Каждый кандидат с новой строки" + "\n2. Кандидаты через точку с запятой");

        int howReadFile = new Scanner(System.in).nextInt();
        if(howReadFile == 1) {
            pairGenerator = new PairGenerator(new FileParserByNewLine());
        }else if (howReadFile == 2){
            pairGenerator = new PairGenerator(new FileParserBySemicolon());
        }else {
            throw new UnknownCommandException("Такого варианта чтения файла нет попробуйте снова");
        }
    }

    private void printResultPairs() throws IOException {
        System.out.println("Введите абсолютный путь к файлу с кандидатами: ");
        String path = new Scanner(System.in).nextLine();
        Map<String, String> result = pairGenerator.generatePair(path, 1);

        if(result.size() != 0){

            System.out.println("\t\t\t\t\tПоздравляю вот ваши пары!!!\n");

            result.forEach((k, v) -> System.out.println(k + " VS " + v));

        }
    }
}
