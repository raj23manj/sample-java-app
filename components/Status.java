package components;

public interface Status<T,U> {
	public T getStatus(U o);
	public String onOrOffStatus(Boolean status);
}
