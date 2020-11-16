package org.nava.year19.sep;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class FileOperations {

	static final String FILE_IN = "/Users/nambi/work/ProgramOfTheDay/java/programofday/src/main/java/org/nava/year19/sep/FileOps.txt";
	static final String FILE_OUT = "/Users/nambi/work/ProgramOfTheDay/java/programofday/src/main/java/org/nava/year19/sep/FileOpsOut.txt";

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		List<FileContent> content = readFile();

		for (FileContent fc : content) {
			sb.append(fc);
			sb.append("\n");
		}
		System.out.println(sb);

		sb.delete(0, sb.length());

		List<FileContent> reverseContent = reverseContent(content);

		for (FileContent fc : reverseContent) {
			sb.append(fc);
			sb.append("\n");
		}
		System.out.println(sb);

		FileContent matchContent = matchContent(content);
		System.out.println("Matched Content" + matchContent);

		FileContent cloneContent = cloneContent(matchContent);

		System.out.println("Do they match:" + (cloneContent == matchContent));

		System.out.println("Matched Content After Clone " + cloneContent);

		writeFile(cloneContent);
		
		Date d = new Date ();
		DateFormat df =  DateFormat.getDateTimeInstance();
		System.out.println(df.format(d));
	}

	static List<FileContent> readFile() {

		List<FileContent> content = new ArrayList<FileContent>();
		BufferedReader fr = null;
		try {

			fr = new BufferedReader(new FileReader(FILE_IN));

			while (fr.read() > 0) {
				String[] st = new String(fr.readLine()).split(",");
				FileContent fc = new FileContent(st[0], st[1], st[2]);
				content.add(fc);
			}

		} catch (FileNotFoundException e) {
			System.err.println("Error while reading file " + e);
		} catch (IOException e) {
			System.err.println("Error while reading file " + e);
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				System.err.println("Error while closing file " + e);
			}
		}

		return content;
	}

	static void writeFile(FileContent content) {

		BufferedWriter bw = null;

		try {

			bw = new BufferedWriter(new FileWriter(FILE_OUT, true));
			bw.write(content.toString());
			bw.write("\n");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	static FileContent matchContent(List<FileContent> content) {

		FileContent matchedContent = null;
		for (FileContent fc : content) {
			if (Pattern.matches("cto", fc.description)) {
				matchedContent = fc;
				break;
			}
		}
		return matchedContent;
	}

	static List<FileContent> reverseContent(List<FileContent> content) {
		List<FileContent> reverseContent = new ArrayList<FileContent>();

		for (int i = content.size() - 1; i >= 0; i--) {
			reverseContent.add(content.get(i));
		}

		return reverseContent;
	}

	static FileContent cloneContent(FileContent content) {
		FileContent cloneContent = null;

		ObjectOutputStream oos;
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);

			oos.writeObject(content);
			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);

			cloneContent = (FileContent) ois.readObject();

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cloneContent;

	}

}

class FileContent implements Serializable {

	private static final long serialVersionUID = -640677604341414900L;
	String id;
	transient String name;
	String description;

	public FileContent() {

	}

	public FileContent(String id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public String toString() {
		return "[id:" + id + ",name:" + name + ",description:" + description + "]";
	}

}