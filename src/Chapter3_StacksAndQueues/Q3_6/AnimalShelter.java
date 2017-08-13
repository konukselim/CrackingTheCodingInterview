package Chapter3_StacksAndQueues.Q3_6;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Created by selimkonuk on 12/08/2017.
 */
public class AnimalShelter {

    LinkedList<Animal> shelter;

    public AnimalShelter(){
        shelter = new LinkedList<>();
    }

    public void enqueue(Animal a){
        shelter.add(a);
    }

    public Animal dequeueAny(){
        if (shelter.isEmpty()){
            throw new NoSuchElementException();
        }

        Animal a = shelter.removeFirst();
        return a;
    }

    public Animal dequeueDog(){
        if (shelter.isEmpty()){
            throw new NoSuchElementException();
        }

        Dog dog = null;
        for (Animal a: shelter){
            if (a.getClass() == Dog.class){
                dog = (Dog) a;
                shelter.remove(a);
                break;
            }
        }

        if (dog == null){
            throw new NoSuchElementException();
        }
        return dog;
    }

    public Animal dequeueCat(){
        if (shelter.isEmpty()){
            throw new NoSuchElementException();
        }

        Cat cat = null;
        for (Animal a: shelter){
            if (a.getClass() == Cat.class){
                cat = (Cat) a;
                shelter.remove(a);
                break;
            }
        }

        if (cat == null){
            throw new NoSuchElementException();
        }
        return cat;
    }
}
