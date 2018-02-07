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
import com.vaadin.ui.ProgressBar;
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
		setSizeFull();
		root = new GridLayout(1,4);
		root.addComponents(header(),widgets(),navButtons(),lowPanels());
		root.setSizeFull();
		root.setSpacing(true);
		setSizeFull();
		setMargin(new MarginInfo(false,false,false,false));
		
		setDefaultComponentAlignment(Alignment.TOP_CENTER);
		setResponsive(true);
		
		Responsive.makeResponsive(this);
		addComponent(root);
		
	}
private Component lowPanels() {
		GridLayout lowerSection = new GridLayout(3,1);
		lowerSection.setSpacing(true);
		VerticalLayout leftpanel = new VerticalLayout();
		leftpanel.addStyleName(ValoTheme.LAYOUT_CARD);
		leftpanel.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		leftpanel.setMargin(true);
		leftpanel.setSpacing(false);
		
		Button med = new Button("Medic service",VaadinIcons.DOCTOR_BRIEFCASE);
		med.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		Button doc = new Button("doctors",VaadinIcons.DOCTOR);
		doc.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		Button inter = new Button("intervation",VaadinIcons.STETHOSCOPE);
		inter.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		leftpanel.addComponents(med,doc,inter);
		leftpanel.addStyleName("pan1");
		
		Button purch = new Button("Purchases",VaadinIcons.CREDIT_CARD);
		purch.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		purch.addStyleName("btnDash");
		Button inv = new Button("Inventory",VaadinIcons.ARCHIVES);
		inv.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		inv.addStyleName("btnDash");
		Button supp = new Button("Supplier",VaadinIcons.CART_O);
		supp.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		VerticalLayout middlepanel = new VerticalLayout(purch,inv,supp);
		middlepanel.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		middlepanel.addStyleName(ValoTheme.LAYOUT_CARD);
		middlepanel.setMargin(true);
		middlepanel.setSpacing(false);
		
		
		Button nam = new Button("User name",VaadinIcons.USER);
		nam.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		Button mail = new Button("user mail",VaadinIcons.MAILBOX);
		mail.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		Button phon = new Button("user phone",VaadinIcons.PHONE);
		phon.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		VerticalLayout rightpanel = new VerticalLayout(nam,mail,phon);
		rightpanel.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		rightpanel.addStyleName(ValoTheme.LAYOUT_CARD);
		rightpanel.setMargin(true);
		rightpanel.setSpacing(false);
		
		lowerSection.addComponents(leftpanel,middlepanel,rightpanel);
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
	HorizontalLayout widget = new HorizontalLayout();
	VerticalLayout analyticPanel = new VerticalLayout();
	analyticPanel.setHeight("200px");
	analyticPanel.setWidth("400px");
	ProgressBar saleAnalyser = new ProgressBar();
	saleAnalyser.setWidth("80%");
	saleAnalyser.setCaption("Sales within 7 Days");
	
	ProgressBar purchaseAnalyser = new ProgressBar();
	purchaseAnalyser.setWidth("80%");
	purchaseAnalyser.setCaption("Purchase within 7 Days");
	Label comment = new Label("You have good Sales past week");
	
	comment.addStyleNames(ValoTheme.LABEL_BOLD, ValoTheme.LABEL_COLORED, ValoTheme.LABEL_H4);
	
	analyticPanel.addComponents(saleAnalyser,purchaseAnalyser,comment);
	analyticPanel.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
	analyticPanel.setMargin(false);
	analyticPanel.addStyleName(ValoTheme.LAYOUT_CARD);
	
	VerticalLayout centerwidgets = new VerticalLayout();
	centerwidgets.setWidth("500px");
	centerwidgets.setHeight("200px");
		HorizontalLayout sale_expensewidgets = new HorizontalLayout();
		
		
		HorizontalLayout salewidget = new HorizontalLayout();
		salewidget.addStyleName(ValoTheme.LAYOUT_CARD);
		salewidget.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		salewidget.setWidth("150px");
		salewidget.setHeight("75px");
		Label salelabel =new Label("0.0"); //today sale
		salelabel.addStyleName(ValoTheme.LABEL_H2);
		Label icon = new Label("");
		icon.setStyleName("blueicon");
		icon.setIcon(VaadinIcons.MONEY);
		
		salewidget.addComponent(icon);	
		salewidget.addComponent(salelabel);
		
		//second Widget
		HorizontalLayout expensewidget = new HorizontalLayout();
		expensewidget.addStyleName(ValoTheme.LAYOUT_CARD);
		expensewidget.setWidth("150px");
		expensewidget.setHeight("75px");
		Label expenselabel =new Label("1000");
		expenselabel.addStyleName(ValoTheme.LABEL_H2);
		Label iconExpense = new Label("");
		iconExpense.setStyleName(ValoTheme.LABEL_COLORED);
		iconExpense.setIcon(VaadinIcons.MINUS_CIRCLE_O);
		
		expensewidget.addComponent(iconExpense);
		expensewidget.addComponent(expenselabel);
		
		//third Widget
				HorizontalLayout modewidget = new HorizontalLayout();
				modewidget.addStyleName(ValoTheme.LAYOUT_CARD);
				modewidget.setWidth("160px");
				modewidget.setHeight("75px");
				Label modelabel =new Label("Online");
				modelabel.addStyleName(ValoTheme.LABEL_H2);
				//card0.setSpacing(true);
				Label iconMode = new Label("");
				iconMode.setStyleName(ValoTheme.LABEL_COLORED);
				iconMode.setIcon(VaadinIcons.SIGNAL);
				
				modewidget.addComponent(iconMode);
				modewidget.addComponent(modelabel);
		
		sale_expensewidgets.addComponents(salewidget,expensewidget,modewidget);
		
		
		HorizontalLayout cloc = new HorizontalLayout();
		Label displayclock = new Label("Wednesday 2/7/2018, 11:00am");
		displayclock.addStyleNames(ValoTheme.LABEL_BOLD,ValoTheme.LABEL_COLORED,ValoTheme.LABEL_H3);
		displayclock.setIcon(VaadinIcons.CLOCK);
		
		cloc.addComponent(displayclock);
		cloc.setComponentAlignment(displayclock, Alignment.MIDDLE_CENTER);
		cloc.addStyleName(ValoTheme.LAYOUT_CARD);
		cloc.setHeight("90px");
		cloc.setWidth("100%");
		
		centerwidgets.addComponents(sale_expensewidgets,cloc);
		centerwidgets.setMargin(new MarginInfo(false,false,false,false));
		centerwidgets.setSpacing(true);
		
		
		
		 //LEFT PANEL
		VerticalLayout status = new VerticalLayout();
		status.addStyleName(ValoTheme.LAYOUT_CARD);
		Label itemstore = new Label("SUM Item in store");
		Label itemexpired = new Label("Item expired");
		Label totalitem = new Label("Total items");
		status.addComponents(itemstore,itemexpired,totalitem);
		status.setWidth("300px");
		status.setHeight("200px");
		status.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		status.setMargin(new MarginInfo(false,false,false,false));
		
		//Add in ROOT Layout
		
		widget.addComponents(analyticPanel,centerwidgets,status);
		widget.setWidth("100%");
		widget.setComponentAlignment(status, Alignment.MIDDLE_RIGHT);
		widget.setComponentAlignment(analyticPanel, Alignment.MIDDLE_LEFT);
		
		return widget;
	}	
private Component header() {
	HorizontalLayout uppersection = new HorizontalLayout();
	uppersection.setHeight("40px");
	uppersection.setWidth("100%");
	uppersection.setMargin(new MarginInfo(false,false,false,false));
	uppersection.addStyleName(ValoTheme.LAYOUT_CARD);
	HorizontalLayout toolLeft = new HorizontalLayout();
	uppersection.addComponent(toolLeft);
	toolLeft.setDefaultComponentAlignment(Alignment.TOP_LEFT);
	toolLeft.setWidth("100%");
	HorizontalLayout toolRight = new HorizontalLayout();
	toolRight.setDefaultComponentAlignment(Alignment.TOP_RIGHT);
	toolRight.setWidth("100%");
	toolRight.setSpacing(false);
	uppersection.addComponent(toolRight);
	
	title = new Label("Dashboard");
	
	title.addStyleName(ValoTheme.LABEL_H2);
	title.addStyleName(ValoTheme.LABEL_NO_MARGIN);
	toolLeft.addComponent(title);
	
	MenuBar bar = new MenuBar();
	bar.addStyleName("mybarmenu");
	toolRight.addComponent(bar);
	
	MenuItem m1 = bar.addItem("Feedback", VaadinIcons.COMMENTS_O, command);
	MenuItem m2 = bar.addItem("Help", VaadinIcons.QUESTION_CIRCLE_O, command);
	MenuItem m3 = bar.addItem("Signout", VaadinIcons.SIGN_OUT_ALT, command);
	
	MenuBar.Command command = new MenuBar.Command() {
	    public void menuSelected(MenuItem selectedItem) {
	    	Notification.show(selectedItem.getText());
		    }
	};
	
	uppersection.setComponentAlignment(toolRight, Alignment.MIDDLE_RIGHT);
	uppersection.setWidth("100%");
	
	
		return uppersection;
	}

@Override
public void enter(ViewChangeListener.ViewChangeEvent event){
	//throw new UnsupportedOperationException("Not supported Yet");
	
}
}
