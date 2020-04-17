import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path

@Serializable
data class Album (
    val userId: Int,
    val id: Int,
    val title: String,
    val comment: String = "default comment"
)

interface ReadyService {
    @GET("albums/{id}")
    fun getAlbum(@Path("id") id: Int): Call<Album>
}

fun main() {
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(Json.asConverterFactory(MediaType.parse("application/json")!!))
        .build()

    val service = retrofit.create(ReadyService::class.java)

    val call = service.getAlbum(3)
    val response = call.execute()

    if (response.isSuccessful) {
        val album: Album? = response.body()
        println(album)
    } else {
        println("Failed to load data.")
    }
}