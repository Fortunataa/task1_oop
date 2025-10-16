package org.example;
import java.util.Scanner;

public class ConsoleApp {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("====== ДВУСВЯЗНЫЙ ЦИКЛИЧЕСКИЙ СПИСОК ======");
        System.out.println("Выберите тип данных для списка:");
        System.out.println("1. Integer");
        System.out.println("2. String");
        System.out.println("3. Double");
        System.out.println("4. Boolean");
        System.out.print("Ваш выбор: ");

        int typeChoice = scanner.nextInt();
        scanner.nextLine();

        switch (typeChoice) {
            case 1:
                operations(Integer.class, "целых чисел");
                break;
            case 2:
                operations(String.class, "строк");
                break;
            case 3:
                operations(Double.class, "дробных чисел");
                break;
            case 4:
                operations(Boolean.class, "логических значений");
                break;
            default:
                System.out.println("Неверный выбор, используем целые числа");
                operations(Integer.class, "целых чисел");
        }
    }

    private static <T> void operations(Class<T> type, String typeName) {
        LinkedCyclicList<T> list = new DoublyLinkedCyclicList<>();
        System.out.println("\n=== Работа со списком " + typeName + " ===");

        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addElement(list, type);
                    break;
                case 2:
                    addElementByIndex(list, type);
                    break;
                case 3:
                    addFirstElement(list, type);
                    break;
                case 4:
                    deleteFirstElement(list);
                    break;
                case 5:
                    deleteLast(list);
                    break;
                case 6:
                    deleteElement(list, type);
                    break;
                case 7:
                    deleteByIndex(list);
                    break;
                case 8:
                    getByIndex(list);
                    break;
                case 9:
                    findIndex(list, type);
                    break;
                case 10:
                    checkContains(list, type);
                    break;
                case 11:
                    clearList(list);
                    break;
                case 12:
                    showInformationList(list);
                    break;
                case 13:
                    getFirst(list);
                    break;
                case 14:
                    getLast(list);
                    break;
                case 0:
                    System.out.println("Возврат к выбору типа");
                    return;
                default:
                    System.out.println("Неверный выбор!");
            }
        }
    }

    private static <T> void addElement(LinkedCyclicList<T> list, Class<T> type) {
        try {
            System.out.print("Введите значение: ");
            String input = scanner.nextLine();
            T value = parseValue(input, type);
            list.add(value);
            System.out.println("Добавлено: " + value);
        } catch (Exception e) {
            System.out.println("Ошибка: неверный формат данных для типа " + type.getSimpleName());
        }
    }

    private static <T> void addElementByIndex(LinkedCyclicList<T> list, Class<T> type) {
        try {
            System.out.print("Введите индекс: ");
            int index = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Введите значение: ");
            String input = scanner.nextLine();
            T value = parseValue(input, type);
            list.addByIndex(value, index);
            System.out.println("Добавлено: " + value + " на позицию " + index);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static <T> void addFirstElement(LinkedCyclicList<T> list, Class<T> type) {
        try {
            System.out.print("Введите значение: ");
            String input = scanner.nextLine();
            T value = parseValue(input, type);
            list.addFirst(value);
            System.out.println("Добавлено в начало: " + value);
        } catch (Exception e) {
            System.out.println("Ошибка: неверный формат данных");
        }
    }

    private static <T> T parseValue(String input, Class<T> type) {
        if (type == Integer.class) {
            return type.cast(Integer.parseInt(input));
        } else if (type == String.class) {
            return type.cast(input);
        } else if (type == Double.class) {
            return type.cast(Double.parseDouble(input));
        } else if (type == Boolean.class) {
            return type.cast(Boolean.parseBoolean(input));
        }
        throw new IllegalArgumentException("Неподдерживаемый тип: " + type.getSimpleName());
    }

    private static <T> void deleteFirstElement(LinkedCyclicList<T> list) {
        try {
            list.deleteFirst();
            System.out.println("Первый элемент удален");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static <T> void deleteLast(LinkedCyclicList<T> list) {
        try {
            list.deleteLast();
            System.out.println("Последний элемент удален");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static <T> void deleteElement(LinkedCyclicList<T> list, Class<T> type) {
        try {
            System.out.print("Введите значение для удаления: ");
            String input = scanner.nextLine();
            T value = parseValue(input, type);
            list.deleteNode(value);
            System.out.println("Удалено: " + value);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static <T> void deleteByIndex(LinkedCyclicList<T> list) {
        try {
            System.out.print("Введите индекс: ");
            int index = scanner.nextInt();
            scanner.nextLine();
            list.deleteByIndex(index);
            System.out.println("Элемент с индексом " + index + " удален");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static <T> void getByIndex(LinkedCyclicList<T> list) {
        try {
            System.out.print("Введите индекс: ");
            int index = scanner.nextInt();
            scanner.nextLine();
            T value = list.get(index);
            System.out.println("Элемент с индексом " + index + ": " + value);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static <T> void findIndex(LinkedCyclicList<T> list, Class<T> type) {
        try {
            System.out.print("Введите значение для поиска: ");
            String input = scanner.nextLine();
            T value = parseValue(input, type);
            int index = list.indexOf(value);
            if (index != -1) {
                System.out.println("Элемент " + value + " найден по индексу: " + index);
            } else {
                System.out.println("Элемент " + value + " не найден");
            }
        } catch (Exception e) {
            System.out.println("Ошибка: неверный формат данных");
        }
    }

    private static <T> void checkContains(LinkedCyclicList<T> list, Class<T> type) {
        try {
            System.out.print("Введите значение для проверки: ");
            String input = scanner.nextLine();
            T value = parseValue(input, type);
            boolean contains = list.contains(value);
            System.out.println("Список " + (contains ? "содержит" : "не содержит") + " элемент: " + value);
        } catch (Exception e) {
            System.out.println("Ошибка: неверный формат данных");
        }
    }

    private static <T> void clearList(LinkedCyclicList<T> list) {
        list.clear();
        System.out.println("Список очищен!");
    }

    private static <T> void showInformationList(LinkedCyclicList<T> list) {
        System.out.println("Текущий список: " + list);
        System.out.println("Размер списка: " + list.size());
    }

    private static <T> void getFirst(LinkedCyclicList<T> list) {
        try {
            System.out.println("Первый элемент:" + list.getFirst());
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static <T> void getLast(LinkedCyclicList<T> list) {
        try {
            System.out.println("Последний элемент:" + list.getLast());
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void showMenu() {
        System.out.println("\n====== МЕНЮ =======");
        System.out.println("1. Добавить элемент");
        System.out.println("2. Добавить элемент по индексу");
        System.out.println("3. Добавить элемент первым");
        System.out.println("4. Удалить первый элемент");
        System.out.println("5. Удалить последний элемент");
        System.out.println("6. Удалить элемент по значению");
        System.out.println("7. Удалить элемент по индексу");
        System.out.println("8. Получить элемент по индексу");
        System.out.println("9. Найти индекс элемента");
        System.out.println("10. Проверить наличие элемента");
        System.out.println("11. Очистить список");
        System.out.println("12. Показать информацию о списке");
        System.out.println("13. Получить первый элемент списка");
        System.out.println("14. Получить последний элемент списка");
        System.out.println("0. Выбрать другой тип данных");
        System.out.print("Выберите действие: ");
    }
}