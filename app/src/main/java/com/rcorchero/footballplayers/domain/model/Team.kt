package com.rcorchero.footballplayers.domain.model

data class Team(
    val id: String,
    val name: String,
    val altName: String,
    val shortName: String,

    val formedYear: String,
    val country: String,

    val descriptionEN: String,
    val descriptionES: String,

    val manager: String,

    val stadium: Stadium,
    val socialNetworks: SocialNetworks,
    val images: Images) : DomainModel() {

    class Stadium (
        val name: String,
        val description: String,
        val capacity: String,
        val location: String,
        val thumb: String) : DomainModel()

    class SocialNetworks (
        val facebook: String,
        val instagram: String,
        val twitter: String,
        val website: String,
        val youtube: String) : DomainModel()

    class Images(
        val badge: String,
        val banner: String,
        val fanarts: List<String>,
        val jersey: String,
        val logo: String) : DomainModel()
}