package com.basictest.jihe.set;

/**
 * Created in 2021/2/22 17:02
 *
 * @description:
 * @Author: huxingxin
 */
class A {
    @Override
    public boolean equals(Object obj) {
        return true;
    }

    @Override
    public String toString() {
        return "A"+hashCode();
    }

}

class B {
    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return "B"+hashCode();
    }
}

class C {
    @Override
    public boolean equals(Object obj) {
        return true;
    }

    @Override
    public int hashCode() {
        return 2;
    }

    @Override
    public String toString() {
        return "C"+hashCode();
    }
}

