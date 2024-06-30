package com.ahorcado;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>(Arrays.asList("Casa","Avion","Carro","Mesa","Tenedor","Telescopio","Canguro","Limpio","Antena","Sensor")) ;
        String choose;
        String letter;
        ArrayList<String> hang = new ArrayList<>();
        Random random = new Random();
        int wordIndex = random.nextInt(words.size());
        choose = words.get(wordIndex);
        System.out.println(choose);
        boolean isActive = true;
        boolean found = false;
        int tries = 3;
        try (Scanner sc = new Scanner(System.in)){
            clearConsole();
            for(int i=0; i<choose.length();i++){
                hang.add("_ ");
            }
            System.out.println(hang);
            while (isActive) {
                letter = sc.nextLine();
                for (int i = 0; i<choose.length();i++){
                    if (letter.charAt(0) == choose.toLowerCase().charAt(i)) {
                        hang.set(i,letter);
                        found = true;
                        System.out.println(hang);
                        clearConsole();
                    }
                }
                if (!found) {
                    System.out.println("Letra incorrecta");
                    tries --;
                }
                if (tries <= 0) {
                    System.out.println("Perdiste");
                    isActive = !isActive;
                }
                if(!hang.contains("_ ")){
                    System.out.println("ganaste");
                    isActive = !isActive;
                }
                clearConsole();
            }
            // Object[] hangArray = hang.toArray();
            
        }
    }

    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("windows")) {
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}