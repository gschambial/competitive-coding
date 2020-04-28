package catchexceptions.scala.leetcode

import scala.collection.mutable

object RemoveAdjacentDuplicatesRecursively extends App {

  case class Elem(character: Char, reps: Int)

  def removeDuplicates(s: String): String = {
    val stack: mutable.Stack[Elem] = mutable.Stack[Elem]()

    for(i <- 0 until s.length){

      if(stack.size == 0){
        // for empty stack insert character with rep 1
        stack.push(Elem(s(i), 1))
      }else if(stack.top.character != s(i)){
        // remove last character if repeated
        if(stack.top.reps > 1){
          stack.pop
          // After removing last character,
          // check if the character at top is same as current or not
          val last : Option[Elem] = if(stack.size != 0) Some(stack.top) else None
          if(last.nonEmpty && last.get.character == s(i)){
            // increment
            stack.pop
            stack.push(Elem(s(i), last.get.reps + 1))
          }else {
            // add
            stack.push(Elem(s(i), 1))
          }
        }else {
          // add
          stack.push(Elem(s(i), 1))
        }
      } else if(stack.top.character == s(i)){
        // Just increase reps of Character as it is a repeated character
        val elem = stack.pop()
        stack.push(Elem(s(i), elem.reps + 1))
      }
    }

    // Special case to handle last character
    if(stack.size > 0){
      if(stack.top.reps > 1){
        stack.pop
      }
    }

    var r: String = ""
    for(i <- 0 until stack.size){
      r = stack.pop.character + r
    }
    r
  }

  val inputs = List("caaabbbaacdddd", "acaaabbbacdddd", "geeksforgeeg", "caacc", "azxxzzy", "mississipie", "aaaacddddcappp")

  inputs.map(removeDuplicates(_)).foreach(println)
}

