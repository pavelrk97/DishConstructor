package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> menu;
    Random random = new Random();
    ArrayList<String> typeList = new ArrayList<>();

    DinnerConstructor() {
        menu = new HashMap<>();
    }

    public void addToMenu(String type, String dish) {
        boolean hasType = menu.containsKey(type);
        if (hasType) {
            boolean hasDish = menu.get(type).contains(dish);
            if (hasDish) {
                System.out.println("Блюдо типа " + type + " уже в списке");
                return;
            } else {
                menu.get(type).add(dish);
                System.out.println("Блюдо типа " + type + " добавлено");
                return;
            }
        } else {
            ArrayList<String> dishes = new ArrayList<>();
            dishes.add(dish);
            menu.put(type, dishes);
            System.out.println("Создан тип " + type + " внесено блюдо " + dish);
            return;
        }
    }

    public void generateRandom(int number) {
        if (hasInMenu(typeList)) {
            for (int i = 0; i < number; i++) {
                ArrayList<String> combination = new ArrayList<>();
                for (String item : typeList) {
                    int dishNum = random.nextInt(menu.get(item).size());
                    String dish = menu.get(item).get(dishNum);
                    combination.add(dish);
                }
                System.out.println("Комбинация " + (i + 1) + ": " + combination);

            }

            typeList.clear();
        }
    }

    public void collectingTypes(String types) {
        typeList.add(types);
    }

    public boolean hasInMenu(ArrayList<String> typeList) {
        boolean inMenu = true;
        for (String item : typeList) {
            if (!menu.containsKey(item)) {
                System.out.println("Нет типа " + item + " в списке типов в меню, добавьте его пжл");
                inMenu = false;
            }
        }
        return inMenu;
    }
}
