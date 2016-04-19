package cn.org.rapid_framework.generator.provider.db.table.model;

public class ButtonInfo {

	public ButtonInfo(){
		
	}
	public ButtonInfo(String opname,String title,String icon,String action){
		this.opname = opname;
		this.title = title;
		this.icon  = icon;
		this.action = action;
	}
	public String getOpname() {
		return opname;
	}
	public void setOpname(String opname) {
		this.opname = opname;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getAction() {
		if(action!=null)action = action.replace("&comma",",");
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}	
	private String opname;
	private String title;
	private String icon;
	private String action;

}
