package com.jchampionsconf;

import java.io.Serializable;

public record SpiderHero<T>(T gadget, String name, String city) {

    public SpiderHero {
        if (!(gadget instanceof Serializable)) {
            throw new RuntimeException("Gadget must be Serializable");
        }
    }

    public boolean equals(Object obj) {
        return this.gadget == ((SpiderHero<?>) obj).gadget;
    }

    public static void main() {
        record NewGadget(String gadgetName) implements Serializable {}
        SpiderHero<String> spiderHero1 = new SpiderHero<>("Web Shooter", "Peter Parker", "New York");
        var spiderHero2 = new SpiderHero<>(new NewGadget("Web Shooter"), "Miles Morales", "Brooklyn");

        System.out.println(spiderHero1.equals(spiderHero2));
        System.out.println(spiderHero2.gadget());
    }
}
