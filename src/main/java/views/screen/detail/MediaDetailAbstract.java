package views.screen.detail;

public abstract class MediaDetailAbstract {
	public void detail() {
		viewCommon();
		viewParticular();
	}

	protected abstract void viewCommon();

	protected abstract void viewParticular();
}
