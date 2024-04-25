interface Command{
	public void execute();
}
interface Device{
	public void turnOn();
	public void turnOff();
}

class TV implements Device{

	@Override
	public void turnOn() {
		System.out.println("Tv turned On");

	}

	@Override
	public void turnOff() {
		System.out.println("TV turned off");

	}
	public void changeChannel() {
		System.out.println("TV channel changed");
	}

}
class Speaker implements Device{

	@Override
	public void turnOn() {
		System.out.println("Speaker turned On");

	}

	@Override
	public void turnOff() {
		System.out.println("Speaker turned off");

	}
	public void changeVolume() {
		System.out.println("Speaker Volume changed");
	}


}

class RemoteController{
	Command c;
	public void setCommand(Command c) {
		this.c = c;
	}

	public void pressButton() {
		c.execute();
	}
}

class TurnOnDevice implements Command{
	Device d;
	public TurnOnDevice(Device d) {
		this.d = d;
	}
	public void execute() {
		d.turnOn();
	}
}
class TurnOffDevice implements Command{
	Device d;
	public TurnOffDevice(Device d) {
		this.d = d;
	}
	@Override
	public void execute() {
		d.turnOff();

	}
}
class ChannelChange implements Command{
	TV t;
	
	public ChannelChange(TV t) {
		this.t = t;
	}
	
	@Override
	public void execute() {
		t.changeChannel();
		
	}
	
}

class VolumeChange implements Command{
	Speaker s;
	
	public VolumeChange(Speaker s) {
		this.s = s;
	}
	@Override
	public void execute() {
		s.changeVolume();
		
	}
	
}
public class CommandPatternExample{
	public static void main(String[] args) {
		TV tv = new TV();
		Speaker speaker = new Speaker();
		
		//tv commands
		Command turnOnTV = new TurnOnDevice(tv);
		Command changeChannel = new ChannelChange(tv);
		Command turnOffTV = new TurnOffDevice(tv);
		
		//speaker commands
		Command turnOnSpeaker = new TurnOnDevice(speaker);
		Command changeVolumen = new VolumeChange(speaker);
		Command turnOffSpeaker = new TurnOffDevice(speaker);
		
		RemoteController rc = new RemoteController();
		rc.setCommand(turnOnTV);
		rc.pressButton();
		
		rc.setCommand(changeChannel);
		rc.pressButton();
		
		rc.setCommand(turnOffTV);
		rc.pressButton();
		
		
		rc.setCommand(turnOnSpeaker);
		rc.pressButton();
		
		rc.setCommand(changeVolumen);
		rc.pressButton();
		
		rc.setCommand(turnOffSpeaker);
		rc.pressButton();
		
		
	}
}
