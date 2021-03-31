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

## 1. Download

- ver1.2.2: [HttpAsFunction-1-2-2.jar](https://github.com/TwoSquirrels/HttpAsFunctions/raw/main/target/HttpAsFunctions-1.2.2.jar)

## 2. Dependencies

### raw
`io.github.twosquirrels:httpasfunctions:1.2.2`

### maven
```xml
<!-- https://github.com/TwoSquirrels/HttpAsFunctions -->
<dependency>
  <groupId>io.github.twosquirrels</groupId>
  <artifactId>httpasfunctions</artifactId>
  <version>1.2.2</version>
</dependency>
```

### gradle
```gradle
// https://github.com/TwoSquirrels/HttpAsFunctions
implementation 'io.github.twosquirrels:httpasfunctions:1.2.2'
```

## 3. Write your code!

### document

[Javadoc](https://twosquirrels.github.io/HttpAsFunctions/target/site/apidocs/)

ドキュメント書くのだるそう
とりあえずJavadocみるなり僕に聞くなりして使ってちょ

### example

いつか書く

# When use it

## プロセス間

- マイクラのプラグイン同士でデータの送信、取得をしたい時

## ネットワーク間

- ソフトやゲームでサーバーにデータを送信したりサーバーからデータを取得したい時
