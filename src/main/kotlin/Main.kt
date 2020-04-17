import com.google.gson.Gson
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class User (
    val name: String,
    val email: String,
    val age: Int = 20
)

fun main() {
    val jsonString = """
            {
                "name" : "Ready Kim",
                "email" : "ready.kim@gmail.com"
            }
        """.trimIndent()

    val user = Gson().fromJson(jsonString, User::class.java)

    println(user)

    val user2 = Json.parse(User.serializer(), jsonString)

    println(user2)
}