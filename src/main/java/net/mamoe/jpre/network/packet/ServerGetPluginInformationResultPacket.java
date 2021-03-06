package net.mamoe.jpre.network.packet;


/**
 * @author Him188 @ JPRE Project
 */
public class ServerGetPluginInformationResultPacket extends Packet {
	public static final byte NETWORK_ID = Protocol.SERVER_GET_PLUGIN_INFORMATION_RESULT;

	private final String name;
	private final String author;
	private final String version;
	private final String main;
	private final int api;
	private final String description;

	public ServerGetPluginInformationResultPacket(String name, String author, String version, String main, int api, String description) {
		this.name = name;
		this.author = author;
		this.version = version;
		this.main = main;
		this.api = api;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public int getApi() {
		return api;
	}

	public String getAuthor() {
		return author;
	}

	public String getDescription() {
		return description;
	}

	public String getMain() {
		return main;
	}

	public String getVersion() {
		return version;
	}

	@Override
	public void encode() {
		if (setEncoded(true)) {
			return;
		}

		clear();
		putString(name);
		putString(main);
		putString(version);
		putInt(api);
		putString(author);
		putString(description);
	}

	@Override
	public void decode() {

	}

	@Override
	public byte getNetworkId() {
		return NETWORK_ID;
	}
}
