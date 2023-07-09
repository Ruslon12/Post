package com.example.post.dto

data class Post (
    val id : Int,
    val content : String,
    val author : Author,
    val comments : Int,
    val likes : Int,
    val shares : Int
)

data class Author (
    val name : String,
    val avatar : String
)

data class GetPost(
    val message: Any,
    val posts: PostsList
)

class PostsList: ArrayList<Post>()

data class SetPost (
    val author: String,
    val content: String
)

class ResponseSetPost (
    val message: Any?,
    val post: Post
)