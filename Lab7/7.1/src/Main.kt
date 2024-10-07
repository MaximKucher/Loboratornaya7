fun main() {
    println("калькУлятор")

    while (true) {
        println("Введите первое число (или 'exit' для выхода): ")
        val input1 = readLine()
        if (input1 == "exit") break

        println("Введите оператор (+, -, *, /): ")
        val operator = readLine()

        println("Введите второе число: ")
        val input2 = readLine()


        val num1 = input1?.toDoubleOrNull()
        val num2 = input2?.toDoubleOrNull()

        if (num1 == null || num2 == null) {
            println("Некорректный ввод. Пожалуйста, введите числа а не символы.")
            continue
        }

        val result = when (operator) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            "/" -> if (num2 != 0.0) num1 / num2 else "Ошибка: деление на ноль"
            else -> "Некорректный оператор"
        }

        println("Результат: $result")
    }

    println("Выход из программы.")
}
