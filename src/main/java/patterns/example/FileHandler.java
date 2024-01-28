package patterns.example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileHandler {

	public static void saveDataToFile(ObjectOutputStream out, Data data) throws IOException {
		out.writeObject(data);
	}
	public static Data getDataFromFile(ObjectInputStream in) throws IOException, ClassNotFoundException {
		return (Data) in.readObject();
	}
}
