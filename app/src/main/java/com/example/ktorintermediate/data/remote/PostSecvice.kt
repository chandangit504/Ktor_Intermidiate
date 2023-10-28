package com.example.ktorintermediate.data.remote

import com.example.ktorintermediate.data.remote.dto.PostRequest
import com.example.ktorintermediate.data.remote.dto.PostResponse
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logging
import kotlinx.serialization.Serializable
import java.util.logging.Level

interface PostSecvice {

    //Q: Here suppose Sometime getting the post call is not Post response or may not be list type ,
    // what we will mention what we will add in this case
    suspend fun getPost( ): List<PostResponse>

//     Here body is required so, we will add body as post request type
    suspend fun createPost(postRequest: PostRequest): PostResponse?


 /*   Here what we have done is we have initialize the client what we have usese inside Post implementation how Http will work/behape we have added some behabiour
    Inside static object we have create a methode which is create type is Postservice and it will return the Http initialisation value ,
    When ever we need Hpptclient we can call create function, and it return all mentod inside Post implementation with client values*/

    companion object{
        fun create(): PostSecvice{
           return PostImplemntation (
               client =  HttpClient(Android){
                   install(Logging){
                       level= LogLevel.ALL
                   }
                   install(JsonFeature){
                       serializer =KotlinxSerializer()
                   }
               }
           )
        }
    }

}