package mallpage;

import java.util.ArrayList;

public abstract class ab_footer {
	//copyright 정보 Model
	copyright cr = new copyright();
	ArrayList<String> cdata  = null;
	public void fts() {
		this.cdata = this.cr.copyright_info();
	}	
}
