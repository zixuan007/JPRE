package net.mamoe.jpre.event.group;

import net.mamoe.jpre.Group;
import net.mamoe.jpre.QQ;
import net.mamoe.jpre.RobotQQ;

/**
 * @author Him188
 */
public abstract class AdminGroupEvent extends GroupEvent {
	private final QQ admin;

	public AdminGroupEvent(RobotQQ robot, Group group, QQ qq, QQ admin) {
		super(robot, group, qq);
		this.admin = admin;
	}

	/**
	 * 获取进行操作的管理员
	 *
	 * @return 进行操作的管理员
	 */
	public QQ getAdmin() {
		return admin;
	}
}