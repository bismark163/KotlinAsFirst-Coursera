@file:Suppress("UNUSED_PARAMETER")
package lesson2.task1

import lesson1.task1.discriminant
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.sqrt

/**
 * Пример
 *
 * Найти число корней квадратного уравнения ax^2 + bx + c = 0
 */
fun quadraticRootNumber(a: Double, b: Double, c: Double): Int {
    val discriminant = discriminant(a, b, c)
    return when {
        discriminant > 0.0 -> 2
        discriminant == 0.0 -> 1
        else -> 0
    }
}

/**
 * Пример
 *
 * Получить строковую нотацию для оценки по пятибалльной системе
 */
fun gradeNotation(grade: Int): String = when (grade) {
    5 -> "отлично"
    4 -> "хорошо"
    3 -> "удовлетворительно"
    2 -> "неудовлетворительно"
    else -> "несуществующая оценка $grade"
}

/**
 * Пример
 *
 * Найти наименьший корень биквадратного уравнения ax^4 + bx^2 + c = 0
 */
fun minBiRoot(a: Double, b: Double, c: Double): Double {
    // 1: в главной ветке if выполняется НЕСКОЛЬКО операторов
    if (a == 0.0) {
        if (b == 0.0) return Double.NaN // ... и ничего больше не делать
        val bc = -c / b
        if (bc < 0.0) return Double.NaN // ... и ничего больше не делать
        return -sqrt(bc)
        // Дальше функция при a == 0.0 не идёт
    }
    val d = discriminant(a, b, c)   // 2
    if (d < 0.0) return Double.NaN  // 3
    // 4
    val y1 = (-b + sqrt(d)) / (2 * a)
    val y2 = (-b - sqrt(d)) / (2 * a)
    val y3 = max(y1, y2)       // 5
    if (y3 < 0.0) return Double.NaN // 6
    return -sqrt(y3)           // 7
}

/**
 * Простая
 *
 * Мой возраст. Для заданного 0 < n < 200, рассматриваемого как возраст человека,
 * вернуть строку вида: «21 год», «32 года», «12 лет».
 */
fun ageDescription(age: Int): String {
    val f = age % 100
    if ((f == 1) && (age != 11 && age != 111)) {
        return "$age год"
    } else if ((f in 2..4) && (age !in 11..20 && age !in 111..120)) {
        return "$age года"
    } else {
        return "$age лет"
    }
}

/**
 * Простая
 *
 * Путник двигался t1 часов со скоростью v1 км/час, затем t2 часов — со скоростью v2 км/час
 * и t3 часов — со скоростью v3 км/час.
 * Определить, за какое время он одолел первую половину пути?
 */
fun timeForHalfWay(t1: Double, v1: Double,
                   t2: Double, v2: Double,
                   t3: Double, v3: Double): Double {


    val s1 = t1 * v1
    val s2 = t2 * v2
    val s3 = t3 * v3
    val fullway = s1 + s2 + s3
    val halfway = fullway / 2

    if (s1 >= halfway) {
        val ourtime = (halfway / v1)
        return ourtime

    } else if (s1 < halfway && s1 + s2 >= halfway) {
        val wayWithV2 = halfway - s1
        val timeWithV2 = wayWithV2 / v2
        val ourtime = t1 + timeWithV2
        return ourtime

    } else if (s1 + s2 < halfway) {
        val wayWithV3 = halfway - (s1 + s2)
        val timeWithV3 = wayWithV3 / v3
        val ourtime = t1 + t2 + timeWithV3
        return ourtime

    }

    return 0.0
}




/**
 * Простая
 *
 * Нa шахматной доске стоят черный король и две белые ладьи (ладья бьет по горизонтали и вертикали).
 * Определить, не находится ли король под боем, а если есть угроза, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от первой ладьи, 2, если только от второй ладьи,
 * и 3, если угроза от обеих ладей.
 * Считать, что ладьи не могут загораживать друг друга
 */
fun whichRookThreatens(kingX: Int, kingY: Int,
                       rookX1: Int, rookY1: Int,
                       rookX2: Int, rookY2: Int): Int {
    val dangerFromRook1 = (rookX1 == kingX || rookY1 == kingY)
    val dangerFromRook2 = (rookX2 == kingX || rookY2 == kingY)
    val doubleDanger = dangerFromRook1 && dangerFromRook2

    if (dangerFromRook1 && dangerFromRook2 == false) return 1 else 0
    if (dangerFromRook1 == false && dangerFromRook2) return 2
    if (doubleDanger) return 3 else 0

    return 0
}

/**
 * Простая
 *
 * На шахматной доске стоят черный король и белые ладья и слон
 * (ладья бьет по горизонтали и вертикали, слон — по диагоналям).
 * Проверить, есть ли угроза королю и если есть, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от ладьи, 2, если только от слона,
 * и 3, если угроза есть и от ладьи и от слона.
 * Считать, что ладья и слон не могут загораживать друг друга.
 */
fun rookOrBishopThreatens(kingX: Int, kingY: Int,
                          rookX: Int, rookY: Int,
                          bishopX: Int, bishopY: Int): Int {
    val dangerFromRook = (rookX == kingX || rookY == kingY)
    val kingBishopX = bishopX - kingX
    val kingBishopY = bishopY - kingY
    val dangerFromBishop = (abs(kingBishopX) == abs(kingBishopY))

    if (dangerFromRook && dangerFromBishop == false) return 1
    if (dangerFromBishop && dangerFromRook == false) return 2
    if (dangerFromBishop && dangerFromRook) return 3
    return 0
}

/**
 * Простая
 *
 * Треугольник задан длинами своих сторон a, b, c.
 * Проверить, является ли данный треугольник остроугольным (вернуть 0),
 * прямоугольным (вернуть 1) или тупоугольным (вернуть 2).
 * Если такой треугольник не существует, вернуть -1.
 */
fun triangleKind(a: Double, b: Double, c: Double): Int {
    if (a > b && a > c && a <= b + c) {
        if (a == sqrt((b * b + c * c))) return 1
        if (a > sqrt((b * b + c * c))) return 2
        if (a < sqrt((b * b + c * c))) return 0
    }

    if (b > a && b > c && b <= a + c) {
        if (b == sqrt((a * a + c * c))) return 1
        if (b > sqrt((a * a + c * c))) return 2
        if (b < sqrt((a * a + c * c))) return 0
    }

    if (c > a && c > b && c <= a + c) {
        if (c == sqrt((b * b + a * a))) return 1
        if (c > sqrt((b * b + a * a))) return 2
        if (c < sqrt((b * b + a * a))) return 0
    }

    if ((a == b && c <= a) || (b == c && a <= c) || (a == c && b <= a)) return 0
    if ((a == b && c > a) || (b == c && a > c) || (a == c && b > a)) {
        if (c < sqrt((b * b + a * a))) return 0
        if (c < sqrt((b * b + a * a))) return 0
        if (c < sqrt((b * b + a * a))) return 0

        if (a == sqrt((b * b + c * c))) return 1
        if (a > sqrt((b * b + c * c))) return 2
        if (a < sqrt((b * b + c * c))) return 0

        if (b == sqrt((a * a + c * c))) return 1
        if (b > sqrt((a * a + c * c))) return 2
        if (b < sqrt((a * a + c * c))) return 0
    }

    return -1
}



/**
 * Средняя
 *
 * Даны четыре точки на одной прямой: A, B, C и D.
 * Координаты точек a, b, c, d соответственно, b >= a, d >= c.
 * Найти длину пересечения отрезков AB и CD.
 * Если пересечения нет, вернуть -1.
 */
fun segmentLength(a: Int, b: Int, c: Int, d: Int): Int {
    val length1 = b - a
    val length2 = d - c
    if (a in c..d && b in c..d) return length1
    if (c in a..b && d in a..b) return length2

    if (b in c..d && a !in c..d) {
        return b - c
    }

    if (d in a..b && c !in a..b) {
        return d - a
    }
    return -1
}