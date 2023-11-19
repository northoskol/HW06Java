import java.util.*;

class Laptop {
    private String brand;
    private int ramSizeGB;
    private int storageSizeGB;
    private String operatingSystem;
    private String color;

    // Конструктор класса
    public Laptop(String brand, int ramSizeGB, int storageSizeGB, String operatingSystem, String color) {
        this.brand = brand;
        this.ramSizeGB = ramSizeGB;
        this.storageSizeGB = storageSizeGB;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }

    // Геттеры для доступа к полям
    public String getBrand() {
        return brand;
    }

    public int getRamSizeGB() {
        return ramSizeGB;
    }

    public int getStorageSizeGB() {
        return storageSizeGB;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getColor() {
        return color;
    }
}

class LaptopStore {
    private Set<Laptop> laptops;

    public LaptopStore() {
        laptops = new HashSet<>();
    }

    // Метод для добавления ноутбука в магазин
    public void addLaptop(Laptop laptop) {
        laptops.add(laptop);
    }

    // Метод для фильтрации и вывода ноутбуков по заданным критериям
    public void filterAndPrint(Map<String, Object> filters) {
        for (Laptop laptop : laptops) {
            boolean passesFilter = true;
            for (Map.Entry<String, Object> entry : filters.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();

                switch (key) {
                    case "brand":
                        if (!laptop.getBrand().equals(value)) {
                            passesFilter = false;
                        }
                        break;
                    case "ramSizeGB":
                        if (laptop.getRamSizeGB() < (int) value) {
                            passesFilter = false;
                        }
                        break;
                    case "storageSizeGB":
                        if (laptop.getStorageSizeGB() < (int) value) {
                            passesFilter = false;
                        }
                        break;
                    case "operatingSystem":
                        if (!laptop.getOperatingSystem().equals(value)) {
                            passesFilter = false;
                        }
                        break;
                    case "color":
                        if (!laptop.getColor().equals(value)) {
                            passesFilter = false;
                        }
                        break;
                    // Добавьте другие критерии фильтрации, если необходимо
                }
            }

            if (passesFilter) {
                System.out.println("Ноутбук подходит к условиям фильтрации: " + laptop.getBrand());
                // Выводите нужные данные о ноутбуке
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        LaptopStore laptopStore = new LaptopStore();

        // Добавление ноутбуков в магазин
        laptopStore.addLaptop(new Laptop("Brand1", 8, 512, "Windows", "Silver"));
        laptopStore.addLaptop(new Laptop("Brand2", 16, 1024, "MacOS", "Space Gray"));
        laptopStore.addLaptop(new Laptop("Brand3", 8, 256, "Linux", "Black"));

        // Пример использования фильтрации
        Map<String, Object> filters = new HashMap<>();
        filters.put("ramSizeGB", 8);
        filters.put("operatingSystem", "Windows");

        laptopStore.filterAndPrint(filters);
    }
}
