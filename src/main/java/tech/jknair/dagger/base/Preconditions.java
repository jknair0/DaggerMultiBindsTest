package tech.jknair.dagger.base;

public class Preconditions {

    public static void checkNotNull(Object object) {
        if (object == null) throw new IllegalStateException("Check failed. Null object");
        System.out.println("check passed not null : " + object.getClass().getSimpleName());
    }

}
