package linked_lists;

public class TestLinkedLists {
    private TestLinkedLists() {}
    public static void run() {
        System.out.println();
        System.out.println("=============================================");
        System.out.println("                 LINKED LISTS                ");
        System.out.println("=============================================");

        AppendToList.test();
        DeleteFromList.test();
        InsertInList.test();
        KthToLastInList.test();
        ListHasCycle.test();
        RemoveDupsFromList.test();
        ReverseList.test();
    }
}