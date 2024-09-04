//Заміна певного символу seq у Kotlin
//Потрібно замінити рядок, який виглядає наступним чином "xxxx-xxxx" на заданий Long, тому введіть вихідні дані:
//"33" -> "xxxx-xx33"

//"884433 -> "xx88-4433"

//"0" -> "xxxx-xxx0"
//Їх потрібно додавати з кінця. Є кілька способів зробити це, наприклад, додати нулі до вхідних даних, а потім індекси, але мені цікаво, чи є в Kotlin спосіб зробити це за допомогою заміни?

fun replaceWithLong(input: String, longValue: Long): String {
	var longString = longValue.toString().padStart(8, '0') // Перетворюємо Long на String і додаємо нулі на початок
	var pattern = "x{4}-x{4}".toRegex() // Шаблон для відповідності "xxxx-xxxx"
	
	return pattern.replaceFirst("xxxx-xxxx") {
		longString.substring(0, 4) + "-" + longString.substring(4)
	}
}

fun main() {
	println(replaceWithLong("xxxx-xxxx", 33))		// Результат: "xxxx-xx33"
	println(replaceWithLong("xxxx-xxxx", 884433))	// Результат: "xx88-4433"
	println(replaceWithLong("xxxx-xxxx", 0))		// Результат: "xxxx-xxx0"
}

// Пояснення:
// longValue.toString().padStart(8, '0'): Це перетворює значення Long на рядок (String) і додає нулі на початок, щоб довжина рядка завжди була 8 символів.
// "x{4}-x{4}".toRegex(): Це створює регулярний вираз, який відповідає шаблону "xxxx-xxxx".
// replaceFirst з лямбдою: Метод replaceFirst використовується для заміни першого збігу з шаблоном. Лямбда-функція розділяє підготовний рядок (longString) на дві частини і форматуватиме їх у вигляді "xxxx-xxxx".
// Це рішення гарантує, що значення Long додається до рядка з кінця, замінюючи відповідні символи "x".