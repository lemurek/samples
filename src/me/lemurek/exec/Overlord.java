package me.lemurek.exec;

import java.util.Collection;

public class Overlord implements Runnable {

    private Collection<LazyAss> slaves;

    public Overlord(Collection<LazyAss> slaves) {
        this.slaves = slaves;
    }

    @Override
    public void run() {
        slaves.forEach(Pushable::slap);
    }
}
