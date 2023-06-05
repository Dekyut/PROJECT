//This class extends the Images class to access the file through the String's property.
import javax.swing.ImageIcon;

public class getImages extends ImagePaths{

	//Backgrounds
	NoScalingIcon backBG = new NoScalingIcon(new ImageIcon(BG1));
	NoScalingIcon RepairBG = new NoScalingIcon(new ImageIcon(BGRepair));

	//Others
	NoScalingIcon logoIMG = new NoScalingIcon(new ImageIcon(Logo));
	NoScalingIcon inventoryIMG = new NoScalingIcon(new ImageIcon(Inventory));
	NoScalingIcon repairIMG = new NoScalingIcon(new ImageIcon(Repair));
	NoScalingIcon aboutIMG = new NoScalingIcon(new ImageIcon(About));
	NoScalingIcon logoutIMG = new NoScalingIcon(new ImageIcon(Logout));

}
