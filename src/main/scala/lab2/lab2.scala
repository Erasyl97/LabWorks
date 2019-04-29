package lab2

object lab2 extends App {

  case class Film( name: String, yearOfRelease: Int, imdbRating: Double)
  case class Director( firstName: String, lastName: String, yearOfBirth: Int, films: Seq[Film])

  val memento = new Film("Memento", 2000, 8.5)
  val darkKnight = new Film("Dark Knight", 2008, 9.0)
  val inception = new Film("Inception", 2010, 8.8)
  val highPlainsDrifter = new Film("High Plains Drifter", 1973, 7.7)
  val outlawJoseyWales = new Film("The Outlaw Josey Wales", 1976, 7.9)
  val unforgiven = new Film("Unforgiven", 1992, 8.3)
  val granTorino = new Film("Gran Torino", 2008, 8.2)
  val invictus = new Film("Invictus", 2009, 7.4)
  val predator = new Film("Predator", 1987, 7.9)
  val dieHard = new Film("Die Hard", 1988, 8.3)
  val huntForRedOctober = new Film("The Hunt for Red October", 1990, 7.6)
  val thomasCrownAffair = new Film("The Thomas Crown Affair", 1999, 6.8)
  val eastwood = new Director("Clint", "Eastwood", 1930,
    Seq(highPlainsDrifter, outlawJoseyWales, unforgiven, granTorino, invictus))
  val mcTiernan = new Director("John", "McTiernan", 1951,
    Seq(predator, dieHard, huntForRedOctober, thomasCrownAffair))
  val nolan = new Director("Christopher", "Nolan", 1970,
    Seq(memento, darkKnight, inception))
  val someGuy = new Director("Just", "Some Guy", 1990,
    Seq())
  val directors = Seq(eastwood, mcTiernan, nolan, someGuy)

  //------------------------------------Task1----------------------------------
  println("----------Task1----------")
  def directedMoreThanX(numberOfFilms: Int) = {
    directors.filter(x => x.films.length>numberOfFilms)
  }
  println(directedMoreThanX(4).length)
  println()

  //------------------------------------Task2---------------------------------
  println("----------Task2----------")
  def bornBeforeTheX(year: Int) = {
    directors.filter(x => x.yearOfBirth<year)
  }
  val directorsBornBeforeX = bornBeforeTheX(1971)
  directorsBornBeforeX.foreach(director => println(director.firstName+ " " +director.lastName))
  println()

  //------------------------------------Task3---------------------------------
  println("----------Task3----------")
  def task3(year: Int, numberOfFilms: Int) = {
    //directedMoreThanX(numberOfFilms).filter(x => x.yearOfBirth<year)
    directors.filter(x => (x.yearOfBirth<year && x.films.length>numberOfFilms))
  }
  val task3Directors = task3(1971,3)
  task3Directors.foreach(director => println(director.firstName+ " " +director.lastName))
  println()

  //------------------------------------Task4---------------------------------
  println("----------Task4----------")
  def sortDirectors(ascending: Boolean) = {
    if(ascending) directors.sortWith((x,y) => x.yearOfBirth < y.yearOfBirth)
    else directors.sortWith((x,y) => x.yearOfBirth > y.yearOfBirth)
  }
  val sortedDirectors = sortDirectors(false)
  sortedDirectors.foreach(director => println(director.firstName+ " " +director.lastName))
  println()

  //------------------------------------Task5---------------------------------
  println("----------Task5----------")
  val nolanFilms = nolan.films.map(x => x.name)
  println(nolanFilms)
  println()

  //------------------------------------Task6---------------------------------
  println("----------Task6----------")
  val filmsArchive = directors.map(director => director.films.map(film => film.name))
  println(filmsArchive)
  println()

  //------------------------------------Task7---------------------------------
  println("----------Task7----------")
  val mcTiernanEarliestFilmDate = mcTiernan.films.foldLeft(2050)((x,y) => math.min(x,y.yearOfRelease))
  println(mcTiernanEarliestFilmDate)
  println()

  //------------------------------------Task8---------------------------------
  println("----------Task8----------")
  //val sortedByImdbFilms = directors.
  //println(directors.map(x=> List(x)))
  val allFilms = directors.map(x => x.films).flatten.sortWith((x,y) => x.imdbRating<y.imdbRating)
  allFilms.foreach(film => println(film.imdbRating + "          " + film.name))
  println()

  //------------------------------------Task9---------------------------------
  println("----------Task9----------")
  val numberOfFilms = directors.map(x => x.films).flatten.length
  val averageImdbScore = directors.map(x => x.films).flatten.foldLeft(0.0)((x,y) => x + y.imdbRating)/numberOfFilms.toDouble
  println("Average IMDB Score is: " + averageImdbScore)
  println()

  //------------------------------------Task10---------------------------------
  println("----------Task10----------")
  directors.map(director => director.films.map(film => println(s"Tonight only! ${film.name} by ${director.firstName + " " + director.lastName}!")))
  println()

  //------------------------------------Task11---------------------------------
  println("----------Task11----------")
  val earliestFilm = directors.map(_.films).flatten.sortWith((x,y) => x.yearOfRelease < y.yearOfRelease).headOption.get
  //val directorsName = directors.map(_.films.filter(film => film==earliestFilm)).flatten
  val directorOfEarliestFilm = directors.filter(director => director.films.contains(earliestFilm)).headOption.get
  println(s"Earliest film is  ${earliestFilm.yearOfRelease}'th ${"\"" + earliestFilm.name + "\""} directed by ${directorOfEarliestFilm.firstName + " " + directorOfEarliestFilm.lastName}")
  //directors.map(_.films).flatten.foldLeft(2050)((x,y) => math.min(x,y.yearOfRelease))

}

