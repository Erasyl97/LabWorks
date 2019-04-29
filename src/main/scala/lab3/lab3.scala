package lab3
import scala.io.StdIn._

object lab3 extends App {

  //------------------------------------Task1----------------------------------
  println("----------Task1----------")
  def divideOpt(num1: Int, num2: Int) : Option[Int] = {
    num2 match {
      case 0 => None
      case num => Some(num1/num)
    }
  }
  println(divideOpt(2,0))

  //------------------------------------Task2----------------------------------
  println("----------Task2----------")
  def calculator(operand1: String, operator: String, operand2: String): Unit = {
    /*val oper1 = operand1.toInt match {
      case num==Int => num
      case any: Any => println("Invalid input for operand1")
    }
    val oper2 = operand2.toInt match {
      case num==Int => num
      case any: Any => println("Invalid input for operand2")
    }*/
    val oper1 = operand1.toInt match {
      case num==Int => Some(num)
      case any: Any => None
    }
    val oper2:Option[Int] = operand2.toInt match {
      case num==Int => Some(num)
      case any: Any => None
    }

    val result = for {
      num1 <- oper1
      num2 <- oper2
      result <- operator match {
        case "+" => Some(num1 + num2)
        case "-" => Some(num1 - num2)
        case "*" => Some(num1 * num2)
        case "/" => Some(num1 / num2)
        case any: Any => None
      }
    } yield result

    result match {
      case Some(result) => println(s"Result of operation $operator = $result")
      case None => println("Invalid input or other Error")
    }
  }
  //calculator("5","+","5")

}
