package interfaces;

public interface iView<T> {
    public void clear();
    public void showData(T data);
    public void showError(String error);
    public void showMessage(String message);    
}
