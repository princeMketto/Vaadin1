package my.vaadin.appUIVaadin;

import java.awt.Dialog;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class Login extends VerticalLayout implements View {
	TextField txfld;
	PasswordField pwd;
	Button signup;
	Button signin;
	public Login(){
		txfld = new TextField("username/ID");
		pwd = new PasswordField("Password");
		
	//	HorizontalLayout Hlayout = new HorizontalLayout();
		signin = new Button("sign in");
		signin.addStyleName("friendly");
		
		signup = new Button("sign up");
		signup.addStyleName("primary");
		HorizontalLayout Hlayout = new HorizontalLayout(signin,signup);
		Hlayout.setSpacing(true);
		
		FormLayout form = new FormLayout(txfld,pwd,Hlayout);
		form.setMargin(true);
		
		
		//Navigate
		signup.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				//Dialog dialog = new Dialog("",new SignUp());
				getUI().getNavigator().navigateTo("signup");
			}
		});
		signin.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				//After testing for login condions
				getUI().getNavigator().navigateTo("dashboard");
				
			}
		});
		Panel loginpanel = new Panel("Login form",form);
		loginpanel.setWidth("450");
		loginpanel.setHeight("250");
		
		addComponents(loginpanel);
		setComponentAlignment(loginpanel, Alignment.MIDDLE_CENTER);
		setHeight("100%");
		
	}
@Override
public void enter(ViewChangeListener.ViewChangeEvent event){
	//throw new UnsupportedOperationException("Not supported Yet");
	
}
}
