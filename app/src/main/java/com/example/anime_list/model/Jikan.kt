package com.example.anime_list.model
data class JpgImage(
    val image_url: String?,
    val small_image_url: String?,
    val large_image_url: String?
)

data class Images(
    val jpg: JpgImage?,
    val webp: JpgImage?
)

data class Trailer(
    val youtube_id: String?,
    val url: String?,
    val embed_url: String?
)

data class Title(
    val type: String?,
    val title: String?
)

data class PropDate(
    val day: Int?,
    val month: Int?,
    val year: Int?
)

data class Aired(
    val from: String?,
    val to: String?,
    val prop: Map<String, Any>?
)

data class Broadcast(
    val day: String?,
    val time: String?,
    val timezone: String?,
    val string: String?
)

data class MalEntry(
    val mal_id: Int?,
    val type: String?,
    val name: String?,
    val url: String?
)

data class Anime(
    val mal_id: Int?,
    val url: String?,
    val images: Images?,
    val trailer: Trailer?,
    val approved: Boolean?,
    val titles: List<Title>?,
    val title: String?,
    val title_english: String?,
    val title_japanese: String?,
    val title_synonyms: List<String>?,
    val type: String?,
    val source: String?,
    val episodes: Int?,
    val status: String?,
    val airing: Boolean?,
    val aired: Aired?,
    val duration: String?,
    val rating: String?,
    val score: Double?,
    val scored_by: Int?,
    val rank: Int?,
    val popularity: Int?,
    val members: Int?,
    val favorites: Int?,
    val synopsis: String?,
    val background: String?,
    val season: String?,
    val year: Int?,
    val broadcast: Broadcast?,
    val producers: List<MalEntry>?,
    val licensors: List<MalEntry>?,
    val studios: List<MalEntry>?,
    val genres: List<MalEntry>?,
    val explicit_genres: List<MalEntry>?,
    val themes: List<MalEntry>?,
    val demographics: List<MalEntry>?
)

data class Items(
    val count: Int?,
    val total: Int?,
    val per_page: Int?
)

data class Pagination(
    val last_visible_page: Int?,
    val has_next_page: Boolean?,
    val current_page: Int?,
    val items: Items?
)

data class SeasonNowResponse(
    val data: List<Anime>?,
    val pagination: Pagination?
)