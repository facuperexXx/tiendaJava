package serializadores;

public interface iSerializador<T> {
    String serializar(T item);
}
