package HomeWork_3;

import java.io.IOException;
import java.util.HashMap;

public class Program {
    public static void main(String[] args) {
        ParsData parsData = new ParsData(); // преобразование данных
        String newFileName = null; // новый файл
        WriteFile writeFile = new WriteFile(); // запись файла

        HashMap<String, Object> data = parsData.parsInputData(); // хранение
        while (data.size() != 6) {
            try {
                throw new DataException();
            } catch (DataException e) {
                data = parsData.parsInputData();
            }
        } // ввод данных с проверкой

        newFileName = data.get("lastName") + ".txt"; // запись данных
        StringBuilder sb = new StringBuilder();
        for (String str : data.keySet()) {
            sb.append(data.get(str));
            sb.append(" ");
        }


        System.out.println(data);
        String filePath = newFileName;
        System.out.println(filePath);
        writeFile.writeData(String.valueOf(sb), filePath); // запись в файл

    }
}

