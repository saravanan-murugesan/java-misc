
interface I{
    I pickOne(I i1, I i2);
}

class A implements I {
    @Override
    public I pickOne(I i1, I i2) {
        return i1;
    }
}

class B implements I {
    @Override
    public I pickOne(I i1, I i2) {
        return i2;
    }
}

class C implements I {
    @Override
    public I pickOne(I i1, I i2) {
        return this;
    }
}