class Smartphone(model: String, price: Double) : Phone(model, price) {
    override fun getInfo(): String {
        return "Модель: $model, цена $price"
    }
}