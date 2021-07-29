package com.asm;

import java.util.Map;
import java.util.stream.*;
import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;

public class Student {
    public static void main(String[] args) {
        var studs = new ArrayList<Stud>(List.of(    // mutable, resizable
                new Stud("B1", 1, 85), new Stud("A2", 2, 80),
                new Stud("B1", 3, 90), new Stud("C1", 4, 80),
                new Stud("A4", 5, 77)));
        studs.add(new Stud("D", 6, 88));

        System.out.println("\tInput : Students");
        studs.forEach(System.out::println);

        Map<String, List<Stud>> studByName =
                studs.stream()
                        .collect(Collectors.groupingBy(Stud::getName));

        /*      studByName : Map<String, List<Stud>>
         *  < Key  :   Value >
         *  <"A2"  :  ["A2",2,80]
         *   "A4"  :  ["A4",5,77]
         *   "D"   :  ["D", 6,88]
         *   "C1"  :  ["C1",4,80]
         *   "B1"  :  ["B1",1,85]  ["B1",3,90]
         */

        System.out.print("\n\t<Key : Values> of studByName");
        for (String k : studByName.keySet()) {
            System.out.println("\n[" + k + "]");
            studByName.get(k).forEach(System.out::println); // List<Stud>
        }

        Map<Integer, List<Stud>> studByScore =
                studs.stream()
                        .collect(Collectors.groupingBy(Stud::getScore));

        /*      studByScore : Map<Integer, List<Stud>>
         *  < Key  :   Value >
         *  < 80  :  ["A2",2,80] ["C1",4,80]
         *    85  :  ["B1",1,85]
         *    88  :  ["D", 1,88]
         *    90  :  ["B1",1,90]
         *    77  :  ["A4",5,77]
         */

        System.out.print("\n\t<Key : Values> of studByScore");
        for (Integer k : studByScore.keySet()) {
            System.out.println("\n[" + k + "]");
            studByScore.get(k).forEach(System.out::println);
        }

        System.out.println("\n\tKeys of studByScore");
        studByScore.keySet().forEach(x -> System.out.print(x + " "));

        System.out.println("\n\n\tValues of studByScore : List<List<Stud>>");
        // List<List<Stud>> : studByScore.values()
        for (List<Stud> listStud : studByScore.values()) {
            listStud.forEach(System.out::println);
            System.out.println();
        }

        System.out.println("\n\tSorted by Score");
        Collections.sort(studs, Comparator.comparing(Stud::getScore));
        studs.forEach(System.out::println);

        System.out.println("\n\tSorted by id");
        // Collections.sort(studs, Comparator.comparing(Stud::getId));
        studs.sort(Comparator.comparing(Stud::getId));
        studs.forEach(System.out::println);

        System.out.println("\n\tSorted by name");
        studs.sort(Comparator.comparing(Stud::getName));
        studs.forEach(System.out::println);

        System.out.println("\n\tSorted by Score Using Lambda");
        studs.sort((s1, s2) -> {
            if (s1.getScore() == s2.getScore()) return 0;
            return (s1.getScore() > s2.getScore()) ? 1 : -1;
        });
        studs.forEach(System.out::println);

    }
}
