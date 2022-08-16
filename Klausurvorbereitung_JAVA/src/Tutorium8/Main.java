package Tutorium8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    private static List<Player> bestPlayers = Player.bestplayers;

    public static void main(String[] args) {
        //System.out.println(uniqueTeams(bestPlayers));
       // System.out.println(Arrays.toString(bestPlayers.stream().distinct().toArray()));

        //System.out.println(topThreeAssists(bestPlayers));
        // System.out.println(Arrays.toString(bestPlayers.stream().sorted(Comparator.comparingInt(Player::getAssists)).toArray()));


        System.out.println(mostCommonFirstName(bestPlayers));
        //System.out.println(teamsWithBestScoringPlayers(bestPlayers));
       // System.out.println(bestScoringTeam(bestPlayers));
    }

    // 8.1.1
    /*
    Input: die besten Spieler aus verschiedenen Teams
    Aufgabe: zähle, wie viele Teams sind das
     */
    public static long uniqueTeams(List<Player> players) {
        return players.stream()
                .map(p -> p.team)
                .distinct()         //Stream("Team1", "Team2", "Team3")
                //.map(x -> 1)
                //.reduce(0, (counter, next) -> counter + next);
                //.reduce(0, (counter, next) -> counter + 1, Integer::sum);
        //.collect(Collectors.counting());
        .count();
    }

    /*
        Input: die besten Spieler aus verschiedenen Teams
        Aufgabe: 3 besten Spieler mit den meisten Assistis raussuchen
         */
    // 8.1.2
    public static List<Player> topThreeAssists(List<Player> players) {
        return players.stream()//.map(p->p.assists).sorted().collect(Collectors.toList());


                .sorted(Comparator.comparingInt(Player::getAssists).reversed()) // alternative solutions
                //.sorted((o1,o2) -> o1.assists > o2.assists ? -1 : 1)
                //.sorted(((o1,o2) -> Integer.compare(o2.assists, o1.assists)))
                .limit(3)
                .collect(Collectors.toList());


    }

/*
    Hinweis: Aufgabe 1.3
    "Sam Brown" -> "Sam Brown".split(" ") -> arr["Sam", "Brown"]
    -> arr[0] --> "Sam"

    Stream("Sam", "Sam", "Tom", "Tom", "Rene")
    Map
    Key -> Value
    "Sam" -> 2
    "Tom" -> 2
    "Rene" -> 1
     */

    // 8.1.3
    public static List<String> mostCommonFirstName(List<Player> players) {
        return players.stream()
                .map(x -> x.name.split(" ")[0]) //"Ivi López" --> "Ivi"
                //Parameter1: map, Parameter 2: reduce (also collector)
                /*
                    Map
                    Key -> Value
                    Sam -> 2
                    Tom -> 2
                    Rene -> 1
                */
                .collect(Collectors.groupingBy(x -> x, Collectors.counting())) // groupingBy(map("Ivi" -> "Ivi"), count("Ivi"))
                .entrySet()//Set von key-value pair objekten. Set( {key: Jakub, value: 1}, {key: Ivi, value: 2} )
                .stream()
                .filter(x -> x.getValue() > 1) //Set({key: Ivi, value: 2})
                .map(x -> x.getKey())// "Ivi"
                .collect(Collectors.toList());


    }

    // 8.1.4
    public static List<Map.Entry<String, Long>> teamsWithBestScoringPlayers(List<Player> players) {
        return players.stream()
                .collect(Collectors.groupingBy(x -> x.team, Collectors.counting()))
                .entrySet() //Set({key: Stal Mielec ,value: 1}, {key: Lechia Gdansk, value: 2}, ...)
                .stream()
                .filter(x -> x.getValue() >= 2)
                // sort in descending order by value
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) //Map.Entry gibt (key-value pairs)
                .collect(Collectors.toList());
    }

    // 8.1.5
    public static Map.Entry<String, Integer> bestScoringTeam(List<Player> players) {
        return players.stream()
                .collect(Collectors.toMap(
                        p -> p.team, //key
                        p -> p.goals, //values (p1: 6, p2: 4) --> value: 10
                        (x,y) -> x + y // wenn key mehrmals vorkommt, dann werden die values nach dieser regel kombiniert
                ))
                .entrySet().stream()
                .reduce((acc, next) -> acc.getValue() > next.getValue() ? acc : next).orElse(null);
    }
}