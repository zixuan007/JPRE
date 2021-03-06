package net.mamoe.jpre;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * QQ 群
 *
 * @author Him188 @ JPRE Project
 */
@SuppressWarnings("WeakerAccess")
public class Group extends User {
	private final long group;

	public Group(RobotQQ robot, long group) {
		super(robot);
		this.group = group;
	}


	private Set<QQ> members = new HashSet<>();
	private Set<QQ> admins = new HashSet<>();

	public Set<QQ> getMembers() {
		return members;
	}

	public Set<QQ> getAdmins() {
		return admins;
	}

	public long getNumber() {
		return group;
	}

	@Override
	public String toString() {
		return String.valueOf(group);
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Group && ((Group) obj).getNumber() == this.getNumber();
	}

	@Override
	public boolean sendMessage(String content) {
		return getRobot().sendGroupMessage(this, content);
	}

	@Override
	public boolean sendObjectMessage(String content, String subType) {
		return getRobot().sendGroupObjectMessage(this.getNumber(), content, subType);
	}

	// TODO: 2017/5/17 添加所有方法

	public boolean mute(QQ qq, int time) {
		return mute(qq.getNumber(), time);
	}

	public boolean mute(long qq, int time) {
		return getRobot().shutUp(this.getNumber(), qq, time);
	}

	public boolean unmute(QQ qq) {
		return unmute(qq.getNumber());
	}

	public boolean unmute(long qq) {
		return mute(qq, 0);
	}

	public boolean wholeMute() {
		return getRobot().shutUpWhole(this.getNumber());
	}

	public boolean wholeUnmute() {
		return getRobot().shutUpWhole(this.getNumber());
	}

	public boolean setNotice(String title, String context) {
		return getRobot().setNotice(this.getNumber(), title, context);
	}

	public long[] getAdminList() {
		String[] list = getRobot().getAdminList(this.getNumber()).split("\n");
		ArrayList<Long> result = new ArrayList<>(list.length);
		for (int i = 0; i < list.length; i++) {
			list[i] = list[i].trim();
			if (list[i].isEmpty()) {
				continue;
			}
			try {
				long number = Long.parseLong(list[i]);
				result.add(number);
			} catch (NumberFormatException ignored) {
			}
		}

		Long[] array = result.toArray(new Long[result.size()]);
		long[] returnValue = new long[array.length];
		for (int i = 0; i < array.length; i++) {
			returnValue[i] = array[i];
		}
		return returnValue;
	}

}
