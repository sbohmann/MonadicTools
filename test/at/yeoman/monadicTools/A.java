package at.yeoman.monadicTools;

class A {
    private B b;

    A() {
    }

    A(B b) {
        this.b = b;
    }

    B getB() {
        return b;
    }

    void setB(B b) {
        this.b = b;
    }
}
