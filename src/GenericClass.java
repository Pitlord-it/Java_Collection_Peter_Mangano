public class GenericClass<T> {

    
    private T input;

    public GenericClass(T input) {
        this.input = input;
    }

    public T getInput() {
        return input;
    }

    public void setInput(T input) {
        this.input = input;
    }


}
