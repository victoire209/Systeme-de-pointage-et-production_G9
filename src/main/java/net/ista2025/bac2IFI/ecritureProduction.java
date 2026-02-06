package net.ista2025.bac2IFI;

import java.io.*;
import java.util.Scanner;
//le code pour ecrire dans le fichier ecritureProducction.java
public class ecritureProduction {
    public static void ecritureProductions() {  // Méthode statique
        String productionPath = "D:/vic_java/Systeme de pointage et production_G9/data/production.csv";

        try (Scanner lect = new Scanner(System.in);
             BufferedWriter bw = new BufferedWriter(new FileWriter(productionPath, true))) {

            System.out.println("Veuillez entrer les données de la production : ");
            String infoProduction = lect.nextLine();
            bw.write(infoProduction);
            bw.newLine();

        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture du fichier!");
            e.printStackTrace();
        }
    }
}


