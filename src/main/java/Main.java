public class Main {
    public static void main(String[] args) {
        Person mark = new Person("Mark", "Mesander", 32, 'M');
        Person emeraude = new Person("Emeraude", "van", "Deenen", 33, 'V');
        Person paul = new Person("Paul", "Mesander", 34, 'M');
        Person eva = new Person("Eva", "Ireland", 34, 'V');
        Person lisa = new Person("Lisa", "Mesander", 30, 'V');
        Person frank = new Person("Frank", "Mesander", 60, 'M');
        Person sonja = new Person("Sonja", "Geelhoed", 60, 'V');
        Person james = new Person("James", "Mesander", 4, 'M');
        Person owen = new Person("Owen", "Mesander", 1, 'M');


        mark.addParents(mark, frank, sonja);
        mark.addSibling(mark, paul);
        mark.addSibling(mark, lisa);

        paul.addParents(paul, frank, sonja);
        paul.addSibling(paul, mark);
        paul.addSibling(paul, lisa);

        lisa.addParents(lisa, frank, sonja);
        lisa.addSibling(lisa, paul);
        lisa.addSibling(lisa, mark);

        james.addParents(james, paul, eva);
        james.addSibling(james, owen);

        owen.addParents(owen, paul, eva);
        owen.addSibling(owen, james);

        for (Person grandChild : sonja.getGrandChildren(sonja)) {
            System.out.println(grandChild.getName());
        }

        for (Person grandChild : frank.getGrandChildren(frank)) {
            System.out.println(grandChild.getName());
        }
    }
}
