
# ColorizedUtil

ColorizedUtil is a Java library for translating Minecraft color codes and gradients. This utility makes it easy to use hexadecimal colors, standard Minecraft color codes, and gradients in your chat messages.

## Installation

To use ColorizedUtil in your project, add the following dependency to your Maven or Gradle build file.

### Maven

Add the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>io.github.pitruk</groupId>
    <artifactId>colorizedutil</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Gradle

Add the following dependency to your `build.gradle`:

```groovy
implementation 'io.github.pitruk:colorizedutil:1.0.0'
```

## Usage

Here's a quick example of how to use the `ColorUtil` class from the `ColorizedUtil` library to translate Minecraft color codes and gradients.

### Example

```java
import pl.pitruk.colorized.ColorUtil;

public class Example {
    public static void main(String[] args) {
        String message = "Hello &#D22AD2world &1and &2everyone&c!";
        String translatedMessage = ColorUtil.colorize(message);
        System.out.println(translatedMessage);
    }
}
```

### Example Chat Messages

You can use ColorizedUtil to create colorful and dynamic messages for your Minecraft chat. Here are a few examples:

1. **Hex Color Codes**

    ```java
    String message = "Welcome to the server &#00FF00Green &#FF0000Red &#0000FFBlue!";
    String translatedMessage = ColorUtil.colorize(message);
    // Outputs: Welcome to the server with the words Green, Red, and Blue in their respective colors
    ```

2. **Standard Minecraft Color Codes**

    ```java
    String message = "This is &1dark blue, &2dark green, and &ccrimson!";
    String translatedMessage = ColorUtil.colorize(message);
    // Outputs: This is dark blue, dark green, and crimson in their respective Minecraft colors
    ```

3. **Gradient**

    ```java
    String message = "<gradient:FF0000:0000FF>Gradient Text</gradient>";
    String translatedMessage = ColorUtil.colorize(message);
    // Outputs: Gradient Text with a smooth transition from red to blue
    ```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contributing

Contributions are welcome! Please open an issue or submit a pull request for any changes.
