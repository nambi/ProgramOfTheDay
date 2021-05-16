package org.nava.year21.may;

public final class Singleton {

    private static Singleton _instance = null;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (_instance == null) {
            synchronized (Singleton.class) {
                _instance = new Singleton();
            }
        }
        return _instance;
    }

    private static class SingletonInstance {
        public static final Singleton instance = new Singleton();
    }

    public static void main(String[] args) {

        Runnable r = new Runnable() {
            @Override
            public void run() {
                Singleton s1 = Singleton.getInstance();
                System.out.println(Thread.currentThread().getName()+"-"+s1);
            }
        };
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(r);
            t.setName("T"+i);
            t.start();
        }

        System.out.println("-------------------");
        for (int i = 0; i < 10; i++) {
            Singleton s1 = SingletonInstance.instance;
            System.out.println(s1);
        }
    }

}
