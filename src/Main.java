
import java.util.Arrays;

import java.util.Scanner;

public class Main {
    public static char[][] labirent = {
            {'#', '!', '.', '.', 'R', '.', '.', '.', '.', '.', '.', '#', '.', '.', '.'},
            {'.', '.', '#', '.', '.', '.', '#', '.', 'H', '.', '.', '.', '.', '.', '!'},
            {'F', '.', '.', '.', '#', '.', '!', '.', '.', 'R', '.', '.', '#', '#', '.'},
            {'.', '.', '#', '.', '.', '#', '.', '.', '.', '.', 'F', '.', '.', '.', '.'},
            {'.', '!', '.', '.', '#', '.', '#', '.', '#', '.', '.', '#', '.', '.', '.'},
            {'.', '.', 'H', '.', '.', '!', '.', '.', 'H', '.', '.', 'F', '.', '.', 'R'},
            {'#', '#', '#', '#', '.', '.', '#', '.', '.', '.', 'T', '.', '.', '.', 'E'},
            {'.', '.', '#', '.', 'F', '.', '#', '#', '.', '#', '#', '#', '#', '.', '.'},
            {'.', '#', '.', '.', '.', '.', '!', '.', '#', '.', '.', '.', '#', '.', '.'},
            {'.', 'T', 'T', '.', '#', '#', '.', '.', '.', '.', 'T', '.', '.', '.', 'R'},
            {'.', '.', '.', '#', '.', '.', '.', '#', '.', '#', '.', '#', '.', 'T', '.'},
            {'B', '.', '#', '.', '.', '!', '.', '!', '.', '.', '.', '.', '.', '.', '#'},
            {'.', '.', '.', 'F', '!', '.', '.', '.', 'H', '.', '.', 'R', '.', '.', '.'},
            {'.', '.', 'H', '.', '.', '.', '!', '.', '.', '.', '#', '.', '.', '#', '.'},
            {'.', '.', '.', '#', '.', '.', '#', '.', '#', '.', '#', '.', '.', '#', '#'}};

    public static int[] bonus = new int[4]; // 1. index R 2. index F 3. index T 4. index H
    public static int[] current_point; // konumu sürekli güncelliyorum
    public static int step_counter = 0;

    public static void printArr(char[][] matrix) { // 2 boyutlu char matrixleri yazdıran method
        for (char[] chars : matrix) {
            for (char Char : chars) {
                System.out.print(Char + "");
            }

            System.out.println();
        }
    }

    public static void printArr(int[] dizi) { //  bir boyutlu int içeren Arrayleri yazdırmaya yarayan method.
        System.out.print("Bulunduğunuz Konum: (");
        for (int i = 0; i < dizi.length; i++) {
            System.out.print(dizi[i]);
            if (i == 0) {
                System.out.print(", ");
            }
        }
        System.out.print(")\n");
    }

    public static int[] start_point(char[][] matrix) { // ilk sütunu gezerek başlangıç noktasını bulan method
        char[][] first_column = new char[matrix.length][1];
        int[] start_point = {0, 0};
        for (int i = 0; i < 15; i++) {
            first_column[i][0] = matrix[i][0];
            if (first_column[i][0] == 'B') {
                start_point[0] = i;
                break;
            }
        }
        return start_point;
    }

    public static int[] exit_point(char[][] matrix) { // son sütunu gezerek çıkış noktasını bulan method
        char[][] last_column = new char[matrix.length][matrix[1].length];
        int[] exit_point = {0, 0};
        for (int i = 0; i < 15; i++) {
            last_column[i][matrix[i].length - 1] = matrix[i][matrix[i].length - 1];
            if (last_column[i][14] == 'E') {
                exit_point[0] = i;
                exit_point[1] = matrix[i].length - 1;
                break;
            }
        }
        return exit_point;
    }

    public static char[][] new_labirent(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                while (true) {
                    int i1 = (int) (Math.random() * matrix.length);
                    int j1 = (int) (Math.random() * matrix[i1].length);
                    if (matrix[i1][j1] != '#' && matrix[i1][j1] != 'B' && matrix[i1][j1] != 'E') {
                        if (matrix[i][j] == '!' && matrix[i1][j1] == '.') {
                            char temp = matrix[i][j];
                            matrix[i][j] = matrix[i1][j1];
                            matrix[i1][j1] = temp;
                            break;
                        } else if (((matrix[i][j] == 'R' && matrix[i1][j1] != 'R') || (matrix[i][j] == 'F' && matrix[i1][j1] != 'F') || (matrix[i][j] == 'T' && matrix[i1][j1] != 'T') || (matrix[i][j] == 'H' && matrix[i1][j1] != 'H')) && matrix[i1][j1] != '!') {
                            char temp = matrix[i][j];
                            matrix[i][j] = matrix[i1][j1];
                            matrix[i1][j1] = temp;
                            break;
                        }
                    } else
                        break;
                }
            }
        }
        return matrix;
    }

    public static void check_obstacle_bonus(String move) {
        switch (move) {
            case "W" -> {
                if (current_point[0] != 0) {
                    current_point[0] -= 1;
                    System.out.print("Yukarı gittniz ve ");
                    step_counter++;
                } else System.out.println("En yukarıda olduğunuz için yukarı gidemzsiniz!!!");
            }
            case "A" -> {
                if (current_point[1] != 0) {
                    current_point[1] -= 1;
                    System.out.print("Sola gittniz ve ");
                    step_counter++;
                } else System.out.println("En solda olduğunuz için sola gidemzsiniz!!!");
            }
            case "S" -> {
                if (current_point[0] != labirent.length - 1) {
                    current_point[0] += 1;
                    System.out.print("Aşağı gittniz ve ");
                    step_counter++;
                } else System.out.println("En aşağıda olduğunuz için aşağı gidemzsiniz!!!");
            }
            case "D" -> {
                if (current_point[1] != labirent[1].length - 1) {
                    current_point[1] += 1;
                    System.out.print("Sağa gittniz ve ");
                    step_counter++;
                } else System.out.println("En sağda olduğunuz için sağa gidemzsiniz!!!");
            }
        }

        if (labirent[current_point[0]][current_point[1]] == '#') {
            // check the bonus list
            if (bonus[0] > 0) {
                System.out.println("Duvar ile karşılaştınız ancak bonusunuz olduğu için duvaru kırdınız");
                labirent[current_point[0]][current_point[1]] = '.';
                bonus[0] -= 1;
            } else {
                System.out.println("Duvar ile karşılaştınız R bonusunuz olmadığı için o yöne gidemezsiniz");
                switch (move) {
                    case "W" -> current_point[0] += 1; // Arrow-syntax switch-case yapısı
                    case "A" -> current_point[1] += 1;
                    case "S" -> current_point[0] -= 1;
                    case "D" -> current_point[1] -= 1;
                }
            }
        } else if (labirent[current_point[0]][current_point[1]] == '!') {

            if (bonus[1] > 0) {
                System.out.println("Mayın ile karşılaştınız ancak bonusunuz olduğu için mayını imha ettiniz");
                labirent[current_point[0]][current_point[1]] = '.';
                bonus[1] -= 1;
            } else {
                labirent[current_point[0]][current_point[1]] = '.';
                printArr(new_labirent(labirent));
                System.out.println("Mayın ile karşılaştınız ancak bonusunuz olmadığı için hamle sayınız 5 arttırıldı ve labirent değiştirildi!!");
                step_counter += 5;
            }

        } else if (labirent[current_point[0]][current_point[1]] == 'R') {
            System.out.println("R bonus ile karşılaştınız dizinize eklendi");
            labirent[current_point[0]][current_point[1]] = '.';
            bonus[0]++;
        } else if (labirent[current_point[0]][current_point[1]] == 'F') {
            System.out.println("F bonus ile karşılaştınız dizinize eklendi");
            labirent[current_point[0]][current_point[1]] = '.';
            bonus[1]++;
        } else if (labirent[current_point[0]][current_point[1]] == 'T') {
            System.out.println("T bonus ile karşılaştınız dizinize eklendi");
            labirent[current_point[0]][current_point[1]] = '.';
            bonus[2]++;
        } else if (labirent[current_point[0]][current_point[1]] == 'H') {
            System.out.println("H bonus ile karşılaştınız dizinize eklendi");
            labirent[current_point[0]][current_point[1]] = '.';
            bonus[3]++;
        }
        printArr(current_point);
    }

    public static void actions(String action) {

        switch (action) {
            case "W" -> check_obstacle_bonus("W");
            case "A" -> check_obstacle_bonus("A");
            case "S" -> check_obstacle_bonus("S");
            case "D" -> check_obstacle_bonus("D");
            case "+" -> {
                System.out.println("Kullanmak istediğiniz bonusu seçin: ");
                Scanner input = new Scanner(System.in);
                String bonuslar = input.next();
                switch (bonuslar) {
                    case "R", "F" ->
                            System.out.println("R ve F bonusu sadece engelle karşılaşıldığında kullanılablir!!!");
                    case "H" -> {
                        if (bonus[3] > 0) {
                            if (step_counter >= 2) {
                                System.out.println("H bonusunu kullandınız hamle sayınız iki azaltıldı.");
                                step_counter -= 2;
                            } else if (step_counter == 1) {
                                step_counter -= 1;
                                System.out.println("Hamle sayınız 1 olduğu için bir hamle azaltılabildi!!");
                            } else if (step_counter == 0) {
                                System.out.println("Hamle sayınız 0 olduğundan hamle sayısı azaltılamadı!!");
                            }
                            bonus[3] -= 1;
                        } else System.out.println("H bonusunuz bulunmamaktadır!!!");
                    }
                    case "T" -> {
                        /// teleport bonusunun işelevi kodlanacak
                        if (bonus[2] > 0) {
                            Scanner input_2 = new Scanner(System.in);
                            while (true) {
                                System.out.println("Gitmek istediğiniz X kordinatını girin");
                                int x = input_2.nextInt();
                                if (x > labirent.length - 1 || x < 0) {
                                    System.out.println("Geçersiz X kordinatı girdiniz lütfen 0 ile 14 arasında bir değer giriniz.");
                                    continue;
                                }
                                System.out.println("Gitmek istediğiniz Y kordinatını girin");
                                int y = input_2.nextInt();
                                if (y > labirent.length - 1 || y < 0) {
                                    System.out.println("Geçersiz Y kordinatı girdiniz lütfen 0 ile 14 arasında bir değer giriniz.");
                                    continue;
                                }
                                if (labirent[x][y] == '#' || labirent[x][y] == '!') {
                                    System.out.println("Gitmek istediğiniz kordinatta mayın veya duvar bulunmakta lütfen başka bir konum seçiniz!!!");
                                } else {
                                    current_point[0] = x;
                                    current_point[1] = y;
                                    System.out.println("Yeni kordinatlarınız " + x + " ve " + y);
                                    step_counter++;
                                    break;
                                }
                            }
                            bonus[2] -= 1;
                        } else System.out.println("T bonusunuz bulunmamaktadır!!!");
                    }
                }
            }
            default -> System.out.println("Geçersiz komut girdiniz!!!");
        }
    }

    public static void main(String[] args) {
        current_point = start_point(labirent); // Başlangıç konumunu start_point(labirent) methodu ile alıp "starting_point" e atıyoruz.
        Scanner input = new Scanner(System.in);
        System.out.println("Labirent Oyunu:");
        System.out.println("W, A, S, D karakterlerinden birini giriniz ya da bonus kullanmak için + " + "karakterine basınız. Çıkış için “exit” yazınız. ");

        while (!Arrays.equals(current_point, exit_point(labirent))) {
            System.out.println("Adım sayısı: " + step_counter);
            printArr(current_point);
            String action = input.next();
            if (action.equals("exit")) {
                System.out.println("Oyun Sonlandırıldı");
                break;
            } else {
                actions(action);
            }
            System.out.println("Girdi: " + action);
            System.out.println(" ");
            System.out.println(bonus[0] + " tane R bonusunuz, " + bonus[1] + " tane F bonusunuz, " + bonus[2] + " tane T bonusunuz, " + bonus[3] + " tane H bonusunuz bulunmakta.");
            if (step_counter % 5 == 0 && step_counter != 0) {
                printArr(new_labirent(labirent));
                System.out.println("Labirent değiştirildi");
            }
        }
        if (Arrays.equals(current_point, exit_point(labirent))) {
            System.out.println("----------------------------------------------------------" +
                    "\nTebrikler Çıkış Noktasına Ulaştınız ve Oyunu Kazandınız");
            System.out.println("Toplam hamle sayınız: " + step_counter);
        }
    }
}

