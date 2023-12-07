package com.cristianpopica.listcristian.Model

data class Movie    (
    val title: String = "",
    val director: String = "",
    val description: String = "",
    var favorite : Boolean = false
) {
    companion object {
        fun getData(): List<Movie> {
            return listOf(
                Movie(title = "Origen", director = "Christopher Nolan", description = "Una película de ciencia ficción que desafía la mente sobre los sueños y la realidad."),
                Movie(title = "Sueño de Fuga", director = "Frank Darabont", description = "Un poderoso drama sobre la esperanza y la redención en la prisión."),
                Movie(title = "El Padrino", director = "Francis Ford Coppola", description = "Una epopeya de crimen sobre la familia mafiosa Corleone."),
                Movie(title = "Pulp Fiction", director = "Quentin Tarantino", description = "Una narrativa no lineal de historias criminales entrelazadas."),
                Movie(title = "El Caballero de la Noche", director = "Christopher Nolan", description = "La icónica película de superhéroes con Batman y el Joker."),
                Movie(title = "La Lista de Schindler", director = "Steven Spielberg", description = "Un drama histórico sobre los esfuerzos de Oskar Schindler durante el Holocausto."),
                Movie(title = "Forrest Gump", director = "Robert Zemeckis", description = "Un relato conmovedor de la vida extraordinaria de un hombre."),
                Movie(title = "Matrix", director = "Lana Wachowski, Lilly Wachowski", description = "Una película de ciencia ficción que explora la naturaleza de la realidad."),
                Movie(title = "Titanic", director = "James Cameron", description = "Una película romántica de desastres ambientada en el trasfondo del Titanic."),
                Movie(title = "Avatar", director = "James Cameron", description = "Una película de ciencia ficción visualmente impactante ambientada en el mundo alienígena de Pandora.")
            )
        }

    }
}
