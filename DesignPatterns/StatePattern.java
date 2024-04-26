class Context{
	States state;
	
	public void setState(States state) {
		this.state = state;
	}
	public void handle() {
		state.handleRequest();
	}
}
interface States{
	public void handleRequest();
}

class ReadyState implements States{
	
	@Override
	public void handleRequest() {
		System.out.println("Inside the Readystate");	
	}
}
class RunningState implements States{
	
	public void handleRequest() {
		System.out.println("Inside the Running state");
	}
}

class TerminatedState implements States{
	
	public void handleRequest() {
		System.out.println("Inside the Terminated state");
	}
}

public class StateDesignPattern {
	public static void main(String[] args) {
		Context c = new Context();
		c.setState(new ReadyState());
		c.handle();
		
		c.setState(new RunningState());
		c.handle();
		
		c.setState(new TerminatedState());
		c.handle();
	}
}
