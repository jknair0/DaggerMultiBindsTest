package tech.jknair.dagger;

import tech.jknair.dagger.splash.SplashActivity;

public class Main {

    public static AppComponent appComponent;

    public static void main(String[] args) {
        appComponent = DaggerAppComponent.create();
        new SplashActivity().check();
    }

}
