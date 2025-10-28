public class Main {
    public static void main(String[] args) {
        // Создаем массив машин для тестирования
        Car[] cars = {
            new Car(1, "Toyota", "Camry", 2018, "Black", 25000.0, "AB1234CD"),
            new Car(2, "Toyota", "Corolla", 2020, "White", 20000.0, "EF5678GH"),
            new Car(3, "Honda", "Civic", 2015, "Red", 18000.0, "IJ9012KL"),
            new Car(4, "Toyota", "RAV4", 2019, "Blue", 28000.0, "MN3456OP"),
            new Car(5, "BMW", "X5", 2022, "Black", 55000.0, "QR7890ST"),
            new Car(6, "Honda", "Accord", 2017, "Silver", 22000.0, "UV1234WX")
        };

        // Тестирование метода getCarByBrend
        System.out.println("=== Тестирование метода getCarByBrend ===");
        Car[] toyotaCars = getCarByBrend(cars, "Toyota");
        System.out.println("Машины марки Toyota:");
        printCars(toyotaCars);

        Car[] hondaCars = getCarByBrend(cars, "Honda");
        System.out.println("\nМашины марки Honda:");
        printCars(hondaCars);

        Car[] audiCars = getCarByBrend(cars, "Audi");
        System.out.println("\nМашины марки Audi:");
        printCars(audiCars);

        // Тестирование метода getCarByBrendAndYearOperational
        System.out.println("\n=== Тестирование метода getCarByBrendAndYearOperational ===");
        int currentYear = 2024; // Предположим, что текущий год 2024
        
        Car[] oldToyotaCars = getCarByBrendAndYearOperational(cars, "Toyota", 4, currentYear);
        System.out.println("Машины Toyota старше 4 лет:");
        printCars(oldToyotaCars);

        Car[] oldHondaCars = getCarByBrendAndYearOperational(cars, "Honda", 6, currentYear);
        System.out.println("\nМашины Honda старше 6 лет:");
        printCars(oldHondaCars);
    }

    /**
     * 13. Метод для получения массива машин по марке
     * @param cars массив машин
     * @param brend марка автомобиля
     * @return массив машин указанной марки или пустой массив, если таких нет
     */
    public static Car[] getCarByBrend(Car[] cars, String brend) {
        // Сначала подсчитаем количество машин нужной марки
        int count = 0;
        for (Car car : cars) {
            if (car.getBrand().equalsIgnoreCase(brend)) {
                count++;
            }
        }

        // Если нет машин нужной марки, возвращаем пустой массив
        if (count == 0) {
            return new Car[0];
        }

        // Создаем массив нужного размера и заполняем его
        Car[] result = new Car[count];
        int index = 0;
        for (Car car : cars) {
            if (car.getBrand().equalsIgnoreCase(brend)) {
                result[index++] = car;
            }
        }

        return result;
    }

    /**
     * 16. Метод для получения массива машин по марке и количеству лет эксплуатации
     * @param cars массив машин
     * @param brend марка автомобиля
     * @param years минимальное количество лет эксплуатации
     * @param currentYear текущий год для расчета возраста
     * @return массив машин заданной марки, которые эксплуатируются больше years лет
     */
    public static Car[] getCarByBrendAndYearOperational(Car[] cars, String brend, int years, int currentYear) {
        // Сначала подсчитаем количество подходящих машин
        int count = 0;
        for (Car car : cars) {
            if (car.getBrand().equalsIgnoreCase(brend) && (currentYear - car.getYear()) > years) {
                count++;
            }
        }

        // Если нет подходящих машин, возвращаем пустой массив
        if (count == 0) {
            return new Car[0];
        }

        // Создаем массив нужного размера и заполняем его
        Car[] result = new Car[count];
        int index = 0;
        for (Car car : cars) {
            if (car.getBrand().equalsIgnoreCase(brend) && (currentYear - car.getYear()) > years) {
                result[index++] = car;
            }
        }

        return result;
    }

    /**
     * Вспомогательный метод для вывода массива машин
     * @param cars массив машин для вывода
     */
    public static void printCars(Car[] cars) {
        if (cars.length == 0) {
            System.out.println("Машин не найдено");
            return;
        }

        for (Car car : cars) {
            System.out.printf("ID: %d, Марка: %s, Модель: %s, Год: %d, Цвет: %s, Цена: $%.2f, Рег. номер: %s%n",
                    car.getId(), car.getBrand(), car.getModel(), car.getYear(),
                    car.getColor(), car.getPrice(), car.getRegistrationNumber());
        }
    }
}
