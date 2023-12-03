package homework5;

import java.io.File;

/**
 * TODO: Доработать метод print, необходимо распечатывать директории и файлы
 */
public class TreeBeauty {

    public static void main(String[] args) {
        print(new File("."), "", true);
    }

    static void print(File file, String indent, boolean isLast) {
        System.out.print(indent);
        if (isLast) {
            System.out.print("└─");
            indent += "  ";
        } else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());

        File[] filesNew = file.listFiles();

        if (filesNew == null) return;

        File[] files = new File[filesNew.length];

        int count = 0;
        for (int i = 0; i < filesNew.length; i++) {
            if (filesNew[i].isDirectory()) {
                files[count] = filesNew[i];
                count++;
            }
        }
        int subDirTotal = count;
        int subFileTotal = files.length-count;

        for (int i = 0; i < filesNew.length; i++) {
            if (filesNew[i].isFile()) {
                files[count] = filesNew[i];
                count++;
            }
        }

        int subDirCounter = 0;
        int subFileCounter = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                print(files[i], indent, subDirTotal == ++subDirCounter && subFileTotal == 0);
            }
            if (files[i].isFile()) {
                print(files[i], indent, subFileTotal == ++subFileCounter);
            }
        }
    }
}