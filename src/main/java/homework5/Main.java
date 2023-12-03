package homework5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*1. Написать функцию, создающую резервную копию всех файлов в директории во вновь созданную папку ./backup
* */

public class Main {
    public static void main(String[] args) throws IOException {
        File startDirectory = new File(".\\backup");
        startDirectory.mkdir();

        checkDir(new File("."), startDirectory);
        System.out.println("Копирование завершено успешно!");
    }

    /**
     * @param fileNameIn Путь к копируемому файлу
     * @param fileNameOut Путь к новому файлу
     * @throws IOException Ошибка ввода-вывода
     */
    static void copyFile(String fileNameIn, String fileNameOut) throws IOException {
        // На запись
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileNameOut)) {
            int c;
            // На чтение
            try (FileInputStream fileInputStream = new FileInputStream(fileNameIn)) {
                while ((c = fileInputStream.read()) != -1) {
                    fileOutputStream.write(c);
                }
            }
        }
    }

    /**
     *
     * @param filein Директория, которую необходимо полностью скопировать
     * @param fileout Директория, в которую будет осуществлено полое копирование
     * @throws IOException Ошибка ввода-вывода
     */
    static void checkDir(File filein, File fileout) throws IOException {

        File[] files = filein.listFiles();
        if (files == null)
            return;

        for (File file : files) {

            String path = file.getPath();
            String start = fileout.getPath();
            if (file.isDirectory()) {
                if (!(path.equals(start))) {
                    File destination = new File(start + path.substring(1));
                    destination.mkdir();
                    checkDir(file, fileout);
                }
            }
            if (file.isFile()) {
                copyFile(path, start + path.substring(1));
            }
        }
    }
}
