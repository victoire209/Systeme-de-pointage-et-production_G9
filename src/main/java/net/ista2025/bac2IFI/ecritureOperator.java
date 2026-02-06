package net.ista2025.bac2IFI;

import java.io.*;
import java.util.Scanner;
//le code pour ecrire dans le fichier erciture0perator.java
public class ecritureOperator {
    public static void ecrireOperateurs() {  // Méthode statique
        String operatorsPath = "D:/vic_java/Systeme de pointage et production_G9/data/operators.txt";

        try (Scanner lect = new Scanner(System.in);
             BufferedWriter bw = new BufferedWriter(new FileWriter(operatorsPath, true))) {

            System.out.println("Veuillez entrer les identités de l'opérateur : ");
            String infoOperators = lect.nextLine();
            bw.write(infoOperators);
            bw.newLine();

        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture du fichier!");
            e.printStackTrace();
        }
    }
}

