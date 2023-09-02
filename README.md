# Palabras - Word Game Application #

The purpose of this document is to outline the **Palabras - Word Game** application's major functionality.

### Purpose of this repository ###

This repository and the code contained therein are released as a proof of concept as part of **Babbel**'s coding challenge for candidates to the role of **Senior Android Developer**. Although both the source code and related resources are open to public access with no explicit licensing restrictions, they remain sole property of **Babbel** and the Developer.

### Version ###
**Version 1.0.0**

### How does it work? ###

The **Palabras - Word Game** is an English-to-Spanish word-matching game, which aims to help English speakers improve their Spanish vocabulary.

A set of English-Spanish word pairs are preloaded from a local source upon starting the application. Once the application is started, the user is presented with an English word to be matched with a suggested Spanish translation.

The Spanish word appears on the screen falling from the top in a waterfall-like animation.
The user has a preset time (an arbitrary 20 seconds) to match the word with its translation; at the top most right corner of the screen a clock-timer animation keeps track of the time available to user to answer the question.

The user has the possibility to either confirm the suggested translation as a match for the presented word, or reject it, by using the two actions buttons at the bottom of the screen, each labeled accordingly.
The user can also choose to skip the current word, for any reason. Skipping a word - by pressing the "**Skip**" button on top of the word card view, results in a failed attempt.

The user can make use of the application's **Text-To-Speech** functionality to hear the word before making a choice.

A score board at the top most left corner of the screen keeps record of the user's score and performance during the game, while a count down of remaining words is displayed above the *word card*.

The user receives a visual feedback for every attempt in the form a face emoticon (*neutral*, *smiley*, *sad* - respectively for no action, for a successful attempt or after a failed attempt)

Any of the following three scenarios results in a failed attempt:
* The user presses the "**CORRECT**" button for a translation that does not match the word currently displayed
* The user presses the "**WRONG**" button to reject a correct translation for the word currently displayed
* The user fails to react within the allocated time, ie. 20 seconds

Throughout the game, the user is presented with (at most) three menu options: "**Exit**", "**Reset**" and "**Resume**"
Pressing **Exit** prompts the user to confirm the action before the game is exited and the application closed.
The "**Reset**" option allows the user to reset their score to a clean slate.
The "**Resume**" option appears after the application has been reset to its original status, to allow the user to resume the game.

### Contribution guidelines ###

No external contribution expected on this repository

### Libraries and tools used ###

* **Kotlin** is the language of choice for this application. For more information on the language, check the [Kotlin's official documentation site](https://kotlinlang.org/docs/reference/android-overview.html)
* **Koin** is used for Depency injection; the preference over *Dagger2*, *Kodein*, *Katana* and the more recent *Hilt* was motivated by **Koin**'s simple implementation and solid documentation. For a more in-depth comparison of available dependency injection tools, check the following [article](https://proandroiddev.com/a-dependency-injection-showdown-213339c76515)
* Google's own **Gson** is used for parsing and conversion from JSON format to POJO/POCO (Plain Old Java/Custom Objet)
* Testing libraries such as **JUnit**, **Robolectric**, **Mockito** and "**Espresso**" have been leveraged.
* **Jacoco** is added to produce test coverage reports, while Kotlin's **Dokka** is used to generate documentation. For more information about Dokka, kindly refer to the [library's official website](https://libraries.io/github/Kotlin/dokka)

### Extra features included ###

* A clock timer has been included as a visual reminder to the user of the remaining time available to them for each attempt
* A basic TTS implementation has been added using Android's own **Text-To-Speech** to provide the user with the ability to read the word being presented

### Possible, future improvements ###

* The application uses Android's **AnimationUtils** to handle animation; the more recent, more recommended **MotionLayout** can be used instead to provide much smoother transitions
* The application's graphical interface can be improved with the help of a better design
* Beyond simple documentation, such an interactive game requires a walkthrough or at the very least some tooltip to guide the user through every stage of the game. An interesting *spotlight* library can be found [here](https://github.com/TakuSemba/Spotlight)

#### For further detail and information, contact [arlon.mukeba@gmail.com](mailto:arlon.mukeba@gmail.com)