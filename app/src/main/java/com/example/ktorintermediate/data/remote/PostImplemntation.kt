package com.example.ktorintermediate.data.remote

import com.example.ktorintermediate.data.remote.dto.PostRequest
import com.example.ktorintermediate.data.remote.dto.PostResponse
import io.ktor.client.HttpClient
import io.ktor.client.features.ClientRequestException
import io.ktor.client.features.RedirectResponseException
import io.ktor.client.features.ServerResponseException
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.url

class PostImplemntation(
    private val client: HttpClient
) : PostSecvice {


    override suspend fun getPost(): List<PostResponse> {
        return try {
            client.get {
                url(HttpRout.POSTS)
            }
        } catch (e: RedirectResponseException) {
            println("Error${e.response.status.description}")
            emptyList()
        } catch (e: ClientRequestException) {
            println("Error${e.response.status.description}")
            emptyList()
        } catch (e: ServerResponseException) {
            println("Error${e.response.status.description}")
            emptyList()
        } catch (e: Exception) {
            println("Error${e.message}")
            emptyList()
        }
    }

    override suspend fun createPost(postRequest: PostRequest): PostResponse? {
        return try {
            client.post<PostResponse>() {
                url(HttpRout.POSTS)
                body= postRequest
            }
        } catch (e: RedirectResponseException) {
            println("Error${e.response.status.description}")
            null
        } catch (e: ClientRequestException) {
            println("Error${e.response.status.description}")
           null
        } catch (e: ServerResponseException) {
            println("Error${e.response.status.description}")
           null
        } catch (e: Exception) {
            println("Error${e.message}")
           null
        }
    }
}