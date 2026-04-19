package com.example.anime_list.model
import kotlinx.serialization.Serializable

@Serializable
data class JpgImage(
    val image_url: String? = null,
    val small_image_url: String? = null,
    val large_image_url: String? = null
)

@Serializable
data class Images(
    val jpg: JpgImage? = null,
    val webp: JpgImage? = null
)

@Serializable
data class Trailer(
    val youtube_id: String? = null,
    val url: String? = null,
    val embed_url: String? = null
)

@Serializable
data class Title(
    val type: String? = null,
    val title: String? = null
)

@Serializable
data class PropDate(
    val day: Int? = null,
    val month: Int? = null,
    val year: Int? = null
)

@Serializable
data class Aired(
    val from: String? = null,
    val to: String? = null
)

@Serializable
data class Broadcast(
    val day: String? = null,
    val time: String? = null,
    val timezone: String? = null,
    val string: String? = null
)

@Serializable
data class MalEntry(
    val mal_id: Int? = null,
    val type: String? = null,
    val name: String? = null,
    val url: String? = null
)

@Serializable
data class Anime(
    val mal_id: Int? = null,
    val url: String? = null,
    val images: Images? = null,
    val trailer: Trailer? = null,
    val approved: Boolean? = null,
    val titles: List<Title>? = null,
    val title: String? = null,
    val title_english: String? = null,
    val title_japanese: String? = null,
    val title_synonyms: List<String>? = null,
    val type: String? = null,
    val source: String? = null,
    val episodes: Int? = null,
    val status: String? = null,
    val airing: Boolean? = null,
    val aired: Aired? = null,
    val duration: String? = null,
    val rating: String? = null,
    val score: Double? = null,
    val scored_by: Int? = null,
    val rank: Int? = null,
    val popularity: Int? = null,
    val members: Int? = null,
    val favorites: Int? = null,
    val synopsis: String? = null,
    val background: String? = null,
    val season: String? = null,
    val year: Int? = null,
    val broadcast: Broadcast? = null,
    val producers: List<MalEntry>? = null,
    val licensors: List<MalEntry>? = null,
    val studios: List<MalEntry>? = null,
    val genres: List<MalEntry>? = null,
    val explicit_genres: List<MalEntry>? = null,
    val themes: List<MalEntry>? = null,
    val demographics: List<MalEntry>? = null
)

@Serializable
data class Items(
    val count: Int? = null,
    val total: Int? = null,
    val per_page: Int? = null
)

@Serializable
data class Pagination(
    val last_visible_page: Int? = null,
    val has_next_page: Boolean? = null,
    val current_page: Int? = null,
    val items: Items? = null
)

@Serializable
data class SeasonNowResponse(
    val data: List<Anime>? = null,
    val pagination: Pagination? = null
)