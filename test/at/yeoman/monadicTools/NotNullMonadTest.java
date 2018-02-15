package at.yeoman.monadicTools;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static at.yeoman.monadicTools.NotNullMonad.unit;

class NotNullMonadTest {
    @Test
    void zeroStepsToZero() {
        Assertions.assertNull(unit(null).get());
    }

    @Test
    void oneStepToNull() {
        A a = new A();

        Assertions.assertNotNull(unit(a)
                .get());

        Assertions.assertNull(unit(a)
                .bind(value -> unit(value.getB()))
                .get());
    }

    @Test
    void twoStepsToNull() {
        A a = new A(new B());

        Assertions.assertNotNull(unit(a)
                .get());

        Assertions.assertNotNull(unit(a)
                .bind(value -> unit(value.getB()))
                .get());

        Assertions.assertNull(unit(a)
                .bind(value -> unit(value.getB()))
                .bind(value -> unit(value.getC()))
                .get());
    }

    @Test
    void threeStepsToNull() {
        A a = new A(new B(new C()));

        Assertions.assertNotNull(unit(a)
                .get());

        Assertions.assertNotNull(unit(a)
                .bind(value -> unit(value.getB()))
                .get());

        Assertions.assertNotNull(unit(a)
                .bind(value -> unit(value.getB()))
                .bind(value -> unit(value.getC()))
                .get());

        Assertions.assertNull(unit(a)
                .bind(value -> unit(value.getB()))
                .bind(value -> unit(value.getC()))
                .bind(value -> unit(value.getName()))
                .get());
    }

    @Test
    void fourStepsToValue() {
        A a = new A(new B(new C("name")));

        Assertions.assertNotNull(unit(a)
                .get());

        Assertions.assertNotNull(unit(a)
                .bind(value -> unit(value.getB()))
                .get());

        Assertions.assertNotNull(unit(a)
                .bind(value -> unit(value.getB()))
                .bind(value -> unit(value.getC()))
                .get());

        Assertions.assertEquals("name", unit(a)
                .bind(value -> unit(value.getB()))
                .bind(value -> unit(value.getC()))
                .bind(value -> unit(value.getName()))
                .get());
    }
}
