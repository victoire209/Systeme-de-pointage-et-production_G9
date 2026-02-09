package manager;

import java.io.*;
import java.util.*;

public class OperatorManager {

    public static boolean exists(String operatorId) {
        try {
            File file = new File("data/operators.txt");
            if (!file.exists()) {
                return false;
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(operatorId + ";")) {
                    br.close();
                    return true;
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Erreur lecture fichier : " + e.getMessage());
        }
        return false;
    }
}