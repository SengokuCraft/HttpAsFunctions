# HTTP as Functions

# What is this?

HTTP as Functions 略して HaF は、  
HTTP通信を関数の用に扱えるライブラリです。  
これを使えばネットワーク間やプロセス間(通信先をlocalhostにする)で関数を呼び出すことができます。  
引数と戻り値は [Gson](https://github.com/google/gson) のJsonElementとなっています。  
関数はライブラリを通して登録したり呼び出したりする事ができますが、中では  
登録は [Spark Freamwork](https://sparkjava.com/) を用いて鯖を建て
呼び出しは [OkHttp](https://square.github.io/okhttp/) を用いて鯖にPOSTリクエストを送信しているだけです。

# How to use

## 1. Dependencies

### raw

- repository: `https://raw.githubusercontent.com/TwoSquirrels/HttpAsFunctions/main/repository`
- gropuId: `io.github.twosquirrels`
- artifactId: `httpasfunctions`
- version: `1.3.0`

### maven

```xml
<project ...>

  ...

  <dependencies>

    ...

    <!-- https://github.com/TwoSquirrels/HttpAsFunctions -->
    <dependency>
      <groupId>io.github.twosquirrels</groupId>
      <artifactId>httpasfunctions</artifactId>
      <version>1.3.0</version>
    </dependency>

  </dependencies>

  ...

  <repositories>

    ...

    <!-- https://github.com/TwoSquirrels/HttpAsFunctions -->
    <repository>
      <id>twosquirrels-haf</id>
      <name>Repository for Http as Functions</name>
      <url>https://raw.githubusercontent.com/TwoSquirrels/HttpAsFunctions/main/repository</url>
    </repository>

  </repositories>

  ...

</project>
```

### gradle

Sorry, I do not understand.

## 2. Write your code!

### document

[Javadoc](https://twosquirrels.github.io/HttpAsFunctions/1.3.0/javadoc/)

ドキュメント書くのだるそう  
とりあえずJavadocみるなり僕に聞くなりして使ってちょ

### example

いつか書く

# When use it

## プロセス間

- マイクラのプラグイン同士でデータの送信、取得をしたい時

## ネットワーク間

- ソフトやゲームでサーバーにデータを送信したりサーバーからデータを取得したい時
