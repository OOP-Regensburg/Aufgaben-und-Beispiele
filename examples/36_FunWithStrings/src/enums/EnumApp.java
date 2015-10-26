package enums;

import acm.program.ConsoleProgram;

@SuppressWarnings("serial")
public class EnumApp extends ConsoleProgram {
	
	private PropulsionState propulsionSate = PropulsionState.OFF;
	
	public void run() {
		engage(PropulsionState.IMPULSE);
		engage(PropulsionState.WARP);
		engage(PropulsionState.TRANSWARP);
		halt();
	}
	
	private void engage(PropulsionState newState) {
		if(newState == PropulsionState.OFF) {
			return;
		} else {
			propulsionSate = newState;
		}
		notifyCaptain();
	}
	
	private void halt() {
		propulsionSate = PropulsionState.OFF;
		notifyCaptain();
	}
	
	private void notifyCaptain() {
		println("Setting state: " + propulsionSate);
	}

}
