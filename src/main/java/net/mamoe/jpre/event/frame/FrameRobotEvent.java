package net.mamoe.jpre.event.frame;

import net.mamoe.jpre.Frame;
import net.mamoe.jpre.RobotQQ;

/**
 * @author Him188 @ JPRE Project
 */
public abstract class FrameRobotEvent extends FrameEvent {
	private final RobotQQ robot;

	public FrameRobotEvent(Frame frame, RobotQQ robot) {
		super(frame);
		this.robot = robot;
	}

	public RobotQQ getRobot() {
		return robot;
	}
}