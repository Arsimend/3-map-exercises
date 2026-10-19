# Map exercises

![Map data structure: keys and their values, for example postal codes and post offices](img/chapters/map.svg)

With these exercises, you learn to use the Map data structure in your own applications. We recommend reading the pages [Using Maps to Store Key Value Pairs](https://dev.java/learn/api/collections-framework/maps/) and [Managing the Content of a Map](https://dev.java/learn/api/collections-framework/working-with-keys-and-values/) of Oracle's [dev.java](https://dev.java/) tutorial.

> *"A hashmap is a structure able to store key-value pairs. The value is any object your application needs to handle, and a key is something that can represent this object.*
>
> *Suppose you need to create an application that has to handle invoices, represented by instances of an Invoice class. Then your values are these Invoice instances, and your keys could be the invoice numbers. Each invoice has a number, and that number is unique among all your invoices."*
>
> Using Maps to Store Key Value Pairs. Oracle. https://dev.java/learn/api/collections-framework/maps/

## Starting the exercise

First fork this repository into your own GitHub repository with GitHub's **Fork** button, and only then clone your fork to your computer:

```sh
git clone https://github.com/<your-github-username>/3-map-exercises.git
```

Open the cloned project in your code editor.

## Testing

The parts of the exercise have ready-made [JUnit](https://junit.org/) unit tests in the [src/test/java](./src/test/java/) directory. Each part tells which test class grades it. You can run the tests with your code editor's testing tool ([VS Code](https://code.visualstudio.com/docs/java/java-testing), [Eclipse](https://www.vogella.com/tutorials/JUnitEclipse/article.html)) or with [Gradle](https://docs.gradle.org/current/userguide/java_testing.html), for example:

```
./gradlew test --tests MapBasicsTest        # unix
.\gradlew.bat test --tests MapBasicsTest    # windows
```

Add `--info` to the end of the command for more details about failing tests. You do not need to study how the tests are implemented, and you can also try your solution with your own `main` method. You may write more tests of your own, but do not change or remove the given tests.

Do not change the names, parameters or return types of the given classes, methods and constructors, because the tests will then not compile. You get the original version of a file back with `git restore <path to file>` or with the **Palauta lähtökoodi** (restore starter code) function of the course system.

## Submitting and points

Each part of the exercise has its own page in the course system (https://jtjuslin.kapsi.fi/java), and its code fields contain the part's starter code. Copy your solution into the code fields or write it there directly. **Testaa ilman palautusta** (test without submitting) runs the part's tests without saving points, and **Lähetä** (submit) submits your solution. Each test class is accepted only if all of its tests pass, and the points are divided according to the accepted test classes.

**Points in two stages**

1. When your solution passes in the course system, you get **half of the points** for the part.
2. Finally, push everything to your public GitHub repository. Then press the **Lähetä tarkistettavaksi** (submit for checking) button on the part's page. When the tests pass, you get **full points** for the part. The repository may remain public.

There is no grading YAML workflow (GitHub Actions) on GitHub, and `git push` does not start any grading. When you press **Lähetä tarkistettavaksi**, the course system's bot fetches your code from your repository and checks it with the same tests. Both stages must be completed before the chapter deadline. You can submit as many times as you need, and your best result is kept.


## Exercise 1: MapBasics *(basics, 40 %)*

In this exercise, you practice creating a new `Map` object and the most common operations for adding, getting, changing and removing data.

The javadoc comments of the [MapBasics](./src/main/java/part01/MapBasics.java) methods tell how each method should work. **Read the comments and implement each method to match its name and description.**

Graded with the test class [MapBasicsTest](./src/test/java/part01/MapBasicsTest.java).

🚀 *Many of these methods do not depend on the types of the map's keys and values. For example, `countEntries` would work just as well with a `<String, String>` map as with a `<String, Integer>` map. A real program would probably use generic types, such as `Map<K, V>`. You do not need to study generics yet, but you may implement the methods as generic ones: https://dev.java/learn/generics/.*


## Exercise 2: MapExperts *(applying, 30 %)*

This exercise continues with `Map` operations as applied tasks. They are more challenging and require broader problem solving than using a single method.

Implement the methods of the [MapExperts](./src/main/java/part02/MapExperts.java) class according to their javadoc comments: counting letter occurrences, inverting a map and turning a list of [Course](./src/main/java/part02/Course.java) objects into a map. `Course` is a ready-made record class.

Graded with the test class [MapExpertsTest](./src/test/java/part02/MapExpertsTest.java).


## Exercise 3: PostalCodesMain *(applying, 15 % + 15 %)*

[JSON (JavaScript Object Notation)](https://www.json.org/) is a lightweight and common way to store and transfer structured data between programs. JSON data can look like this, for example:

```json
{
    "74701": "KIURUVESI",
    "35540": "JUUPAJOKI",
    "74705": "PAKETTIAUTOMAATTI",
    "74704": "SMARTPOST",
    "44884": "SMART POST"
}
```

A Map is an excellent data structure for such key-value pairs. In this exercise, you handle postal code data stored in the JSON file [postcode_map_light.json](./data/postcode_map_light.json). Reading the file is already implemented in the [PostalCodesReader](./src/main/java/part03/PostalCodesReader.java) class, which uses Google's [GSON library](https://github.com/google/gson). You do not need to study GSON.

🚀 *GSON is not part of Java's standard library but has been added to the project with Gradle. Can you find out from the [build.gradle](./build.gradle) file how and where GSON is defined?*

### User interface

You may implement the solution as you see best and create the classes and methods you need. However, the program must start from the `main` method of the [PostalCodesMain](./src/main/java/part03/PostalCodesMain.java) class, ask the user for only one input, print the answer in the format shown below and exit. Get the postal codes with the `readPostalCodes` method of `PostalCodesReader`.

**Postal code (15 %)**

If the user enters a postal code, the program prints the corresponding post office:

```
Input postal code or district (e.g., 00100 or Helsinki): 00100

Post office: HELSINKI
```

If the postal code is not found, print for example "Post office not found."

**Post office name (15 %)**

If the user enters the name of a post office, the program prints all of its postal codes:

```
Input postal code or district (e.g., 00100 or Helsinki): Porvoo

Postal codes: 06100, 06101, 06150, 06151, 06200, 06400, 06401, 06450, 06500
```

The case of the name does not matter, and partial matches are not shown. The postal codes must be **in ascending order, separated by a comma and a space**, so first collect them into a list, for example, and [sort](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Collections.html#sort(java.util.List)) it before printing. If no postal codes are found for the name, print for example "Postal codes not found."

### Running and grading the program

You can run the program with the Run button of your code editor or with Gradle:

```
./gradlew --quiet --console plain run         # unix
.\gradlew.bat --quiet --console plain run     # windows
```

The first run may be slow, but [Gradle's cache speeds up the following ones](https://docs.gradle.org/current/userguide/build_cache.html). Gradle knows to start `PostalCodesMain` because it is defined as the main class in [build.gradle](./build.gradle).

The course system runs your program with different inputs using two test classes. They are not in this repository, so try the program yourself with the examples above. The ready-made [PostalCodesReaderTest](./src/test/java/part03/PostalCodesReaderTest.java) only tests the given file reader.

* `PostalCodeLookupTest` *(postal code, 15 %)*: with inputs such as `19230`, `00100`, `99999` and `71820`, the output must contain the corresponding post office (ONKINIEMI, HELSINKI, KORVATUNTURI and PÖLJÄ). A partial postal code, such as `001`, must not produce a result.
* `PostalDistrictLookupTest` *(post office name, 15 %)*: with inputs such as `tammisaari`, `TAMMISAARI`, `Porvoo` and `kauniainen`, the output must contain the post office's postal codes in ascending order. A partial name, such as `Porv`, must not produce a result.

💡 *The test picks all five-digit numbers from the output, so do not print other five-digit numbers than the postal codes found. The example in the input prompt "(e.g., 00100 or Helsinki)" is ignored.*


## Bonus exercise 4: MorseCode *(applying, 0 %)*

This optional bonus exercise does not affect the points. Implement the methods `textToMorse` and `morseToText` of the [MorseCode](./src/main/java/part04/MorseCode.java) class, which convert text to Morse code and back:

```
hello world
.... . .-.. .-.. ---   .-- --- .-. .-.. -..
```

More information about Morse code is available on Wikipedia, for example: https://en.wikipedia.org/wiki/Morse_code. The [MorseApp](./src/main/java/part04/MorseApp.java) class is not checked.

Tried with the test class [MorseCodeTest](./src/test/java/part04/MorseCodeTest.java).


## License and authors

This exercise was developed by Teemu Havulinna and Jukka Juslin, and it is licensed under the [Creative Commons BY-NC-SA license](https://creativecommons.org/licenses/by-nc-sa/4.0/). ChatGPT 3.5 and GitHub Copilot were used in creating the assignment, the source code and the tests.

**Postal code data.** The data [postcode_map_light.json](./data/postcode_map_light.json) was borrowed from the file [postcode_map_light.json](https://github.com/theikkila/postinumerot/blob/master/postcode_map_light.json) of the project https://github.com/theikkila/postinumerot on 7.6.2023. The copyright of the data belongs to Posti, and it is used according to [Posti's terms of use](https://www.posti.fi/fi/asiakastuki/postinumerotiedostot). If you make copies of the data, make sure to follow the terms of use.

**Ohjelmoinnin MOOC.** The methods of the `MapExperts` class are strongly inspired by the Python exercises of the University of Helsinki's Ohjelmoinnin perusteet MOOC at https://ohjelmointi-23.mooc.fi/osa-5. Ohjelmoinnin MOOC is licensed under CC BY-NC-SA 4.0:

> *Kurssimateriaalin ja tehtävien tekijät ovat Erkki Kaila, Antti Laaksonen ja Matti Luukkainen. Muutama kurssin tehtävistä on Arto Hellaksen (né Vihavainen) käsialaa.*
>
> *Kurssin materiaali on lisensoitu [Creative Commons BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/deed.fi) -lisenssillä, joten voit käyttää ja levittää sitä vapaasti, kunhan alkuperäisten tekijöiden nimiä ei poisteta. Jos teet muutoksia materiaaliin ja haluat levittää muunneltua versiota, se täytyy lisensoida samalla lisenssillä. Materiaalien käyttö kaupalliseen tarkoitukseen on ilman erillistä lupaa kielletty.*
