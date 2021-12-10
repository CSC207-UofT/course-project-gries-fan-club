package UseCases;

import java.util.HashMap;
import java.util.List;

public class ResponseImpl extends HashMap<String, List<String>> implements Response {
	String status;
	boolean success;

	public ResponseImpl(String status, boolean success) {
		this.status = status;
		this.success = success;
	}

	@Override
	public boolean success() {
		return this.success;
	}

	@Override
	public String status() {
		return status;
	}
}
