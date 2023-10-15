package org.example.View;

import java.util.Scanner;

public class UI {
    public UI() {
        try(Scanner in = new Scanner(System.in)) {
            while(true){
                System.out.print("\033[H\033[J");
                System.out.print("\nВозможные действия\n1 - Обновить данные\n2 - Ввод данных ТО\n");
                System.out.print("3 - Формировать реестр\n4 - Формировать график\n0 - Выход\nВаш выбор: ");
                String key = in.next();

                switch (key) {
                    case "1":
                        //presenter.prev();
                        System.out.println("key = " + key);
                        break;
                    case "2":
                        //presenter.next();
                        System.out.println("key = " + key);
                        break;
                    case "3":
                        //presenter.prev();
                        System.out.println("key = " + key);
                        break;
                    case "0":
                        System.out.println("key = " + key);
                        return;
                    default:
                        System.out.println("Такой команды нет");
                        break;
                }
//                key = in.next();
            }
        }

    }


}
