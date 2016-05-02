interface AC {
    AB g(int z);
}

interface AB {
    int f(int x);
}

/*
 Is this closure? Why does the compiler does not complain about 'd' being non-final?
 */
class ClosureTest {

    AC ac1 = new AC() {
        @Override
        public AB g(int y) {
            int c = 10;
            return new AB() {
                @Override
                public int f(int x) {
                    return c+x+y;
                }
            };
        }
    };

    public void defineInnerClass() {
        for(int i=0; i<10; i++) {
            final int j =i;
            class MyLocalInnerClass {
                public void doSomething() {
                    System.out.println(j);
                }
            }
        }
    }

    public static void main(String[] args) {
        ClosureTest st = new ClosureTest();
AB test = st.ac1.g(5);
        System.out.println(test.f(10));
    }

}

