package my.vaadin.appUIVaadin;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.RadioButtonGroup;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class SignUp extends VerticalLayout implements View {
	Label lheader;
	Label title;
	TextField ID;
	TextField name;
	PasswordField pwd;
	DateField dob;
	ComboBox cb;
	Button save;
	Button cancel;
	RadioButtonGroup gender;
	
	public SignUp(){
		setSpacing(true);
		setMargin(true);
		
		lheader = new Label("Sign up form");
		lheader.addStyleName("h1");
		addComponent(lheader);
		
		FormLayout form = new FormLayout();
		form.setMargin(true);
		form.setWidth("500");
		form.addStyleName("light");
		addComponent(form);
		
		title = new Label("Personal details");
		title.addStyleName("h2");
		title.addStyleName("colored");
		
		ID = new TextField("username/ID");
		ID.setResponsive(true);
		ID.setRequiredIndicatorVisible(true);
		
		name = new TextField("name");
		name.setRequiredIndicatorVisible(true);
		
		pwd = new PasswordField("password");
		pwd.setRequiredIndicatorVisible(true);
		
		dob = new DateField("Date of birth");
		dob.setDateFormat("dd-MM-yyyy");
		java.util.Date now = new java.util.Date();
		dob.setValue(now.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		
		RadioButtonGroup<String> gender= new RadioButtonGroup<>("Gender");
		gender.setItems("Male","Female");
		gender.addStyleName("horizontal");
		
		ArrayList<String>listtype = new ArrayList<>();
		listtype.add("staff");
		listtype.add("non-staff");
		
		cb = new ComboBox<>("Type",listtype);
		
		save = new Button("Confirm");
		save.addStyleName("primary");
		
		cancel = new Button("cancel");
		cancel.addStyleName("danger");
		HorizontalLayout btns = new HorizontalLayout(save,cancel);
			btns.setMargin(new MarginInfo(true,false,true,false));
			btns.setSpacing(true);
			btns.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
			
	
	form.addComponents(title,ID,name,pwd,dob,gender,cb,btns);
		
	save.addClickListener(new Button.ClickListener() {
		
		@Override
		public void buttonClick(ClickEvent event) {
			// Link here with MainSystem from backend
			Notification.show("You signed up seuccessfully");
			getUI().getNavigator().navigateTo("login");
			
		}
	});
	cancel.addClickListener(new Button.ClickListener() {
		
		@Override
		public void buttonClick(ClickEvent event) {
			getUI().getNavigator().navigateTo("login");
			
		}
	});
		
	}
@Override
public void enter(ViewChangeListener.ViewChangeEvent event){
	//throw new UnsupportedOperationException("Not supported Yet");
	
}
}