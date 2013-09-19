/*
 * Copyright 2013 SatoShun
 *
 * Builder Pattern
 */

package sample.design_pattern;


class Director {
    private ConcreateBuilder builder;

    public Director(ConcreateBuilder builder) {
        this.builder = builder;
    }

    public String create() {
        builder.prepare(11);
        builder.execute("hogehoge");
        return builder.getBuilderResult();
    }
}


abstract class IBuilder {
    abstract protected void prepare(int count);
    abstract protected void execute(String s);
    abstract protected String getBuilderResult();
}


class ConcreateBuilder extends IBuilder {
    private StringBuilder sb;
    private int count;

    public ConcreateBuilder() {
        sb = new StringBuilder();
        count = 0;
    }

    @Override
    protected void prepare(int count) {
        this.count = count;
    }

    @Override
    protected void execute(String s) {
        for (int i = 0; i < count; i++) {
            sb.append(s + "\n");
        }
    }

    @Override
    protected String getBuilderResult() {
        return new String(sb);
    }
}


class Builder {
    public static void main(String[] args) {
        Director director = new Director(new ConcreateBuilder());

        System.out.println(director.create());
    }
}
