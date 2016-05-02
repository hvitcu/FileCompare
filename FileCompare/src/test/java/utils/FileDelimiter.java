package utils;

public enum FileDelimiter {
	CSV_FILE(","),
	PIPE_FILE("\\|");
	
	private String delimiter;
	
	private FileDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}
	
	public String getDelimiter() {
		return delimiter;
	}
}
