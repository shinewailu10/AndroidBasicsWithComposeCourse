// print messages
// fun main() {
//     println("Use the val keyword when the value doesn't change.")
//     println("Use the var keyword when the value can change.")
//     println("When you define a function, you define the parameters that can be passed to it.")
//     println("When you call a function, you pass arguments for the parameters.")
// }

// fix compiler
/* fun main() { 
    println("New chat message from a friend'}
}
 */
//  fun main() {
//     println("New chat message from a friend")
//  }


//String templates
/* 
fun main() {
        val discountPercentage: Int = 0
        val offer: String = ""
        val item = "Google Chromecast"
        discountPercentage = 20
        offer = "Sale - Up to $discountPercentage% discount on $item! Hurry up!"
        
        println(offer)
}
*/

// fun main() {
//     val discountPercentage = 20
//     val item = "Google Chromecast"
//     val offer = "Sale - Up to $discountPercentage% discount on $item! Hurry up!"
    
//     println(offer)
// }
 
//String Concatenation
/*
fun main() {
    val numberOfAdults = "20"
    val numberOfKids = "30"
    val total = numberOfAdults + numberOfKids
    println("The total party size is: $total")
} 
*/

// fun main() {
//     val numberOfAdults = 20
//     val numberOfKids = 30
//     val total = numberOfAdults + numberOfKids
//     println("The total party size is: $total")
// }

// add() and substract()
// fun main() {
//     val firstNumber = 10
//     val secondNumber = 5
//     val thirdNumber = 8
    
//     val result = add(firstNumber, secondNumber)
//     val anotherResult = substract(firstNumber, thirdNumber)

//     println("$firstNumber + $secondNumber = $result")
//     println("$firstNumber + $thirdNumber = $anotherResult")
// }

// fun add(num1 : Int, num2 : Int) : Int {
//     return num1 + num2
// }

// fun substract(num1 : Int, num2 : Int) : Int {
//     return num1 - num2
// }

//display alert message funtion
// fun main() {
//     val operatingSystem = "Chrome OS"
//     val emailId = "sample@gmail.com"

//     println(displayAlertMessage(operatingSystem, emailId))
// }

// fun main() {
//     val firstUserEmailId = "user_one@gmail.com"

//     // The following line of code assumes that you named your parameter as emailId. 
//     // If you named it differently, feel free to update the name.
//     println(displayAlertMessage(emailId = firstUserEmailId))
//     println()

//     val secondUserOperatingSystem = "Windows"
//     val secondUserEmailId = "user_two@gmail.com"

//     println(displayAlertMessage(secondUserOperatingSystem, secondUserEmailId))
//     println()

//     val thirdUserOperatingSystem = "Mac OS"
//     val thirdUserEmailId = "user_three@gmail.com"

//     println(displayAlertMessage(thirdUserOperatingSystem, thirdUserEmailId))
//     println()
// }

// fun displayAlertMessage(operatingSystem : String = "Unknown OS" , emailId : String) : String {
//     return "There's a new sign-in request on $operatingSystem for your Google Account $emailId."
// }

// fun main() {
//     val steps = 4000
//     val caloriesBurned = pedometerStepsToCalories(steps);
//     println("Walking $steps steps burns $caloriesBurned calories") 
// }

// fun pedometerStepsToCalories(numberOfSteps: Int): Double {
//     val caloriesBurnedForEachStep = 0.04
//     val totalCaloriesBurned = numberOfSteps * caloriesBurnedForEachStep
//     return totalCaloriesBurned
// }

//compare 2 number
// fun main() {
//     println("Have I spent more time using my phone today: ${compareTime(300, 250)}")
//     println("Have I spent more time using my phone today: ${compareTime(300, 300)}")
//     println("Have I spent more time using my phone today: ${compareTime(200, 220)}")
// }

// fun compareTime(timeSpentToday: Int, timeSpentYesterday: Int): Boolean {
//     return timeSpentToday > timeSpentYesterday
// }

//duplicate code into a function
/*
fun main() {
    println("City: Ankara")
    println("Low temperature: 27, High temperature: 31")
    println("Chance of rain: 82%")
    println()

    println("City: Tokyo")
    println("Low temperature: 32, High temperature: 36")
    println("Chance of rain: 10%")
    println()
    
    println("City: Cape Town")
    println("Low temperature: 59, High temperature: 64")
    println("Chance of rain: 2%")
    println()
    
    println("City: Guatemala City")
    println("Low temperature: 50, High temperature: 55")
    println("Chance of rain: 7%")
    println()
}
*/

// fun main() {
//     displayCityInfo("Ankara", 27, 31, 82)
//     displayCityInfo("Tokyo", 32, 36, 10)
//     displayCityInfo("Cape Town", 59, 64, 2)
//     displayCityInfo("Guatemala", 50, 55, 7)
// }

// fun displayCityInfo(city : String, lowTemperature : Int, highTemperature : Int, rain : Int) {
//     println("City: $city")
//     println("Low temperature: $lowTemperature, High temperature: $highTemperature")
//     println("Chance of rain: $rain%")
//     println()
// }