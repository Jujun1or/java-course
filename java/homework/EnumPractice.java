package homework;

/*
Практика по теме: Перечисления (enum)
*/

public class EnumPractice {

    public static void main(String[] args) {

        showSeasons();

        showCoffeeStrengths();
    }

    /*
     Практика #1
     Перечисление Season имеет конструктор с параметрами.
     Каждый элемент хранит своё описание и номер по порядку.
    */
    public static void showSeasons() {
        for (Season s : Season.values()) {
            System.out.println(s + " — " + s.getDescription() + ", порядок: " + s.getOrder());
        }
    }

    /*
     Перечисление с инициализацией элементов.
     Каждый элемент создаётся с собственными аргументами.
    */
    enum Season {
        WINTER("Холодное время года", 1),
        SPRING("Цветение и тепло", 2),
        SUMMER("Жара и солнце", 3),
        AUTUMN("Листопад и дожди", 4);

        private final String description;
        private final int order;

        Season(String description, int order) {
            this.description = description;
            this.order = order;
        }

        public String getDescription() {
            return description;
        }

        public int getOrder() {
            return order;
        }
    }

    /*
     Практика #2
     Перечисление с дополнительным методом, который возвращает значение, основанное на данных элемента.
     */
    public static void showCoffeeStrengths() {
        for (CoffeeStrength level : CoffeeStrength.values()) {
            System.out.println(level + " -> крепость: " + level.getCaffeineLevel() + " мг, описание: " + level.describe());
        }
    }

    /*
     Собственное перечисление с дополнительными полями и методом.
     */
    enum CoffeeStrength {
        LIGHT(80),
        MEDIUM(120),
        STRONG(180);

        private final int caffeineLevel;

        CoffeeStrength(int caffeineLevel) {
            this.caffeineLevel = caffeineLevel;
        }

        public int getCaffeineLevel() {
            return caffeineLevel;
        }

        // Дополнительный метод
        public String describe() {
            if (caffeineLevel < 100) return "Мягкий вкус, подходит для вечера.";
            else if (caffeineLevel < 150) return "Баланс вкуса и бодрости.";
            else return "Очень крепкий, лучше утром.";
        }
    }
}
