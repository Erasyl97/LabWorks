package lab1

object lab1 extends App {


  //----------Task1----------
  println("----------Task1----------")
  class Cat(Name: String, Colour: String, Food: String)

  val cat1 = new Cat("Oswald", "Black", "Milk")
  val cat2 = new Cat("Henderson", "Ginger", "Chips")
  val cat3 = new Cat("Quentin", "Tabby and White", "Curry")

  //----------Task2----------
  println("----------Task2----------")
  class Director(val firstName: String, val lastName: String, val yearOfBirth: Int) {
    def name = firstName + " " +lastName
  }

  class Film(val name: String, val yearOfRelease: Int, val imdbRating: Double, val director: Director) {
    def directorsAge = yearOfRelease - director.yearOfBirth
    def isDirectedBy(director1: Director) = director1 == director

    def copy(name: String = this.name, yearOfRelease: Int = this.yearOfRelease, imdbRating: Double = this.imdbRating, director: Director = this.director) = new Film(name, yearOfRelease, imdbRating, director)
  }

  val eastwood = new Director("Clint","Eastwood", 1930)
  val mcTiernan = new Director("John","McTiernan", 1951)
  val nolan = new Director("Christopher","Nolan", 1970)
  val someBody = new Director("Just","SomeBody", 1990)
  val memento = new Film("Memento", 2000, 8.5, nolan)
  val darkKnight = new Film("DarkKnight", 2008, 9.0, nolan)
  val inception = new Film("Inception", 2010, 8.8, nolan)
  val highPlainsDrifter  = new Film("HighPlainsDrifter", 1973, 7.7, eastwood)
  val outlawJoseyWales   = new Film("TheOutlawJoseyWales", 1976, 7.9, eastwood)
  val unforgiven = new Film("Unforgiven", 1992, 8.3, eastwood)
  val granTorino = new Film("GranTorino", 2008, 8.2, eastwood)
  val invictus = new Film("Invictus", 2009, 7.4, eastwood)
  val predator = new Film("Predator", 1987, 7.9, mcTiernan)
  val dieHard = new Film("DieHard", 1988, 8.3, mcTiernan)
  val huntForRedOctober = new Film("TheHuntforRedOctober", 1990, 7.6, mcTiernan)
  val thomasCrownAffair = new Film("TheThomasCrownAffair", 1999, 6.8, mcTiernan)

  println(eastwood.yearOfBirth)
  println(dieHard.director.name)
  println(invictus.isDirectedBy(nolan))

  println(highPlainsDrifter.copy("L'homedomssajd").yearOfRelease)
  println(thomasCrownAffair.copy(yearOfRelease = 1968,director = new Director("Norman","Jewison", 1926)))
  println(inception.copy().copy().copy())

  //----------Task3----------
  println("----------Task3----------")
  class Counter(val count: Int) {
    def inc(x: Int = 1) = new Counter(count+x)
    def dec(x: Int = 1) = new Counter(count-x)
  }
  println(new Counter(10).inc().inc().count)

  //----------Task4----------
  println("----------Task4----------")
  println(new Counter(10).inc(10).dec(5).count)

  //----------Task5----------
  case class Cats(name: String, colour: String, food: String)
  val cats1 = Cats("Oswald", "Black", "Milk")
  val cats2 = Cats("Markau", "Sary", "Chips")

  //----------Task6----------
  println("----------Task6----------")
  case class Director1(firstName: String, lastName: String, yearOfBirth: Int) {
    def name = firstName + " " +lastName
  }
  val eastwood1 = Director1("Clint","Eastwood", 1930)
  println(eastwood1.name)

  case class Film1(name: String, yearOfRelease: Int, imdbRating: Double, director: Director1) {
    def directorsAge = yearOfRelease - director.yearOfBirth
    def isDirectedBy(director1: Director1) = director1 == director

    //def copy(name: String = this.name, yearOfRelease: Int = this.yearOfRelease, imdbRating: Double = this.imdbRating, director: Director = this.director) = new Film(name, yearOfRelease, imdbRating, director)
  }
  val film1 = Film1("asd",54, 10.0, eastwood1)
  film1.copy()

  //----------Task7----------
  println("----------Task7----------")
  case class newCounter(count: Int = 0) {
    def inc = copy(count = count+1)
    def dec = copy(count = count-1)
  }
  println(newCounter(5).inc.inc.count)
  //----------Task8----------
  println("----------Task8----------")
  object ChipShop {
    def willServe(cats: Cats): Boolean = {
      cats match {
        case Cats(_,_,"Chips") => true
        case Cats(_,_,_) => false
      }
    }
  }
  println(ChipShop.willServe(cats1))

  //----------Task9----------
  println("----------Task9----------")

  object Dad {
    def rate(film: Film1): Double = {
      film.director match {
        case Director1("Clint","Eastwood",_) => 10.0
        case Director1("John","McTiernan",_) => 7.0
        case Director1(_,_,_) =>3.0
      }
    }
  }
  val highPlainsDrifter1  = Film1("HighPlainsDrifter", 1973, 7.7, eastwood1)
  println(Dad.rate(highPlainsDrifter1))
}



