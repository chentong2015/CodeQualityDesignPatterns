package design_patterns.pattern1_creation.builder.core;

public class Student extends People {

    private String school;

    // 这里应该设置成private，防止外部直接构建对象，而不是通过builder
    private Student(Builder builder) {
        super(builder);
        this.school = builder.school;
    }

    // Builder类型的继承，重写父类Builder中定义的方法
    public static class Builder extends People.Builder<Builder> {

        private String school;

        public Builder school(String school) {
            this.school = school;
            return this;
        }

        @Override
        public Builder getThis() {
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

    // 返回一个Builder的实例，用于构造Student的对象
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return super.toString() + ", school: " + this.school;
    }
}
