class RepairService {
    fun repairPhone(): Boolean {
        println("Ваш телефон сломан? (да/нет)")
        val response = readLine()
        return response.equals("да", ignoreCase = true)
    }
}