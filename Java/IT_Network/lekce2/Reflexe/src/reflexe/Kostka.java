package reflexe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Random;

public class Kostka {

    private Random random;
    private int pocetSten;

    public Kostka() {
        this.pocetSten = 6;
        random = new Random();
    }

    public Kostka(int pocetSten) {
        this.pocetSten = pocetSten;
        random = new Random();
    }

    public int vratPocetSten() {
        return pocetSten;
    }

    public int hod() {
        return random.nextInt(pocetSten + 1) + 1;
    }

    @Override
    public String toString() {
        return String.format("Kostka s %s stěnami", pocetSten);
    }

    public static void main(String[] args) {
        System.out.println("Název třídy: " + Kostka.class.getName());
        System.out.println("----- Konstruktory třídy ------");
        final Constructor<?>[] constructors = Kostka.class.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("\t Název: " + constructor.getName());
            System.out.println("\t\t Parametry konstruktoru: " + Arrays.toString(constructor.getParameterTypes()));
        }
        System.out.println();
        System.out.println("------- Atributy třídy --------");
        final Field[] fields = Kostka.class.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("\t Název: " + field.getName());
            final int modifier = field.getModifiers();
            System.out.println("\t\t Modifiers.isPublic: " + Modifier.isPublic(modifier));
            System.out.println("\t\t Modifiers.isPrivate: " + Modifier.isPrivate(modifier));
            System.out.println("\t\t Modifiers.isProtected: " + Modifier.isProtected(modifier));
            System.out.println("\t\t Modifiers.isStatic: " + Modifier.isStatic(modifier));
            System.out.println("\t\t Modifiers.isFinal: " + Modifier.isFinal(modifier));
            System.out.println("\t\t Modifiers.isSynchronized: " + Modifier.isSynchronized(modifier));
            System.out.println("\t\t Modifiers.isVolatile: " + Modifier.isVolatile(modifier));
            System.out.println("\t\t Modifiers.isTransient: " + Modifier.isTransient(modifier));
            System.out.println("\t\t Modifiers.isNative: " + Modifier.isNative(modifier));
            System.out.println("\t\t Modifiers.isAbstract: " + Modifier.isAbstract(modifier));
        }
        final Method[] methods = Kostka.class.getDeclaredMethods();
        System.out.println("Declared methods: " + Arrays.asList(methods));
        System.out.println("Methods: " + Arrays.asList(Kostka.class.getMethods()));
        for (Method method : methods) {
            System.out.println("\t Název: " + method.getName());
            final int modifier = method.getModifiers();
            System.out.println("\t\t Modifiers.isPublic: " + Modifier.isPublic(modifier));
            System.out.println("\t\t Modifiers.isPrivate: " + Modifier.isPrivate(modifier));
            System.out.println("\t\t Modifiers.isProtected: " + Modifier.isProtected(modifier));
            System.out.println("\t\t Modifiers.isStatic: " + Modifier.isStatic(modifier));
            System.out.println("\t\t Modifiers.isFinal: " + Modifier.isFinal(modifier));
            System.out.println("\t\t Modifiers.isSynchronized: " + Modifier.isSynchronized(modifier));
            System.out.println("\t\t Modifiers.isVolatile: " + Modifier.isVolatile(modifier));
            System.out.println("\t\t Modifiers.isTransient: " + Modifier.isTransient(modifier));
            System.out.println("\t\t Modifiers.isNative: " + Modifier.isNative(modifier));
            System.out.println("\t\t Modifiers.isAbstract: " + Modifier.isAbstract(modifier));
            System.out.println("\t\t Parametry: " + Arrays.toString(method.getParameterTypes()));
            System.out.println("\t\t Návratový typ: " + method.getReturnType());
        }
    }
}
