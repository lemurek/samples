package me.lemurek.exec;

import java.util.Random;

public class LazyAss implements Runnable, Pushable {

    final Random r;
    final int name;
    int working;

    public LazyAss(int name) {
        this.name = name;
        this.r = new Random(System.currentTimeMillis());
    }

    @Override
    public void run() {
        working = r.nextInt(10);
        System.out.println(name + " Hi there. I'll be working hard for " + working + " seconds");
        synchronized(this) {
            try {
                Thread.sleep(working * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(name + " I'm done!");
                working = 0;
            }
        }

    }

    @Override
    public void slap() {
        if (working > 0) {
            System.out.println(name + " I'm working hard!");
        } else {
            System.out.println(name + " Take it easy man!");
        }
    }
}
