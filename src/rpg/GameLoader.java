package rpg;

import java.io.*;
import javax.swing.*;

public class GameLoader {
    public static String loadGame(int fileIndex) {
        // Ruta del archivo de guardado (puedes adaptar el nombre según tu sistema)
        String fileName = "save_game_" + fileIndex + ".txt";
        StringBuilder gameData = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                gameData.append(line).append("\n");
            }
        } catch (IOException e) {
            return null; // Si hay un error al leer el archivo, retorna null
        }

        return gameData.toString(); // Devuelve el contenido del archivo
    }
}
