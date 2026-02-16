import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.ResponseException
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object KtorClient {
    fun create(): HttpClient = HttpClient {
        expectSuccess = true
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                    explicitNulls = false
                    isLenient = true
                }
            )
        }

        install(HttpTimeout) {
            socketTimeoutMillis = 15_000
            connectTimeoutMillis = 15_000
            requestTimeoutMillis = 15_000
        }
        HttpResponseValidator {
            handleResponseExceptionWithRequest { cause, _ ->
                if (cause is ResponseException) {
                    println("HTTP ERROR: ${cause.response.status}")
                }
            }
        }
    }
}