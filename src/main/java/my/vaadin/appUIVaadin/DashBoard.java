package my.vaadin.appUIVaadin;

import com.github.appreciated.material.MaterialTheme;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Responsive;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.themes.ValoTheme;

public class DashBoard extends VerticalLayout implements View {
	Label title;
	Button signout;
	Button help;
	Button feedback;
	GridLayout root;
	
	Button sale;
	Button products;
	Button store;
	Button management;
	MenuBar bar;
	MenuBar.Command command;
	
	public DashBoard(){
	//	addStyleName(ValoTheme.PANEL_BORDERLESS);
		setSizeFull();
		setHeight("100%");
		//setSpacing(false);
		root = new GridLayout(1,4);
		root.addComponents(header(),widgets(),navButtons(),lowPanels());
		root.setSizeFull();
		root.setSpacing(true);
		setSizeFull();
		setSpacing(true);
	//	root.addStyleName("dashboard-view");
		setDefaultComponentAlignment(Alignment.TOP_CENTER);
		setResponsive(true);
		
		Responsive.makeResponsive(this);
		addComponent(root);
		//addComponent(header());
		/*addComponent(widgets());
		addComponent(navButtons());
		addComponent(lowPanels());*/
	}
private Component lowPanels() {
		GridLayout lowerSection = new GridLayout(3,1);
		lowerSection.setSpacing(true);
		VerticalLayout pan1 = new VerticalLayout();
		pan1.setMargin(true);
		pan1.setSpacing(false);
		
		Button med = new Button("Medic service");
		med.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		Button doc = new Button("doctors");
		doc.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		Button inter = new Button("intervation");
		inter.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		pan1.addComponents(med,doc,inter);
		pan1.addStyleName("pan1");
		
		Button purch = new Button("Purchases");
		purch.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		purch.addStyleName("btnDash");
		Button inv = new Button("Inventory");
		inv.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		inv.addStyleName("btnDash");
		Button supp = new Button("Supplier");
		supp.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		VerticalLayout pan2 = new VerticalLayout(purch,inv,supp);
		pan2.setMargin(true);
		pan2.setSpacing(false);
		
		
		Button nam = new Button("User name");
		nam.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		Button mail = new Button("user mail");
		mail.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		Button phon = new Button("user phone");
		phon.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		VerticalLayout pan3 = new VerticalLayout(nam,mail,phon);
		pan3.setMargin(true);
		pan3.setSpacing(false);
		
		lowerSection.addComponents(pan1,pan2,pan3);
		lowerSection.setWidth("100%");
		
		
		return lowerSection;
	}
private Component navButtons() {
	GridLayout flat = new GridLayout(4,1);
		Button nSal = new Button("sale");
		nSal.setIcon(VaadinIcons.CART);
		nSal.addStyleName(ValoTheme.BUTTON_ICON_ALIGN_TOP);
		nSal.addStyleName(ValoTheme.BUTTON_LARGE);
		nSal.addStyleName(ValoTheme.LABEL_H1);
		nSal.addStyleName(MaterialTheme.BUTTON_FLOATING_ACTION);
		
		
		Button nProd = new Button("Products");
		nProd.setIcon(VaadinIcons.DIAMOND);
		nProd.addStyleName(ValoTheme.BUTTON_ICON_ALIGN_TOP);
		nProd.addStyleName(ValoTheme.BUTTON_LARGE);
		nProd.addStyleName(ValoTheme.LABEL_H1);
		nProd.addStyleName(MaterialTheme.BUTTON_FLOATING_ACTION);
		
		Button nStore = new Button("Store");
		nStore.setIcon(VaadinIcons.SHOP);
		nStore.addStyleName(ValoTheme.BUTTON_ICON_ALIGN_TOP);
		nStore.addStyleName(ValoTheme.BUTTON_LARGE);
		nStore.addStyleName(ValoTheme.LABEL_H1);
		nStore.addStyleName(MaterialTheme.BUTTON_FLOATING_ACTION);
		
		
		Button nManag = new Button("Management");
		nManag.setIcon(VaadinIcons.COGS);
		nManag.addStyleName(ValoTheme.BUTTON_ICON_ALIGN_TOP);
		nManag.addStyleName(ValoTheme.BUTTON_LARGE);
		nManag.addStyleName(ValoTheme.LABEL_H1);
		nManag.addStyleName(MaterialTheme.BUTTON_FLOATING_ACTION);
		
		flat.addComponents(nSal,nProd,nStore,nManag);
		flat.setWidth("100%");
		return flat;
	}
private Component widgets() {
	GridLayout widget = new GridLayout(3,1);
	VerticalLayout ana = new VerticalLayout();
	Label ons = new Label("Sales within 7 Days");
	Label onp = new Label("Purchase within 7Days");
	Label com = new Label("comment");
	ana.addComponents(ons,onp,com);
	ana.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
	ana.setMargin(true);
	
	VerticalLayout widgs = new VerticalLayout();
		HorizontalLayout flatwgs = new HorizontalLayout();
		
		Label tS =new Label("Sale");
		tS.addStyleName(ValoTheme.LABEL_H2);
		HorizontalLayout card0 = new HorizontalLayout();
		card0.addStyleName(MaterialTheme.CARD_0);
		//card0.setSpacing(true);
		Label ic = new Label("");
		ic.setStyleName(MaterialTheme.LABEL_H1+""+MaterialTheme.LABEL_COLORED);
		ic.setIcon(VaadinIcons.MONEY);
		
		card0.addComponent(ic);
		card0.addComponent(tS);
		
		Label tp =new Label("Sale");
		tp.addStyleName(ValoTheme.LABEL_H2);
		HorizontalLayout card1 = new HorizontalLayout();
		card1.addStyleName(MaterialTheme.CARD_0);
		//card0.setSpacing(true);
		Label ic1 = new Label("");
		ic1.setStyleName(MaterialTheme.LABEL_H1+""+MaterialTheme.LABEL_COLORED);
		ic1.setIcon(VaadinIcons.MINUS_CIRCLE);
		
		card1.addComponent(ic1);
		card1.addComponent(tp);
		
		flatwgs.addComponents(card0,card1);
		flatwgs.setWidth("100%");
		
		widgs.addComponent(flatwgs);
		Panel cloc = new Panel("",new Label("Display clock \n and or ...\n Here"));
		cloc.setHeight("20%");
		cloc.setWidth("100%");
		widgs.addComponent(cloc);
		widgs.setWidth("100%");
		
		 //LEFT
		VerticalLayout stat = new VerticalLayout();
		Label it = new Label("SUM Item in store");
		Label itex = new Label("Item expired");
		Label totit = new Label("Total items");
		stat.addComponents(it,itex,totit);
		stat.setMargin(true);
		stat.setWidth("100%");
		stat.setDefaultComponentAlignment(Alignment.MIDDLE_RIGHT);
		stat.setMargin(new MarginInfo(true,false,false,false));
		//Add in Layout
		widget.addComponents(ana,widgs,stat);
		widget.setWidth("100%");
		widget.setComponentAlignment(stat, Alignment.MIDDLE_RIGHT);
		widget.setComponentAlignment(ana, Alignment.MIDDLE_LEFT);
		
		return widget;
	}
private Component header() {
	GridLayout header = new GridLayout(2,1);
	
	HorizontalLayout toolL = new HorizontalLayout();
	toolL.setDefaultComponentAlignment(Alignment.TOP_LEFT);
	toolL.setWidth("100%");
	HorizontalLayout toolR = new HorizontalLayout();
	toolR.setDefaultComponentAlignment(Alignment.TOP_RIGHT);
	toolR.setWidth("100%");
	toolR.setSpacing(false);
	
	
	title = new Label("Dashboard");
	
	title.addStyleName(ValoTheme.LABEL_H2);
	title.addStyleName(ValoTheme.LABEL_NO_MARGIN);
	toolL.addComponent(title);
	
	MenuBar bar = new MenuBar();
	bar.addStyleName("mybarmenu");
	toolR.addComponent(bar);
	
	MenuItem m1 = bar.addItem("Feedback", VaadinIcons.COMMENTS_O, command);
	MenuItem m2 = bar.addItem("Help", VaadinIcons.QUESTION_CIRCLE_O, command);
	MenuItem m3 = bar.addItem("Signout", VaadinIcons.SIGN_OUT_ALT, command);
	
	MenuBar.Command command = new MenuBar.Command() {
	    public void menuSelected(MenuItem selectedItem) {
	    	Notification.show(selectedItem.getText());
		    }
	};
	
	//toolR.addComponents(b1,b2,b3);
	
	header.addComponents(toolL,toolR);
	header.setComponentAlignment(toolR, Alignment.MIDDLE_RIGHT);
	header.setWidth("100%");
	header.setHeight("15%");
	
	
		return header;
	}

@Override
public void enter(ViewChangeListener.ViewChangeEvent event){
	//throw new UnsupportedOperationException("Not supported Yet");
	
}
}
