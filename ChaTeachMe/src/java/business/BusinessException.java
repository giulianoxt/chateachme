package business;

public class BusinessException extends Exception {
  public BusinessException() { }
  public BusinessException(String message) {
    super(message);
  }
}
