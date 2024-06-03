package igawa.com;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
//　今日紹介したものは一通り実装


  public static void main(String[] args) {
    List<Integer> numberList = List.of(1,2,3,4,5,6,7,8,9,10);
    numberList.stream()
        .filter(number -> number <= 5)// filter・・・引数が1個のもの　アロー演算子->
//        ↓forEach(number　-> System.out.println(number));の略
        .forEach(System.out::println);//メソッド参照

    numberList.stream()
        .limit(3)//上限
        .forEach(System.out::println);

    List<String>studentList = List.of("ka","me","ha","me","ha");
    studentList.stream()
//        .map(v -> v.toUpperCase())//大文字に変換
        .map(String::toUpperCase)//↑と同じ
        .forEach(System.out::println);

    studentList.stream()
        .sorted()//アルファベット順にソート
        .forEach(System.out::println);

    studentList.stream()
        .distinct()//重複処理
        .forEach(System.out::println);

    System.out.println(studentList.stream()
        .map(String::toUpperCase)
        .sorted()
        .distinct()
//        .forEach(System.out::println);
//        .collect(Collectors.joining(",")));//カンマ区切りに文字列の連続
//        .toList());
//        .count());
//        .findFirst());
//        .anyMatch(v -> v.startsWith("K")));//条件に合致するかどうか　true or false の出力
        .allMatch(v -> v.startsWith("H")));

//  文字列のリストを作る。要素数は10個
//  その文字列に対して、文字数が2以上のものを抽出して、文字列に変換をする。区切り文字はカンマで行う。
//  その文字列を出力。
    List<String> rankList = List.of("ss","s","aa","a","bb","cc","c","dd","d","e");
    System.out.println(rankList.stream()
        .filter(v -> v.length() >= 2)
        .collect(Collectors.joining(",")));

//  数値のリスト作る。要素数は10個
//  その数値の中の奇数のものだけを抽出して、平均値を出す。
//  その平均値を出力する。
    List<Integer> number = List.of(15,278,56,83,92,46,67,23,29,999);
    double average = number.stream()//double型：小数点を含む数値を扱う
        .filter(n -> n % 2 != 0)//リスト配列から奇数のものだけ抽出
        .mapToDouble(Integer::doubleValue)//Integer型の要素をdouble型に変換
        .average()
        .orElse(0.00);//オプショナルな値が存在しないときにデフォルト値として0.00を返す
    System.out.println(average);

//  chatGPTなどの生成AIを使って、streamAPIの基礎的な要素を一つ作る。
//  それを実装する
//  1. Integer型のリストがあり、そのリストから偶数の要素のみをフィルタリングするStream操作を書いてください。
    List<Integer> num = List.of(4,8,58,67,15,69,34,35,3,42,888,102);
    num.stream()
        .filter(n -> n % 2 ==0)
        .forEach(System.out::println);
//　2. String型のリストがあり、各文字列の長さを取得し、その長さの合計値を計算するStream操作を書いてください。
    List<String> name =List.of("taishi","mari","hinata","honoka","takeru","suzuha","minori","gen");
    int totalLengths = name.stream()
        .mapToInt(String::length)//Intstreamに変換（文字列の各要素の長さをint型に変換）
        .sum();
    System.out.println(totalLengths);
  }
}