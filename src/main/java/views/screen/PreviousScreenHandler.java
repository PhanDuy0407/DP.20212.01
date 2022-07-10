package views.screen;

public class PreviousScreenHandler {
    private BaseScreenHandler prev;
    public void setPreviousScreen(BaseScreenHandler prev) {
        this.prev = prev;
    }
    public BaseScreenHandler getPreviousScreen() {
        return this.prev;
    }
}
