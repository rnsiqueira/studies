package java21;


import java.util.*;

/**
 * This class contains methods that shows the changes introduced to add
 * Sequenced Collections in JDK 21.
 */
public class SequencedCollectionsExamples {

    public static void main(String[] args) {

        retrieveFirstLastListBefore21();
        retrieveFirstLastLinkedHashSetBefore21();
        retrieveFirstLastTreeSetBefore21();

        removeFirstLastFromTreeSetBefore21();
        removeFirstLastFromLinkedHashSetBefore21();

        listInReverseBefore21();
        linkedHashSetInReverseBefore21();

        retrieveFirstLastListFrom21();
        retrieveFirstLastLinkedHashSetFrom21();
        removeFirstLastFromLinkedHashSetFrom21();

        listInReverseFrom21();
        linkedHashSetInReverseFrom21();
    }

    public static void linkedHashSetInReverseBefore21() {
        var linkedHashSet = new LinkedHashSet<String>();

        linkedHashSet.add("football");
        linkedHashSet.add("basketball");
        linkedHashSet.add("cricket");
        linkedHashSet.add("baseball");

        var linkedList = new LinkedList<>(linkedHashSet);
        Iterator<String> itr = linkedList.descendingIterator();
        System.out.println("Reverse order in LinkedHashSet: ");
        while(itr.hasNext()) {
            String game = itr.next();
            System.out.println(game);
        }
    }

    public static void linkedHashSetInReverseFrom21() {
        var linkedHashSet = new LinkedHashSet<String>();

        linkedHashSet.add("football");
        linkedHashSet.add("basketball");
        linkedHashSet.add("cricket");
        linkedHashSet.add("baseball");

        var reversedSetView = linkedHashSet.reversed();
        System.out.println("Set : " + linkedHashSet);
        System.out.println("Reversed Set View : " + reversedSetView);
    }

    public static void listInReverseBefore21() {
        System.out.println("Reverse order in List: ");
        var list = List.of("football","basketball","cricket","baseball");
        for(var it = list.listIterator(list.size());it.hasPrevious();){
            String game = it.previous();
            System.out.println(game);
        }
    }

    public static void listInReverseFrom21() {
        System.out.println("Reverse order in List: ");
        var list = List.of("football","basketball","cricket","baseball");
        var reversedList = list.reversed();
        System.out.println("List contents : "+ list);
        System.out.println("Reversed list view : "+ reversedList);
    }

    public static void removeFirstLastFromLinkedHashSetBefore21() {
        var linkedHashSet = new LinkedHashSet<String>();

        linkedHashSet.add("football");
        linkedHashSet.add("basketball");
        linkedHashSet.add("cricket");
        linkedHashSet.add("baseball");

        Iterator<String> it = linkedHashSet.iterator();
        if (it.hasNext()) {
            it.next();
            it.remove();
            System.out.println("Removed the first element from LinkedHashSet");
        } else {
            System.out.println("LinkedHashSet is empty");
        }
        System.out.println("LinkedHashSet after removing first element: "+linkedHashSet);
    }

    public static void removeFirstLastFromLinkedHashSetFrom21() {
        var linkedHashSet = new LinkedHashSet<String>();

        linkedHashSet.add("football");
        linkedHashSet.add("basketball");
        linkedHashSet.add("cricket");
        linkedHashSet.add("baseball");

        String first = linkedHashSet.removeFirst();
        String last = linkedHashSet.removeLast();
        System.out.printf("Removed %s %s from LinkedHashSet%n",first,last);
        System.out.println("LinkedHashSet after removing first and last element: "+linkedHashSet);
    }

    public static void removeFirstLastFromTreeSetBefore21() {
        var treeSet = new TreeSet<String>();
        treeSet.add("football");
        treeSet.add("basketball");
        treeSet.add("cricket");
        treeSet.add("baseball");

        String firstElement = treeSet.pollFirst();
        if (firstElement != null) {
            System.out.println("Removed the first element: " + firstElement);
        } else {
            System.out.println("The set is empty.");
        }

        // Remove the last element
        String lastElement = treeSet.pollLast();
        if (lastElement != null) {
            System.out.println("Removed the last element: " + lastElement);
        } else {
            System.out.println("The set is empty.");
        }

        // Print the modified TreeSet
        System.out.println("Modified TreeSet: " + treeSet);
    }

    public static void retrieveFirstLastListBefore21() {
        var list = List.of("football","basketball","cricket","baseball");
        String first = list.get(0);
        String last = list.get(list.size() -1);

        list.remove(0);
        list.remove(list.size()-1);

        System.out.println("First element in List: " + first);
        System.out.println("Last element in List: " + last);
    }

    public static void retrieveFirstLastListFrom21() {
        var list = List.of("football","basketball","cricket","baseball");
        String first = list.getFirst();
        String last = list.getLast();

        list.removeFirst();
        list.removeLast();

        System.out.println("First element in List: " + first);
        System.out.println("Last element in List: " + last);
    }

    public static void retrieveFirstLastTreeSetBefore21() {
        var set = new TreeSet<String>();
        set.add("football");
        set.add("basketball");
        set.add("cricket");
        set.add("baseball");

        String first = set.first();
        String last = set.last();

        System.out.println("First element in TreeSet: " + first);
        System.out.println("Last element in TreeSet: " + last);
    }

    public static void retrieveFirstLastLinkedHashSetBefore21() {

        var linkedHashSet = new LinkedHashSet<String>();

        linkedHashSet.add("football");
        linkedHashSet.add("basketball");
        linkedHashSet.add("cricket");
        linkedHashSet.add("baseball");

        Iterator<String> iterator = linkedHashSet.iterator();

        String first = iterator.hasNext() ? iterator.next() : null;

        String last = null;
        while(iterator.hasNext()){
            last = iterator.next();
        }
        System.out.println("First element in LinkedHashSet: " + first);
        System.out.println("Last element in LinkedHashSet: " + last);
    }

    public static void retrieveFirstLastLinkedHashSetFrom21() {

        var linkedHashSet = new LinkedHashSet<String>();

        linkedHashSet.add("football");
        linkedHashSet.add("basketball");
        linkedHashSet.add("cricket");
        linkedHashSet.add("baseball");

        String first = linkedHashSet.getFirst();
        String last = linkedHashSet.getLast();

        System.out.println("First element in LinkedHashSet: " + first);
        System.out.println("Last element in LinkedHashSet: " + last);
    }

    public static void retrieveFirstLastSortedSet() {
        var set = new TreeSet<String>();
        set.add("football");
        set.add("basketball");
        set.add("cricket");
        set.add("baseball");

        String first = set.getFirst();
        String last = set.getLast();

        System.out.println("First element in TreeSet: " + first);
        System.out.println("Last element in TreeSet: " + last);
    }


}
