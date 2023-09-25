package calc.gui;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveAndLoad {

	OptionDB opDb;
	
	private String Address="out.ser";
	public void SaveData() throws IOException{
		ObjectOutputStream saveOut = new ObjectOutputStream(new FileOutputStream(Address));
		saveOut.writeObject(opDb);
		saveOut.close();

	}
	
	public OptionDB LoadData() throws ClassNotFoundException, IOException{
		FileInputStream ComeIn = new FileInputStream(Address);
		@SuppressWarnings("resource")
		ObjectInputStream reader = new ObjectInputStream(ComeIn); 
		return  (OptionDB) reader.readObject();
	}
	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public OptionDB getOpDb() {
		return opDb;
	}

	public void setOpDb(OptionDB opDb) {
		this.opDb = opDb;
	}
	
}
