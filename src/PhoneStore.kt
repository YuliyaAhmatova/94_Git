class PhoneStore(
    val name: String, val city: String, val phones: List<Phone>,
) : Store {
    var soldPhonesCount: MutableMap<String, Int> = mutableMapOf()
    override fun sellPhone(model: String): Boolean {
        val phone = phones.find { it.model == model }
        return if (phone != null) {
            soldPhonesCount[model] = soldPhonesCount.getOrDefault(model, 0) + 1
            println("Вы купили телефон: ${phone.getInfo()}")
            true
        } else {
            println("Телефон не найден.")
            false
        }
    }

    override fun showStatistics() {
        println("Статистика продаж в магазине $name, город $city:")
        soldPhonesCount.forEach { model, count ->
            println("Модель: $model, Продано: $count")
        }
    }
}