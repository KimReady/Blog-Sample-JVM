open class Fruit
class Apple : Fruit()
class Banana : Fruit()

// case 1
//fun receiveFruits(fruits: Array<Fruit>) {
//    println("Number of fruits: ${fruits.size}")
//}
//
//fun main() {
//    val fruits: Array<Apple> = arrayOf(Apple(), Apple())
//    receiveFruits(fruits)   // Compile Error !
//}


//// case 2
//fun receiveFruits(fruits: List<Fruit>) {
//    println("Number of fruits: ${fruits.size}")
//}
//
//fun main() {
//    val fruits: List<Apple> = listOf(Apple(), Apple())
//    receiveFruits(fruits)   // Number of fruits: 2
//}

//// case 3
//fun copyFromTo(from: Array<Fruit>, to: Array<Fruit>) {
//    for (i in from.indices) {
//        to[i] = from[i]
//    }
//}
//
//fun main() {
//    val fruitsBasket1 = Array<Fruit>(3) { _ -> Fruit() }
//    val fruitsBasket2 = Array<Fruit>(3) { _ -> Fruit() }
//    copyFromTo(fruitsBasket1, fruitsBasket2)
//}

//// case 4
//fun copyFromTo(from: Array<Fruit>, to: Array<Fruit>) {
//    for (i in from.indices) {
//        to[i] = from[i]
//    }
//}
//
//fun main() {
//    val fruitsBasket1 = Array<Fruit>(3) { _ -> Fruit() }
//    val fruitsBasket2 = Array<Apple>(3) { _ -> Apple() }
//    copyFromTo(fruitsBasket1, fruitsBasket2) // type mismatch
//}

//// case 5
//fun copyFromTo(from: Array<out Fruit>, to: Array<Fruit>) {
//    for (i in from.indices) {
//        to[i] = from[i]
////        from[i] = Fruit() // compile error !
//    }
//}
//
//fun main() {
//    val fruitsBasket1 = Array<Apple>(3) { _ -> Apple() }
//    val fruitsBasket2 = Array<Fruit>(3) { _ -> Fruit() }
//    copyFromTo(fruitsBasket1, fruitsBasket2) // type mismatch
//}

//// case 6
//fun copyFromTo(from: Array<out Fruit>, to: Array<Fruit>) {
//    for (i in from.indices) {
//        to[i] = from[i]
//    }
//}
//
//fun main() {
//    val fruitsBasket1 = Array<Apple>(3) { _ -> Apple() }
//    val fruitsBasket2 = Array<Any>(3) { _ -> Any() }
//    copyFromTo(fruitsBasket1, fruitsBasket2) // type mismatch
//}

//// case 7
//fun copyFromTo(from: Array<out Fruit>, to: Array<in Fruit>) {
//    for (i in from.indices) {
//        to[i] = from[i]
//    }
//}
//
//fun main() {
//    val fruitsBasket1 = Array<Apple>(3) { _ -> Apple() }
//    val fruitsBasket2 = Array<Any>(3) { _ -> Any() }
//    copyFromTo(fruitsBasket1, fruitsBasket2)
//}

//// case 8
//fun <T> useAndClose(input: T) {
//    input.close()  // ERROR: unresolved reference: close
//}

//// case 9
//fun <T> useAndClose(input: T) where T: AutoCloseable, T: Appendable {
//    input.append("there")
//    input.close()
//}

//// case 10
//fun printValues(values: Array<*>) {
//    for (value in values) {
//        println(value)
//    }
//    values[0] = values[1] // ERROR
//}

// case 11
fun <T> findFirst(fruits: List<Fruit>, ofClass: Class<T>): T {
    val selected = fruits.filter { fruit -> ofClass.isInstance(fruit) }
    if (selected.isEmpty()) {
        throw RuntimeException("Not found")
    }
    return ofClass.cast(selected[0])
}