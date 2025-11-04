/**
 * Тестовая программа, демонстрирующая работу методов класса Cache
 */
public class CacheDemo {
    public static void main(String[] args) {
        System.out.println("=== Демонстрация работы класса Cache<T> ===");
        
        // Тестируем с целыми числами
        testIntegerCache();
        
        // Тестируем со строками
        testStringCache();
        
        // Тестируем граничные случаи
        testEdgeCases();
        
        System.out.println("=== Демонстрация завершена ===");
    }
    
    private static void testIntegerCache() {
        System.out.println("\n--- Тестирование Cache<Integer> ---");
        
        Cache<Integer> intCache = new Cache<>(3);
        System.out.println("Создан кэш для Integer с максимальным размером 3");
        
        // Тестируем добавление элементов
        System.out.println("\n1. Тестируем метод add(T item):");
        intCache.add(10);
        intCache.add(20);
        intCache.add(30);
        System.out.println("Добавлены элементы: 10, 20, 30");
        
        // Добавляем четвертый элемент - первый должен удалиться
        intCache.add(40);
        System.out.println("Добавлен элемент 40 (превышение лимита)");
        
        // Тестируем метод exists
        System.out.println("\n2. Тестируем метод exists(T item):");
        System.out.println("Элемент 20 существует: " + intCache.exists(20));
        System.out.println("Элемент 10 существует: " + intCache.exists(10));
        
        // Тестируем методы getFirst и getLast
        System.out.println("\n3. Тестируем getFirst() и getLast():");
        System.out.println("Первый элемент: " + intCache.getFirst());
        System.out.println("Последний элемент: " + intCache.getLast());
        
        // Тестируем getItemByIndex
        System.out.println("\n4. Тестируем метод getItemByIndex(int i):");
        for (int i = 0; i < 4; i++) {
            Integer item = intCache.getItemByIndex(i);
            System.out.println("Элемент по индексу " + i + ": " + item);
        }
        
        // Тестируем remove
        System.out.println("\n5. Тестируем метод remove(T item):");
        System.out.println("Удаляем элемент 20: " + intCache.remove(20));
        System.out.println("Удаляем несуществующий элемент 100: " + intCache.remove(100));
    }
    
    private static void testStringCache() {
        System.out.println("\n--- Тестирование Cache<String> ---");
        
        Cache<String> stringCache = new Cache<>(2);
        stringCache.add("Hello");
        stringCache.add("World");
        stringCache.add("Java");
        
        System.out.println("Первый элемент: " + stringCache.getFirst());
        System.out.println("Последний элемент: " + stringCache.getLast());
        System.out.println("Существует 'World': " + stringCache.exists("World"));
        System.out.println("Существует 'Hello': " + stringCache.exists("Hello"));
    }
    
    private static void testEdgeCases() {
        System.out.println("\n--- Тестирование граничных случаев ---");
        
        Cache<Integer> emptyCache = new Cache<>(5);
        System.out.println("Пустой кэш - getFirst(): " + emptyCache.getFirst());
        System.out.println("Пустой кэш - getLast(): " + emptyCache.getLast());
        System.out.println("Пустой кэш - getItemByIndex(0): " + emptyCache.getItemByIndex(0));
        
        Cache<Integer> singleCache = new Cache<>(1);
        singleCache.add(100);
        singleCache.add(200);
        System.out.println("Кэш размером 1 после двух добавлений: " + singleCache.getFirst());
    }
}