object LetterCounter {

  def countLetterOccurrences(words: List[String]): Int = {
  
    val wordLengths = words.map(_.length)

    val totalLetterCount = wordLengths.reduce(_ + _)

    totalLetterCount
  }

  def main(args: Array[String]): Unit = {
  
    val words = List("apple", "banana", "cherry", "date")

    val totalLetters = countLetterOccurrences(words)

    println(s"Total count of letter occurrences: $totalLetters")
  }
}
