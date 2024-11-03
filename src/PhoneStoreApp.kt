import java.util.Scanner

class PhoneStoreApp() {
    private val scanner = Scanner(System.`in`)
    private val store1 = PhoneStore("Магазин 1", "Город А",
        listOf(Smartphone("Модель А", 500.0),
            Smartphone("Модель В", 600.0)))
    private val store2 = PhoneStore("Магазин 2", "Город B",
        listOf(Smartphone("Модель А", 550.0),
            Smartphone("Модель В", 650.0)))
    private val repairService = RepairService()

    fun start(){
        while (true){
            println("Добро пожаловать в интернет-магазин телефонов!")
            println("Выберите город: 1 - Город А, 2 - Город В, 0 - Выход")
            when (scanner.nextInt()){
                1 -> shop(store1)
                2 -> shop(store2)
                0 -> {
                    println("Спасибо за использование приложения!")
                    return
                }
                else-> println("Некорректный ввод. Попробуйте снова.")
            }
        }
    }

    private fun shop(store: PhoneStore){
        var repairOffered = false
        while (true){
            println("Вы в магазине ${store.name} в городе ${store.city}")
            println("Доступные модели телефонов:")
            store.phones.forEach { println(it.getInfo()) }
            println("Введите модель телефона для покупки или 'статистика' для просмотра статистики,'выход' для выхода из магазина:")
            val input = readln()
            when{
                input.equals("статистика", ignoreCase = true) -> store.showStatistics()
                input.equals("выход", ignoreCase = true) -> return
                else -> {
                    if (store.sellPhone(input) && !repairOffered) {
                        if (repairService.repairPhone()) {
                            println("Ваш телефон был успешно отремонтирован!")
                        } else {
                            println("Вы не нуждаетесть в ремонте")
                        }
                        repairOffered = true
                    }
                }
            }
        }
    }
}