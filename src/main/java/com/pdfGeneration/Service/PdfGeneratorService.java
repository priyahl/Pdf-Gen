

package com.pdfGeneration.Service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class PdfGeneratorService {
    public void export(HttpServletResponse response) throws IOException, DocumentException {
      Rectangle pagesize=new Rectangle(700,880);
    	Document document = new Document(pagesize);
        PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        
        PdfPTable table = new PdfPTable(1); 
        table.setWidthPercentage(100); // Width as percentage of page width

        Image image1 = Image.getInstance("images/payaw.png");
        image1.scaleAbsolute(50f, 70f); 

        PdfPCell cellfirst=new PdfPCell();
       
        cellfirst.setPaddingTop(3f);
        cellfirst.setPaddingBottom(10f);
        cellfirst.setPaddingLeft(10f);
        cellfirst.setPaddingRight(10f);
        cellfirst.setBorder(Rectangle.RIGHT | Rectangle.BOTTOM | Rectangle.LEFT );


        Phrase phrase = new Phrase();

        Font fontBold = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12);
        Font fontNormal = FontFactory.getFont(FontFactory.HELVETICA, 12);

        // Add text with different fonts as separate Chunks
        Chunk chunkBold = new Chunk("Booking Date:", fontBold);
        Chunk chunkNormal = new Chunk(" Sept 25,2023", fontNormal);

        // Add the Chunks to the Phrase
        table.addCell(image1);

        phrase.add(chunkBold);
        phrase.add(chunkNormal);
        cellfirst.addElement(phrase);
        table.addCell(cellfirst);

        document.add(table);
        
        PdfPTable table1 = new PdfPTable(2); 
        table1.setWidthPercentage(100); // Width as percentage of page width
        PdfPTable innertable = new PdfPTable(1); 

        PdfPCell cell=new PdfPCell();
       
        cell.setPaddingTop(15f);
        cell.setPaddingBottom(10f);
        cell.setPaddingLeft(10f);
        cell.setPaddingRight(10f);
        
        Font fontbold = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
 
        cell.addElement(new Phrase("Order Id",fontbold));
        cell.addElement(new Phrase("234",font));
        cell.addElement(new Phrase("Ticket Id",fontbold));
        cell.addElement(new Phrase("23",font));
        cell.addElement(new Phrase("Ticket Class",fontbold));
        cell.addElement(new Phrase("SEH - Ultra Early Bird",font));
        cell.setBorder(Rectangle.LEFT);
        
        Image image2 = Image.getInstance("images/qrcode.png");
        image2.scaleAbsolute(150.00f,150.00f);
      
        PdfPCell imagecell=new PdfPCell(image2);

        imagecell.setPaddingTop(10f);
        imagecell.setPaddingBottom(10f);
        imagecell.setPaddingLeft(10f);
        imagecell.setPaddingRight(10f);
        imagecell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        imagecell.setBorder(Rectangle.RIGHT);
      cell.addElement(innertable);
      table1.addCell(cell);
      table1.addCell(imagecell);
      document.add(table1);

      Image image3 = Image.getInstance("images/Screenshot (98).png");
      image3.scaleAbsolute(170.00f,130.00f);
      PdfPCell imagecell3=new PdfPCell(image3);
      imagecell3.setPaddingTop(10f);
      imagecell3.setPaddingBottom(10f);
      imagecell3.setPaddingLeft(10f);
      imagecell3.setPaddingRight(10f);
      imagecell3.setHorizontalAlignment(Element.ALIGN_RIGHT);
      imagecell3.setVerticalAlignment(Element.ALIGN_CENTER);

      imagecell3.setBorder(Rectangle.LEFT | Rectangle.TOP | Rectangle.BOTTOM);
      imagecell3.setHorizontalAlignment(Element.ALIGN_RIGHT);
      imagecell3.setBorder(Rectangle.RIGHT | Rectangle.TOP | Rectangle.BOTTOM);

      
      PdfPTable table2 = new PdfPTable(2); 
      table2.setWidthPercentage(100); // Width as percentage of page width
      PdfPTable innertable2 = new PdfPTable(1); 
      PdfPCell cell2=new PdfPCell();
      cell2.setPaddingTop(10f);
      cell2.setPaddingBottom(10f);
      cell2.setPaddingLeft(10f);
      cell2.setPaddingRight(10f);
      cell2.addElement(new Phrase("Event Details",fontbold));
      cell2.addElement(new Phrase("SEH - Buleria x Icons",font));
      cell2.setBorder(Rectangle.LEFT | Rectangle.TOP | Rectangle.BOTTOM);
    
     
      Image image4 = Image.getInstance("images/calendar.jpg");
      image4.scaleAbsolute(20.00f,20.00f);
    
      Image image5 = Image.getInstance("images/clock.png");
      image5.scaleAbsolute(20.00f,20.00f);

      Image image6 = Image.getInstance("images/location.png");
      image6.scaleAbsolute(20.00f,20.00f);
      
      float columnWidth[] = {20,100};
      PdfPTable nestedTable2 = new PdfPTable(columnWidth);
      nestedTable2.setWidthPercentage(100);
	    PdfPCell nestedcell2 = new PdfPCell();
	    nestedcell2.setBorder(0);
	    nestedcell2.setPaddingTop(6f);
	    nestedcell2.addElement(image4);
	    nestedTable2.addCell(nestedcell2);
	    PdfPCell nestedcell3 = new PdfPCell();
	    nestedcell3.setBorder(0);
	    nestedcell3.addElement(new Phrase("May 07 ,2023",font));
	    nestedcell3.setHorizontalAlignment(Element.ALIGN_LEFT);
	    nestedTable2.addCell(nestedcell3);

	    PdfPTable nestedTable3 = new PdfPTable(columnWidth);
	    nestedTable3.setWidthPercentage(100);
	    PdfPCell nestedcell4 = new PdfPCell();
	    nestedcell4.setBorder(0);
	    nestedcell4.addElement(image5);
	    nestedTable3.addCell(nestedcell4);
	    PdfPCell nestedcell5 = new PdfPCell();
	    nestedcell5.setBorder(0);
	    nestedcell5.addElement(new Phrase("10:00 PM",font));
	    nestedTable3.addCell(nestedcell5);
      
	    PdfPTable nestedTable4 = new PdfPTable(columnWidth);
	    nestedTable4.setWidthPercentage(100);
	    PdfPCell nestedcell6 = new PdfPCell();
	    nestedcell6.setBorder(0);
	    nestedcell6.addElement(image6);
	    nestedTable4.addCell(nestedcell6);
	    PdfPCell nestedcell7 = new PdfPCell();
	    nestedcell7.setBorder(0);
	    nestedcell7.addElement(new Phrase("The Venue Aruba",font));
	    nestedTable4.addCell(nestedcell7);
	    
    
      cell2.addElement(innertable2);
      cell2.addElement(nestedTable2);
      cell2.addElement(nestedTable3);
      cell2.addElement(nestedTable4);
      table2.addCell(cell2);
      table2.addCell(imagecell3);
      document.add(table2);

      
      PdfPTable table4 = new PdfPTable(1); 
      table4.setWidthPercentage(100); // Width as percentage of page width
      PdfPTable innertable4 = new PdfPTable(1); 
      PdfPCell cell4=new PdfPCell();
      cell4.setPaddingTop(8f);
      cell4.setPaddingBottom(10f);
      cell4.setPaddingLeft(10f);
      cell4.setPaddingRight(10f);
      cell4.addElement(new Phrase("Payment Summary",fontbold));
      cell4.addElement(new Phrase("   Ticket Subtotal",font));
      cell4.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
    
      float columns[] = {380,100};
      PdfPTable nestedTable5 = new PdfPTable(columns);
      nestedTable5.setWidthPercentage(100);
	    PdfPCell nestedcel5 = new PdfPCell();
	    nestedcel5.setBorder(0);
	    nestedcel5.addElement(new Phrase("   2 SEH-Ultra Early Bird @ Afl. 55.00",font));
	    nestedTable5.addCell(nestedcel5);
	    PdfPCell nestedcel6 = new PdfPCell();
	    nestedcel6.setBorder(0);
	    nestedcel6.addElement(new Phrase("Afl. 110.00",font));
	    nestedTable5.addCell(nestedcel6);

	    PdfPTable nestedTable6 = new PdfPTable(columns);
	    nestedTable6.setWidthPercentage(100);
		    PdfPCell nestedcel7 = new PdfPCell();
		    nestedcel7.setBorder(0);
		    nestedcel7.setPaddingBottom(10f);
		    nestedcel7.addElement(new Phrase("   1 SEH-VIP Single @ Afl. 100.00",font));
		    nestedTable6.addCell(nestedcel7);
		    PdfPCell nestedcel8 = new PdfPCell();
		    nestedcel8.setBorder(0);
		    nestedcel8.setPaddingBottom(10f);
		    nestedcel8.addElement(new Phrase("Afl. 110.00",font));
		    nestedTable6.addCell(nestedcel8);

		    float columnss[] = {380,100};
		      PdfPTable nestedTable7 = new PdfPTable(columnss);
		      nestedTable7.setWidthPercentage(100);
			    PdfPCell nestedcel9 = new PdfPCell();
			    nestedcel9.setBorder(Rectangle.TOP);
			    nestedcel9.setPaddingBottom(6f);
			    nestedcel9.addElement(new Phrase("  Total Amount",fontbold));
			    nestedTable7.addCell(nestedcel9);
			    PdfPCell nestedcel10 = new PdfPCell();
			    nestedcel10.setBorder(0);
			    nestedcel10.setBorder(Rectangle.TOP);
			    nestedcel10.addElement(new Phrase("Afl. 210.00",font));
			    nestedcel10.setPaddingBottom(6f);
			    nestedTable7.addCell(nestedcel10);
		    
		      cell4.addElement(innertable4);

		      cell4.addElement(nestedTable5);
		      cell4.addElement(nestedTable6);
		      
		      cell4.addElement(nestedTable7);

		      table4.addCell(cell4);
		      document.add(table4);

			   
		      PdfPTable t6 = new PdfPTable(1);
				t6.setWidthPercentage(100);

				PdfPCell t6cell = new PdfPCell();
				t6cell.setBorder(0);
				t6cell.setBorder(Rectangle.LEFT| Rectangle.RIGHT);
				t6cell.setBackgroundColor(BaseColor.GRAY);
				float columns1[] = { 55f, 45f };
				PdfPTable addInfo = new PdfPTable(columns1);
				addInfo.setWidthPercentage(100);

				 BaseColor whiteColor = new BaseColor(255, 255, 255);
				    Font white = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.NORMAL, whiteColor);

				PdfPCell footerCellLeft = new PdfPCell();
				footerCellLeft.setPaddingLeft(40f);
				footerCellLeft.setPaddingBottom(20f);
				footerCellLeft.addElement(new Phrase("Information ", white));
				footerCellLeft.setBorder(0);
				footerCellLeft.setPaddingLeft(80f);

				addInfo.addCell(footerCellLeft);

				PdfPCell footerCellRight = new PdfPCell();
				footerCellRight.setPaddingLeft(50f);
				footerCellRight.setPaddingBottom(20f);
				footerCellRight.addElement(new Phrase("Social", white));
				footerCellRight.setBorder(0);
				footerCellRight.setPaddingLeft(100f);
				addInfo.addCell(footerCellRight);

				t6cell.addElement(addInfo);

				float column[] = {4f, 25f, 5f, 5f, 5f };
				PdfPTable icons = new PdfPTable(column);
				icons.setWidthPercentage(80);

				PdfPCell addPhone = new PdfPCell();
				Image phoneIcon = Image.getInstance("images/callogo1.jpg");
				phoneIcon.scaleAbsolute(20.00f, 20.00f);
				addPhone.setPaddingTop(8f);
				addPhone.setBorder(0);
				addPhone.setPaddingBottom(5f);

				addPhone.addElement(phoneIcon);

				icons.addCell(addPhone);
				

				 BaseColor whiteColor1 = new BaseColor(255, 255, 255);
				    Font white1 = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.NORMAL, whiteColor1);

				
				PdfPCell addPhnNo = new PdfPCell();
				addPhnNo.setBorder(0);
				addPhnNo.addElement(new Phrase("145", white1));

				icons.addCell(addPhnNo);

				PdfPCell addFB = new PdfPCell();
				Image fbIcon = Image.getInstance("images/face2.png");
				fbIcon.scaleAbsolute(25f, 25f);
//				addFB.setPaddingTop(5f);
				addFB.setBorder(0);
				addFB.addElement(fbIcon);

				icons.addCell(addFB);

				PdfPCell adduTube = new PdfPCell();
				Image uTubeIcon = Image.getInstance("images/youtube.png");
				uTubeIcon.scaleAbsolute(25f, 20f);
//				adduTube.setPadding(2.5f);
				adduTube.setBorder(0);
				adduTube.addElement(uTubeIcon);

				icons.addCell(adduTube);

				PdfPCell addInsta = new PdfPCell();
				Image instaIcon = Image.getInstance("images/insta.png");
				instaIcon.scaleAbsolute(25f, 25f);
//				addInsta.setPaddingRight(30f);
				addInsta.setBorder(0);
				addInsta.addElement(instaIcon);

				icons.addCell(addInsta);

				t6cell.addElement(icons);

				float addWp[] = { 9f, 92f };
				PdfPTable whatsApp = new PdfPTable(addWp);
				whatsApp.setWidthPercentage(80);

				PdfPCell addWhatsapp = new PdfPCell();
				Image wpIcon = Image.getInstance("images/whatsapp2.jpg");
				wpIcon.scaleAbsolute(20f, 20f);
//				addWhatsapp.setPadding(10f);
				addWhatsapp.setBorder(0);
				addWhatsapp.addElement(wpIcon);

				whatsApp.addCell(addWhatsapp);

				PdfPCell wpNo = new PdfPCell();
//				wpNo.setPadding(15f);
				wpNo.setBorder(0);
				wpNo.addElement(new Phrase("12345675", white1));
				wpNo.setPaddingBottom(10f);

				whatsApp.addCell(wpNo);

				t6cell.addElement(whatsApp);

				float addMail[] = { 10f, 100f };
				PdfPTable Mail = new PdfPTable(addMail);
				Mail.setWidthPercentage(80);

				PdfPCell addingmail = new PdfPCell();
				Image mailIcon = Image.getInstance("images/mail1.png");
				mailIcon.scaleAbsolute(30f, 25f);
//				addingmail.setPadding(10f);
				addingmail.setBorder(0);
				addingmail.addElement(mailIcon);
				addingmail.setPaddingRight(10f);
				Mail.addCell(addingmail);

				PdfPCell Mname = new PdfPCell();
//				Mname.setPadding(15f);
				Mname.setBorder(0);
				Mname.addElement(new Phrase("coustomercare@pay.aw", white1));
				Mname.setPaddingBottom(10f);

				Mail.addCell(Mname);

				t6cell.addElement(Mail);

				float addGlobe[] = { 8f, 100f };
				PdfPTable globe = new PdfPTable(addMail);
				globe.setWidthPercentage(80);

				PdfPCell addingGlobe = new PdfPCell();
				Image globeIcon = Image.getInstance("images/internet2.png");
				globeIcon.scaleAbsolute(22f, 22f);
//				addingGlobe.setPadding(5f);
				addingGlobe.setBorder(0);
				addingGlobe.addElement(globeIcon);

				globe.addCell(addingGlobe);

				PdfPCell name = new PdfPCell();
//				name.setPadding(15f);
				name.setBorder(0);
				name.addElement(new Phrase("pay.aw", white1));
				name.setPaddingBottom(20f);
				globe.addCell(name);

				t6cell.addElement(globe);

				t6.addCell(t6cell);

				document.add(t6);
				  
      
					    
        document.close();
    }
}



	        
