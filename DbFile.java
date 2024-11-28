public interface DbFile<T>{
    abstract public T buildObject(String line);
    abstract public String buildString(T data);
}