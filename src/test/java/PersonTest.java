import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @Test
    void addParentsTest() {
        // Arrange
        Person father = new Person("Wilbert", "Testemans", 66, 'M');
        Person mother = new Person("Tina", "Testemans", 64, 'V');
        Person child = new Person("Theo", "Testemans", 32, 'M');

        // Act
        child.addParents(child, father, mother);

        // Assert
        assertEquals("Wilbert", child.getFather().getName());
        assertEquals("Tina", child.getMother().getName());
    }

    @Test
    void addChildTest() {
        // Arrange
        Person father = new Person("Wilbert", "Testemans", 66, 'M');
        Person mother = new Person("Tina", "Testemans", 64, 'V');
        Person child = new Person("Theo", "Testemans", 32, 'M');
        List<Person> children = new ArrayList<>();

        // Act
        father.addChild(father, child);
        mother.addChild(mother, child);
        children.add(child);

        // Assert
        assertEquals(children, father.getChildren());
        assertEquals(children, mother.getChildren());
    }

    @Test
    void addPetTest() {
        // Arrange
        Person person = new Person("Theo", "Testemans", 32, 'M');
        Pet rabbit = new Pet("Wollie", 3, "Rabbit");
        Pet cat = new Pet("Miauw", 3, "Cat");
        List<Pet> animals = new ArrayList<>();

        // Act
        animals.add(rabbit);
        animals.add(cat);
        person.addPet(person, rabbit);
        person.addPet(person, cat);

        // Assert
        assertEquals(animals, person.getPets());
    }

    @Test
    void addSiblingTest() {
        // Arrange
        Person person1 = new Person("Theo", "Testemans", 32, 'M');
        Person person2 = new Person("Thea", "Testemans", 32, 'V');
        Person person3 = new Person("Drea", "Testemans", 32, 'V');
        List<Person> siblings = new ArrayList<>();

        // Act
        siblings.add(person2);
        siblings.add(person3);
        person1.addSibling(person1, person2);
        person1.addSibling(person1, person3);

        // Assert
        assertEquals(siblings, person1.getSiblings());
    }

    @Test
    void getGrandChildrenTest() {
        // Arrange
        Person person1 = new Person("Wilbert", "Testemans", 66, 'M');
        Person person2 = new Person("Tina", "Testemans", 64, 'V');
        Person person3 = new Person("Theo", "Testemans", 32, 'M');
        Person person4 = new Person("Wilma", "Testemans", 32, 'M');
        Person person5 = new Person("Theootje", "Testemans", 2, 'M');
        Person person6 = new Person("Wilmaatje", "Testemans", 1, 'V');
        List<Person> grandChildren = new ArrayList<>();

        // Act
        grandChildren.add(person5);
        grandChildren.add(person6);
        person3.addParents(person3, person1, person2);
        person5.addParents(person5, person3, person4);
        person6.addParents(person6, person3, person4);

        // Assert
        assertEquals(grandChildren, person1.getGrandChildren(person1));
        assertEquals(grandChildren, person2.getGrandChildren(person2));
        assertTrue(person3.getGrandChildren(person3).isEmpty());
    }

    @Test
    void getNameTest() {
        // Arrange
        Person person = new Person("Theo", "Testemans", 32, 'M');

        // Act
        String name = person.getName();

        // Assert
        assertEquals("Theo", name);
    }

    @Test
    void setNameTest() {
        // Arrange
        Person person = new Person("Theo", "Testemans", 32, 'M');

        // Act
        person.setName("Wilbert");

        // Assert
        assertEquals("Wilbert", person.getName());
    }

    @Test
    void getMiddleNameTest() {
        // Arrange
        Person person = new Person("Theo", "Testemans", 32, 'M');

        // Act
        String middleName = person.getMiddleName();

        // Assert
        assertNull(middleName);
    }

    @Test
    void setMiddleNameTest() {
        // Arrange
        Person person = new Person("Theo", "Testemans", 32, 'M');

        // Act
        person.setMiddleName("von");

        // Assert
        assertEquals("von", person.getMiddleName());
    }

    @Test
    void getLastNameTest() {
        // Arrange
        Person person = new Person("Theo", "Testemans", 32, 'M');

        // Act
        String lastName = person.getLastName();

        // Assert
        assertEquals("Testemans", lastName);
    }

    @Test
    void setLastNameTest() {
        // Arrange
        Person person = new Person("Theo", "Testemans", 32, 'M');

        // Act
        person.setLastName("Wilbertussemans");

        // Assert
        assertEquals("Wilbertussemans", person.getLastName());
    }

    @Test
    void getSexTest() {
        // Arrange
        Person person = new Person("Theo", "Testemans", 32, 'M');

        // Act
        Character sex = person.getSex();

        // Assert
        assertEquals('M', sex);
    }

    @Test
    void setSexTest() {
        // Arrange
        Person person = new Person("Theo", "Testemans", 32, 'M');

        // Act
        person.setSex('V');

        // Assert
        assertEquals('V', person.getSex());
    }

    @Test
    void getAgeTest() {
        // Arrange
        Person person = new Person("Theo", "Testemans", 32, 'M');

        // Act
        int age = person.getAge();

        // Assert
        assertEquals(32, age);
    }

    @Test
    void setAgeTest() {
        // Arrange
        Person person = new Person("Theo", "Testemans", 32, 'M');

        // Act
        person.setAge(33);

        // Assert
        assertEquals(33, person.getAge());
    }

    @Test
    void getMotherTest() {
        // Arrange
        Person child = new Person("Theo", "Testemans", 32, 'M');
        Person mother = new Person("Tina", "Testemans", 64, 'V');

        // Act
        child.setMother(mother);
        String checkMother = child.getMother().getName();

        // Assert
        assertEquals("Tina", checkMother);
    }

    @Test
    void setMotherTest() {
        // Arrange
        Person child = new Person("Theo", "Testemans", 32, 'M');
        Person mother = new Person("Tina", "Testemans", 64, 'V');

        // Act
        child.setMother(mother);

        // Assert
        assertEquals("Tina", child.getMother().getName());
    }

    @Test
    void getFatherTest() {
        // Arrange
        Person child = new Person("Theo", "Testemans", 32, 'M');
        Person father = new Person("Wilbert", "Testemans", 66, 'M');

        // Act
        child.setFather(father);
        String checkFather = child.getFather().getName();

        // Assert
        assertEquals("Wilbert", checkFather);
    }

    @Test
    void setFatherTest() {
        // Arrange
        Person child = new Person("Theo", "Testemans", 32, 'M');
        Person father = new Person("Wilbert", "Testemans", 66, 'M');

        // Act
        child.setFather(father);

        // Assert
        assertEquals(father.getName(), child.getFather().getName());
    }

    @Test
    void getSiblingsTest() {
        // Arrange
        Person person = new Person("Theo", "Testemans", 32, 'M');
        Person person2 = new Person("Thea", "Testemans", 32, 'V');
        Person person3 = new Person("Drea", "Testemans", 32, 'V');
        List<Person> siblings = new ArrayList<>();

        // Act
        person.addSibling(person, person2);
        person.addSibling(person, person3);
        for (Person sibling : person.getSiblings()) {
            siblings.add(sibling);
        }

        // Assert
        assertEquals(siblings, person.getSiblings());
    }

    @Test
    void setSiblingsTest() {
        // Arrange
        Person person = new Person("Theo", "Testemans", 32, 'M');
        Person person2 = new Person("Thea", "Testemans", 32, 'V');
        Person person3 = new Person("Drea", "Testemans", 32, 'V');
        List<Person> siblings = new ArrayList<>();

        // Act
        siblings.add(person2);
        siblings.add(person3);
        person.setSiblings(siblings);

        // Assert
        assertEquals(siblings, person.getSiblings());
    }

    @Test
    void getChildrenTest() {
        // Arrange
        Person father = new Person("Wilbert", "Testemans", 66, 'M');
        Person child1 = new Person("Theo", "Testemans", 32, 'M');
        Person child2 = new Person("Thea", "Testemans", 32, 'V');
        Person child3 = new Person("Drea", "Testemans", 32, 'V');
        List<Person> children = new ArrayList<>();

        // Act
        children.add(child1);
        children.add(child2);
        children.add(child3);
        father.setChildren(children);
        List<Person> testChildren = father.getChildren();

        // Assert
        assertEquals(children, testChildren);
    }

    @Test
    void setChildrenTest() {
        // Arrange
        Person father = new Person("Wilbert", "Testemans", 66, 'M');
        Person child1 = new Person("Theo", "Testemans", 32, 'M');
        Person child2 = new Person("Thea", "Testemans", 32, 'V');
        Person child3 = new Person("Drea", "Testemans", 32, 'V');
        List<Person> children = new ArrayList<>();

        // Act
        children.add(child1);
        children.add(child2);
        children.add(child3);
        father.setChildren(children);

        // Assert
        assertEquals(children, father.getChildren());
    }

    @Test
    void getPetsTest() {
        // Arrange
        Person person = new Person("Theo", "Testemans", 32, 'M');
        Pet rabbit = new Pet("Wollie", 3, "Rabbit");
        List<Pet> animals = new ArrayList<>();


        // Act
        animals.add(rabbit);
        person.setPets(animals);
        List<Pet> checkAnimals = person.getPets();

        // Assert
        assertEquals(animals, checkAnimals);
    }

    @Test
    void setPetsTest() {
        // Arrange
        Person person = new Person("Theo", "Testemans", 32, 'M');
        Pet rabbit = new Pet("Wollie", 3, "Rabbit");
        List<Pet> animals = new ArrayList<>();

        // Act
        animals.add(rabbit);
        person.setPets(animals);

        // Assert
        assertEquals(animals, person.getPets());
    }
}