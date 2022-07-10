package common.interfaces;

public interface State {
	void cancel();
	void approve();
	void payment();
	void ordering();
}
