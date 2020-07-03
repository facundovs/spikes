package pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class RbSoftPDFGeneration {

    public static void main(String[] args) throws Exception{

        FontFactory.register("src/main/resources/playlist-script.otf");

        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("test.pdf"));
        document.open();

        Image template = Image.getInstance("src/main/resources/2.png");

        template.scaleToFit(800, 800);
        template.setAlignment(Image.ALIGN_CENTER);


        Image logo = Image.getInstance("src/main/resources/mc.png");
        logo.setAbsolutePosition(200f, 500f);
        logo.scaleAbsolute(200, 200);
        logo.setAlignment(Image.ALIGN_CENTER);


        Image qr = Image.getInstance("src/main/resources/qr.jpeg");
        qr.setAbsolutePosition(175f, 205f);
        qr.scaleAbsolute(250, 250);
        qr.setAlignment(Image.ALIGN_CENTER);



//        String foobar = "Ro y Facu";
        Font font = FontFactory.getFont("Playlist Script");
        font.setColor(BaseColor.BLACK);
        font.setSize(80);
        PdfContentByte canvas = writer.getDirectContent();
//        Phrase phrase = new Phrase(foobar, font);
//        ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, phrase, 300, 600, 0);

        document.add(template);
        document.add(qr);

        document.add(logo);

        document.close();
    }
}
