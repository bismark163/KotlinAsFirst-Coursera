@file:Suppress("UNUSED_PARAMETER")

package lesson2.task2

import lesson1.task1.lengthInMeters
import lesson1.task1.sqr
import kotlin.math.abs
import kotlin.math.sqrt

/**
 * Пример
 *
 * Лежит ли точка (x, y) внутри окружности с центром в (x0, y0) и радиусом r?
 */
fun pointInsideCircle(x: Double, y: Double, x0: Double, y0: Double, r: Double) =
        sqr(x - x0) + sqr(y - y0) <= sqr(r)

/**
 * Простая
 *
 * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
 * Определить, счастливое ли заданное число, вернуть true, если это так.
 */
fun isNumberHappy(number: Int): Boolean {
    val firstPart = number / 100
    val secondPart = number % 100

    val fpa1 = firstPart / 10
    val fpa2 = firstPart % 10
    val spa1 = secondPart / 10
    val spa2 = secondPart % 10

    val firstPartSum = fpa1 + fpa2
    val secondPartSum = spa1 + spa2

    if (firstPartSum == secondPartSum) return true
    else return false
}

/**
 * Простая
 *
 * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
 * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
 * Считать, что ферзи не могут загораживать друг друга.
 */
fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
    val ferz1 = x1 - x2
    val ferz2 = y1 - y2

    if (x1 == x2) return true
    else if (y1 == y2) return true
    else if (abs(ferz1) == abs(ferz2)) return true
    return false
}


/**
 * Простая
 *
 * Дан номер месяца (от 1 до 12 включительно) и год (положительный).
 * Вернуть число дней в этом месяце этого года по григорианскому календарю.
 */
fun daysInMonth(month: Int, year: Int): Int {

    val o = year % 4
    val a = year % 100
    val c = year % 400
    if (a == 0 && c == 0) {
        when (month) {
            1 -> return 31
            2 -> return 29
            3 -> return 31
            4 -> return 30
            5 -> return 31
            6 -> return 30
            7 -> return 31
            8 -> return 31
            9 -> return 30
            10 -> return 31
            11 -> return 30
            12 -> return 31
        }


    } else if (o == 0 && a != 0 && c != 0) {
        when (month) {
            1 -> return 31
            2 -> return 29
            3 -> return 31
            4 -> return 30
            5 -> return 31
            6 -> return 30
            7 -> return 31
            8 -> return 31
            9 -> return 30
            10 -> return 31
            11 -> return 30
            12 -> return 31
        }
    } else {
        when (month) {
            1 -> return 31
            2 -> return 28
            3 -> return 31
            4 -> return 30
            5 -> return 31
            6 -> return 30
            7 -> return 31
            8 -> return 31
            9 -> return 30
            10 -> return 31
            11 -> return 30
            12 -> return 31
        }
    }
    return 0
}

/**
 * Средняя
 *
 * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
 * окружности с центром в (x2, y2) и радиусом r2.
 * Вернуть true, если утверждение верно
 */
fun circleInside(x1: Double, y1: Double, r1: Double,
                 x2: Double, y2: Double, r2: Double): Boolean {
    val lengthBetweenCenter = sqrt(sqr(x2 - x1) + sqr(y2 - y1))
    val radiusSum = abs(r1 + r2)
    val radiusMin = abs(r1 - r2)
    if (radiusSum < lengthBetweenCenter) {
        return false
    } else if (lengthBetweenCenter == radiusSum) {
        return false
    } else if (lengthBetweenCenter < radiusSum && lengthBetweenCenter > radiusMin) {
        return false
    } else if (lengthBetweenCenter == 0.0 && (r1 > r2)) {
        return false
    } else {
        return true
    }

}

/**
 * Средняя
 *
 * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
 * Стороны отверстия должны быть параллельны граням кирпича.
 * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
 * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
 * Вернуть true, если кирпич пройдёт
 */
fun brickPasses(a: Int, b: Int, c: Int, r: Int, s: Int): Boolean {
    if ((a <= r && b <= s) || (a <= s && b <= r)) {
        return true
    }
    if ((b <= r && c <= s) || (b <= s && c <= r)) {
        return true
    }
    if ((a <= r && c <= s) || (a <= s && c <= r)) {
        return true
    } else {
        return false
    }

    return true
}
