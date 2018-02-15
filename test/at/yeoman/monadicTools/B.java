package at.yeoman.monadicTools;

class B {
    private C c;

    B() {
    }

    B(C c) {
        this.c = c;
    }

    C getC() {
        return c;
    }

    void setC(C c) {
        this.c = c;
    }
}
