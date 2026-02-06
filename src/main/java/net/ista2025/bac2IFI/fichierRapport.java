package net.ista2025.bac2IFI;

import java.io.*;
import java.util.Scanner;
//le code pour ecrire dans le fichier fichierRapport.java

public class fichierRapport {
    public static void fichierRapports() {  // Méthode statique
            String reportPath = "D:/vic_java/Systeme de pointage et production_G9/data";
            File fichier = new File(reportPath);


    try{
        if (fichier.createNewFile()) {
            System.out.println("Fichier créé avec succès");
        } else {
            System.out.println("Fichier existe déjà");
        }
        } catch (IOException e) {
        throw new RuntimeException(e);
    }

        String productionPath = "D:/vic_java/Systeme de pointage et production_G9/data";

        try(
            Scanner lect = new Scanner(System.in);
            BufferedWriter bw = new BufferedWriter(new FileWriter(productionPath, true)))

            {

                System.out.println("Veuillez entrer les données de la production : ");

                String infoProduction = lect.nextLine();
                bw.write(infoProduction);
                bw.newLine();

            } catch(IOException e)

            {
                System.out.println("erreur lors de l'ecriture du fichier!");
                e.printStackTrace();
            }
        }
    }
