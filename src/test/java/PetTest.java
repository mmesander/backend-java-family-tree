import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class PetTest {
    @Test
    void getNameTest() {
        // Arrange
        Pet rabbit = new Pet("Wollie", 3, "Rabbit");

        // Act
        String name = rabbit.getName();

        // Assert
        assertEquals("Wollie", name);
    }

    @Test
    void setNameTest(){
        // Arrange
        Pet rabbit = new Pet("Wollie", 3, "Rabbit");

        // Act
        rabbit.setName("Wilbert");

        // Assert
        assertEquals("Wilbert", rabbit.getName());
    }

    @Test
    void getAgeTest(){
        // Arrange
        Pet rabbit = new Pet("Wollie", 3, "Rabbit");

        // Act
        int age = rabbit.getAge();

        // Assert
        assertEquals(3, rabbit.getAge());
    }

    @Test
    void setAgeTest(){
        // Arrange
        Pet rabbit = new Pet("Wollie", 3, "Rabbit");

        // Act
        rabbit.setAge(4);

        // Assert
        assertEquals(4, rabbit.getAge());
    }

    @Test
    void getSpeciesTest(){
        // Arrange
        Pet rabbit = new Pet("Wollie", 3, "Rabbit");

        // Act
        String species = rabbit.getSpecies();

        // Assert
        assertEquals("Rabbit", species);
    }

    @Test
    void setSpeciesTest(){
        // Arrange
        Pet rabbit = new Pet("Wollie", 3, "Rabbit");

        // Act
        rabbit.setSpecies("Draak");

        // Assert
        assertEquals("Draak", rabbit.getSpecies());
    }

    @Test
    void getOwnerTest(){
        // Arrange
        Pet rabbit = new Pet("Wollie", 3, "Rabbit");

        // Act
        Person owner = rabbit.getOwner();

        // Assert
        assertNull(rabbit.getOwner());
    }

    @Test
    void setOwnerTest(){
        // Arrange
        Pet rabbit = new Pet("Wollie", 3, "Rabbit");
        Person emeraude = new Person("Emeraude", "Mesander", 33, 'V');

        // Act
        rabbit.setOwner(emeraude);

        // Assert
        assertEquals("Emeraude", rabbit.getOwner().getName());
    }
}