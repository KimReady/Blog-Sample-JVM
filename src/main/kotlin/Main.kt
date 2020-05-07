
open class KotlinA {
    val a = 5
}

class KotlinB : KotlinA() {
    val b = 10
}

fun main() {
    val obj: KotlinA = KotlinB()
    if (obj is KotlinB) {
        println(obj.b)
    }
}