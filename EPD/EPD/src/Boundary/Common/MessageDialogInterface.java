package Boundary.Common;

public interface MessageDialogInterface {
    public void showError(String title, String message);
    public void showWarning(String title, String message);
    public void showNotice(String title, String message);
}
