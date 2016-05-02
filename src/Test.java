public class Test {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A();
        A a3 = new A();
        B b1 = new B();
        B b2 = new B();
        B b3 = new B();
        GenericConsumer consumer = new GenericConsumer();
        consumer.add(a1,a2,a3);
        consumer.add(b1,b2,b3);
    }
}
