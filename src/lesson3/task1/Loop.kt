@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1

import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    if (n == 2) return true
    if (n % 2 == 0) return false
    for (m in 3..sqrt(n.toDouble()).toInt() step 2) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
        when {
            n == m -> 1
            n < 10 -> 0
            else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
        }

/**
 * Тривиальная
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun digitNumber(n: Int): Int {
    var count = 0
    var number = n
    do {
        count++
        number /= 10
    } while (number > 0)
    return count
}

/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    var c = -1
    var b = 1
    var s = 0
    for (m in 0..n) {
        s = c + b
        c = b
        b = s
    }
    return s
}

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    var a = 1
    while ((a % m != 0) || (a % n != 0)) {
        a++
    }
    return a
}


/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    var divider = 2
    while (n % divider != 0) {
        divider++
    }
    return divider
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    var divider = n - 1
    while (n % divider != 0 && divider != 1) {
        divider--
    }
    return divider
}

/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    var commonDivider = m
    while (commonDivider != 1) {
        if (m % commonDivider == 0 && n % commonDivider == 0) {
            return false
        }
        commonDivider--
    }
    return true
}

/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    var a = 0.0
    while (a <= n) {
        if (a in sqrt(m.toDouble())..sqrt(n.toDouble())) {
            return true
        }
        a++
    }
    return false
}

/**
 * Средняя
 *
 * Гипотеза Коллатца. Рекуррентная последовательность чисел задана следующим образом:
 *
 *   ЕСЛИ (X четное)
 *     Xслед = X /2
 *   ИНАЧЕ
 *     Xслед = 3 * X + 1
 *
 * например
 *   15 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1 4 2 1 4 2 1 ...
 * Данная последовательность рано или поздно встречает X == 1.
 * Написать функцию, которая находит, сколько шагов требуется для
 * этого для какого-либо начального X > 0.
 */
fun collatzSteps(x: Int): Int {
    var number = x
    var count = 0
    while (number != 1) {
        if (number % 2 == 0) {
            number /= 2
            count++
        } else if (number % 2 != 0) {
            number = 3 * number + 1
            count++
        }
    }
    return count
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun sin(x: Double, eps: Double): Double {
    var n = 1
    var sum = 0.0
    var a = 1.0
    val division = (x % PI)
    val divisionWithPresicion = (division * 10000).toInt()

    if (division == 0.0 || divisionWithPresicion == 0) {
        return sum

    } else {
        while (abs(a) > eps) {
            a = ((-1.0).pow(n - 1)) * ((x.pow(2 * n - 1)) / factorial(2 * n - 1))
            sum += a
            n++
        }
    }
    return sum
}


/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun cos(x: Double, eps: Double): Double {
    var n = 1
    var sum = 1.0
    val halfPi = 0.0
    var a = 1.0
    val division = (x / (PI))
    val divisionWith = division % 2

    if (divisionWith != 0.0 && x != 0.0 && x != PI) {
        return halfPi
        println("I AM HERE")

    } else if (x == 0.0 || divisionWith == 0.0) {
        return 1.0
    } else {
        while (abs(a) > eps) {
            a = ((-1.0).pow(n)) * ((x.pow(2 * n)) / factorial(2 * n))

            sum += a
            n++

        }
    }
    return sum
}

/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun revert(n: Int): Int {
    var number = n
    var number2 = n
    var count = 0
    var sum = 0
    var division: Int
    var stepen: Double
    while (number > 0) {
        number /= 10
        count++
    }
    while (number2 > 0) {
        division = number2 % 10
        stepen = (10.0).pow(count - 1)
        division *= stepen.toInt()
        sum += division
        count--
        number2 /= 10
    }
    return sum

}


/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun isPalindrome(n: Int): Boolean {
    //val a = n.equals(revert(n))
    //return a
    var number = n
    var copyNumber = n
    var count = 0
    var palindrome: Boolean
    while (number > 0) {
        number /= 10
        count++
    }

    var firstPart: Int
    var secondPart: Int
    var halfCount = count / 2

    if (count % 2 == 0) {
        var a = copyNumber / 10.0.pow(count / 2)
        var b = copyNumber % 10.0.pow(count / 2)
        firstPart = a.toInt()
        secondPart = b.toInt()
        var stepen = 1
        while (halfCount > 0) {
            var s = firstPart / 10.0.pow((count / 2) - 1)
            var b = secondPart % 10.0.pow(stepen)
            count--
            stepen++
            palindrome = s.equals(b)
            return palindrome
        }

    }
    return true
}

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun hasDifferentDigits(n: Int): Boolean {
    var withDifDigits: Boolean = true
    var number = n
    var copyNumber = n
    var count = 0
    var b: Int
    var secondCount = 1
    while (number > 0) {
        number /= 10
        count++
    }

    if (count == 1 || n == 0) {
        println("COUNT is only one")
        withDifDigits = false
    } else {
        println("Now count is equal $count")
        var firstDigit = copyNumber / (10.0.pow(count - 1)).toInt()
        println("Now firstDigit is equal $firstDigit")
        var anotherPart = (copyNumber % 10.0.pow(count - 1)).toInt()
        while (secondCount <= count - 1) {
            println("Before WHILE starts anotherPart is equal $anotherPart")

            b = anotherPart % 10
            println("INSIDE WHILE b is equal $b")

            anotherPart /= 10
            println("INSIDE WHILE anotherPart is equal $anotherPart")
            secondCount++

            if ((firstDigit.equals(b))) {
                println("$firstDigit is equal $b")
                withDifDigits = false
                continue
            } else {
                println("$firstDigit is NOT equal $b")
                withDifDigits = true
                break
            }
        }
    }

    println("Main withDifDigits is equal $withDifDigits ")
    return withDifDigits
}


/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun squareSequenceDigit(n: Int): Int = TODO()

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun fibSequenceDigit(n: Int): Int = TODO()
